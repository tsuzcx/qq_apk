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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public enum AppForegroundDelegate
{
  public static final String heZ;
  private static String hfc;
  public static boolean hff;
  private static ArrayList<String> hfi;
  public static boolean hfj;
  private static final c hfk;
  private static ConcurrentHashMap<String, e> hfl;
  public volatile boolean eLx;
  private boolean fcK;
  private Handler hfa;
  private Runnable hfb;
  private WeakReference<Activity> hfd;
  private WeakReference<Activity> hfe;
  public final Set<r> hfg;
  private d hfh;
  private volatile boolean isInit;
  private final Set<q> listeners;
  private Handler mainHandler;
  
  static
  {
    AppMethodBeat.i(131766);
    heY = new AppForegroundDelegate("INSTANCE");
    hfm = new AppForegroundDelegate[] { heY };
    heZ = WeChatPermissions.PERMISSION_MM_MESSAGE();
    hfc = null;
    hff = false;
    hfi = new ArrayList();
    hfj = false;
    hfk = new c((byte)0);
    hfl = new ConcurrentHashMap();
    AppMethodBeat.o(131766);
  }
  
  private AppForegroundDelegate()
  {
    AppMethodBeat.i(131761);
    this.mainHandler = new Handler(Looper.getMainLooper());
    this.hfd = null;
    this.hfe = null;
    this.listeners = new HashSet();
    this.hfg = new HashSet();
    this.eLx = false;
    this.hfh = new d((byte)0);
    this.isInit = false;
    this.fcK = false;
    AppMethodBeat.o(131761);
  }
  
  public static String aCa()
  {
    AppMethodBeat.i(239282);
    if (Util.isNullOrNil(hfc)) {
      hfc = avV();
    }
    String str = hfc;
    AppMethodBeat.o(239282);
    return str;
  }
  
  private static boolean aCd()
  {
    AppMethodBeat.i(239287);
    if (!hff)
    {
      AppMethodBeat.o(239287);
      return true;
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = MMApplicationContext.getAliveProcess();
    Iterator localIterator = hfl.entrySet().iterator();
    boolean bool = true;
    for (;;)
    {
      Map.Entry localEntry;
      JSONObject localJSONObject;
      if (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if (((List)localObject2).contains(localEntry.getKey()))
        {
          if (((e)localEntry.getValue()).hfF.size() <= 0) {
            continue;
          }
          Log.i("MicroMsg.AppForegroundDelegate", "[isFallbackBackgroundValid] printRecord=%s", new Object[] { ((e)localEntry.getValue()).hfF.toString() });
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("isFallbackBackgroundValid=false", ((e)localEntry.getValue()).hfF.toString());
        label164:
        f.Ozc.b(20459, new Object[] { localJSONObject.toString().replaceAll(",", ";"), Long.valueOf(3L) });
        bool = false;
        continue;
        ((LinkedList)localObject1).add((String)localEntry.getKey());
        continue;
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          hfl.remove(localObject2);
        }
        AppMethodBeat.o(239287);
        return bool;
      }
      catch (JSONException localJSONException)
      {
        break label164;
      }
    }
  }
  
  public static WeakReference<Activity> aCe()
  {
    AppMethodBeat.i(239294);
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
        AppMethodBeat.o(239294);
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
          AppMethodBeat.o(239294);
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(239294);
    }
    return null;
  }
  
  private static String avV()
  {
    AppMethodBeat.i(239290);
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
        AppMethodBeat.o(239290);
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
          AppMethodBeat.o(239290);
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(239290);
    }
    return null;
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(131762);
    if (this.eLx) {
      paramq.onAppForeground(this.hfh.hfy.hfG);
    }
    synchronized (this.listeners)
    {
      this.listeners.add(paramq);
      AppMethodBeat.o(131762);
      return;
    }
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(239356);
    synchronized (this.hfg)
    {
      this.hfg.add(paramr);
      AppMethodBeat.o(239356);
      return;
    }
  }
  
  public final WeakReference<Activity> aCb()
  {
    AppMethodBeat.i(239347);
    if ((this.hfd == null) || (this.hfd.get() == null)) {
      this.hfd = aCe();
    }
    WeakReference localWeakReference = this.hfd;
    AppMethodBeat.o(239347);
    return localWeakReference;
  }
  
  public final WeakReference<Activity> aCc()
  {
    AppMethodBeat.i(239352);
    if ((this.hfe == null) || (this.hfe.get() == null)) {
      this.hfe = aCe();
    }
    WeakReference localWeakReference = this.hfe;
    AppMethodBeat.o(239352);
    return localWeakReference;
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(131763);
    synchronized (this.listeners)
    {
      this.listeners.remove(paramq);
      AppMethodBeat.o(131763);
      return;
    }
  }
  
  public final void c(Application paramApplication)
  {
    AppMethodBeat.i(239346);
    if (this.isInit)
    {
      Log.e("MicroMsg.AppForegroundDelegate", "has init!");
      AppMethodBeat.o(239346);
      return;
    }
    this.isInit = true;
    localObject1 = new HandlerThread("AppForegroundDelegate");
    ((HandlerThread)localObject1).start();
    this.hfa = new Handler(((HandlerThread)localObject1).getLooper());
    if (MMApplicationContext.isMainProcess())
    {
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction(a.a(a.hfp));
      ((IntentFilter)localObject1).addAction(a.a(a.hfq));
      ((IntentFilter)localObject1).addAction(a.a(a.hfr));
      ((IntentFilter)localObject1).addAction(a.a(a.hfs));
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
      paramApplication.registerReceiver(this.hfh.hfA, (IntentFilter)localObject1, heZ, null);
    }
    for (;;)
    {
      paramApplication.registerActivityLifecycleCallbacks(this.hfh.hfA);
      paramApplication.registerComponentCallbacks(this.hfh.hfA);
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
      ((IntentFilter)localObject1).addAction("com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
      paramApplication.registerReceiver(this.hfh.hfy, (IntentFilter)localObject1, heZ, null);
      AppMethodBeat.o(239346);
      return;
      if (MMApplicationContext.getProcessName().endsWith(":dexopt"))
      {
        AppMethodBeat.o(239346);
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
          this.eLx = localBundle1.getBoolean("isAppForeground");
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
            f.Ozc.idkeyStat(1118L, 0L, 1L, true);
            localObject2 = localObject1;
          }
          else
          {
            f.Ozc.idkeyStat(1118L, 1L, 1L, true);
            localObject2 = localObject1;
            continue;
            localObject1 = localObject2.getString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
          }
        }
      }
      if (localBundle1 != null) {
        break label443;
      }
      localObject1 = "";
      Log.i("MicroMsg.AppForegroundDelegate", "[init] process:%s isAppForeground:%s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(this.eLx) });
      if (this.eLx) {
        this.mainHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131735);
            Intent localIntent = new Intent();
            localIntent.setAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
            localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", this.fcG);
            AppForegroundDelegate.a(AppForegroundDelegate.this).hfy.onReceive(MMApplicationContext.getContext(), localIntent);
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
      AppMethodBeat.i(239093);
      AUTHORITY = WeChatAuthorities.AUTHORITIES_APPFOREGROUNDDELEGATE_PROVIDER();
      AppMethodBeat.o(239093);
    }
    
    public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
    {
      AppMethodBeat.i(131758);
      if (paramString1.equals("isAppForeground"))
      {
        paramString1 = new Bundle();
        paramString1.putString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", AppForegroundDelegate.a(AppForegroundDelegate.heY).hfy.hfG);
        paramString1.putBoolean("isAppForeground", AppForegroundDelegate.c(AppForegroundDelegate.heY));
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
      hfo = new a("CREATED", 0, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_CREATED");
      hfp = new a("STARTED", 1, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STARTED");
      hfq = new a("RESUMED", 2, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_RESUMED");
      hfr = new a("PAUSED", 3, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_PAUSED");
      hfs = new a("STOPPED", 4, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STOPPED");
      hft = new a("DESTROY", 5, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_DESTROY");
      hfu = new a[] { hfo, hfp, hfq, hfr, hfs, hft };
      AppMethodBeat.o(131741);
    }
    
    private a(String paramString)
    {
      this.value = paramString;
    }
    
    public static a ij(String paramString)
    {
      AppMethodBeat.i(131740);
      if (paramString.equals(hfp.value))
      {
        paramString = hfp;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(hfq.value))
      {
        paramString = hfq;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(hfr.value))
      {
        paramString = hfr;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(hfs.value))
      {
        paramString = hfs;
        AppMethodBeat.o(131740);
        return paramString;
      }
      AppMethodBeat.o(131740);
      return null;
    }
  }
  
  static final class c
    implements Runnable
  {
    public boolean clZ = true;
    AppForegroundDelegate.f hfy;
    int hfz = 0;
    Handler mainHandler;
    
    public final void run()
    {
      AppMethodBeat.i(239267);
      Log.i("MicroMsg.AppForegroundDelegate", "CheckExceptionRunnable... isValid=%s checkErrorCount=%s isAppForeground=%s", new Object[] { Boolean.valueOf(this.clZ), Integer.valueOf(this.hfz), Boolean.valueOf(AppForegroundDelegate.c(AppForegroundDelegate.heY)) });
      if (!this.clZ)
      {
        AppMethodBeat.o(239267);
        return;
      }
      JSONObject localJSONObject;
      if ((AppForegroundDelegate.c(AppForegroundDelegate.heY)) && (this.hfz >= 2))
      {
        Log.e("MicroMsg.AppForegroundDelegate", "check error! isScreenOff is true but isAppForeground is true");
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("isOpenFallbackCheck", AppForegroundDelegate.hff);
        label103:
        f.Ozc.b(20459, new Object[] { localJSONObject.toString().replaceAll(",", ";"), Long.valueOf(3L) });
        if (AppForegroundDelegate.hff) {
          f.Ozc.idkeyStat(1439L, 11L, 1L, false);
        }
        for (;;)
        {
          f.Ozc.idkeyStat(1439L, 13L, 1L, false);
          AppForegroundDelegate.aCf().clear();
          if (this.hfy != null) {
            AppForegroundDelegate.f.e(false, "fallback");
          }
          AppMethodBeat.o(239267);
          return;
          f.Ozc.idkeyStat(1439L, 12L, 1L, false);
        }
        if ((AppForegroundDelegate.c(AppForegroundDelegate.heY)) && (this.hfz < 2))
        {
          this.hfz += 1;
          this.mainHandler.postDelayed(this, 5000L);
        }
        AppMethodBeat.o(239267);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label103;
      }
    }
  }
  
  final class d
  {
    a hfA;
    AppForegroundDelegate.f hfy;
    
    private d()
    {
      AppMethodBeat.i(131755);
      this.hfA = new a((byte)0);
      this.hfy = new AppForegroundDelegate.f(AppForegroundDelegate.this, (byte)0);
      AppMethodBeat.o(131755);
    }
    
    final class a
      extends BroadcastReceiver
      implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
    {
      private HashSet<String> hfB;
      
      private a()
      {
        AppMethodBeat.i(131745);
        this.hfB = new HashSet();
        AppMethodBeat.o(131745);
      }
      
      private static void a(AppForegroundDelegate.a parama, String paramString)
      {
        AppMethodBeat.i(131747);
        Intent localIntent = new Intent();
        localIntent.setAction(AppForegroundDelegate.a.a(parama));
        localIntent.putExtra("_application_context_process_", aCi());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        MMApplicationContext.getContext().sendBroadcast(localIntent, AppForegroundDelegate.heZ);
        AppMethodBeat.o(131747);
      }
      
      private static void a(AppForegroundDelegate.b paramb, Activity paramActivity)
      {
        AppMethodBeat.i(239110);
        Intent localIntent = new Intent();
        localIntent.setAction(paramb.value);
        localIntent.putExtra("_application_context_process_", aCi());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_REF", paramActivity.hashCode());
        AppMethodBeat.o(239110);
      }
      
      private void a(final String paramString1, String paramString2, AppForegroundDelegate.a parama)
      {
        AppMethodBeat.i(131748);
        Log.i("MicroMsg.AppForegroundDelegate", "[checkAlive] activityName:%s process:%s action:%s", new Object[] { paramString1, paramString2, parama.name() });
        AppForegroundDelegate.a(paramString2, parama, paramString1);
        if (parama == AppForegroundDelegate.a.hfp)
        {
          if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
            AppForegroundDelegate.f.e(true, paramString1);
          }
          this.hfB.remove(paramString1);
        }
        if (((parama == AppForegroundDelegate.a.hfo) || (parama == AppForegroundDelegate.a.hfp) || (parama == AppForegroundDelegate.a.hfq) || (parama == AppForegroundDelegate.a.hfr)) && (AppForegroundDelegate.g(AppForegroundDelegate.this) != null))
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.g(AppForegroundDelegate.this));
          AppForegroundDelegate.a(AppForegroundDelegate.this, null);
        }
        if (parama == AppForegroundDelegate.a.hfq)
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131743);
              if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                AppForegroundDelegate.f.e(true, paramString1);
              }
              AppMethodBeat.o(131743);
            }
          }), 600L);
          AppMethodBeat.o(131748);
          return;
        }
        if (parama == AppForegroundDelegate.a.hfr)
        {
          AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131744);
              if ((AppForegroundDelegate.c(AppForegroundDelegate.this)) && (AppForegroundDelegate.d.a.a(AppForegroundDelegate.d.a.this).remove(paramString1)))
              {
                AppForegroundDelegate.f.e(false, paramString1);
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
        if ((parama == AppForegroundDelegate.a.hfs) || (parama == AppForegroundDelegate.a.hft))
        {
          if (parama == AppForegroundDelegate.a.hfs) {
            this.hfB.add(paramString1);
          }
          if (AppForegroundDelegate.g(AppForegroundDelegate.this) == null) {
            AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182866);
                if (AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                  AppForegroundDelegate.f.e(false, paramString1);
                }
                AppMethodBeat.o(182866);
              }
            }), 600L);
          }
        }
        AppMethodBeat.o(131748);
      }
      
      private static String aCi()
      {
        AppMethodBeat.i(239125);
        String str = MMApplicationContext.getProcessName() + "@" + Process.myPid();
        AppMethodBeat.o(239125);
        return str;
      }
      
      public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
      {
        AppMethodBeat.i(131749);
        paramBundle = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        AppForegroundDelegate.ii(paramBundle);
        AppForegroundDelegate.b(AppForegroundDelegate.this, new WeakReference(paramActivity));
        AppForegroundDelegate.aCh().add(paramActivity.getClass().getName());
        if (MMApplicationContext.isMainProcess())
        {
          a(paramBundle, aCi(), AppForegroundDelegate.a.hfo);
          AppMethodBeat.o(131749);
          return;
        }
        a(AppForegroundDelegate.a.hfo, paramBundle);
        AppMethodBeat.o(131749);
      }
      
      public final void onActivityDestroyed(Activity paramActivity)
      {
        AppMethodBeat.i(131754);
        String str = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        AppForegroundDelegate.aCh().remove(paramActivity.getClass().getName());
        if (MMApplicationContext.isMainProcess()) {
          a(str, aCi(), AppForegroundDelegate.a.hft);
        }
        for (;;)
        {
          a(AppForegroundDelegate.b.hfw, paramActivity);
          AppMethodBeat.o(131754);
          return;
          a(AppForegroundDelegate.a.hft, str);
        }
      }
      
      public final void onActivityPaused(Activity paramActivity)
      {
        AppMethodBeat.i(131752);
        AppForegroundDelegate.hfj = false;
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, aCi(), AppForegroundDelegate.a.hfr);
          AppMethodBeat.o(131752);
          return;
        }
        a(AppForegroundDelegate.a.hfr, paramActivity);
        AppMethodBeat.o(131752);
      }
      
      public final void onActivityPreCreated(Activity paramActivity, Bundle paramBundle)
      {
        AppMethodBeat.i(239140);
        a(AppForegroundDelegate.b.hfv, paramActivity);
        AppForegroundDelegate.a(AppForegroundDelegate.this, new WeakReference(paramActivity));
        AppMethodBeat.o(239140);
      }
      
      public final void onActivityResumed(Activity paramActivity)
      {
        AppMethodBeat.i(131751);
        AppForegroundDelegate.hfj = true;
        String str = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        AppForegroundDelegate.a(AppForegroundDelegate.this, new WeakReference(paramActivity));
        if (MMApplicationContext.isMainProcess())
        {
          a(str, aCi(), AppForegroundDelegate.a.hfq);
          AppMethodBeat.o(131751);
          return;
        }
        a(AppForegroundDelegate.a.hfq, str);
        AppMethodBeat.o(131751);
      }
      
      public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
      
      public final void onActivityStarted(Activity paramActivity)
      {
        AppMethodBeat.i(131750);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, aCi(), AppForegroundDelegate.a.hfp);
          AppMethodBeat.o(131750);
          return;
        }
        a(AppForegroundDelegate.a.hfp, paramActivity);
        AppMethodBeat.o(131750);
      }
      
      public final void onActivityStopped(Activity paramActivity)
      {
        AppMethodBeat.i(131753);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (MMApplicationContext.isMainProcess())
        {
          a(paramActivity, aCi(), AppForegroundDelegate.a.hfs);
          AppMethodBeat.o(131753);
          return;
        }
        a(AppForegroundDelegate.a.hfs, paramActivity);
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
            paramContext = AppForegroundDelegate.aCg();
            paramIntent = AppForegroundDelegate.d.this.hfy;
            localObject = AppForegroundDelegate.d(AppForegroundDelegate.this);
            paramContext.hfy = paramIntent;
            paramContext.mainHandler = ((Handler)localObject);
            paramContext.hfz = 0;
            paramContext.clZ = true;
            AppForegroundDelegate.d(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.aCg(), 5000L);
          }
          for (;;)
          {
            h.ahAA.g(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(131742);
                synchronized (AppForegroundDelegate.e(AppForegroundDelegate.this))
                {
                  LinkedList localLinkedList = new LinkedList(AppForegroundDelegate.e(AppForegroundDelegate.this));
                  ??? = localLinkedList.iterator();
                  if (((Iterator)???).hasNext()) {
                    ((r)((Iterator)???).next()).onScreen(AppForegroundDelegate.f(AppForegroundDelegate.this));
                  }
                }
              }
            }, "MicroMsg.AppForegroundDelegate");
            AppMethodBeat.o(131746);
            return;
            AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.aCg());
            AppForegroundDelegate.a(AppForegroundDelegate.this, false);
          }
        }
        paramContext = AppForegroundDelegate.a.ij(paramContext);
        if ((paramContext == AppForegroundDelegate.a.hfp) || (paramContext == AppForegroundDelegate.a.hfq))
        {
          AppForegroundDelegate.aCg().clZ = false;
          AppForegroundDelegate.d(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.aCg());
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
  
  static final class e
  {
    LinkedList<String> hfF;
    
    public e(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(239259);
      this.hfF = new LinkedList();
      a(paramString, parama);
      AppMethodBeat.o(239259);
    }
    
    public final boolean a(String paramString, AppForegroundDelegate.a parama)
    {
      AppMethodBeat.i(239262);
      String str = paramString + "#" + parama;
      if (!this.hfF.contains(str))
      {
        if (parama == AppForegroundDelegate.a.hfq) {
          this.hfF.add(str);
        }
        for (;;)
        {
          AppMethodBeat.o(239262);
          return true;
          if (parama == AppForegroundDelegate.a.hfr) {
            this.hfF.remove(paramString + "#" + AppForegroundDelegate.a.hfq);
          }
        }
      }
      AppMethodBeat.o(239262);
      return false;
    }
  }
  
  final class f
    extends BroadcastReceiver
  {
    public String hfG;
    
    private f() {}
    
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
        MMApplicationContext.getContext().sendBroadcast(localIntent, AppForegroundDelegate.heZ);
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
      this.hfG = paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
      long l = paramIntent.getLongExtra("com.tencent.mm.AppForegroundDelegate.DISPATCH_TIME", 0L);
      boolean bool = "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE".equalsIgnoreCase(paramContext);
      l = SystemClock.uptimeMillis() - l;
      if (bool)
      {
        AppForegroundDelegate.a(AppForegroundDelegate.this, this.hfG, l);
        AppMethodBeat.o(131756);
        return;
      }
      AppForegroundDelegate.b(AppForegroundDelegate.this, this.hfG, l);
      AppMethodBeat.o(131756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.app.AppForegroundDelegate
 * JD-Core Version:    0.7.0.1
 */