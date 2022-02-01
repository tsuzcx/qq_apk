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
import android.util.ArrayMap;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum AppForegroundDelegate
{
  public static final String djS;
  private static String djV;
  public static boolean djW;
  private static final b dka;
  private static ConcurrentHashMap<String, d> dkb;
  private Handler aDv;
  public volatile boolean cPB;
  private Handler djT;
  private Runnable djU;
  public final Set<p> djX;
  private c djY;
  private boolean djZ;
  private volatile boolean isInit;
  private final Set<o> listeners;
  
  static
  {
    AppMethodBeat.i(131766);
    djR = new AppForegroundDelegate("INSTANCE");
    dkc = new AppForegroundDelegate[] { djR };
    djS = WeChatPermissions.PERMISSION_MM_MESSAGE();
    djV = null;
    djW = false;
    dka = new b((byte)0);
    dkb = new ConcurrentHashMap();
    AppMethodBeat.o(131766);
  }
  
  private AppForegroundDelegate()
  {
    AppMethodBeat.i(131761);
    this.aDv = new Handler(Looper.getMainLooper());
    this.listeners = new HashSet();
    this.djX = new HashSet();
    this.cPB = false;
    this.djY = new c((byte)0);
    this.isInit = false;
    this.djZ = false;
    AppMethodBeat.o(131761);
  }
  
  private static String RF()
  {
    AppMethodBeat.i(196965);
    try
    {
      Object localObject2 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject2).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject2 = ((Class)localObject2).getDeclaredField("mActivities");
      ((Field)localObject2).setAccessible(true);
      localObject1 = (ArrayMap)((Field)localObject2).get(localObject1);
      int i = ((Map)localObject1).size();
      if (i <= 0)
      {
        AppMethodBeat.o(196965);
        return null;
      }
      localObject2 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        Class localClass = localObject1.getClass();
        Field localField = localClass.getDeclaredField("paused");
        localField.setAccessible(true);
        if (!localField.getBoolean(localObject1))
        {
          localObject2 = localClass.getDeclaredField("activity");
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Activity)((Field)localObject2).get(localObject1)).getClass().getCanonicalName();
          AppMethodBeat.o(196965);
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(196965);
    }
    return null;
  }
  
  public static String Wb()
  {
    AppMethodBeat.i(196964);
    if (Util.isNullOrNil(djV)) {
      djV = RF();
    }
    String str = djV;
    AppMethodBeat.o(196964);
    return str;
  }
  
  public final boolean Wc()
  {
    return this.cPB;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(131762);
    if (this.cPB) {
      paramo.onAppForeground(this.djY.dkl.activity);
    }
    synchronized (this.listeners)
    {
      this.listeners.add(paramo);
      AppMethodBeat.o(131762);
      return;
    }
  }
  
  public final void b(o paramo)
  {
    AppMethodBeat.i(131763);
    synchronized (this.listeners)
    {
      this.listeners.remove(paramo);
      AppMethodBeat.o(131763);
      return;
    }
  }
  
  public final void d(Application paramApplication)
  {
    AppMethodBeat.i(196963);
    if (this.isInit)
    {
      Log.e("MicroMsg.AppForegroundDelegate", "has init!");
      AppMethodBeat.o(196963);
      return;
    }
    this.isInit = true;
    localObject1 = new HandlerThread("AppForegroundDelegate");
    ((HandlerThread)localObject1).start();
    this.djT = new Handler(((HandlerThread)localObject1).getLooper());
    if (MMApplicationContext.isMainProcess())
    {
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction(a.a(a.dkf));
      ((IntentFilter)localObject1).addAction(a.a(a.dkg));
      ((IntentFilter)localObject1).addAction(a.a(a.dkh));
      ((IntentFilter)localObject1).addAction(a.a(a.dki));
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
      paramApplication.registerReceiver(this.djY.dkn, (IntentFilter)localObject1, djS, null);
    }
    for (;;)
    {
      paramApplication.registerActivityLifecycleCallbacks(this.djY.dkn);
      paramApplication.registerComponentCallbacks(this.djY.dkn);
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
      paramApplication.registerReceiver(this.djY.dkl, (IntentFilter)localObject1, djS, null);
      AppMethodBeat.o(196963);
      return;
      if (MMApplicationContext.getProcessName().endsWith(":dexopt"))
      {
        AppMethodBeat.o(196963);
        return;
      }
      Uri localUri = Uri.parse("content://" + Provider.AUTHORITY + "/");
      Bundle localBundle2 = new Bundle();
      Bundle localBundle1 = localBundle2;
      localObject1 = localBundle2;
      try
      {
        if (MMApplicationContext.isMMProcessExist())
        {
          localObject1 = localBundle2;
          localBundle1 = paramApplication.getContentResolver().call(localUri, "isAppForeground", null, null);
          localObject1 = localBundle1;
          this.cPB = localBundle1.getBoolean("isAppForeground");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppForegroundDelegate", localException, "isMMProcessExist:%s", new Object[] { Boolean.valueOf(MMApplicationContext.isMMProcessExist()) });
          Object localObject2;
          if (MMApplicationContext.isPushProcess())
          {
            e.Cxv.idkeyStat(1118L, 0L, 1L, true);
            localObject2 = localObject1;
          }
          else
          {
            e.Cxv.idkeyStat(1118L, 1L, 1L, true);
            localObject2 = localObject1;
            continue;
            localObject1 = localObject2.getString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
          }
        }
      }
      if (localBundle1 != null) {
        break label446;
      }
      localObject1 = "";
      Log.i("MicroMsg.AppForegroundDelegate", "[init] process:%s isAppForeground:%s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(this.cPB) });
      if (this.cPB) {
        this.aDv.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131735);
            Intent localIntent = new Intent();
            localIntent.setAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
            localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", this.cQb);
            AppForegroundDelegate.a(AppForegroundDelegate.this).dkl.onReceive(MMApplicationContext.getContext(), localIntent);
            AppMethodBeat.o(131735);
          }
        });
      }
    }
  }
  
  public static class Provider
    extends ContentProvider
  {
    public static final String AUTHORITY;
    
    static
    {
      AppMethodBeat.i(196962);
      AUTHORITY = WeChatAuthorities.AUTHORITIES_APPFOREGROUNDDELEGATE_PROVIDER();
      AppMethodBeat.o(196962);
    }
    
    public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
    {
      AppMethodBeat.i(131758);
      if (paramString1.equals("isAppForeground"))
      {
        paramString1 = new Bundle();
        paramString1.putString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", AppForegroundDelegate.a(AppForegroundDelegate.djR).dkl.activity);
        paramString1.putBoolean("isAppForeground", AppForegroundDelegate.c(AppForegroundDelegate.djR));
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
      dke = new a("CREATED", 0, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_CREATED");
      dkf = new a("STARTED", 1, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STARTED");
      dkg = new a("RESUMED", 2, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_RESUMED");
      dkh = new a("PAUSED", 3, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_PAUSED");
      dki = new a("STOPPED", 4, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STOPPED");
      dkj = new a("DESTROY", 5, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_DESTROY");
      dkk = new a[] { dke, dkf, dkg, dkh, dki, dkj };
      AppMethodBeat.o(131741);
    }
    
    private a(String paramString)
    {
      this.value = paramString;
    }
    
    public static a fY(String paramString)
    {
      AppMethodBeat.i(131740);
      if (paramString.equals(dkf.value))
      {
        paramString = dkf;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(dkg.value))
      {
        paramString = dkg;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(dkh.value))
      {
        paramString = dkh;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(dki.value))
      {
        paramString = dki;
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
    Handler aDv;
    public boolean daZ = true;
    AppForegroundDelegate.e dkl;
    int dkm = 0;
    
    public final void run()
    {
      AppMethodBeat.i(196958);
      Log.i("MicroMsg.AppForegroundDelegate", "CheckExceptionRunnable... isValid=%s checkErrorCount=%s isAppForeground=%s", new Object[] { Boolean.valueOf(this.daZ), Integer.valueOf(this.dkm), Boolean.valueOf(AppForegroundDelegate.c(AppForegroundDelegate.djR)) });
      if (!this.daZ)
      {
        AppMethodBeat.o(196958);
        return;
      }
      if ((AppForegroundDelegate.c(AppForegroundDelegate.djR)) && (this.dkm >= 2))
      {
        Log.e("MicroMsg.AppForegroundDelegate", "check error! isScreenOff is true but isAppForeground is true");
        e.Cxv.a(20459, new Object[] { Boolean.valueOf(AppForegroundDelegate.djW), Integer.valueOf(2) });
        if (AppForegroundDelegate.djW) {
          e.Cxv.idkeyStat(1439L, 11L, 1L, false);
        }
        for (;;)
        {
          e.Cxv.idkeyStat(1439L, 13L, 1L, false);
          AppForegroundDelegate.Wd().clear();
          if (this.dkl == null) {
            break;
          }
          AppForegroundDelegate.e.c(false, "fallback");
          AppMethodBeat.o(196958);
          return;
          e.Cxv.idkeyStat(1439L, 12L, 1L, false);
        }
      }
      if ((AppForegroundDelegate.c(AppForegroundDelegate.djR)) && (this.dkm < 2))
      {
        this.dkm += 1;
        this.aDv.postDelayed(this, 5000L);
      }
      AppMethodBeat.o(196958);
    }
  }
  
  final class c
  {
    AppForegroundDelegate.e dkl;
    a dkn;
    
    private c()
    {
      AppMethodBeat.i(131755);
      this.dkn = new a((byte)0);
      this.dkl = new AppForegroundDelegate.e(AppForegroundDelegate.this, (byte)0);
      AppMethodBeat.o(131755);
    }
    
    final class a
      extends BroadcastReceiver
      implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
    {
      private HashSet<String> dko;
      
      private a()
      {
        AppMethodBeat.i(131745);
        this.dko = new HashSet();
        AppMethodBeat.o(131745);
      }
      
      private static String Wf()
      {
        AppMethodBeat.i(196959);
        String str = MMApplicationContext.getProcessName() + "@" + Process.myPid();
        AppMethodBeat.o(196959);
        return str;
      }
      
      private static void a(AppForegroundDelegate.a parama, String paramString)
      {
        AppMethodBeat.i(131747);
        Intent localIntent = new Intent();
        localIntent.setAction(AppForegroundDelegate.a.a(parama));
        localIntent.putExtra("_application_context_process_", Wf());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        MMApplicationContext.getContext().sendBroadcast(localIntent, AppForegroundDelegate.djS);
        AppMethodBeat.o(131747);
      }
      
      private void a(final String paramString1, String paramString2, AppForegroundDelegate.a parama)
      {
        AppMethodBeat.i(131748);
        Log.i("MicroMsg.AppForegroundDelegate", "[checkAlive] activityName:%s process:%s action:%s", new Object[] { paramString1, paramString2, parama.name() });
        AppForegroundDelegate.a(paramString2, parama, paramString1);
        if (parama == AppForegroundDelegate.a.dkf)
        {
          if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
            AppForegroundDelegate.e.c(true, paramString1);
          }
          this.dko.remove(paramString1);
        }
        if (((parama == AppForegroundDelegate.a.dke) || (parama == AppForegroundDelegate.a.dkf) || (parama == AppForegroundDelegate.a.dkg) || (parama == AppForegroundDelegate.a.dkh)) && (AppForegroundDelegate.g(AppForegroundDelegate.this) != null))
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.g(AppForegroundDelegate.this));
          AppForegroundDelegate.a(AppForegroundDelegate.this, null);
        }
        if (parama == AppForegroundDelegate.a.dkg)
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
        if (parama == AppForegroundDelegate.a.dkh)
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
              Log.w("MicroMsg.AppForegroundDelegate", "[PAUSED] delay to check background in stop!");
              AppMethodBeat.o(131744);
            }
          }), 600L);
          AppMethodBeat.o(131748);
          return;
        }
        if ((parama == AppForegroundDelegate.a.dki) || (parama == AppForegroundDelegate.a.dkj))
        {
          if (parama == AppForegroundDelegate.a.dki) {
            this.dko.add(paramString1);
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
        AppForegroundDelegate.fX(paramActivity);
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, Wf(), AppForegroundDelegate.a.dke);
          AppMethodBeat.o(131749);
          return;
        }
        a(AppForegroundDelegate.a.dke, paramActivity);
        AppMethodBeat.o(131749);
      }
      
      public final void onActivityDestroyed(Activity paramActivity)
      {
        AppMethodBeat.i(131754);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, Wf(), AppForegroundDelegate.a.dkj);
          AppMethodBeat.o(131754);
          return;
        }
        a(AppForegroundDelegate.a.dkj, paramActivity);
        AppMethodBeat.o(131754);
      }
      
      public final void onActivityPaused(Activity paramActivity)
      {
        AppMethodBeat.i(131752);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, Wf(), AppForegroundDelegate.a.dkh);
          AppMethodBeat.o(131752);
          return;
        }
        a(AppForegroundDelegate.a.dkh, paramActivity);
        AppMethodBeat.o(131752);
      }
      
      public final void onActivityResumed(Activity paramActivity)
      {
        AppMethodBeat.i(131751);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, Wf(), AppForegroundDelegate.a.dkg);
          AppMethodBeat.o(131751);
          return;
        }
        a(AppForegroundDelegate.a.dkg, paramActivity);
        AppMethodBeat.o(131751);
      }
      
      public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
      
      public final void onActivityStarted(Activity paramActivity)
      {
        AppMethodBeat.i(131750);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, Wf(), AppForegroundDelegate.a.dkf);
          AppMethodBeat.o(131750);
          return;
        }
        a(AppForegroundDelegate.a.dkf, paramActivity);
        AppMethodBeat.o(131750);
      }
      
      public final void onActivityStopped(Activity paramActivity)
      {
        AppMethodBeat.i(131753);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, Wf(), AppForegroundDelegate.a.dki);
          AppMethodBeat.o(131753);
          return;
        }
        a(AppForegroundDelegate.a.dki, paramActivity);
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
          Log.i("MicroMsg.AppForegroundDelegate", "ACTION_SCREEN:%s isAppForeground:%s", new Object[] { paramContext, Boolean.valueOf(AppForegroundDelegate.c(AppForegroundDelegate.this)) });
          if ("android.intent.action.SCREEN_OFF".equals(paramContext))
          {
            AppForegroundDelegate.a(AppForegroundDelegate.this, true);
            paramContext = AppForegroundDelegate.We();
            paramIntent = AppForegroundDelegate.c.this.dkl;
            localObject = AppForegroundDelegate.d(AppForegroundDelegate.this);
            paramContext.dkl = paramIntent;
            paramContext.aDv = ((Handler)localObject);
            paramContext.dkm = 0;
            paramContext.daZ = true;
            AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.We(), 5000L);
          }
          for (;;)
          {
            h.RTc.b(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(131742);
                synchronized (AppForegroundDelegate.e(AppForegroundDelegate.this))
                {
                  LinkedList localLinkedList = new LinkedList(AppForegroundDelegate.e(AppForegroundDelegate.this));
                  ??? = localLinkedList.iterator();
                  if (((Iterator)???).hasNext()) {
                    ((p)((Iterator)???).next()).cM(AppForegroundDelegate.f(AppForegroundDelegate.this));
                  }
                }
                AppMethodBeat.o(131742);
              }
            }, "MicroMsg.AppForegroundDelegate");
            AppMethodBeat.o(131746);
            return;
            AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.We());
            AppForegroundDelegate.a(AppForegroundDelegate.this, false);
          }
        }
        paramContext = AppForegroundDelegate.a.fY(paramContext);
        if ((paramContext == AppForegroundDelegate.a.dkf) || (paramContext == AppForegroundDelegate.a.dkg))
        {
          AppForegroundDelegate.We().daZ = false;
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.We());
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
    LinkedList<String> dkr;
    
    public d(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(196960);
      this.dkr = new LinkedList();
      a(paramString, parama);
      AppMethodBeat.o(196960);
    }
    
    public final boolean a(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(196961);
      String str = paramString + "#" + parama;
      if (!this.dkr.contains(str))
      {
        if (parama == AppForegroundDelegate.a.dkg) {
          this.dkr.add(str);
        }
        for (;;)
        {
          AppMethodBeat.o(196961);
          return true;
          if (parama == AppForegroundDelegate.a.dkh) {
            this.dkr.remove(paramString + "#" + AppForegroundDelegate.a.dkg);
          }
        }
      }
      AppMethodBeat.o(196961);
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
        MMApplicationContext.getContext().sendBroadcast(localIntent, AppForegroundDelegate.djS);
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