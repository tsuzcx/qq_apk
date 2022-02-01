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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import java.lang.ref.WeakReference;
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
  private static String fbC;
  public static boolean fbE;
  private static final b fbH;
  private static ConcurrentHashMap<String, d> fbI;
  public static final String fbz;
  public volatile boolean cQt;
  private boolean ddZ;
  private Handler die;
  private Handler fbA;
  private Runnable fbB;
  public WeakReference<Activity> fbD;
  public final Set<p> fbF;
  private c fbG;
  private volatile boolean isInit;
  private final Set<o> listeners;
  
  static
  {
    AppMethodBeat.i(131766);
    fby = new AppForegroundDelegate("INSTANCE");
    fbJ = new AppForegroundDelegate[] { fby };
    fbz = WeChatPermissions.PERMISSION_MM_MESSAGE();
    fbC = null;
    fbE = false;
    fbH = new b((byte)0);
    fbI = new ConcurrentHashMap();
    AppMethodBeat.o(131766);
  }
  
  private AppForegroundDelegate()
  {
    AppMethodBeat.i(131761);
    this.die = new Handler(Looper.getMainLooper());
    this.fbD = null;
    this.listeners = new HashSet();
    this.fbF = new HashSet();
    this.cQt = false;
    this.fbG = new c((byte)0);
    this.isInit = false;
    this.ddZ = false;
    AppMethodBeat.o(131761);
  }
  
  private static String Vs()
  {
    AppMethodBeat.i(194051);
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
        AppMethodBeat.o(194051);
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
          AppMethodBeat.o(194051);
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(194051);
    }
    return null;
  }
  
  public static String aaw()
  {
    AppMethodBeat.i(194043);
    if (Util.isNullOrNil(fbC)) {
      fbC = Vs();
    }
    String str = fbC;
    AppMethodBeat.o(194043);
    return str;
  }
  
  public static WeakReference<Activity> aay()
  {
    AppMethodBeat.i(194058);
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
        AppMethodBeat.o(194058);
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
          localObject1 = new WeakReference((Activity)((Field)localObject2).get(localObject1));
          AppMethodBeat.o(194058);
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(194058);
    }
    return null;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(131762);
    if (this.cQt) {
      paramo.onAppForeground(this.fbG.fbT.fca);
    }
    synchronized (this.listeners)
    {
      this.listeners.add(paramo);
      AppMethodBeat.o(131762);
      return;
    }
  }
  
  public final boolean aax()
  {
    return this.cQt;
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
  
  public final void c(Application paramApplication)
  {
    AppMethodBeat.i(194041);
    if (this.isInit)
    {
      Log.e("MicroMsg.AppForegroundDelegate", "has init!");
      AppMethodBeat.o(194041);
      return;
    }
    this.isInit = true;
    localObject1 = new HandlerThread("AppForegroundDelegate");
    ((HandlerThread)localObject1).start();
    this.fbA = new Handler(((HandlerThread)localObject1).getLooper());
    if (MMApplicationContext.isMainProcess())
    {
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction(a.a(a.fbN));
      ((IntentFilter)localObject1).addAction(a.a(a.fbO));
      ((IntentFilter)localObject1).addAction(a.a(a.fbP));
      ((IntentFilter)localObject1).addAction(a.a(a.fbQ));
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
      paramApplication.registerReceiver(this.fbG.fbV, (IntentFilter)localObject1, fbz, null);
    }
    for (;;)
    {
      paramApplication.registerActivityLifecycleCallbacks(this.fbG.fbV);
      paramApplication.registerComponentCallbacks(this.fbG.fbV);
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
      paramApplication.registerReceiver(this.fbG.fbT, (IntentFilter)localObject1, fbz, null);
      AppMethodBeat.o(194041);
      return;
      if (MMApplicationContext.getProcessName().endsWith(":dexopt"))
      {
        AppMethodBeat.o(194041);
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
          this.cQt = localBundle1.getBoolean("isAppForeground");
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
            f.Iyx.idkeyStat(1118L, 0L, 1L, true);
            localObject2 = localObject1;
          }
          else
          {
            f.Iyx.idkeyStat(1118L, 1L, 1L, true);
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
      Log.i("MicroMsg.AppForegroundDelegate", "[init] process:%s isAppForeground:%s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(this.cQt) });
      if (this.cQt) {
        this.die.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131735);
            Intent localIntent = new Intent();
            localIntent.setAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
            localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", this.fbK);
            AppForegroundDelegate.a(AppForegroundDelegate.this).fbT.onReceive(MMApplicationContext.getContext(), localIntent);
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
      AppMethodBeat.i(214797);
      AUTHORITY = WeChatAuthorities.AUTHORITIES_APPFOREGROUNDDELEGATE_PROVIDER();
      AppMethodBeat.o(214797);
    }
    
    public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
    {
      AppMethodBeat.i(131758);
      if (paramString1.equals("isAppForeground"))
      {
        paramString1 = new Bundle();
        paramString1.putString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", AppForegroundDelegate.a(AppForegroundDelegate.fby).fbT.fca);
        paramString1.putBoolean("isAppForeground", AppForegroundDelegate.c(AppForegroundDelegate.fby));
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
      fbM = new a("CREATED", 0, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_CREATED");
      fbN = new a("STARTED", 1, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STARTED");
      fbO = new a("RESUMED", 2, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_RESUMED");
      fbP = new a("PAUSED", 3, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_PAUSED");
      fbQ = new a("STOPPED", 4, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STOPPED");
      fbR = new a("DESTROY", 5, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_DESTROY");
      fbS = new a[] { fbM, fbN, fbO, fbP, fbQ, fbR };
      AppMethodBeat.o(131741);
    }
    
    private a(String paramString)
    {
      this.value = paramString;
    }
    
    public static a gI(String paramString)
    {
      AppMethodBeat.i(131740);
      if (paramString.equals(fbN.value))
      {
        paramString = fbN;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(fbO.value))
      {
        paramString = fbO;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(fbP.value))
      {
        paramString = fbP;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(fbQ.value))
      {
        paramString = fbQ;
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
    public boolean cSY = true;
    Handler die;
    AppForegroundDelegate.e fbT;
    int fbU = 0;
    
    public final void run()
    {
      AppMethodBeat.i(203768);
      Log.i("MicroMsg.AppForegroundDelegate", "CheckExceptionRunnable... isValid=%s checkErrorCount=%s isAppForeground=%s", new Object[] { Boolean.valueOf(this.cSY), Integer.valueOf(this.fbU), Boolean.valueOf(AppForegroundDelegate.c(AppForegroundDelegate.fby)) });
      if (!this.cSY)
      {
        AppMethodBeat.o(203768);
        return;
      }
      if ((AppForegroundDelegate.c(AppForegroundDelegate.fby)) && (this.fbU >= 2))
      {
        Log.e("MicroMsg.AppForegroundDelegate", "check error! isScreenOff is true but isAppForeground is true");
        f.Iyx.a(20459, new Object[] { Boolean.valueOf(AppForegroundDelegate.fbE), Integer.valueOf(2) });
        if (AppForegroundDelegate.fbE) {
          f.Iyx.idkeyStat(1439L, 11L, 1L, false);
        }
        for (;;)
        {
          f.Iyx.idkeyStat(1439L, 13L, 1L, false);
          AppForegroundDelegate.aaz().clear();
          if (this.fbT == null) {
            break;
          }
          AppForegroundDelegate.e.e(false, "fallback");
          AppMethodBeat.o(203768);
          return;
          f.Iyx.idkeyStat(1439L, 12L, 1L, false);
        }
      }
      if ((AppForegroundDelegate.c(AppForegroundDelegate.fby)) && (this.fbU < 2))
      {
        this.fbU += 1;
        this.die.postDelayed(this, 5000L);
      }
      AppMethodBeat.o(203768);
    }
  }
  
  final class c
  {
    AppForegroundDelegate.e fbT;
    a fbV;
    
    private c()
    {
      AppMethodBeat.i(131755);
      this.fbV = new a((byte)0);
      this.fbT = new AppForegroundDelegate.e(AppForegroundDelegate.this, (byte)0);
      AppMethodBeat.o(131755);
    }
    
    final class a
      extends BroadcastReceiver
      implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
    {
      private HashSet<String> fbW;
      
      private a()
      {
        AppMethodBeat.i(131745);
        this.fbW = new HashSet();
        AppMethodBeat.o(131745);
      }
      
      private static void a(AppForegroundDelegate.a parama, String paramString)
      {
        AppMethodBeat.i(131747);
        Intent localIntent = new Intent();
        localIntent.setAction(AppForegroundDelegate.a.a(parama));
        localIntent.putExtra("_application_context_process_", aaB());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        MMApplicationContext.getContext().sendBroadcast(localIntent, AppForegroundDelegate.fbz);
        AppMethodBeat.o(131747);
      }
      
      private void a(final String paramString1, String paramString2, AppForegroundDelegate.a parama)
      {
        AppMethodBeat.i(131748);
        Log.i("MicroMsg.AppForegroundDelegate", "[checkAlive] activityName:%s process:%s action:%s", new Object[] { paramString1, paramString2, parama.name() });
        AppForegroundDelegate.a(paramString2, parama, paramString1);
        if (parama == AppForegroundDelegate.a.fbN)
        {
          if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
            AppForegroundDelegate.e.e(true, paramString1);
          }
          this.fbW.remove(paramString1);
        }
        if (((parama == AppForegroundDelegate.a.fbM) || (parama == AppForegroundDelegate.a.fbN) || (parama == AppForegroundDelegate.a.fbO) || (parama == AppForegroundDelegate.a.fbP)) && (AppForegroundDelegate.g(AppForegroundDelegate.this) != null))
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.g(AppForegroundDelegate.this));
          AppForegroundDelegate.a(AppForegroundDelegate.this, null);
        }
        if (parama == AppForegroundDelegate.a.fbO)
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131743);
              if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                AppForegroundDelegate.e.e(true, paramString1);
              }
              AppMethodBeat.o(131743);
            }
          }), 600L);
          AppMethodBeat.o(131748);
          return;
        }
        if (parama == AppForegroundDelegate.a.fbP)
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131744);
              if ((AppForegroundDelegate.c(AppForegroundDelegate.this)) && (AppForegroundDelegate.c.a.a(AppForegroundDelegate.c.a.this).remove(paramString1)))
              {
                AppForegroundDelegate.e.e(false, paramString1);
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
        if ((parama == AppForegroundDelegate.a.fbQ) || (parama == AppForegroundDelegate.a.fbR))
        {
          if (parama == AppForegroundDelegate.a.fbQ) {
            this.fbW.add(paramString1);
          }
          if (AppForegroundDelegate.g(AppForegroundDelegate.this) == null) {
            AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182866);
                if (AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                  AppForegroundDelegate.e.e(false, paramString1);
                }
                AppMethodBeat.o(182866);
              }
            }), 600L);
          }
        }
        AppMethodBeat.o(131748);
      }
      
      private static String aaB()
      {
        AppMethodBeat.i(200554);
        String str = MMApplicationContext.getProcessName() + "@" + Process.myPid();
        AppMethodBeat.o(200554);
        return str;
      }
      
      public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
      {
        AppMethodBeat.i(131749);
        paramBundle = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        AppForegroundDelegate.gH(paramBundle);
        AppForegroundDelegate.a(AppForegroundDelegate.this, new WeakReference(paramActivity));
        if (MMApplicationContext.isMainProcess())
        {
          a(paramBundle, aaB(), AppForegroundDelegate.a.fbM);
          AppMethodBeat.o(131749);
          return;
        }
        a(AppForegroundDelegate.a.fbM, paramBundle);
        AppMethodBeat.o(131749);
      }
      
      public final void onActivityDestroyed(Activity paramActivity)
      {
        AppMethodBeat.i(131754);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, aaB(), AppForegroundDelegate.a.fbR);
          AppMethodBeat.o(131754);
          return;
        }
        a(AppForegroundDelegate.a.fbR, paramActivity);
        AppMethodBeat.o(131754);
      }
      
      public final void onActivityPaused(Activity paramActivity)
      {
        AppMethodBeat.i(131752);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, aaB(), AppForegroundDelegate.a.fbP);
          AppMethodBeat.o(131752);
          return;
        }
        a(AppForegroundDelegate.a.fbP, paramActivity);
        AppMethodBeat.o(131752);
      }
      
      public final void onActivityResumed(Activity paramActivity)
      {
        AppMethodBeat.i(131751);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, aaB(), AppForegroundDelegate.a.fbO);
          AppMethodBeat.o(131751);
          return;
        }
        a(AppForegroundDelegate.a.fbO, paramActivity);
        AppMethodBeat.o(131751);
      }
      
      public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
      
      public final void onActivityStarted(Activity paramActivity)
      {
        AppMethodBeat.i(131750);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, aaB(), AppForegroundDelegate.a.fbN);
          AppMethodBeat.o(131750);
          return;
        }
        a(AppForegroundDelegate.a.fbN, paramActivity);
        AppMethodBeat.o(131750);
      }
      
      public final void onActivityStopped(Activity paramActivity)
      {
        AppMethodBeat.i(131753);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, aaB(), AppForegroundDelegate.a.fbQ);
          AppMethodBeat.o(131753);
          return;
        }
        a(AppForegroundDelegate.a.fbQ, paramActivity);
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
            paramContext = AppForegroundDelegate.aaA();
            paramIntent = AppForegroundDelegate.c.this.fbT;
            localObject = AppForegroundDelegate.d(AppForegroundDelegate.this);
            paramContext.fbT = paramIntent;
            paramContext.die = ((Handler)localObject);
            paramContext.fbU = 0;
            paramContext.cSY = true;
            AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.aaA(), 5000L);
          }
          for (;;)
          {
            h.ZvG.d(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(131742);
                synchronized (AppForegroundDelegate.e(AppForegroundDelegate.this))
                {
                  LinkedList localLinkedList = new LinkedList(AppForegroundDelegate.e(AppForegroundDelegate.this));
                  ??? = localLinkedList.iterator();
                  if (((Iterator)???).hasNext()) {
                    ((p)((Iterator)???).next()).di(AppForegroundDelegate.f(AppForegroundDelegate.this));
                  }
                }
              }
            }, "MicroMsg.AppForegroundDelegate");
            AppMethodBeat.o(131746);
            return;
            AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.aaA());
            AppForegroundDelegate.a(AppForegroundDelegate.this, false);
          }
        }
        paramContext = AppForegroundDelegate.a.gI(paramContext);
        if ((paramContext == AppForegroundDelegate.a.fbN) || (paramContext == AppForegroundDelegate.a.fbO))
        {
          AppForegroundDelegate.aaA().cSY = false;
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.aaA());
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
    LinkedList<String> fbZ;
    
    public d(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(206465);
      this.fbZ = new LinkedList();
      a(paramString, parama);
      AppMethodBeat.o(206465);
    }
    
    public final boolean a(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(206466);
      String str = paramString + "#" + parama;
      if (!this.fbZ.contains(str))
      {
        if (parama == AppForegroundDelegate.a.fbO) {
          this.fbZ.add(str);
        }
        for (;;)
        {
          AppMethodBeat.o(206466);
          return true;
          if (parama == AppForegroundDelegate.a.fbP) {
            this.fbZ.remove(paramString + "#" + AppForegroundDelegate.a.fbO);
          }
        }
      }
      AppMethodBeat.o(206466);
      return false;
    }
  }
  
  final class e
    extends BroadcastReceiver
  {
    public String fca;
    
    private e() {}
    
    public static void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(131757);
      Intent localIntent = new Intent();
      if (paramBoolean) {}
      for (String str = "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE";; str = "com.tencent.mm.AppForegroundDelegate.ACTION_DEAD")
      {
        localIntent.setAction(str);
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.DISPATCH_TIME", SystemClock.uptimeMillis());
        MMApplicationContext.getContext().sendBroadcast(localIntent, AppForegroundDelegate.fbz);
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
      this.fca = paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
      long l = paramIntent.getLongExtra("com.tencent.mm.AppForegroundDelegate.DISPATCH_TIME", 0L);
      boolean bool = "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE".equalsIgnoreCase(paramContext);
      l = SystemClock.uptimeMillis() - l;
      if (bool)
      {
        AppForegroundDelegate.a(AppForegroundDelegate.this, this.fca, l);
        AppMethodBeat.o(131756);
        return;
      }
      AppForegroundDelegate.b(AppForegroundDelegate.this, this.fca, l);
      AppMethodBeat.o(131756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.AppForegroundDelegate
 * JD-Core Version:    0.7.0.1
 */