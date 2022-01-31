package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.xweb.WebView.c;
import java.io.File;
import java.util.Locale;
import junit.framework.Assert;
import org.xwalk.core.XWalkEnvironment;

public final class ToolsProfile
  extends com.tencent.mm.compatible.loader.e
{
  private static final String TAG;
  public static final String bXW;
  private static Locale locale;
  private final ap bZa;
  private int bZi;
  
  static
  {
    AppMethodBeat.i(15423);
    bXW = ah.getProcessName();
    TAG = "MicroMsg." + com.tencent.mm.cn.b.dTi() + "Profile";
    AppMethodBeat.o(15423);
  }
  
  public ToolsProfile()
  {
    AppMethodBeat.i(15420);
    this.bZa = new ap(new ToolsProfile.3(this), true);
    this.bZi = 0;
    AppMethodBeat.o(15420);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(15422);
    paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext());
    ab.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + paramConfiguration.toString());
    if (!paramConfiguration.equals(locale))
    {
      ab.w(TAG, "language changed, restart process");
      System.exit(-1);
    }
    AppMethodBeat.o(15422);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(15421);
    long l = System.currentTimeMillis();
    Object localObject = ToolsProfile.class.getClassLoader();
    com.tencent.mm.f.a.bp(ah.getContext());
    m.a(new ToolsProfile.1(this));
    m.dw(bXW);
    AppLogic.setCallBack(new AppCallBack(ah.getContext()));
    v localv = new v(com.tencent.mm.booter.d.bt(this.app.getBaseContext()));
    localv.kt("TOOL");
    ae.gjY = bo.a(localv.ku(".com.tencent.mm.debug.test.display_errcode"), false);
    ae.gjZ = bo.a(localv.ku(".com.tencent.mm.debug.test.display_msgstate"), false);
    ae.gka = bo.a(localv.ku(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ae.gkb = bo.a(localv.ku(".com.tencent.mm.debug.test.network.force_touch"), false);
    ae.gkc = bo.a(localv.ku(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ae.gkd = bo.a(localv.ku(".com.tencent.mm.debug.test.crashIsExit"), false);
    ae.gkh = bo.a(localv.ku(".com.tencent.mm.debug.test.album_show_info"), false);
    ae.gki = bo.a(localv.ku(".com.tencent.mm.debug.test.location_help"), false);
    ae.gkl = bo.a(localv.ku(".com.tencent.mm.debug.test.force_soso"), false);
    ae.gkm = bo.a(localv.ku(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ae.gkn = bo.a(localv.ku(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ae.gko = bo.a(localv.ku(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ae.gkr = bo.a(localv.ku(".com.tencent.mm.debug.test.filterfpnp"), false);
    ae.gks = bo.a(localv.ku(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bo.a(localv.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ae.gkp = i;
    if ((i != 4) && (ae.gkp > 0))
    {
      com.tencent.mm.storage.ab.yxm = ae.gkp;
      ab.e("MicroMsg.ToolDebugger", "cdn thread num " + ae.gkp);
    }
    ae.gkq = bo.a(localv.ku(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.MA(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localv.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bo.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.eQs = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.whD = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.whF = String.valueOf(str);
          com.tencent.mm.sdk.a.b.aoP(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eQs).append(" ").append(com.tencent.mm.sdk.a.b.dsg());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.whG).append(" new: ").append(i);
          com.tencent.mm.protocal.d.whG = i;
        }
        catch (Exception localException4)
        {
          try
          {
            i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localv.dZN.dYP = i;
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bo.a(localv.ku(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bo.a(localv.ku(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bo.a(localv.ku(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bo.a(localv.ku(".com.tencent.mm.debug.report.useraction"), false);
                c.c(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                ae.gkF = bo.bf(localv.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                ab.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + ae.gkF);
                ae.gkG = bo.bf(localv.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                ab.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + ae.gkG);
                ae.gkH = bo.a(localv.ku(".com.tencent.mm.debug.skiploadurlcheck"), false);
                ab.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + ae.gkH);
                ae.gkI = bo.a(localv.ku(".com.tencent.mm.debug.forcex5webview"), false);
                ab.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + ae.gkI);
                d.aY(((h)com.tencent.mm.kernel.g.RI().Rj()).bX);
                a.dr(bXW);
                k.a("wcdb", (ClassLoader)localObject);
                k.a("commonimgdec", (ClassLoader)localObject);
                k.a("wechatcommon", (ClassLoader)localObject);
                k.a(com.tencent.mm.sdk.a.ylY, (ClassLoader)localObject);
                k.a("FFmpeg", (ClassLoader)localObject);
                k.a("wechatpack", (ClassLoader)localObject);
                i = com.tencent.mm.compatible.e.m.Lo();
                if ((i & 0x400) == 0) {
                  break label1313;
                }
                ab.i(TAG, "load wechatsight_v7a, core number: %d ", new Object[] { Integer.valueOf(i >> 12) });
                k.a("wechatsight_v7a", (ClassLoader)localObject);
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.b.qSn = 3;
                com.tencent.mm.plugin.sight.base.b.qSp = 3;
                com.tencent.mm.plugin.sight.base.b.qSq = 544000;
                SightVideoJNI.registerALL();
                locale = MMActivity.initLanguage(this.app.getBaseContext());
                s.By();
                if ((com.tencent.mm.compatible.util.d.fv(14)) && (b.bXD != null)) {
                  b.bXD.getApplication().registerActivityLifecycleCallbacks(new ToolsProfile.4(this));
                }
                ab.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - l));
                if (ah.dsW())
                {
                  u.s("use_sandbox", Boolean.TRUE);
                  u.s("sandbox_crash_record0", new File(ah.getContext().getFilesDir(), "crash/java_" + ah.getPackageName() + ":isolated_process0").getAbsolutePath());
                  u.s("sandbox_crash_record1", new File(ah.getContext().getFilesDir(), "crash/" + ah.getPackageName() + ":isolated_process0").getAbsolutePath());
                }
                u.a.fO(ah.getContext());
                com.tencent.mm.pluginsdk.ui.d.b.a.wbT = com.tencent.mm.app.plugin.e.Ce();
                localObject = new WebView.c()
                {
                  public final void BG()
                  {
                    AppMethodBeat.i(15407);
                    AppMethodBeat.o(15407);
                  }
                  
                  public final void onCoreInitFinished()
                  {
                    AppMethodBeat.i(15406);
                    AppMethodBeat.o(15406);
                  }
                };
                com.tencent.mm.cn.d.a(MMWebView.ADX, (WebView.c)localObject);
                com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.i.a.bgb());
                XWalkEnvironment.setIsForbidDownloadCode(com.tencent.mm.sdk.platformtools.g.dsn());
                com.tencent.mm.sdk.b.a.ymk.c(new o(22, 32));
                u.a.dln();
                AppMethodBeat.o(15421);
                return;
                localException1 = localException1;
                ab.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException2 = localException2;
                ab.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                ab.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                ab.i("MicroMsg.ToolDebugger", "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                ab.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.b.qSn = 1;
                com.tencent.mm.plugin.sight.base.b.qSp = 1;
                com.tencent.mm.plugin.sight.base.b.qSq = 640000;
                continue;
                label1313:
                ab.i(TAG, "load wechatsight");
                k.a("wechatsight", (ClassLoader)localObject);
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.b.qSn = 1;
                com.tencent.mm.plugin.sight.base.b.qSp = 1;
                com.tencent.mm.plugin.sight.base.b.qSq = 640000;
              }
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return bXW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile
 * JD-Core Version:    0.7.0.1
 */