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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum AppForegroundDelegate
{
  public static boolean cST;
  private static final b cSX;
  private static ConcurrentHashMap<String, d> cSY;
  private Handler aCF;
  private final Set<n> cAT;
  public volatile boolean cAU;
  private volatile boolean cAX;
  private Handler cSR;
  private Runnable cSS;
  public final Set<o> cSU;
  private c cSV;
  private boolean cSW;
  
  static
  {
    AppMethodBeat.i(131766);
    cSQ = new AppForegroundDelegate("INSTANCE");
    cSZ = new AppForegroundDelegate[] { cSQ };
    cST = false;
    cSX = new b((byte)0);
    cSY = new ConcurrentHashMap();
    AppMethodBeat.o(131766);
  }
  
  private AppForegroundDelegate()
  {
    AppMethodBeat.i(131761);
    this.aCF = new Handler(Looper.getMainLooper());
    this.cAT = new HashSet();
    this.cSU = new HashSet();
    this.cAU = false;
    this.cSV = new c((byte)0);
    this.cAX = false;
    this.cSW = false;
    AppMethodBeat.o(131761);
  }
  
  public final String LG()
  {
    return this.cSV.cTi.activity;
  }
  
  public final boolean LH()
  {
    return this.cAU;
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(131762);
    if (this.cAU) {
      paramn.onAppForeground(this.cSV.cTi.activity);
    }
    synchronized (this.cAT)
    {
      this.cAT.add(paramn);
      AppMethodBeat.o(131762);
      return;
    }
  }
  
  public final void b(n paramn)
  {
    AppMethodBeat.i(131763);
    synchronized (this.cAT)
    {
      this.cAT.remove(paramn);
      AppMethodBeat.o(131763);
      return;
    }
  }
  
  public final void d(Application paramApplication)
  {
    AppMethodBeat.i(189809);
    if (this.cAX)
    {
      ad.e("MicroMsg.AppForegroundDelegate", "has init!");
      AppMethodBeat.o(189809);
      return;
    }
    this.cAX = true;
    localObject1 = new HandlerThread("AppForegroundDelegate");
    ((HandlerThread)localObject1).start();
    this.cSR = new Handler(((HandlerThread)localObject1).getLooper());
    if (aj.cmR())
    {
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction(a.a(a.cTc));
      ((IntentFilter)localObject1).addAction(a.a(a.cTd));
      ((IntentFilter)localObject1).addAction(a.a(a.cTe));
      ((IntentFilter)localObject1).addAction(a.a(a.cTf));
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
      paramApplication.registerReceiver(this.cSV.cTj, (IntentFilter)localObject1, "com.tencent.mm.permission.MM_MESSAGE", null);
    }
    for (;;)
    {
      paramApplication.registerActivityLifecycleCallbacks(this.cSV.cTj);
      paramApplication.registerComponentCallbacks(this.cSV.cTj);
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
      paramApplication.registerReceiver(this.cSV.cTi, (IntentFilter)localObject1, "com.tencent.mm.permission.MM_MESSAGE", null);
      AppMethodBeat.o(189809);
      return;
      if (aj.getProcessName().endsWith(":dexopt"))
      {
        AppMethodBeat.o(189809);
        return;
      }
      Uri localUri = Uri.parse("content://com.tencent.mm.AppForegroundDelegate.Provider/");
      Bundle localBundle2 = new Bundle();
      Bundle localBundle1 = localBundle2;
      localObject1 = localBundle2;
      try
      {
        if (aj.fkO())
        {
          localObject1 = localBundle2;
          localBundle1 = paramApplication.getContentResolver().call(localUri, "isAppForeground", null, null);
          localObject1 = localBundle1;
          this.cAU = localBundle1.getBoolean("isAppForeground");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppForegroundDelegate", localException, "isMMProcessExist:%s", new Object[] { Boolean.valueOf(aj.fkO()) });
          Object localObject2;
          if (aj.fkG())
          {
            e.ygI.idkeyStat(1118L, 0L, 1L, true);
            localObject2 = localObject1;
          }
          else
          {
            e.ygI.idkeyStat(1118L, 1L, 1L, true);
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
      ad.i("MicroMsg.AppForegroundDelegate", "[init] process:%s isAppForeground:%s", new Object[] { aj.getProcessName(), Boolean.valueOf(this.cAU) });
      if (this.cAU) {
        this.aCF.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131735);
            Intent localIntent = new Intent();
            localIntent.setAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
            localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", this.cBv);
            AppForegroundDelegate.a(AppForegroundDelegate.this).cTi.onReceive(aj.getContext(), localIntent);
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
        paramString1.putString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", AppForegroundDelegate.a(AppForegroundDelegate.cSQ).cTi.activity);
        paramString1.putBoolean("isAppForeground", AppForegroundDelegate.c(AppForegroundDelegate.cSQ));
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
      cTb = new a("CREATED", 0, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_CREATED");
      cTc = new a("STARTED", 1, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STARTED");
      cTd = new a("RESUMED", 2, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_RESUMED");
      cTe = new a("PAUSED", 3, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_PAUSED");
      cTf = new a("STOPPED", 4, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STOPPED");
      cTg = new a("DESTROY", 5, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_DESTROY");
      cTh = new a[] { cTb, cTc, cTd, cTe, cTf, cTg };
      AppMethodBeat.o(131741);
    }
    
    private a(String paramString)
    {
      this.value = paramString;
    }
    
    public static a ff(String paramString)
    {
      AppMethodBeat.i(131740);
      if (paramString.equals(cTc.value))
      {
        paramString = cTc;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cTd.value))
      {
        paramString = cTd;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cTe.value))
      {
        paramString = cTe;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cTf.value))
      {
        paramString = cTf;
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
    public boolean cJS = true;
    AppForegroundDelegate.e cTi;
    int cUG = 0;
    
    public final void run()
    {
      AppMethodBeat.i(189805);
      ad.i("MicroMsg.AppForegroundDelegate", "CheckExceptionRunnable... isValid=%s checkErrorCount=%s isAppForeground=%s", new Object[] { Boolean.valueOf(this.cJS), Integer.valueOf(this.cUG), Boolean.valueOf(AppForegroundDelegate.c(AppForegroundDelegate.cSQ)) });
      if (!this.cJS)
      {
        AppMethodBeat.o(189805);
        return;
      }
      if ((AppForegroundDelegate.c(AppForegroundDelegate.cSQ)) && (this.cUG >= 2))
      {
        ad.e("MicroMsg.AppForegroundDelegate", "check error! isScreenOff is true but isAppForeground is true");
        e.ygI.f(20459, new Object[] { Boolean.valueOf(AppForegroundDelegate.cST), Integer.valueOf(2) });
        if (AppForegroundDelegate.cST) {
          e.ygI.idkeyStat(1439L, 11L, 1L, false);
        }
        for (;;)
        {
          e.ygI.idkeyStat(1439L, 13L, 1L, false);
          AppForegroundDelegate.LI().clear();
          if (this.cTi == null) {
            break;
          }
          AppForegroundDelegate.e.c(false, "fallback");
          AppMethodBeat.o(189805);
          return;
          e.ygI.idkeyStat(1439L, 12L, 1L, false);
        }
      }
      if ((AppForegroundDelegate.c(AppForegroundDelegate.cSQ)) && (this.cUG < 2))
      {
        this.cUG += 1;
        this.aCF.postDelayed(this, 5000L);
      }
      AppMethodBeat.o(189805);
    }
  }
  
  final class c
  {
    AppForegroundDelegate.e cTi;
    a cTj;
    
    private c()
    {
      AppMethodBeat.i(131755);
      this.cTj = new a((byte)0);
      this.cTi = new AppForegroundDelegate.e(AppForegroundDelegate.this, (byte)0);
      AppMethodBeat.o(131755);
    }
    
    final class a
      extends BroadcastReceiver
      implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
    {
      private HashSet<String> cTk;
      
      private a()
      {
        AppMethodBeat.i(131745);
        this.cTk = new HashSet();
        AppMethodBeat.o(131745);
      }
      
      private static String LK()
      {
        AppMethodBeat.i(189806);
        String str = aj.getProcessName() + "@" + Process.myPid();
        AppMethodBeat.o(189806);
        return str;
      }
      
      private static void a(AppForegroundDelegate.a parama, String paramString)
      {
        AppMethodBeat.i(131747);
        Intent localIntent = new Intent();
        localIntent.setAction(AppForegroundDelegate.a.a(parama));
        localIntent.putExtra("_application_context_process_", LK());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        aj.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(131747);
      }
      
      private void a(final String paramString1, String paramString2, AppForegroundDelegate.a parama)
      {
        AppMethodBeat.i(131748);
        ad.i("MicroMsg.AppForegroundDelegate", "[checkAlive] activityName:%s process:%s action:%s", new Object[] { paramString1, paramString2, parama.name() });
        AppForegroundDelegate.a(paramString2, parama, paramString1);
        if (parama == AppForegroundDelegate.a.cTc)
        {
          if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
            AppForegroundDelegate.e.c(true, paramString1);
          }
          this.cTk.remove(paramString1);
        }
        if (((parama == AppForegroundDelegate.a.cTb) || (parama == AppForegroundDelegate.a.cTc) || (parama == AppForegroundDelegate.a.cTd) || (parama == AppForegroundDelegate.a.cTe)) && (AppForegroundDelegate.g(AppForegroundDelegate.this) != null))
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.g(AppForegroundDelegate.this));
          AppForegroundDelegate.a(AppForegroundDelegate.this, null);
        }
        if (parama == AppForegroundDelegate.a.cTd)
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
        if (parama == AppForegroundDelegate.a.cTe)
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
              ad.w("MicroMsg.AppForegroundDelegate", "[PAUSED] delay to check background in stop!");
              AppMethodBeat.o(131744);
            }
          }), 600L);
          AppMethodBeat.o(131748);
          return;
        }
        if ((parama == AppForegroundDelegate.a.cTf) || (parama == AppForegroundDelegate.a.cTg))
        {
          if (parama == AppForegroundDelegate.a.cTf) {
            this.cTk.add(paramString1);
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
        if (aj.cmR())
        {
          a(paramActivity, LK(), AppForegroundDelegate.a.cTb);
          AppMethodBeat.o(131749);
          return;
        }
        a(AppForegroundDelegate.a.cTb, paramActivity);
        AppMethodBeat.o(131749);
      }
      
      public final void onActivityDestroyed(Activity paramActivity)
      {
        AppMethodBeat.i(131754);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cmR())
        {
          a(paramActivity, LK(), AppForegroundDelegate.a.cTg);
          AppMethodBeat.o(131754);
          return;
        }
        a(AppForegroundDelegate.a.cTg, paramActivity);
        AppMethodBeat.o(131754);
      }
      
      public final void onActivityPaused(Activity paramActivity)
      {
        AppMethodBeat.i(131752);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cmR())
        {
          a(paramActivity, LK(), AppForegroundDelegate.a.cTe);
          AppMethodBeat.o(131752);
          return;
        }
        a(AppForegroundDelegate.a.cTe, paramActivity);
        AppMethodBeat.o(131752);
      }
      
      public final void onActivityResumed(Activity paramActivity)
      {
        AppMethodBeat.i(131751);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cmR())
        {
          a(paramActivity, LK(), AppForegroundDelegate.a.cTd);
          AppMethodBeat.o(131751);
          return;
        }
        a(AppForegroundDelegate.a.cTd, paramActivity);
        AppMethodBeat.o(131751);
      }
      
      public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
      
      public final void onActivityStarted(Activity paramActivity)
      {
        AppMethodBeat.i(131750);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cmR())
        {
          a(paramActivity, LK(), AppForegroundDelegate.a.cTc);
          AppMethodBeat.o(131750);
          return;
        }
        a(AppForegroundDelegate.a.cTc, paramActivity);
        AppMethodBeat.o(131750);
      }
      
      public final void onActivityStopped(Activity paramActivity)
      {
        AppMethodBeat.i(131753);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cmR())
        {
          a(paramActivity, LK(), AppForegroundDelegate.a.cTf);
          AppMethodBeat.o(131753);
          return;
        }
        a(AppForegroundDelegate.a.cTf, paramActivity);
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
          ad.i("MicroMsg.AppForegroundDelegate", "ACTION_SCREEN:%s isAppForeground:%s", new Object[] { paramContext, Boolean.valueOf(AppForegroundDelegate.c(AppForegroundDelegate.this)) });
          if ("android.intent.action.SCREEN_OFF".equals(paramContext))
          {
            AppForegroundDelegate.a(AppForegroundDelegate.this, true);
            paramContext = AppForegroundDelegate.Mm();
            paramIntent = AppForegroundDelegate.c.this.cTi;
            localObject = AppForegroundDelegate.d(AppForegroundDelegate.this);
            paramContext.cTi = paramIntent;
            paramContext.aCF = ((Handler)localObject);
            paramContext.cUG = 0;
            paramContext.cJS = true;
            AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.Mm(), 5000L);
          }
          for (;;)
          {
            h.LTJ.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(131742);
                synchronized (AppForegroundDelegate.e(AppForegroundDelegate.this))
                {
                  LinkedList localLinkedList = new LinkedList(AppForegroundDelegate.e(AppForegroundDelegate.this));
                  ??? = localLinkedList.iterator();
                  if (((Iterator)???).hasNext()) {
                    ((o)((Iterator)???).next()).cd(AppForegroundDelegate.f(AppForegroundDelegate.this));
                  }
                }
                AppMethodBeat.o(131742);
              }
            }, "MicroMsg.AppForegroundDelegate");
            AppMethodBeat.o(131746);
            return;
            AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.Mm());
            AppForegroundDelegate.a(AppForegroundDelegate.this, false);
          }
        }
        paramContext = AppForegroundDelegate.a.ff(paramContext);
        if ((paramContext == AppForegroundDelegate.a.cTc) || (paramContext == AppForegroundDelegate.a.cTd))
        {
          AppForegroundDelegate.Mm().cJS = false;
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.Mm());
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
    LinkedList<String> cTn;
    
    public d(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(189807);
      this.cTn = new LinkedList();
      a(paramString, parama);
      AppMethodBeat.o(189807);
    }
    
    public final boolean a(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(189808);
      String str = paramString + "#" + parama;
      if (!this.cTn.contains(str))
      {
        if (parama == AppForegroundDelegate.a.cTd) {
          this.cTn.add(str);
        }
        for (;;)
        {
          AppMethodBeat.o(189808);
          return true;
          if (parama == AppForegroundDelegate.a.cTe) {
            this.cTn.remove(paramString + "#" + AppForegroundDelegate.a.cTd);
          }
        }
      }
      AppMethodBeat.o(189808);
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
        aj.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
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