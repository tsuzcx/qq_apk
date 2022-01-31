package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.h.a.ur;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.v.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.xweb.WebView.c;
import java.util.Locale;
import junit.framework.Assert;
import org.xwalk.core.XWalkEnvironment;

public final class ToolsProfile
  extends com.tencent.mm.compatible.loader.e
{
  private static final String TAG = "MicroMsg." + com.tencent.mm.cl.a.cNC() + "Profile";
  public static final String bwr = ;
  private static Locale locale;
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext());
    y.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + paramConfiguration.toString());
    if (!paramConfiguration.equals(locale))
    {
      y.w(TAG, "language changed, restart process");
      System.exit(-1);
    }
  }
  
  public final void onCreate()
  {
    long l = System.currentTimeMillis();
    Object localObject = ToolsProfile.class.getClassLoader();
    com.tencent.mm.g.a.aQ(com.tencent.mm.sdk.platformtools.ae.getContext());
    k.a(new ToolsProfile.1(this));
    k.cl(bwr);
    com.tencent.mm.compatible.util.k.setupBrokenLibraryHandler();
    AppLogic.setCallBack(new AppCallBack(com.tencent.mm.sdk.platformtools.ae.getContext()));
    w localw = new w(com.tencent.mm.booter.c.aS(this.app.getBaseContext()));
    localw.em("TOOL");
    com.tencent.mm.platformtools.ae.eSd = bk.a(localw.en(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ae.eSe = bk.a(localw.en(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ae.eSf = bk.a(localw.en(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ae.eSg = bk.a(localw.en(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ae.eSh = bk.a(localw.en(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ae.eSi = bk.a(localw.en(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ae.eSm = bk.a(localw.en(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ae.eSn = bk.a(localw.en(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ae.eSq = bk.a(localw.en(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ae.eSr = bk.a(localw.en(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ae.eSs = bk.a(localw.en(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ae.eSt = bk.a(localw.en(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ae.eSw = bk.a(localw.en(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ae.eSx = bk.a(localw.en(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bk.a(localw.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ae.eSu = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ae.eSu > 0))
    {
      com.tencent.mm.storage.ab.unv = com.tencent.mm.platformtools.ae.eSu;
      y.e("MicroMsg.ToolDebugger", "cdn thread num " + com.tencent.mm.platformtools.ae.eSu);
    }
    com.tencent.mm.platformtools.ae.eSv = bk.a(localw.en(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.EC(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localw.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bk.bl(str))
        {
          com.tencent.mm.protocal.d.dOM = "android-" + str;
          com.tencent.mm.protocal.d.soW = "android-" + str;
          com.tencent.mm.protocal.d.soY = str;
          com.tencent.mm.sdk.a.b.YR(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.dOM).append(" ").append(com.tencent.mm.sdk.a.b.cql());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.soZ).append(" new: ").append(i);
          com.tencent.mm.protocal.d.soZ = i;
        }
        catch (Exception localException4)
        {
          try
          {
            i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localw.diu.dhC = i;
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bk.a(localw.en(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bk.a(localw.en(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bk.a(localw.en(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bk.a(localw.en(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                com.tencent.mm.platformtools.ae.eSK = bk.aM(localw.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                y.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ae.eSK);
                com.tencent.mm.platformtools.ae.eSL = bk.aM(localw.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                y.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + com.tencent.mm.platformtools.ae.eSL);
                com.tencent.mm.platformtools.ae.eSM = bk.a(localw.en(".com.tencent.mm.debug.skiploadurlcheck"), false);
                y.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + com.tencent.mm.platformtools.ae.eSM);
                com.tencent.mm.platformtools.ae.eSN = bk.a(localw.en(".com.tencent.mm.debug.forcex5webview"), false);
                y.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + com.tencent.mm.platformtools.ae.eSN);
                d.aA(com.tencent.mm.sdk.platformtools.ae.getContext());
                a.cg(bwr);
                com.tencent.mm.compatible.util.k.b("wcdb", (ClassLoader)localObject);
                com.tencent.mm.compatible.util.k.b("commonimgdec", (ClassLoader)localObject);
                com.tencent.mm.compatible.util.k.b("wechatcommon", (ClassLoader)localObject);
                com.tencent.mm.compatible.util.k.b(com.tencent.mm.sdk.a.udJ, (ClassLoader)localObject);
                com.tencent.mm.compatible.util.k.b("wechatImgTools", (ClassLoader)localObject);
                com.tencent.mm.compatible.util.k.b("FFmpeg", (ClassLoader)localObject);
                com.tencent.mm.compatible.util.k.b("wechatpack", (ClassLoader)localObject);
                i = m.yR();
                if ((i & 0x400) == 0) {
                  break label1199;
                }
                y.i(TAG, "load wechatsight_v7a, core number: %d ", new Object[] { Integer.valueOf(i >> 12) });
                com.tencent.mm.compatible.util.k.b("wechatsight_v7a", (ClassLoader)localObject);
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.b.odY = 3;
                com.tencent.mm.plugin.sight.base.b.oea = 3;
                com.tencent.mm.plugin.sight.base.b.oeb = 544000;
                SightVideoJNI.registerALL();
                locale = MMActivity.initLanguage(this.app.getBaseContext());
                p.tb();
                if ((com.tencent.mm.compatible.util.d.gF(14)) && (b.applicationLike != null)) {
                  b.applicationLike.getApplication().registerActivityLifecycleCallbacks(new ToolsProfile.3(this));
                }
                MMBitmapFactory.init();
                y.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - l));
                v.a.eO(com.tencent.mm.sdk.platformtools.ae.getContext());
                localObject = new WebView.c()
                {
                  public final void onCoreInitFinished()
                  {
                    y.i(ToolsProfile.TAG, "onCoreInitFinished");
                    ur localur = new ur();
                    localur.cfu.success = true;
                    com.tencent.mm.sdk.b.a.udP.m(localur);
                  }
                  
                  public final void tc()
                  {
                    y.i(ToolsProfile.TAG, "onCoreInitFailed");
                    ur localur = new ur();
                    localur.cfu.success = false;
                    com.tencent.mm.sdk.b.a.udP.m(localur);
                  }
                };
                com.tencent.mm.cl.b.a(MMWebView.wkp, (WebView.c)localObject);
                com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.i.a.aDE());
                XWalkEnvironment.setIsForbidDownloadCode(com.tencent.mm.sdk.platformtools.e.cqq());
                com.tencent.mm.sdk.b.a.udP.c(new l(22, 32));
                v.a.ckF();
                return;
                localException1 = localException1;
                y.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException2 = localException2;
                y.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                y.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                y.i("MicroMsg.ToolDebugger", "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                y.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.b.odY = 1;
                com.tencent.mm.plugin.sight.base.b.oea = 1;
                com.tencent.mm.plugin.sight.base.b.oeb = 640000;
                continue;
                label1199:
                y.i(TAG, "load wechatsight");
                com.tencent.mm.compatible.util.k.b("wechatsight", (ClassLoader)localObject);
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.b.odY = 1;
                com.tencent.mm.plugin.sight.base.b.oea = 1;
                com.tencent.mm.plugin.sight.base.b.oeb = 640000;
              }
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return bwr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile
 * JD-Core Version:    0.7.0.1
 */