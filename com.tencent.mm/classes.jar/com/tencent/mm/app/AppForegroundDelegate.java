package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum AppForegroundDelegate
{
  public static boolean cTD;
  private static final b cTH;
  private static ConcurrentHashMap<String, d> cTI;
  private Handler aCF;
  private final Set<o> cBA;
  public volatile boolean cBB;
  private volatile boolean cBE;
  private Handler cTB;
  private Runnable cTC;
  public final Set<p> cTE;
  private c cTF;
  private boolean cTG;
  
  static
  {
    AppMethodBeat.i(131766);
    cTA = new AppForegroundDelegate("INSTANCE");
    cTJ = new AppForegroundDelegate[] { cTA };
    cTD = false;
    cTH = new b((byte)0);
    cTI = new ConcurrentHashMap();
    AppMethodBeat.o(131766);
  }
  
  private AppForegroundDelegate()
  {
    AppMethodBeat.i(131761);
    this.aCF = new Handler(Looper.getMainLooper());
    this.cBA = new HashSet();
    this.cTE = new HashSet();
    this.cBB = false;
    this.cTF = new c((byte)0);
    this.cBE = false;
    this.cTG = false;
    AppMethodBeat.o(131761);
  }
  
  public final String LO()
  {
    return this.cTF.cTS.activity;
  }
  
  public final boolean LP()
  {
    return this.cBB;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(131762);
    if (this.cBB) {
      paramo.onAppForeground(this.cTF.cTS.activity);
    }
    synchronized (this.cBA)
    {
      this.cBA.add(paramo);
      AppMethodBeat.o(131762);
      return;
    }
  }
  
  public final void b(o paramo)
  {
    AppMethodBeat.i(131763);
    synchronized (this.cBA)
    {
      this.cBA.remove(paramo);
      AppMethodBeat.o(131763);
      return;
    }
  }
  
  public final void d(Application paramApplication)
  {
    AppMethodBeat.i(193526);
    if (this.cBE)
    {
      ae.e("MicroMsg.AppForegroundDelegate", "has init!");
      AppMethodBeat.o(193526);
      return;
    }
    this.cBE = true;
    localObject1 = new HandlerThread("AppForegroundDelegate");
    ((HandlerThread)localObject1).start();
    this.cTB = new Handler(((HandlerThread)localObject1).getLooper());
    if (ak.coh())
    {
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction(a.a(a.cTM));
      ((IntentFilter)localObject1).addAction(a.a(a.cTN));
      ((IntentFilter)localObject1).addAction(a.a(a.cTO));
      ((IntentFilter)localObject1).addAction(a.a(a.cTP));
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
      paramApplication.registerReceiver(this.cTF.cTU, (IntentFilter)localObject1, "com.tencent.mm.permission.MM_MESSAGE", null);
    }
    for (;;)
    {
      paramApplication.registerActivityLifecycleCallbacks(this.cTF.cTU);
      paramApplication.registerComponentCallbacks(this.cTF.cTU);
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
      paramApplication.registerReceiver(this.cTF.cTS, (IntentFilter)localObject1, "com.tencent.mm.permission.MM_MESSAGE", null);
      AppMethodBeat.o(193526);
      return;
      if (ak.getProcessName().endsWith(":dexopt"))
      {
        AppMethodBeat.o(193526);
        return;
      }
      Uri localUri = Uri.parse("content://com.tencent.mm.AppForegroundDelegate.Provider/");
      Bundle localBundle2 = new Bundle();
      Bundle localBundle1 = localBundle2;
      localObject1 = localBundle2;
      try
      {
        if (ak.foJ())
        {
          localObject1 = localBundle2;
          localBundle1 = paramApplication.getContentResolver().call(localUri, "isAppForeground", null, null);
          localObject1 = localBundle1;
          this.cBB = localBundle1.getBoolean("isAppForeground");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AppForegroundDelegate", localException, "isMMProcessExist:%s", new Object[] { Boolean.valueOf(ak.foJ()) });
          Object localObject2;
          if (ak.foA())
          {
            e.ywz.idkeyStat(1118L, 0L, 1L, true);
            localObject2 = localObject1;
          }
          else
          {
            e.ywz.idkeyStat(1118L, 1L, 1L, true);
            localObject2 = localObject1;
            continue;
            localObject1 = localObject2.getString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
          }
        }
      }
      if (localBundle1 != null) {
        break label421;
      }
      localObject1 = "";
      ae.i("MicroMsg.AppForegroundDelegate", "[init] process:%s isAppForeground:%s", new Object[] { ak.getProcessName(), Boolean.valueOf(this.cBB) });
      if (this.cBB) {
        this.aCF.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131735);
            Intent localIntent = new Intent();
            localIntent.setAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
            localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", this.cCc);
            AppForegroundDelegate.a(AppForegroundDelegate.this).cTS.onReceive(ak.getContext(), localIntent);
            AppMethodBeat.o(131735);
          }
        });
      }
    }
  }
  
  public static class Provider
    extends ContentProvider
  {
    public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
    {
      AppMethodBeat.i(131758);
      if (paramString1.equals("isAppForeground"))
      {
        paramString1 = new Bundle();
        paramString1.putString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", AppForegroundDelegate.a(AppForegroundDelegate.cTA).cTS.activity);
        paramString1.putBoolean("isAppForeground", AppForegroundDelegate.c(AppForegroundDelegate.cTA));
        AppMethodBeat.o(131758);
        return paramString1;
      }
      paramString1 = super.call(paramString1, paramString2, paramBundle);
      AppMethodBeat.o(131758);
      return paramString1;
    }
    
    public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
    {
      return 0;
    }
    
    public String getType(Uri paramUri)
    {
      return null;
    }
    
    public Uri insert(Uri paramUri, ContentValues paramContentValues)
    {
      return null;
    }
    
    public boolean onCreate()
    {
      return true;
    }
    
    public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
    {
      return null;
    }
    
    public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      return 0;
    }
  }
  
  static enum a
  {
    private String value;
    
    static
    {
      AppMethodBeat.i(131741);
      cTL = new a("CREATED", 0, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_CREATED");
      cTM = new a("STARTED", 1, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STARTED");
      cTN = new a("RESUMED", 2, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_RESUMED");
      cTO = new a("PAUSED", 3, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_PAUSED");
      cTP = new a("STOPPED", 4, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STOPPED");
      cTQ = new a("DESTROY", 5, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_DESTROY");
      cTR = new a[] { cTL, cTM, cTN, cTO, cTP, cTQ };
      AppMethodBeat.o(131741);
    }
    
    private a(String paramString)
    {
      this.value = paramString;
    }
    
    public static a fk(String paramString)
    {
      AppMethodBeat.i(131740);
      if (paramString.equals(cTM.value))
      {
        paramString = cTM;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cTN.value))
      {
        paramString = cTN;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cTO.value))
      {
        paramString = cTO;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cTP.value))
      {
        paramString = cTP;
        AppMethodBeat.o(131740);
        return paramString;
      }
      AppMethodBeat.o(131740);
      return null;
    }
  }
  
  static final class b
    implements Runnable
  {
    Handler aCF;
    public boolean cKB = true;
    AppForegroundDelegate.e cTS;
    int cTT = 0;
    
    public final void run()
    {
      AppMethodBeat.i(193522);
      ae.i("MicroMsg.AppForegroundDelegate", "CheckExceptionRunnable... isValid=%s checkErrorCount=%s isAppForeground=%s", new Object[] { Boolean.valueOf(this.cKB), Integer.valueOf(this.cTT), Boolean.valueOf(AppForegroundDelegate.c(AppForegroundDelegate.cTA)) });
      if (!this.cKB)
      {
        AppMethodBeat.o(193522);
        return;
      }
      if ((AppForegroundDelegate.c(AppForegroundDelegate.cTA)) && (this.cTT >= 2))
      {
        ae.e("MicroMsg.AppForegroundDelegate", "check error! isScreenOff is true but isAppForeground is true");
        e.ywz.f(20459, new Object[] { Boolean.valueOf(AppForegroundDelegate.cTD), Integer.valueOf(2) });
        if (AppForegroundDelegate.cTD) {
          e.ywz.idkeyStat(1439L, 11L, 1L, false);
        }
        for (;;)
        {
          e.ywz.idkeyStat(1439L, 13L, 1L, false);
          AppForegroundDelegate.LQ().clear();
          if (this.cTS == null) {
            break;
          }
          AppForegroundDelegate.e.c(false, "fallback");
          AppMethodBeat.o(193522);
          return;
          e.ywz.idkeyStat(1439L, 12L, 1L, false);
        }
      }
      if ((AppForegroundDelegate.c(AppForegroundDelegate.cTA)) && (this.cTT < 2))
      {
        this.cTT += 1;
        this.aCF.postDelayed(this, 5000L);
      }
      AppMethodBeat.o(193522);
    }
  }
  
  final class c
  {
    AppForegroundDelegate.e cTS;
    a cTU;
    
    private c()
    {
      AppMethodBeat.i(131755);
      this.cTU = new a((byte)0);
      this.cTS = new AppForegroundDelegate.e(AppForegroundDelegate.this, (byte)0);
      AppMethodBeat.o(131755);
    }
    
    final class a
      extends BroadcastReceiver
      implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
    {
      private HashSet<String> cTV;
      
      private a()
      {
        AppMethodBeat.i(131745);
        this.cTV = new HashSet();
        AppMethodBeat.o(131745);
      }
      
      private static String LS()
      {
        AppMethodBeat.i(193523);
        String str = ak.getProcessName() + "@" + Process.myPid();
        AppMethodBeat.o(193523);
        return str;
      }
      
      private static void a(AppForegroundDelegate.a parama, String paramString)
      {
        AppMethodBeat.i(131747);
        Intent localIntent = new Intent();
        localIntent.setAction(AppForegroundDelegate.a.a(parama));
        localIntent.putExtra("_application_context_process_", LS());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        ak.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(131747);
      }
      
      private void a(final String paramString1, String paramString2, AppForegroundDelegate.a parama)
      {
        AppMethodBeat.i(131748);
        ae.i("MicroMsg.AppForegroundDelegate", "[checkAlive] activityName:%s process:%s action:%s", new Object[] { paramString1, paramString2, parama.name() });
        AppForegroundDelegate.a(paramString2, parama, paramString1);
        if (parama == AppForegroundDelegate.a.cTM)
        {
          if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
            AppForegroundDelegate.e.c(true, paramString1);
          }
          this.cTV.remove(paramString1);
        }
        if (((parama == AppForegroundDelegate.a.cTL) || (parama == AppForegroundDelegate.a.cTM) || (parama == AppForegroundDelegate.a.cTN) || (parama == AppForegroundDelegate.a.cTO)) && (AppForegroundDelegate.g(AppForegroundDelegate.this) != null))
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.g(AppForegroundDelegate.this));
          AppForegroundDelegate.a(AppForegroundDelegate.this, null);
        }
        if (parama == AppForegroundDelegate.a.cTN)
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131743);
              if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                AppForegroundDelegate.e.c(true, paramString1);
              }
              AppMethodBeat.o(131743);
            }
          }), 600L);
          AppMethodBeat.o(131748);
          return;
        }
        if (parama == AppForegroundDelegate.a.cTO)
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131744);
              if ((AppForegroundDelegate.c(AppForegroundDelegate.this)) && (AppForegroundDelegate.c.a.a(AppForegroundDelegate.c.a.this).remove(paramString1)))
              {
                AppForegroundDelegate.e.c(false, paramString1);
                AppMethodBeat.o(131744);
                return;
              }
              AppForegroundDelegate.a(AppForegroundDelegate.this, null);
              ae.w("MicroMsg.AppForegroundDelegate", "[PAUSED] delay to check background in stop!");
              AppMethodBeat.o(131744);
            }
          }), 600L);
          AppMethodBeat.o(131748);
          return;
        }
        if ((parama == AppForegroundDelegate.a.cTP) || (parama == AppForegroundDelegate.a.cTQ))
        {
          if (parama == AppForegroundDelegate.a.cTP) {
            this.cTV.add(paramString1);
          }
          if (AppForegroundDelegate.g(AppForegroundDelegate.this) == null) {
            AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182866);
                if (AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                  AppForegroundDelegate.e.c(false, paramString1);
                }
                AppMethodBeat.o(182866);
              }
            }), 600L);
          }
        }
        AppMethodBeat.o(131748);
      }
      
      public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
      {
        AppMethodBeat.i(131749);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ak.coh())
        {
          a(paramActivity, LS(), AppForegroundDelegate.a.cTL);
          AppMethodBeat.o(131749);
          return;
        }
        a(AppForegroundDelegate.a.cTL, paramActivity);
        AppMethodBeat.o(131749);
      }
      
      public final void onActivityDestroyed(Activity paramActivity)
      {
        AppMethodBeat.i(131754);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ak.coh())
        {
          a(paramActivity, LS(), AppForegroundDelegate.a.cTQ);
          AppMethodBeat.o(131754);
          return;
        }
        a(AppForegroundDelegate.a.cTQ, paramActivity);
        AppMethodBeat.o(131754);
      }
      
      public final void onActivityPaused(Activity paramActivity)
      {
        AppMethodBeat.i(131752);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ak.coh())
        {
          a(paramActivity, LS(), AppForegroundDelegate.a.cTO);
          AppMethodBeat.o(131752);
          return;
        }
        a(AppForegroundDelegate.a.cTO, paramActivity);
        AppMethodBeat.o(131752);
      }
      
      public final void onActivityResumed(Activity paramActivity)
      {
        AppMethodBeat.i(131751);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ak.coh())
        {
          a(paramActivity, LS(), AppForegroundDelegate.a.cTN);
          AppMethodBeat.o(131751);
          return;
        }
        a(AppForegroundDelegate.a.cTN, paramActivity);
        AppMethodBeat.o(131751);
      }
      
      public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
      
      public final void onActivityStarted(Activity paramActivity)
      {
        AppMethodBeat.i(131750);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ak.coh())
        {
          a(paramActivity, LS(), AppForegroundDelegate.a.cTM);
          AppMethodBeat.o(131750);
          return;
        }
        a(AppForegroundDelegate.a.cTM, paramActivity);
        AppMethodBeat.o(131750);
      }
      
      public final void onActivityStopped(Activity paramActivity)
      {
        AppMethodBeat.i(131753);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ak.coh())
        {
          a(paramActivity, LS(), AppForegroundDelegate.a.cTP);
          AppMethodBeat.o(131753);
          return;
        }
        a(AppForegroundDelegate.a.cTP, paramActivity);
        AppMethodBeat.o(131753);
      }
      
      public final void onConfigurationChanged(Configuration paramConfiguration) {}
      
      public final void onLowMemory() {}
      
      public final void onReceive(Context paramContext, Intent paramIntent)
      {
        AppMethodBeat.i(131746);
        if (paramIntent == null)
        {
          AppMethodBeat.o(131746);
          return;
        }
        paramContext = paramIntent.getAction();
        Object localObject;
        if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("android.intent.action.SCREEN_ON".equals(paramContext)))
        {
          ae.i("MicroMsg.AppForegroundDelegate", "ACTION_SCREEN:%s isAppForeground:%s", new Object[] { paramContext, Boolean.valueOf(AppForegroundDelegate.c(AppForegroundDelegate.this)) });
          if ("android.intent.action.SCREEN_OFF".equals(paramContext))
          {
            AppForegroundDelegate.a(AppForegroundDelegate.this, true);
            paramContext = AppForegroundDelegate.LR();
            paramIntent = AppForegroundDelegate.c.this.cTS;
            localObject = AppForegroundDelegate.d(AppForegroundDelegate.this);
            paramContext.cTS = paramIntent;
            paramContext.aCF = ((Handler)localObject);
            paramContext.cTT = 0;
            paramContext.cKB = true;
            AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.LR(), 5000L);
          }
          for (;;)
          {
            h.MqF.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(131742);
                synchronized (AppForegroundDelegate.e(AppForegroundDelegate.this))
                {
                  LinkedList localLinkedList = new LinkedList(AppForegroundDelegate.e(AppForegroundDelegate.this));
                  ??? = localLinkedList.iterator();
                  if (((Iterator)???).hasNext()) {
                    ((p)((Iterator)???).next()).cd(AppForegroundDelegate.f(AppForegroundDelegate.this));
                  }
                }
                AppMethodBeat.o(131742);
              }
            }, "MicroMsg.AppForegroundDelegate");
            AppMethodBeat.o(131746);
            return;
            AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.LR());
            AppForegroundDelegate.a(AppForegroundDelegate.this, false);
          }
        }
        paramContext = AppForegroundDelegate.a.fk(paramContext);
        if ((paramContext == AppForegroundDelegate.a.cTM) || (paramContext == AppForegroundDelegate.a.cTN))
        {
          AppForegroundDelegate.LR().cKB = false;
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.LR());
        }
        if (paramContext != null)
        {
          localObject = paramIntent.getStringExtra("_application_context_process_");
          a(paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME"), (String)localObject, paramContext);
        }
        AppMethodBeat.o(131746);
      }
      
      public final void onTrimMemory(int paramInt) {}
    }
  }
  
  static final class d
  {
    LinkedList<String> cTY;
    
    public d(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(193524);
      this.cTY = new LinkedList();
      a(paramString, parama);
      AppMethodBeat.o(193524);
    }
    
    public final boolean a(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(193525);
      String str = paramString + "#" + parama;
      if (!this.cTY.contains(str))
      {
        if (parama == AppForegroundDelegate.a.cTN) {
          this.cTY.add(str);
        }
        for (;;)
        {
          AppMethodBeat.o(193525);
          return true;
          if (parama == AppForegroundDelegate.a.cTO) {
            this.cTY.remove(paramString + "#" + AppForegroundDelegate.a.cTN);
          }
        }
      }
      AppMethodBeat.o(193525);
      return false;
    }
  }
  
  final class e
    extends BroadcastReceiver
  {
    public String activity;
    
    private e() {}
    
    public static void c(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(131757);
      Intent localIntent = new Intent();
      if (paramBoolean) {}
      for (String str = "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE";; str = "com.tencent.mm.AppForegroundDelegate.ACTION_DEAD")
      {
        localIntent.setAction(str);
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.DISPATCH_TIME", SystemClock.uptimeMillis());
        ak.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(131757);
        return;
      }
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(131756);
      if (paramIntent == null)
      {
        AppMethodBeat.o(131756);
        return;
      }
      paramContext = paramIntent.getAction();
      this.activity = paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
      long l = paramIntent.getLongExtra("com.tencent.mm.AppForegroundDelegate.DISPATCH_TIME", 0L);
      boolean bool = "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE".equalsIgnoreCase(paramContext);
      l = SystemClock.uptimeMillis() - l;
      if (bool)
      {
        AppForegroundDelegate.a(AppForegroundDelegate.this, this.activity, l);
        AppMethodBeat.o(131756);
        return;
      }
      AppForegroundDelegate.b(AppForegroundDelegate.this, this.activity, l);
      AppMethodBeat.o(131756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.AppForegroundDelegate
 * JD-Core Version:    0.7.0.1
 */