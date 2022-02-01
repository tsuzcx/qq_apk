package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

public class SupportProfile
  extends com.tencent.mm.compatible.loader.d
{
  protected static String cEw = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19476);
    cEw = ak.getProcessName();
    SupportProfile.class.getClassLoader();
    com.tencent.mm.f.a.bH(ak.getContext());
    t.a(new av.c()
    {
      public final void a(av paramAnonymousav, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(186307);
        g.yxI.idkeyStat(637L, 0L, 1L, false);
        KVCommCrossProcessReceiver.dND();
        AppMethodBeat.o(186307);
      }
    });
    v localv = new v(com.tencent.mm.booter.d.bL(this.app.getBaseContext()));
    localv.ux("SUPPORT");
    ac.iQV = bu.a(localv.uy(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.iQW = bu.a(localv.uy(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.iQX = bu.a(localv.uy(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.iQY = bu.a(localv.uy(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.iQZ = bu.a(localv.uy(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.iRa = bu.a(localv.uy(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.iRe = bu.a(localv.uy(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.iRf = bu.a(localv.uy(".com.tencent.mm.debug.test.location_help"), false);
    ac.iRi = bu.a(localv.uy(".com.tencent.mm.debug.test.force_soso"), false);
    ac.iRj = bu.a(localv.uy(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.iRk = bu.a(localv.uy(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.iRl = bu.a(localv.uy(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.iRo = bu.a(localv.uy(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.iRp = bu.a(localv.uy(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bu.a(localv.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.iRm = i;
    if ((i != 4) && (ac.iRm > 0))
    {
      com.tencent.mm.storage.al.IKf = ac.iRm;
      ae.e("SetupSupportDebugger", "cdn thread num " + ac.iRm);
    }
    ac.iRn = bu.a(localv.uy(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    ac.iRF = bu.a(localv.uy(".com.tencent.mm.debug.forcex5webview"), false);
    ac.iRC = bu.bI(localv.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    ae.d("SetupSupportDebugger", "Test.jsapiPermission = " + ac.iRC);
    try
    {
      i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.aag(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localv.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bu.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.hjv = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.FFD = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.FFF = String.valueOf(str);
          b.aRu(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hjv).append(" ").append(b.fnG());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.FFG).append(" new: ").append(i);
          com.tencent.mm.protocal.d.FFG = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localv.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localv.fHC.fGh = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bu.a(localv.uy(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bu.a(localv.uy(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bu.a(localv.uy(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bu.a(localv.uy(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                t.fq(cEw);
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
                  break label922;
                }
                ae.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", new Object[] { Integer.valueOf(i >> 12) });
                j.vN("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.c.zhj = 3;
                com.tencent.mm.plugin.sight.base.c.zhl = 3;
                com.tencent.mm.plugin.sight.base.c.zhm = 544000;
                com.tencent.mm.f.a.bH(ak.getContext());
                ab.Mv();
                MMActivity.initLanguage(this.app.getBaseContext());
                AppMethodBeat.o(19476);
                return;
                localException2 = localException2;
                ae.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                ae.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                ae.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                ae.i("SetupSupportDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ae.i("SetupSupportDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.c.zhj = 1;
                com.tencent.mm.plugin.sight.base.c.zhl = 1;
                com.tencent.mm.plugin.sight.base.c.zhm = 640000;
                continue;
                label922:
                ae.i("MicroMsg.SupportProfile", "load wechatsight");
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
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(19477);
    super.onTrimMemory(paramInt);
    ae.v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.SupportProfile
 * JD-Core Version:    0.7.0.1
 */