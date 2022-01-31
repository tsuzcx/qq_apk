package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.mm.booter.q;
import com.tencent.mm.cl.b.1;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import junit.framework.Assert;

public class AppBrandProfile
  extends e
{
  protected static String bnX = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    bnX = com.tencent.mm.sdk.platformtools.ae.getProcessName();
    ClassLoader localClassLoader = AppBrandProfile.class.getClassLoader();
    com.tencent.mm.g.a.aQ(com.tencent.mm.sdk.platformtools.ae.getContext());
    k.a(new AppBrandProfile.1(this));
    com.tencent.mm.booter.p localp = new com.tencent.mm.booter.p(com.tencent.mm.booter.c.aS(this.app.getBaseContext()));
    bnX.replace(com.tencent.mm.sdk.platformtools.ae.getPackageName() + ":appbrand", "");
    com.tencent.mm.platformtools.ae.eSd = bk.a(localp.en(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ae.eSe = bk.a(localp.en(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ae.eSf = bk.a(localp.en(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ae.eSg = bk.a(localp.en(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ae.eSh = bk.a(localp.en(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ae.eSi = bk.a(localp.en(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ae.eSm = bk.a(localp.en(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ae.eSn = bk.a(localp.en(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ae.eSq = bk.a(localp.en(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ae.eSr = bk.a(localp.en(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ae.eSs = bk.a(localp.en(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ae.eSt = bk.a(localp.en(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ae.eSw = bk.a(localp.en(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ae.eSx = bk.a(localp.en(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bk.a(localp.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ae.eSu = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ae.eSu > 0))
    {
      com.tencent.mm.storage.ab.unv = com.tencent.mm.platformtools.ae.eSu;
      y.e("MicroMsg.AppBDebugger", "cdn thread num " + com.tencent.mm.platformtools.ae.eSu);
    }
    com.tencent.mm.platformtools.ae.eSv = bk.a(localp.en(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    com.tencent.mm.platformtools.ae.eSN = bk.a(localp.en(".com.tencent.mm.debug.forcex5webview"), false);
    com.tencent.mm.platformtools.ae.eSK = bk.aM(localp.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    y.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ae.eSK);
    try
    {
      i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.EC(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localp.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bk.bl(str))
        {
          com.tencent.mm.protocal.d.dOM = "android-" + str;
          com.tencent.mm.protocal.d.soW = "android-" + str;
          com.tencent.mm.protocal.d.soY = str;
          com.tencent.mm.sdk.a.b.YR(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.dOM).append(" ").append(com.tencent.mm.sdk.a.b.cql());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.soZ).append(" new: ").append(i);
          com.tencent.mm.protocal.d.soZ = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localp.diu.dhC = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bk.a(localp.en(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bk.a(localp.en(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bk.a(localp.en(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bk.a(localp.en(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                d.aA(com.tencent.mm.sdk.platformtools.ae.getContext());
                k.cl(bnX);
                a.cg(bnX);
                com.tencent.mm.compatible.util.k.b("wcdb", localClassLoader);
                com.tencent.mm.compatible.util.k.b("commonimgdec", localClassLoader);
                com.tencent.mm.compatible.util.k.b("wechatcommon", localClassLoader);
                com.tencent.mm.compatible.util.k.b(com.tencent.mm.sdk.a.udJ, localClassLoader);
                com.tencent.mm.compatible.util.k.b("FFmpeg", localClassLoader);
                com.tencent.mm.compatible.util.k.b("wechatpack", localClassLoader);
                i = m.yR();
                if ((i & 0x400) == 0) {
                  break label991;
                }
                y.i("MicroMsg.AppBrandProfile", "load wechatsight_v7a, core number: %d", new Object[] { Integer.valueOf(i >> 12) });
                com.tencent.mm.compatible.util.k.b("wechatsight_v7a", localClassLoader);
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.b.odY = 3;
                com.tencent.mm.plugin.sight.base.b.oea = 3;
                com.tencent.mm.plugin.sight.base.b.oeb = 544000;
                com.tencent.mm.g.a.aQ(com.tencent.mm.sdk.platformtools.ae.getContext());
                p.tb();
                MMActivity.initLanguage(this.app.getBaseContext());
                MMBitmapFactory.init();
                com.tencent.mm.cl.b.a(MMWebView.wkp, new b.1());
                com.tencent.mm.sdk.b.a.udP.c(new l(42, 52));
                return;
                localException2 = localException2;
                y.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                y.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                y.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                y.i("MicroMsg.AppBDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                y.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.b.odY = 1;
                com.tencent.mm.plugin.sight.base.b.oea = 1;
                com.tencent.mm.plugin.sight.base.b.oeb = 640000;
                continue;
                label991:
                y.i("MicroMsg.AppBrandProfile", "load wechatsight");
                com.tencent.mm.compatible.util.k.b("wechatsight", localClassLoader);
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
  
  public final void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    y.v("MicroMsg.AppBrandProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.AppBrandProfile
 * JD-Core Version:    0.7.0.1
 */