package com.tencent.mm.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.util.ArrayMap;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.ab;
import com.tencent.mm.pluginsdk.model.ab.a;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.xwebutil.b;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.xweb.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

public final class ToolsProfile
  extends com.tencent.mm.compatible.loader.c
{
  public static final String PROCESS_NAME;
  private static final String TAG;
  private static Locale locale;
  private int feR;
  
  static
  {
    AppMethodBeat.i(19501);
    PROCESS_NAME = MMApplicationContext.getProcessName();
    TAG = "MicroMsg." + b.getModuleName() + "Profile";
    AppMethodBeat.o(19501);
  }
  
  public ToolsProfile()
  {
    AppMethodBeat.i(19498);
    this.feR = 0;
    AppMethodBeat.o(19498);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19500);
    paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext());
    Log.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + paramConfiguration.toString());
    if (!paramConfiguration.equals(locale))
    {
      Log.w(TAG, "language changed, restart process");
      paramConfiguration = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramConfiguration.aFh(), "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramConfiguration.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    }
    AppMethodBeat.o(19500);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19499);
    long l = System.currentTimeMillis();
    ToolsProfile.class.getClassLoader();
    t.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
    {
      public final void uncaughtException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(292370);
        KVCommCrossProcessReceiver.fBy();
        AppMethodBeat.o(292370);
      }
    });
    Log.i("MicroMsg.ToolsProfileTest", PROCESS_NAME);
    t.f(false, PROCESS_NAME);
    AppLogic.setCallBack(new AppCallBack(MMApplicationContext.getContext()));
    Object localObject = new w(com.tencent.mm.booter.d.cc(this.app.getBaseContext()));
    ((w)localObject).JC("TOOL");
    com.tencent.mm.platformtools.ac.mEX = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ac.mEY = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ac.mEZ = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ac.mFa = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ac.mFb = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ac.mFc = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ac.mFh = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ac.mFi = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ac.mFl = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ac.mFm = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ac.mFn = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ac.mFo = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ac.mFr = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ac.mFs = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(((w)localObject).JD(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ac.mFp = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ac.mFp > 0))
    {
      com.tencent.mm.storage.aq.VfZ = com.tencent.mm.platformtools.ac.mFp;
      Log.e("MicroMsg.ToolDebugger", "cdn thread num " + com.tencent.mm.platformtools.ac.mFp);
    }
    com.tencent.mm.platformtools.ac.mFq = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(((w)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.arg(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = ((w)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.kQZ = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.RAy = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.RAA = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.kQZ).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(((w)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.RAC).append(" new: ").append(i);
          com.tencent.mm.protocal.d.RAC = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(((w)localObject).getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            ((com.tencent.mm.booter.q)localObject).iQW.iPy = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                com.tencent.mm.platformtools.ac.mFH = Util.nullAs(((w)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                Log.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ac.mFH);
                com.tencent.mm.platformtools.ac.mFI = Util.nullAs(((w)localObject).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                Log.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + com.tencent.mm.platformtools.ac.mFI);
                com.tencent.mm.platformtools.ac.mFJ = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.skiploadurlcheck"), false);
                Log.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + com.tencent.mm.platformtools.ac.mFJ);
                com.tencent.mm.platformtools.ac.mFK = Util.nullAs(((w)localObject).JE(".com.tencent.mm.debug.forcex5webview"), false);
                Log.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + com.tencent.mm.platformtools.ac.mFK);
                f.bE(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw);
                a.aak();
                j.KW("wcdb");
                j.KW("commonimgdec");
                j.KW("wechatcommon");
                j.KW("wechatbase");
                j.KW(CommLibFileName.quic);
                j.KW("wechatmm");
                j.KW("FFmpeg");
                j.KW("wechatpack");
                i = m.aus();
                if ((i & 0x400) == 0) {
                  break label1311;
                }
                Log.i(TAG, "load wechatsight_v7a, core number: %d ", new Object[] { Integer.valueOf(i >> 12) });
                j.KW("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.d.JrF = 3;
                com.tencent.mm.plugin.sight.base.d.JrH = 3;
                com.tencent.mm.plugin.sight.base.d.JrI = 544000;
                SightVideoJNI.registerALL();
                locale = MMActivity.initLanguage(this.app.getBaseContext());
                ac.abg();
                if ((com.tencent.mm.compatible.util.d.qV(14)) && (d.fcb != null)) {
                  d.fcb.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
                  {
                    private Set<Activity> feT;
                    
                    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
                    {
                      AppMethodBeat.i(268203);
                      ToolsProfile.a(ToolsProfile.this);
                      this.feT.add(paramAnonymousActivity);
                      AppMethodBeat.o(268203);
                    }
                    
                    public final void onActivityDestroyed(Activity paramAnonymousActivity)
                    {
                      AppMethodBeat.i(268204);
                      ToolsProfile.b(ToolsProfile.this);
                      Log.d(ToolsProfile.TAG, "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[] { Integer.valueOf(ToolsProfile.c(ToolsProfile.this)) });
                      if (ToolsProfile.c(ToolsProfile.this) == 0)
                      {
                        ToolsProfile.a.access$200();
                        boolean bool = WebView.getCanReboot();
                        Log.i(ToolsProfile.TAG, "onActivityDestroyed, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
                        if ((bool) && (!ToolsProfile.a.isLocked()))
                        {
                          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                          Object localObject = new Object();
                          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                          Process.killProcess(((Integer)locala.sf(0)).intValue());
                          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        }
                      }
                      this.feT.remove(paramAnonymousActivity);
                      AppMethodBeat.o(268204);
                    }
                    
                    public final void onActivityPaused(Activity paramAnonymousActivity)
                    {
                      AppMethodBeat.i(268205);
                      this.feT.remove(paramAnonymousActivity);
                      ToolsProfile.a.access$300();
                      AppMethodBeat.o(268205);
                    }
                    
                    public final void onActivityResumed(Activity paramAnonymousActivity)
                    {
                      AppMethodBeat.i(268206);
                      if (!this.feT.contains(paramAnonymousActivity)) {
                        ToolsProfile.a.access$400();
                      }
                      AppMethodBeat.o(268206);
                    }
                    
                    public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
                    
                    public final void onActivityStarted(Activity paramAnonymousActivity) {}
                    
                    public final void onActivityStopped(Activity paramAnonymousActivity) {}
                  });
                }
                Log.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - l));
                if (MMApplicationContext.isToolsProcess())
                {
                  ab.D("use_sandbox", Boolean.TRUE);
                  ab.D("sandbox_crash_record0", new com.tencent.mm.vfs.q(MMApplicationContext.getContext().getFilesDir(), "crash/java_" + MMApplicationContext.getPackageName() + ":isolated_process0").bOF());
                  ab.D("sandbox_crash_record1", new com.tencent.mm.vfs.q(MMApplicationContext.getContext().getFilesDir(), "crash/" + MMApplicationContext.getPackageName() + ":isolated_process0").bOF());
                }
                ab.a.jt(MMApplicationContext.getContext());
                com.tencent.mm.pluginsdk.ui.span.d.a.RrK = com.tencent.mm.app.plugin.f.abQ();
                EventCenter.instance.addListener(new v(22, 32));
                ab.a.hhi();
                if (!MMApplicationContext.isToolsMpProcess()) {
                  break label1370;
                }
                localObject = com.tencent.mm.plugin.appbrand.ae.a.a.c.rkl;
                try
                {
                  com.tencent.mm.plugin.appbrand.ae.a.a.c.cmr().clearAll();
                  Log.i("MicroMsg.AppBrand.ThumbPlayerInitLogic", "resetPreloadData");
                  AppMethodBeat.o(19499);
                  return;
                }
                catch (Exception localException1)
                {
                  Log.printErrStackTrace("MicroMsg.AppBrand.ThumbPlayerInitLogic", (Throwable)localException1, "", new Object[0]);
                }
                localException2 = localException2;
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
              }
            }
            catch (Exception localException6)
            {
              for (;;)
              {
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.d.JrF = 1;
                com.tencent.mm.plugin.sight.base.d.JrH = 1;
                com.tencent.mm.plugin.sight.base.d.JrI = 640000;
                continue;
                label1311:
                Log.i(TAG, "load wechatsight");
                j.KW("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.d.JrF = 1;
                com.tencent.mm.plugin.sight.base.d.JrH = 1;
                com.tencent.mm.plugin.sight.base.d.JrI = 640000;
              }
              label1370:
              AppMethodBeat.o(19499);
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return PROCESS_NAME;
  }
  
  public static final class a
  {
    private static final AtomicInteger feU;
    private static Object feV;
    
    static
    {
      AppMethodBeat.i(19497);
      feU = new AtomicInteger(0);
      AppMethodBeat.o(19497);
    }
    
    public static boolean abu()
    {
      AppMethodBeat.i(280530);
      if ((feU.get() > 0) || ((gW("com.tencent.mm:tools")) && (gW("com.tencent.mm:toolsmp"))))
      {
        AppMethodBeat.o(280530);
        return true;
      }
      AppMethodBeat.o(280530);
      return false;
    }
    
    private static boolean abv()
    {
      AppMethodBeat.i(19493);
      try
      {
        if (feV == null)
        {
          Object localObject2 = MMApplicationContext.getContext();
          Object localObject1 = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
          ((Method)localObject1).setAccessible(true);
          localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
          if (localObject1 != null) {}
          for (;;)
          {
            feV = localObject1;
            localObject1 = (ArrayMap)org.a.a.gY(localObject1).bIx("mServices").object;
            int i = ((ArrayMap)localObject1).size();
            if (i > 0) {
              break;
            }
            AppMethodBeat.o(19493);
            return true;
            localObject1 = localObject2.getClass().getField("mLoadedApk");
            ((Field)localObject1).setAccessible(true);
            localObject1 = ((Field)localObject1).get(localObject2);
            localObject2 = localObject1.getClass().getDeclaredField("mActivityThread");
            ((Field)localObject2).setAccessible(true);
            localObject1 = ((Field)localObject2).get(localObject1);
          }
          if (((ArrayMap)localObject1).size() == 1)
          {
            boolean bool = localObject1.values().toArray()[0] instanceof BaseIPCService;
            if (bool)
            {
              AppMethodBeat.o(19493);
              return true;
            }
          }
          AppMethodBeat.o(19493);
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("MicroMsg.ToolsProcessLocker", "skipServiceConditionIfOnlyIPCServiceAlive, hack ActivityThread_mServices e=%s", new Object[] { localThrowable });
        AppMethodBeat.o(19493);
      }
      return false;
    }
    
    @SuppressLint({"InlinedApi"})
    private static boolean gW(String paramString)
    {
      AppMethodBeat.i(280531);
      Object localObject = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
      if (localObject == null)
      {
        AppMethodBeat.o(280531);
        return false;
      }
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null)
      {
        AppMethodBeat.o(280531);
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (paramString.equals(localRunningAppProcessInfo.processName))
        {
          int i = localRunningAppProcessInfo.importance;
          if (!com.tencent.mm.compatible.loader.a.contains(new int[] { 100 }, i))
          {
            i = localRunningAppProcessInfo.importance;
            if ((!com.tencent.mm.compatible.loader.a.contains(new int[] { 300, 125 }, i)) || (abv()))
            {
              i = localRunningAppProcessInfo.importanceReasonCode;
              if (!com.tencent.mm.compatible.loader.a.contains(new int[] { 1, 2 }, i)) {
                break label214;
              }
            }
          }
          label214:
          for (boolean bool = true;; bool = false)
          {
            Log.i("MicroMsg.ToolsProcessLocker", "hasRunningServicesOrProviders:%b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localRunningAppProcessInfo.importance), Integer.valueOf(localRunningAppProcessInfo.importanceReasonCode) });
            if (!bool) {
              break;
            }
            AppMethodBeat.o(280531);
            return true;
          }
        }
      }
      AppMethodBeat.o(280531);
      return false;
    }
    
    public static boolean isLocked()
    {
      AppMethodBeat.i(19492);
      if ((feU.get() > 0) || (gW(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName)))
      {
        AppMethodBeat.o(19492);
        return true;
      }
      AppMethodBeat.o(19492);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile
 * JD-Core Version:    0.7.0.1
 */