package com.tencent.mm.app;

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
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
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
  extends com.tencent.mm.compatible.loader.d
{
  private static final String TAG;
  public static final String cTJ;
  private static Locale locale;
  private int cVj;
  
  static
  {
    AppMethodBeat.i(19501);
    cTJ = aj.getProcessName();
    TAG = "MicroMsg." + com.tencent.mm.cq.b.getModuleName() + "Profile";
    AppMethodBeat.o(19501);
  }
  
  public ToolsProfile()
  {
    AppMethodBeat.i(19498);
    this.cVj = 0;
    AppMethodBeat.o(19498);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19500);
    paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext());
    ad.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + paramConfiguration.toString());
    if (!paramConfiguration.equals(locale))
    {
      ad.w(TAG, "language changed, restart process");
      paramConfiguration = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramConfiguration.ahp(), "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramConfiguration.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    }
    AppMethodBeat.o(19500);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19499);
    long l = System.currentTimeMillis();
    ToolsProfile.class.getClassLoader();
    com.tencent.mm.f.a.bF(aj.getContext());
    s.a(new au.c()
    {
      public final void a(au paramAnonymousau, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(193075);
        KVCommCrossProcessReceiver.dKl();
        AppMethodBeat.o(193075);
      }
    });
    s.fk(cTJ);
    AppLogic.setCallBack(new AppCallBack(aj.getContext()));
    com.tencent.mm.booter.w localw = new com.tencent.mm.booter.w(com.tencent.mm.booter.d.bJ(this.app.getBaseContext()));
    localw.uc("TOOL");
    ac.iOb = bt.a(localw.ud(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.iOc = bt.a(localw.ud(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.iOd = bt.a(localw.ud(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.iOe = bt.a(localw.ud(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.iOf = bt.a(localw.ud(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.iOg = bt.a(localw.ud(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.iOk = bt.a(localw.ud(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.iOl = bt.a(localw.ud(".com.tencent.mm.debug.test.location_help"), false);
    ac.iOo = bt.a(localw.ud(".com.tencent.mm.debug.test.force_soso"), false);
    ac.iOp = bt.a(localw.ud(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.iOq = bt.a(localw.ud(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.iOr = bt.a(localw.ud(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.iOu = bt.a(localw.ud(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.iOv = bt.a(localw.ud(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bt.a(localw.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.iOs = i;
    if ((i != 4) && (ac.iOs > 0))
    {
      com.tencent.mm.storage.ak.IpL = ac.iOs;
      ad.e("MicroMsg.ToolDebugger", "cdn thread num " + ac.iOs);
    }
    ac.iOt = bt.a(localw.ud(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.ZA(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localw.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.hgH = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Fnf = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Fnh = String.valueOf(str);
          com.tencent.mm.sdk.a.b.aPX(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hgH).append(" ").append(com.tencent.mm.sdk.a.b.fjO());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Fni).append(" new: ").append(i);
          com.tencent.mm.protocal.d.Fni = i;
        }
        catch (Exception localException4)
        {
          try
          {
            i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localw.fFy.fEd = i;
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bt.a(localw.ud(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bt.a(localw.ud(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bt.a(localw.ud(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bt.a(localw.ud(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                ac.iOI = bt.bI(localw.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                ad.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + ac.iOI);
                ac.iOJ = bt.bI(localw.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                ad.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + ac.iOJ);
                ac.iOK = bt.a(localw.ud(".com.tencent.mm.debug.skiploadurlcheck"), false);
                ad.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + ac.iOK);
                ac.iOL = bt.a(localw.ud(".com.tencent.mm.debug.forcex5webview"), false);
                ad.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + ac.iOL);
                f.bk(((h)com.tencent.mm.kernel.g.ajz().ajb()).ca);
                a.Lu();
                j.vr("wcdb");
                j.vr("commonimgdec");
                j.vr("wechatcommon");
                j.vr("wechatbase");
                j.vr(com.tencent.mm.sdk.a.IbC);
                j.vr("wechatmm");
                j.vr("FFmpeg");
                j.vr("wechatpack");
                i = m.aaf();
                if ((i & 0x400) == 0) {
                  break label1289;
                }
                ad.i(TAG, "load wechatsight_v7a, core number: %d ", new Object[] { Integer.valueOf(i >> 12) });
                j.vr("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.c.yQZ = 3;
                com.tencent.mm.plugin.sight.base.c.yRb = 3;
                com.tencent.mm.plugin.sight.base.c.yRc = 544000;
                SightVideoJNI.registerALL();
                locale = MMActivity.initLanguage(this.app.getBaseContext());
                ab.MA();
                if ((com.tencent.mm.compatible.util.d.ly(14)) && (d.cTo != null)) {
                  d.cTo.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
                  {
                    private Set<Activity> cVl;
                    
                    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
                    {
                      AppMethodBeat.i(193077);
                      ToolsProfile.a(ToolsProfile.this);
                      this.cVl.add(paramAnonymousActivity);
                      AppMethodBeat.o(193077);
                    }
                    
                    public final void onActivityDestroyed(Activity paramAnonymousActivity)
                    {
                      AppMethodBeat.i(193078);
                      ToolsProfile.b(ToolsProfile.this);
                      ad.d(ToolsProfile.TAG, "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[] { Integer.valueOf(ToolsProfile.c(ToolsProfile.this)) });
                      if (ToolsProfile.c(ToolsProfile.this) == 0)
                      {
                        ToolsProfile.a.access$200();
                        boolean bool = WebView.getCanReboot();
                        ad.i(ToolsProfile.TAG, "onActivityDestroyed, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
                        if ((bool) && (!ToolsProfile.a.isLocked()))
                        {
                          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                          Object localObject = new Object();
                          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                          Process.killProcess(((Integer)locala.mq(0)).intValue());
                          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                        }
                      }
                      this.cVl.remove(paramAnonymousActivity);
                      AppMethodBeat.o(193078);
                    }
                    
                    public final void onActivityPaused(Activity paramAnonymousActivity)
                    {
                      AppMethodBeat.i(193079);
                      this.cVl.remove(paramAnonymousActivity);
                      ToolsProfile.a.access$300();
                      AppMethodBeat.o(193079);
                    }
                    
                    public final void onActivityResumed(Activity paramAnonymousActivity)
                    {
                      AppMethodBeat.i(193080);
                      if (!this.cVl.contains(paramAnonymousActivity)) {
                        ToolsProfile.a.MK();
                      }
                      AppMethodBeat.o(193080);
                    }
                    
                    public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
                    
                    public final void onActivityStarted(Activity paramAnonymousActivity) {}
                    
                    public final void onActivityStopped(Activity paramAnonymousActivity) {}
                  });
                }
                ad.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - l));
                if (aj.fkI())
                {
                  com.tencent.mm.pluginsdk.model.w.x("use_sandbox", Boolean.TRUE);
                  com.tencent.mm.pluginsdk.model.w.x("sandbox_crash_record0", com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(aj.getContext().getFilesDir(), "crash/java_" + aj.getPackageName() + ":isolated_process0").fOK()));
                  com.tencent.mm.pluginsdk.model.w.x("sandbox_crash_record1", com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(aj.getContext().getFilesDir(), "crash/" + aj.getPackageName() + ":isolated_process0").fOK()));
                }
                w.a.hq(aj.getContext());
                com.tencent.mm.pluginsdk.ui.span.c.a.Fhd = com.tencent.mm.app.plugin.e.Nh();
                com.tencent.mm.sdk.b.a.IbL.c(new u(22, 32));
                w.a.eZI();
                AppMethodBeat.o(19499);
                return;
                localException1 = localException1;
                ad.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException2 = localException2;
                ad.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                ad.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                ad.i("MicroMsg.ToolDebugger", "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                ad.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.c.yQZ = 1;
                com.tencent.mm.plugin.sight.base.c.yRb = 1;
                com.tencent.mm.plugin.sight.base.c.yRc = 640000;
                continue;
                label1289:
                ad.i(TAG, "load wechatsight");
                j.vr("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.c.yQZ = 1;
                com.tencent.mm.plugin.sight.base.c.yRb = 1;
                com.tencent.mm.plugin.sight.base.c.yRc = 640000;
              }
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return cTJ;
  }
  
  public static final class a
  {
    private static final AtomicInteger cVm;
    private static Object cVn;
    
    static
    {
      AppMethodBeat.i(19497);
      cVm = new AtomicInteger(0);
      AppMethodBeat.o(19497);
    }
    
    private static boolean MJ()
    {
      AppMethodBeat.i(19493);
      try
      {
        if (cVn == null)
        {
          Object localObject2 = aj.getContext();
          Object localObject1 = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
          ((Method)localObject1).setAccessible(true);
          localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
          if (localObject1 != null) {}
          for (;;)
          {
            cVn = localObject1;
            localObject1 = (ArrayMap)org.a.a.gy(localObject1).bdX("mServices").object;
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
        ad.e("MicroMsg.ToolsProcessLocker", "skipServiceConditionIfOnlyIPCServiceAlive, hack ActivityThread_mServices e=%s", new Object[] { localThrowable });
        AppMethodBeat.o(19493);
      }
      return false;
    }
    
    public static boolean isLocked()
    {
      AppMethodBeat.i(19492);
      boolean bool;
      if (cVm.get() <= 0)
      {
        Object localObject = (ActivityManager)aj.getContext().getSystemService("activity");
        if (localObject == null) {
          break label226;
        }
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        if (localObject == null) {
          break label226;
        }
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if (((h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName.equals(localRunningAppProcessInfo.processName))
            {
              i = localRunningAppProcessInfo.importance;
              if (!com.tencent.mm.compatible.loader.a.contains(new int[] { 100 }, i))
              {
                i = localRunningAppProcessInfo.importance;
                if ((!com.tencent.mm.compatible.loader.a.contains(new int[] { 300, 125 }, i)) || (MJ()))
                {
                  i = localRunningAppProcessInfo.importanceReasonCode;
                  if (!com.tencent.mm.compatible.loader.a.contains(new int[] { 1, 2 }, i)) {
                    break;
                  }
                }
              }
              bool = true;
              ad.i("MicroMsg.ToolsProcessLocker", "hasRunningServicesOrProviders:%b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localRunningAppProcessInfo.importance), Integer.valueOf(localRunningAppProcessInfo.importanceReasonCode) });
              if (!bool) {}
            }
          }
        }
      }
      label226:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label231;
        }
        AppMethodBeat.o(19492);
        return true;
        bool = false;
        break;
      }
      label231:
      AppMethodBeat.o(19492);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile
 * JD-Core Version:    0.7.0.1
 */