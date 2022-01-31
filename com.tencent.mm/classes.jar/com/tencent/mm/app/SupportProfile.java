package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.al.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

public class SupportProfile
  extends e
{
  protected static String bnX = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    bnX = com.tencent.mm.sdk.platformtools.ae.getProcessName();
    ClassLoader localClassLoader = SupportProfile.class.getClassLoader();
    com.tencent.mm.g.a.aQ(com.tencent.mm.sdk.platformtools.ae.getContext());
    k.a(new al.c()
    {
      public final void c(String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        h.nFQ.a(637L, 0L, 1L, false);
        KVCommCrossProcessReceiver.bwU();
      }
    });
    v localv = new v(com.tencent.mm.booter.c.aS(this.app.getBaseContext()));
    localv.em("SUPPORT");
    com.tencent.mm.platformtools.ae.eSd = bk.a(localv.en(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ae.eSe = bk.a(localv.en(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ae.eSf = bk.a(localv.en(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ae.eSg = bk.a(localv.en(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ae.eSh = bk.a(localv.en(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ae.eSi = bk.a(localv.en(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ae.eSm = bk.a(localv.en(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ae.eSn = bk.a(localv.en(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ae.eSq = bk.a(localv.en(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ae.eSr = bk.a(localv.en(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ae.eSs = bk.a(localv.en(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ae.eSt = bk.a(localv.en(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ae.eSw = bk.a(localv.en(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ae.eSx = bk.a(localv.en(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bk.a(localv.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ae.eSu = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ae.eSu > 0))
    {
      com.tencent.mm.storage.ab.unv = com.tencent.mm.platformtools.ae.eSu;
      y.e("SetupSupportDebugger", "cdn thread num " + com.tencent.mm.platformtools.ae.eSu);
    }
    com.tencent.mm.platformtools.ae.eSv = bk.a(localv.en(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    com.tencent.mm.platformtools.ae.eSN = bk.a(localv.en(".com.tencent.mm.debug.forcex5webview"), false);
    com.tencent.mm.platformtools.ae.eSK = bk.aM(localv.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    y.d("SetupSupportDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ae.eSK);
    try
    {
      i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      d.EC(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localv.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bk.bl(str))
        {
          d.dOM = "android-" + str;
          d.soW = "android-" + str;
          d.soY = str;
          b.YR(str);
          new StringBuilder("set up test protocal apilevel = ").append(d.dOM).append(" ").append(b.cql());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(d.soZ).append(" new: ").append(i);
          d.soZ = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localv.diu.dhC = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bk.a(localv.en(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bk.a(localv.en(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bk.a(localv.en(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bk.a(localv.en(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
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
                  break label930;
                }
                y.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", new Object[] { Integer.valueOf(i >> 12) });
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
                return;
                localException2 = localException2;
                y.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                y.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                y.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                y.i("SetupSupportDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                y.i("SetupSupportDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.b.odY = 1;
                com.tencent.mm.plugin.sight.base.b.oea = 1;
                com.tencent.mm.plugin.sight.base.b.oeb = 640000;
                continue;
                label930:
                y.i("MicroMsg.SupportProfile", "load wechatsight");
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
    y.v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.SupportProfile
 * JD-Core Version:    0.7.0.1
 */