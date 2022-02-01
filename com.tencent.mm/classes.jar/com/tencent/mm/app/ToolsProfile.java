package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.plugin.e;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.cr.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.model.x.a;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.entry.ApplicationLike;
import java.util.Locale;
import junit.framework.Assert;

public final class ToolsProfile
  extends com.tencent.mm.compatible.loader.d
{
  private static final String TAG;
  public static final String dkO;
  private static Locale locale;
  private int dmD;
  
  static
  {
    AppMethodBeat.i(19501);
    dkO = MMApplicationContext.getProcessName();
    TAG = "MicroMsg." + b.getModuleName() + "Profile";
    AppMethodBeat.o(19501);
  }
  
  public ToolsProfile()
  {
    AppMethodBeat.i(19498);
    this.dmD = 0;
    AppMethodBeat.o(19498);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19500);
    paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext());
    Log.d(TAG, "onConfigurationChanged, locale = " + locale.toString() + ", n = " + paramConfiguration.toString());
    if (!paramConfiguration.equals(locale))
    {
      Log.w(TAG, "language changed, restart process");
      paramConfiguration = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramConfiguration.axQ(), "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)paramConfiguration.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/ToolsProfile", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    }
    AppMethodBeat.o(19500);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19499);
    long l = System.currentTimeMillis();
    ToolsProfile.class.getClassLoader();
    com.tencent.mm.f.a.cc(MMApplicationContext.getContext());
    t.addOnUncaughtExceptionListener(new ToolsProfile.1(this));
    Log.i("MicroMsg.ToolsProfileTest", dkO);
    t.d(false, dkO);
    AppLogic.setCallBack(new AppCallBack(MMApplicationContext.getContext()));
    w localw = new w(com.tencent.mm.booter.d.cg(this.app.getBaseContext()));
    localw.CN("TOOL");
    ac.jNP = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.jNQ = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.jNR = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.jNS = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.jNT = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.jNU = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.jNY = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.jNZ = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.location_help"), false);
    ac.jOc = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.force_soso"), false);
    ac.jOd = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.jOe = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.jOf = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.jOi = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.jOj = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(localw.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.jOg = i;
    if ((i != 4) && (ac.jOg > 0))
    {
      com.tencent.mm.storage.aq.NSc = ac.jOg;
      Log.e("MicroMsg.ToolDebugger", "cdn thread num " + ac.jOg);
    }
    ac.jOh = Util.nullAs(localw.CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.aiV(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        String str = localw.getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.KyM = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(i);
          com.tencent.mm.protocal.d.KyN = i;
        }
        catch (Exception localException4)
        {
          try
          {
            i = Integer.decode(localw.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            localw.gmN.glq = i;
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(localw.CO(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(localw.CO(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(localw.CO(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(localw.CO(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                ac.jOx = Util.nullAs(localw.getString(".com.tencent.mm.debug.jsapi.permission"), "");
                Log.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + ac.jOx);
                ac.jOy = Util.nullAs(localw.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                Log.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + ac.jOy);
                ac.jOz = Util.nullAs(localw.CO(".com.tencent.mm.debug.skiploadurlcheck"), false);
                Log.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + ac.jOz);
                ac.jOA = Util.nullAs(localw.CO(".com.tencent.mm.debug.forcex5webview"), false);
                Log.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + ac.jOA);
                f.bF(((h)com.tencent.mm.kernel.g.aAe().azG()).ca);
                a.VP();
                j.Ed("wcdb");
                j.Ed("commonimgdec");
                j.Ed("wechatcommon");
                j.Ed("wechatbase");
                j.Ed(CommLibFileName.quic);
                j.Ed("wechatmm");
                j.Ed("FFmpeg");
                j.Ed("wechatpack");
                i = m.aon();
                if ((i & 0x400) == 0) {
                  break label1298;
                }
                Log.i(TAG, "load wechatsight_v7a, core number: %d ", new Object[] { Integer.valueOf(i >> 12) });
                j.Ed("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.c.Dma = 3;
                com.tencent.mm.plugin.sight.base.c.Dmc = 3;
                com.tencent.mm.plugin.sight.base.c.Dmd = 544000;
                SightVideoJNI.registerALL();
                locale = MMActivity.initLanguage(this.app.getBaseContext());
                ab.WH();
                if ((com.tencent.mm.compatible.util.d.oD(14)) && (d.dks != null)) {
                  d.dks.getApplication().registerActivityLifecycleCallbacks(new ToolsProfile.2(this));
                }
                Log.i(TAG, "start time check toolsprofile use time = " + (System.currentTimeMillis() - l));
                if (MMApplicationContext.isToolsProcess())
                {
                  x.E("use_sandbox", Boolean.TRUE);
                  x.E("sandbox_crash_record0", aa.z(new o(MMApplicationContext.getContext().getFilesDir(), "crash/java_" + MMApplicationContext.getPackageName() + ":isolated_process0").her()));
                  x.E("sandbox_crash_record1", aa.z(new o(MMApplicationContext.getContext().getFilesDir(), "crash/" + MMApplicationContext.getPackageName() + ":isolated_process0").her()));
                }
                x.a.iq(MMApplicationContext.getContext());
                com.tencent.mm.pluginsdk.ui.span.d.a.KqD = e.Xo();
                EventCenter.instance.addListener(new v(22, 32));
                x.a.gmH();
                AppMethodBeat.o(19499);
                return;
                localException1 = localException1;
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException2 = localException2;
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                Log.i("MicroMsg.ToolDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.c.Dma = 1;
                com.tencent.mm.plugin.sight.base.c.Dmc = 1;
                com.tencent.mm.plugin.sight.base.c.Dmd = 640000;
                continue;
                label1298:
                Log.i(TAG, "load wechatsight");
                j.Ed("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.c.Dma = 1;
                com.tencent.mm.plugin.sight.base.c.Dmc = 1;
                com.tencent.mm.plugin.sight.base.c.Dmd = 640000;
              }
            }
          }
        }
      }
    }
  }
  
  public final String toString()
  {
    return dkO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile
 * JD-Core Version:    0.7.0.1
 */