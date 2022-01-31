package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

public class SupportProfile
  extends e
{
  protected static String bNv = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(15401);
    bNv = ah.getProcessName();
    ClassLoader localClassLoader = SupportProfile.class.getClassLoader();
    com.tencent.mm.f.a.bp(ah.getContext());
    m.a(new SupportProfile.1(this));
    u localu = new u(com.tencent.mm.booter.d.bt(this.app.getBaseContext()));
    localu.kt("SUPPORT");
    ae.gjY = bo.a(localu.ku(".com.tencent.mm.debug.test.display_errcode"), false);
    ae.gjZ = bo.a(localu.ku(".com.tencent.mm.debug.test.display_msgstate"), false);
    ae.gka = bo.a(localu.ku(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ae.gkb = bo.a(localu.ku(".com.tencent.mm.debug.test.network.force_touch"), false);
    ae.gkc = bo.a(localu.ku(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ae.gkd = bo.a(localu.ku(".com.tencent.mm.debug.test.crashIsExit"), false);
    ae.gkh = bo.a(localu.ku(".com.tencent.mm.debug.test.album_show_info"), false);
    ae.gki = bo.a(localu.ku(".com.tencent.mm.debug.test.location_help"), false);
    ae.gkl = bo.a(localu.ku(".com.tencent.mm.debug.test.force_soso"), false);
    ae.gkm = bo.a(localu.ku(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ae.gkn = bo.a(localu.ku(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ae.gko = bo.a(localu.ku(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ae.gkr = bo.a(localu.ku(".com.tencent.mm.debug.test.filterfpnp"), false);
    ae.gks = bo.a(localu.ku(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bo.a(localu.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ae.gkp = i;
    if ((i != 4) && (ae.gkp > 0))
    {
      com.tencent.mm.storage.ab.yxm = ae.gkp;
      ab.e("SetupSupportDebugger", "cdn thread num " + ae.gkp);
    }
    ae.gkq = bo.a(localu.ku(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    ae.gkI = bo.a(localu.ku(".com.tencent.mm.debug.forcex5webview"), false);
    ae.gkF = bo.bf(localu.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    ab.d("SetupSupportDebugger", "Test.jsapiPermission = " + ae.gkF);
    try
    {
      i = Integer.decode(localu.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.MA(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localu.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bo.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.eQs = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.whD = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.whF = String.valueOf(str);
          b.aoP(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.eQs).append(" ").append(b.dsg());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localu.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.whG).append(" new: ").append(i);
          com.tencent.mm.protocal.d.whG = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localu.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localu.dZN.dYP = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bo.a(localu.ku(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bo.a(localu.ku(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bo.a(localu.ku(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bo.a(localu.ku(".com.tencent.mm.debug.report.useraction"), false);
                c.c(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                m.dw(bNv);
                a.dr(bNv);
                k.a("wcdb", localClassLoader);
                k.a("commonimgdec", localClassLoader);
                k.a("wechatcommon", localClassLoader);
                k.a(com.tencent.mm.sdk.a.ylY, localClassLoader);
                k.a("FFmpeg", localClassLoader);
                k.a("wechatpack", localClassLoader);
                i = com.tencent.mm.compatible.e.m.Lo();
                if ((i & 0x400) == 0) {
                  break label928;
                }
                ab.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", new Object[] { Integer.valueOf(i >> 12) });
                k.a("wechatsight_v7a", localClassLoader);
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.b.qSn = 3;
                com.tencent.mm.plugin.sight.base.b.qSp = 3;
                com.tencent.mm.plugin.sight.base.b.qSq = 544000;
                com.tencent.mm.f.a.bp(ah.getContext());
                s.By();
                MMActivity.initLanguage(this.app.getBaseContext());
                AppMethodBeat.o(15401);
                return;
                localException2 = localException2;
                ab.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                ab.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                ab.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                ab.i("SetupSupportDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ab.i("SetupSupportDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.b.qSn = 1;
                com.tencent.mm.plugin.sight.base.b.qSp = 1;
                com.tencent.mm.plugin.sight.base.b.qSq = 640000;
                continue;
                label928:
                ab.i("MicroMsg.SupportProfile", "load wechatsight");
                k.a("wechatsight", localClassLoader);
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
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(15402);
    super.onTrimMemory(paramInt);
    ab.v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(15402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.SupportProfile
 * JD-Core Version:    0.7.0.1
 */