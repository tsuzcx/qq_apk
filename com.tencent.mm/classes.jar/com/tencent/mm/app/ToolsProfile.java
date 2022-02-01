package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.b.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.Locale;
import junit.framework.Assert;

public final class ToolsProfile
  extends com.tencent.mm.compatible.loader.d
{
  private static final String TAG;
  public static final String cIB;
  private static Locale locale;
  private int cJW;
  
  static
  {
    AppMethodBeat.i(19501);
    cIB = ai.getProcessName();
    TAG = "MicroMsg." + com.tencent.mm.cq.b.getModuleName() + "Profile";
    AppMethodBeat.o(19501);
  }
  
  public ToolsProfile()
  {
    AppMethodBeat.i(19498);
    this.cJW = 0;
    AppMethodBeat.o(19498);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19500);
    paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext());
    ac.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + paramConfiguration.toString());
    if (!paramConfiguration.equals(locale))
    {
      ac.w(TAG, "language changed, restart process");
      System.exit(-1);
    }
    AppMethodBeat.o(19500);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19499);
    long l = System.currentTimeMillis();
    ToolsProfile.class.getClassLoader();
    com.tencent.mm.f.a.bG(ai.getContext());
    s.a(new ToolsProfile.1(this));
    s.ep(cIB);
    AppLogic.setCallBack(new AppCallBack(ai.getContext()));
    com.tencent.mm.booter.w localw = new com.tencent.mm.booter.w(com.tencent.mm.booter.d.bK(this.app.getBaseContext()));
    localw.rq("TOOL");
    com.tencent.mm.platformtools.ab.iuU = bs.a(localw.rr(".com.tencent.mm.debug.test.display_errcode"), false);
    com.tencent.mm.platformtools.ab.iuV = bs.a(localw.rr(".com.tencent.mm.debug.test.display_msgstate"), false);
    com.tencent.mm.platformtools.ab.iuW = bs.a(localw.rr(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    com.tencent.mm.platformtools.ab.iuX = bs.a(localw.rr(".com.tencent.mm.debug.test.network.force_touch"), false);
    com.tencent.mm.platformtools.ab.iuY = bs.a(localw.rr(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    com.tencent.mm.platformtools.ab.iuZ = bs.a(localw.rr(".com.tencent.mm.debug.test.crashIsExit"), false);
    com.tencent.mm.platformtools.ab.ivd = bs.a(localw.rr(".com.tencent.mm.debug.test.album_show_info"), false);
    com.tencent.mm.platformtools.ab.ive = bs.a(localw.rr(".com.tencent.mm.debug.test.location_help"), false);
    com.tencent.mm.platformtools.ab.ivh = bs.a(localw.rr(".com.tencent.mm.debug.test.force_soso"), false);
    com.tencent.mm.platformtools.ab.ivi = bs.a(localw.rr(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    com.tencent.mm.platformtools.ab.ivj = bs.a(localw.rr(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    com.tencent.mm.platformtools.ab.ivk = bs.a(localw.rr(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    com.tencent.mm.platformtools.ab.ivn = bs.a(localw.rr(".com.tencent.mm.debug.test.filterfpnp"), false);
    com.tencent.mm.platformtools.ab.ivo = bs.a(localw.rr(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bs.a(localw.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    com.tencent.mm.platformtools.ab.ivl = i;
    if ((i != 4) && (com.tencent.mm.platformtools.ab.ivl > 0))
    {
      com.tencent.mm.storage.ag.GDs = com.tencent.mm.platformtools.ab.ivl;
      ac.e("MicroMsg.ToolDebugger", "cdn thread num " + com.tencent.mm.platformtools.ab.ivl);
    }
    com.tencent.mm.platformtools.ab.ivm = bs.a(localw.rr(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.XE(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localw.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bs.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.gMK = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.DHY = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.DIa = String.valueOf(str);
          com.tencent.mm.sdk.a.b.aKr(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.gMK).append(" ").append(com.tencent.mm.sdk.a.b.eUl());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.DIb).append(" new: ").append(i);
          com.tencent.mm.protocal.d.DIb = i;
        }
        catch (Exception localException4)
        {
          try
          {
            i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localw.fnq.flW = i;
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bs.a(localw.rr(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bs.a(localw.rr(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bs.a(localw.rr(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bs.a(localw.rr(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                com.tencent.mm.platformtools.ab.ivB = bs.bG(localw.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                ac.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.ab.ivB);
                com.tencent.mm.platformtools.ab.ivC = bs.bG(localw.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                ac.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + com.tencent.mm.platformtools.ab.ivC);
                com.tencent.mm.platformtools.ab.ivD = bs.a(localw.rr(".com.tencent.mm.debug.skiploadurlcheck"), false);
                ac.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + com.tencent.mm.platformtools.ab.ivD);
                com.tencent.mm.platformtools.ab.ivE = bs.a(localw.rr(".com.tencent.mm.debug.forcex5webview"), false);
                ac.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + com.tencent.mm.platformtools.ab.ivE);
                f.bk(((h)com.tencent.mm.kernel.g.agO().agp()).ca);
                a.JV();
                j.sC("wcdb");
                j.sC("commonimgdec");
                j.sC("wechatcommon");
                j.sC("wechatbase");
                j.sC(com.tencent.mm.sdk.a.GpP);
                j.sC("wechatmm");
                j.sC("FFmpeg");
                j.sC("wechatpack");
                i = m.XE();
                if ((i & 0x400) == 0) {
                  break label1280;
                }
                ac.i(TAG, "load wechatsight_v7a, core number: %d ", new Object[] { Integer.valueOf(i >> 12) });
                j.sC("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.c.xCp = 3;
                com.tencent.mm.plugin.sight.base.c.xCr = 3;
                com.tencent.mm.plugin.sight.base.c.xCs = 544000;
                SightVideoJNI.registerALL();
                locale = MMActivity.initLanguage(this.app.getBaseContext());
                ab.KT();
                if ((com.tencent.mm.compatible.util.d.kZ(14)) && (d.cIg != null)) {
                  d.cIg.getApplication().registerActivityLifecycleCallbacks(new ToolsProfile.2(this));
                }
                ac.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - l));
                if (ai.eVd())
                {
                  com.tencent.mm.pluginsdk.model.w.z("use_sandbox", Boolean.TRUE);
                  com.tencent.mm.pluginsdk.model.w.z("sandbox_crash_record0", com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(ai.getContext().getFilesDir(), "crash/java_" + ai.getPackageName() + ":isolated_process0").fxV()));
                  com.tencent.mm.pluginsdk.model.w.z("sandbox_crash_record1", com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(ai.getContext().getFilesDir(), "crash/" + ai.getPackageName() + ":isolated_process0").fxV()));
                }
                w.a.hl(ai.getContext());
                com.tencent.mm.pluginsdk.ui.span.c.a.DBW = com.tencent.mm.app.plugin.e.Lz();
                com.tencent.mm.sdk.b.a.GpY.c(new u(22, 32));
                w.a.eKO();
                AppMethodBeat.o(19499);
                return;
                localException1 = localException1;
                ac.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException2 = localException2;
                ac.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                ac.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                ac.i("MicroMsg.ToolDebugger", "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                ac.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.c.xCp = 1;
                com.tencent.mm.plugin.sight.base.c.xCr = 1;
                com.tencent.mm.plugin.sight.base.c.xCs = 640000;
                continue;
                label1280:
                ac.i(TAG, "load wechatsight");
                j.sC("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.c.xCp = 1;
                com.tencent.mm.plugin.sight.base.c.xCr = 1;
                com.tencent.mm.plugin.sight.base.c.xCs = 640000;
              }
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return cIB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile
 * JD-Core Version:    0.7.0.1
 */