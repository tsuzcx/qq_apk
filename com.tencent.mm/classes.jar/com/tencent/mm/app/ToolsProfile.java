package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import junit.framework.Assert;

public final class ToolsProfile
  extends com.tencent.mm.compatible.loader.d
{
  private static final String TAG;
  public static final String cLt;
  private static Locale locale;
  private final av cME;
  private int cML;
  
  static
  {
    AppMethodBeat.i(19501);
    cLt = aj.getProcessName();
    TAG = "MicroMsg." + com.tencent.mm.cr.b.getModuleName() + "Profile";
    AppMethodBeat.o(19501);
  }
  
  public ToolsProfile()
  {
    AppMethodBeat.i(19498);
    this.cME = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(19486);
        ad.i(ToolsProfile.TAG, "onTimerExpired, check kill tools process");
        if (ToolsProfile.a(ToolsProfile.this) == 0)
        {
          ToolsProfile.a.access$200();
          boolean bool = WebView.getCanReboot();
          ad.i(ToolsProfile.TAG, "onTimerExpired, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
          if ((bool) || (!ToolsProfile.a.isLocked()))
          {
            com.tencent.mm.cr.d.aNr("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            AppMethodBeat.o(19486);
            return false;
          }
        }
        AppMethodBeat.o(19486);
        return true;
      }
    }, true);
    this.cML = 0;
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
      System.exit(-1);
    }
    AppMethodBeat.o(19500);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19499);
    long l = System.currentTimeMillis();
    ToolsProfile.class.getClassLoader();
    com.tencent.mm.f.a.bD(aj.getContext());
    s.a(new au.c()
    {
      public final void b(String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(19485);
        KVCommCrossProcessReceiver.dkK();
        AppMethodBeat.o(19485);
      }
    });
    s.eA(cLt);
    AppLogic.setCallBack(new AppCallBack(aj.getContext()));
    v localv = new v(com.tencent.mm.booter.d.bH(this.app.getBaseContext()));
    localv.ok("TOOL");
    ab.hUQ = bt.a(localv.ol(".com.tencent.mm.debug.test.display_errcode"), false);
    ab.hUR = bt.a(localv.ol(".com.tencent.mm.debug.test.display_msgstate"), false);
    ab.hUS = bt.a(localv.ol(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ab.hUT = bt.a(localv.ol(".com.tencent.mm.debug.test.network.force_touch"), false);
    ab.hUU = bt.a(localv.ol(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ab.hUV = bt.a(localv.ol(".com.tencent.mm.debug.test.crashIsExit"), false);
    ab.hUZ = bt.a(localv.ol(".com.tencent.mm.debug.test.album_show_info"), false);
    ab.hVa = bt.a(localv.ol(".com.tencent.mm.debug.test.location_help"), false);
    ab.hVd = bt.a(localv.ol(".com.tencent.mm.debug.test.force_soso"), false);
    ab.hVe = bt.a(localv.ol(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ab.hVf = bt.a(localv.ol(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ab.hVg = bt.a(localv.ol(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ab.hVj = bt.a(localv.ol(".com.tencent.mm.debug.test.filterfpnp"), false);
    ab.hVk = bt.a(localv.ol(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bt.a(localv.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ab.hVh = i;
    if ((i != 4) && (ab.hVh > 0))
    {
      com.tencent.mm.storage.ad.FfF = ab.hVh;
      ad.e("MicroMsg.ToolDebugger", "cdn thread num " + ab.hVh);
    }
    ab.hVi = bt.a(localv.ol(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.Vv(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localv.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.glX = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.CpG = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.CpI = String.valueOf(str);
          com.tencent.mm.sdk.a.b.aFa(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.glX).append(" ").append(com.tencent.mm.sdk.a.b.eER());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.CpJ).append(" new: ").append(i);
          com.tencent.mm.protocal.d.CpJ = i;
        }
        catch (Exception localException4)
        {
          try
          {
            i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localv.fjW.fiC = i;
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bt.a(localv.ol(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bt.a(localv.ol(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bt.a(localv.ol(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bt.a(localv.ol(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                ab.hVx = bt.by(localv.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                ad.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + ab.hVx);
                ab.hVy = bt.by(localv.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                ad.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + ab.hVy);
                ab.hVz = bt.a(localv.ol(".com.tencent.mm.debug.skiploadurlcheck"), false);
                ad.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + ab.hVz);
                ab.hVA = bt.a(localv.ol(".com.tencent.mm.debug.forcex5webview"), false);
                ad.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + ab.hVA);
                f.bj(((h)com.tencent.mm.kernel.g.afy().aeZ()).ca);
                a.Kl();
                j.pq("wcdb");
                j.pq("commonimgdec");
                j.pq("wechatcommon");
                j.pq("wechatbase");
                j.pq(com.tencent.mm.sdk.a.ESC);
                j.pq("wechatmm");
                j.pq("FFmpeg");
                j.pq("wechatpack");
                i = m.WG();
                if ((i & 0x400) == 0) {
                  break label1283;
                }
                ad.i(TAG, "load wechatsight_v7a, core number: %d ", new Object[] { Integer.valueOf(i >> 12) });
                j.pq("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.c.wqY = 3;
                com.tencent.mm.plugin.sight.base.c.wra = 3;
                com.tencent.mm.plugin.sight.base.c.wrb = 544000;
                SightVideoJNI.registerALL();
                locale = MMActivity.initLanguage(this.app.getBaseContext());
                aa.KV();
                if ((com.tencent.mm.compatible.util.d.lf(14)) && (d.cKY != null)) {
                  d.cKY.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
                  {
                    private Set<Activity> cMN;
                    
                    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
                    {
                      AppMethodBeat.i(19488);
                      ToolsProfile.b(ToolsProfile.this);
                      this.cMN.add(paramAnonymousActivity);
                      AppMethodBeat.o(19488);
                    }
                    
                    public final void onActivityDestroyed(Activity paramAnonymousActivity)
                    {
                      AppMethodBeat.i(19489);
                      ToolsProfile.c(ToolsProfile.this);
                      ad.d(ToolsProfile.TAG, "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[] { Integer.valueOf(ToolsProfile.a(ToolsProfile.this)) });
                      if (ToolsProfile.a(ToolsProfile.this) == 0)
                      {
                        ToolsProfile.a.access$200();
                        boolean bool = WebView.getCanReboot();
                        ad.i(ToolsProfile.TAG, "onActivityDestroyed, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
                        if ((bool) && (!ToolsProfile.a.isLocked())) {
                          Process.killProcess(Process.myPid());
                        }
                      }
                      this.cMN.remove(paramAnonymousActivity);
                      AppMethodBeat.o(19489);
                    }
                    
                    public final void onActivityPaused(Activity paramAnonymousActivity)
                    {
                      AppMethodBeat.i(19490);
                      this.cMN.remove(paramAnonymousActivity);
                      ToolsProfile.a.access$300();
                      AppMethodBeat.o(19490);
                    }
                    
                    public final void onActivityResumed(Activity paramAnonymousActivity)
                    {
                      AppMethodBeat.i(19491);
                      if (!this.cMN.contains(paramAnonymousActivity)) {
                        ToolsProfile.a.Le();
                      }
                      AppMethodBeat.o(19491);
                    }
                    
                    public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
                    
                    public final void onActivityStarted(Activity paramAnonymousActivity) {}
                    
                    public final void onActivityStopped(Activity paramAnonymousActivity) {}
                  });
                }
                ad.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - l));
                if (aj.eFJ())
                {
                  w.y("use_sandbox", Boolean.TRUE);
                  w.y("sandbox_crash_record0", com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(aj.getContext().getFilesDir(), "crash/java_" + aj.getPackageName() + ":isolated_process0").fhU()));
                  w.y("sandbox_crash_record1", com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(aj.getContext().getFilesDir(), "crash/" + aj.getPackageName() + ":isolated_process0").fhU()));
                }
                w.a.ha(aj.getContext());
                com.tencent.mm.pluginsdk.ui.span.c.a.CjF = com.tencent.mm.app.plugin.e.LB();
                com.tencent.mm.sdk.b.a.ESL.c(new u(22, 32));
                w.a.evu();
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
                com.tencent.mm.plugin.sight.base.c.wqY = 1;
                com.tencent.mm.plugin.sight.base.c.wra = 1;
                com.tencent.mm.plugin.sight.base.c.wrb = 640000;
                continue;
                label1283:
                ad.i(TAG, "load wechatsight");
                j.pq("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.c.wqY = 1;
                com.tencent.mm.plugin.sight.base.c.wra = 1;
                com.tencent.mm.plugin.sight.base.c.wrb = 640000;
              }
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return cLt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile
 * JD-Core Version:    0.7.0.1
 */