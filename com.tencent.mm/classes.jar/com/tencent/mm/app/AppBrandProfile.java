package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.p;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.console.Shell;
import com.tencent.mm.plugin.report.b.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;

public class AppBrandProfile
  extends com.tencent.mm.compatible.loader.d
{
  protected static String csT = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19429);
    ac.i("MicroMsg.AppBrandProfile", "AppBrandProfile create");
    csT = ai.getProcessName();
    AppBrandProfile.class.getClassLoader();
    com.tencent.mm.f.a.bG(ai.getContext());
    s.a(new AppBrandProfile.1(this));
    p localp = new p(com.tencent.mm.booter.d.bK(this.app.getBaseContext()));
    csT.replace(ai.getPackageName() + ":appbrand", "");
    com.tencent.mm.platformtools.ab.iuU = bs.a(localp.rr(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ab.iuV = bs.a(localp.rr(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ab.iuW = bs.a(localp.rr(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ab.iuX = bs.a(localp.rr(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ab.iuY = bs.a(localp.rr(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ab.iuZ = bs.a(localp.rr(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ab.ivd = bs.a(localp.rr(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ab.ive = bs.a(localp.rr(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ab.ivh = bs.a(localp.rr(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ab.ivi = bs.a(localp.rr(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ab.ivj = bs.a(localp.rr(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ab.ivk = bs.a(localp.rr(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ab.ivn = bs.a(localp.rr(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ab.ivo = bs.a(localp.rr(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bs.a(localp.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ab.ivl = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ab.ivl > 0))
    {
      com.tencent.mm.storage.ag.GDs = com.tencent.mm.platformtools.ab.ivl;
      ac.e("MicroMsg.AppBDebugger", "cdn thread num " + com.tencent.mm.platformtools.ab.ivl);
    }
    com.tencent.mm.platformtools.ab.ivm = bs.a(localp.rr(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    com.tencent.mm.platformtools.ab.ivE = bs.a(localp.rr(".com.tencent.mm.debug.forcex5webview"), false);
    com.tencent.mm.platformtools.ab.ivB = bs.bG(localp.getString(".com.tencent.mm.debug.jsapi.permission"), "");
    ac.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ab.ivB);
    try
    {
      i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.XE(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = localp.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bs.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.gMK = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.DHY = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.DIa = String.valueOf(str);
          b.aKr(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.gMK).append(" ").append(b.eUl());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.DIb).append(" new: ").append(i);
          com.tencent.mm.protocal.d.DIb = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(localp.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localp.fnq.flW = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bs.a(localp.rr(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bs.a(localp.rr(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bs.a(localp.rr(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bs.a(localp.rr(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                if (bt.eWo()) {
                  new Shell().init(ai.getContext());
                }
                a.JV();
                j.sC("commonimgdec");
                j.sC("wechatcommon");
                j.sC("wechatbase");
                j.sC(com.tencent.mm.sdk.a.GpP);
                j.sC("wechatmm");
                j.sC("FFmpeg");
                j.sC("wechatpack");
                ab.KT();
                com.tencent.mm.plugin.appbrand.a.a.jjb = bs.eWj();
                com.tencent.mm.cq.d.kE(this.app);
                com.tencent.mm.plugin.appbrand.a.a.jjc = bs.eWj();
                com.tencent.mm.sdk.b.a.GpY.c(new u(42, 52));
                AppMethodBeat.o(19429);
                return;
                localException2 = localException2;
                ac.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                ac.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                ac.i("MicroMsg.AppBDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                ac.i("MicroMsg.AppBDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ac.i("MicroMsg.AppBDebugger", "no debugger was got");
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(19430);
    super.onTrimMemory(paramInt);
    ac.v("MicroMsg.AppBrandProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.AppBrandProfile
 * JD-Core Version:    0.7.0.1
 */