package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.plugin.e;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.k;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.Locale;
import junit.framework.Assert;

public final class ToolsProfile
  extends com.tencent.mm.compatible.loader.d
{
  private static final String TAG;
  public static final String cUu;
  private static Locale locale;
  private int cWg;
  
  static
  {
    AppMethodBeat.i(19501);
    cUu = ak.getProcessName();
    TAG = "MicroMsg." + com.tencent.mm.cp.b.getModuleName() + "Profile";
    AppMethodBeat.o(19501);
  }
  
  public ToolsProfile()
  {
    AppMethodBeat.i(19498);
    this.cWg = 0;
    AppMethodBeat.o(19498);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19500);
    paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext());
    ae.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + paramConfiguration.toString());
    if (!paramConfiguration.equals(locale))
    {
      ae.w(TAG, "language changed, restart process");
      paramConfiguration = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramConfiguration.ahE(), "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramConfiguration.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    }
    AppMethodBeat.o(19500);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19499);
    long l = System.currentTimeMillis();
    ToolsProfile.class.getClassLoader();
    com.tencent.mm.f.a.bH(ak.getContext());
    t.a(new ToolsProfile.1(this));
    t.fq(cUu);
    AppLogic.setCallBack(new AppCallBack(ak.getContext()));
    com.tencent.mm.booter.w localw = new com.tencent.mm.booter.w(com.tencent.mm.booter.d.bL(this.app.getBaseContext()));
    localw.ux("TOOL");
    ac.iQV = bu.a(localw.uy(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.iQW = bu.a(localw.uy(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.iQX = bu.a(localw.uy(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.iQY = bu.a(localw.uy(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.iQZ = bu.a(localw.uy(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.iRa = bu.a(localw.uy(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.iRe = bu.a(localw.uy(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.iRf = bu.a(localw.uy(".com.tencent.mm.debug.test.location_help"), false);
    ac.iRi = bu.a(localw.uy(".com.tencent.mm.debug.test.force_soso"), false);
    ac.iRj = bu.a(localw.uy(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.iRk = bu.a(localw.uy(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.iRl = bu.a(localw.uy(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.iRo = bu.a(localw.uy(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.iRp = bu.a(localw.uy(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bu.a(localw.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.iRm = i;
    if ((i != 4) && (ac.iRm > 0))
    {
      com.tencent.mm.storage.al.IKf = ac.iRm;
      ae.e("MicroMsg.ToolDebugger", "cdn thread num " + ac.iRm);
    }
    ac.iRn = bu.a(localw.uy(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.aag(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localw.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bu.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.hjv = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.FFD = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.FFF = String.valueOf(str);
          com.tencent.mm.sdk.a.b.aRu(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hjv).append(" ").append(com.tencent.mm.sdk.a.b.fnG());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.FFG).append(" new: ").append(i);
          com.tencent.mm.protocal.d.FFG = i;
        }
        catch (Exception localException4)
        {
          try
          {
            i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localw.fHC.fGh = i;
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bu.a(localw.uy(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bu.a(localw.uy(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bu.a(localw.uy(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bu.a(localw.uy(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                ac.iRC = bu.bI(localw.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                ae.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + ac.iRC);
                ac.iRD = bu.bI(localw.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                ae.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + ac.iRD);
                ac.iRE = bu.a(localw.uy(".com.tencent.mm.debug.skiploadurlcheck"), false);
                ae.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + ac.iRE);
                ac.iRF = bu.a(localw.uy(".com.tencent.mm.debug.forcex5webview"), false);
                ae.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + ac.iRF);
                f.bl(((h)com.tencent.mm.kernel.g.ajO().ajq()).ca);
                a.LC();
                j.vN("wcdb");
                j.vN("commonimgdec");
                j.vN("wechatcommon");
                j.vN("wechatbase");
                j.vN(com.tencent.mm.sdk.a.IvK);
                j.vN("wechatmm");
                j.vN("FFmpeg");
                j.vN("wechatpack");
                i = m.aao();
                if ((i & 0x400) == 0) {
                  break label1288;
                }
                ae.i(TAG, "load wechatsight_v7a, core number: %d ", new Object[] { Integer.valueOf(i >> 12) });
                j.vN("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.c.zhj = 3;
                com.tencent.mm.plugin.sight.base.c.zhl = 3;
                com.tencent.mm.plugin.sight.base.c.zhm = 544000;
                SightVideoJNI.registerALL();
                locale = MMActivity.initLanguage(this.app.getBaseContext());
                ab.Mv();
                if ((com.tencent.mm.compatible.util.d.lA(14)) && (d.cTZ != null)) {
                  d.cTZ.getApplication().registerActivityLifecycleCallbacks(new ToolsProfile.2(this));
                }
                ae.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - l));
                if (ak.foC())
                {
                  com.tencent.mm.pluginsdk.model.w.x("use_sandbox", Boolean.TRUE);
                  com.tencent.mm.pluginsdk.model.w.x("sandbox_crash_record0", com.tencent.mm.vfs.w.B(new k(ak.getContext().getFilesDir(), "crash/java_" + ak.getPackageName() + ":isolated_process0").fTh()));
                  com.tencent.mm.pluginsdk.model.w.x("sandbox_crash_record1", com.tencent.mm.vfs.w.B(new k(ak.getContext().getFilesDir(), "crash/" + ak.getPackageName() + ":isolated_process0").fTh()));
                }
                w.a.hw(ak.getContext());
                com.tencent.mm.pluginsdk.ui.span.c.a.FzB = e.Nc();
                com.tencent.mm.sdk.b.a.IvT.c(new v(22, 32));
                w.a.fdw();
                AppMethodBeat.o(19499);
                return;
                localException1 = localException1;
                ae.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException2 = localException2;
                ae.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                ae.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                ae.i("MicroMsg.ToolDebugger", "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                ae.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.c.zhj = 1;
                com.tencent.mm.plugin.sight.base.c.zhl = 1;
                com.tencent.mm.plugin.sight.base.c.zhm = 640000;
                continue;
                label1288:
                ae.i(TAG, "load wechatsight");
                j.vN("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.c.zhj = 1;
                com.tencent.mm.plugin.sight.base.c.zhl = 1;
                com.tencent.mm.plugin.sight.base.c.zhm = 640000;
              }
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return cUu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile
 * JD-Core Version:    0.7.0.1
 */