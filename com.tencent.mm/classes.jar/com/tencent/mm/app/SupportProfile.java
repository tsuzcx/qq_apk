package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.ad;
import com.tencent.mm.sandbox.updater.k.a;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;

public class SupportProfile
  extends com.tencent.mm.compatible.loader.c
{
  protected static String eMg = "";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(19476);
    eMg = MMApplicationContext.getProcessName();
    SupportProfile.class.getClassLoader();
    w.addOnUncaughtExceptionListener(new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener()
    {
      public final void uncaughtException(MMUncaughtExceptionHandler paramAnonymousMMUncaughtExceptionHandler, String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(239092);
        h.OAn.idkeyStat(637L, 0L, 1L, false);
        KVCommCrossProcessReceiver.gNR();
        AppMethodBeat.o(239092);
      }
    });
    Object localObject = new v(com.tencent.mm.booter.d.cO(this.app.getBaseContext()));
    ((v)localObject).Ci("SUPPORT");
    z.pBz = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.display_errcode"), false);
    z.pBA = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.display_msgstate"), false);
    z.pBB = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    z.pBC = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.network.force_touch"), false);
    z.pBD = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    z.pBE = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.crashIsExit"), false);
    z.pBI = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.album_show_info"), false);
    z.pBJ = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.location_help"), false);
    z.pBM = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.force_soso"), false);
    z.pBN = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    z.pBO = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    z.pBP = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    z.pBS = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.filterfpnp"), false);
    z.pBT = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(((v)localObject).Cj(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    z.pBQ = i;
    if ((i != 4) && (z.pBQ > 0))
    {
      com.tencent.mm.storage.as.acHo = z.pBQ;
      Log.e("SetupSupportDebugger", "cdn thread num " + z.pBQ);
    }
    z.pBR = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    z.pCk = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.forcex5webview"), false);
    z.pCh = Util.nullAs(((v)localObject).getString(".com.tencent.mm.debug.jsapi.permission"), "");
    Log.d("SetupSupportDebugger", "Test.jsapiPermission = " + z.pCh);
    try
    {
      i = Integer.decode(((v)localObject).getString(".com.tencent.mm.debug.log.setversion")).intValue();
      com.tencent.mm.protocal.d.axo(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException5)
    {
      try
      {
        String str = ((v)localObject).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.protocal.d.nsC = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Yxc = "android-".concat(String.valueOf(str));
          com.tencent.mm.protocal.d.Yxe = String.valueOf(str);
          CrashReportFactory.setDebugerApiLevel(str);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.nsC).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException5)
      {
        try
        {
          i = Integer.decode(((v)localObject).getString(".com.tencent.mm.debug.log.setuin")).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Yxg).append(" new: ").append(i);
          com.tencent.mm.protocal.d.Yxg = i;
        }
        catch (Exception localException5)
        {
          try
          {
            i = Integer.decode(((v)localObject).getString(".com.tencent.mm.debug.log.setchannel")).intValue();
            ((q)localObject).lsS.lrt = i;
          }
          catch (Exception localException5)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(((v)localObject).Ck(".com.tencent.mm.debug.report.useraction"), false);
                com.tencent.mm.plugin.report.a.c.e(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                w.f(false, eMg);
                a.aBO();
                k.DA("wcdb");
                k.DA("commonimgdec");
                k.DA("wechatcommon");
                k.DA("wechatbase");
                k.DA(CommLibFileName.quic);
                k.DA("wechatmm");
                k.DA("FFmpeg");
                k.DA("wechatpack");
                i = m.aOK();
                if ((i & 0x400) == 0) {
                  break label915;
                }
                Log.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", new Object[] { Integer.valueOf(i >> 12) });
                k.DA("wechatsight_v7a");
                if (i >> 12 < 4) {
                  break;
                }
                com.tencent.mm.plugin.sight.base.d.PFh = 3;
                com.tencent.mm.plugin.sight.base.d.PFj = 3;
                com.tencent.mm.plugin.sight.base.d.PFk = 544000;
                af.aCS();
                MMActivity.initLanguage(this.app.getBaseContext());
                localObject = k.a.acoQ;
                ad.iIg();
                AppMethodBeat.o(19476);
                return;
                localException2 = localException2;
                Log.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException3 = localException3;
                Log.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException4 = localException4;
                Log.i("SetupSupportDebugger", "no debugger was got");
                continue;
                localException5 = localException5;
                Log.i("SetupSupportDebugger", "no debugger was got");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.i("SetupSupportDebugger", "no debugger was got");
                continue;
                com.tencent.mm.plugin.sight.base.d.PFh = 1;
                com.tencent.mm.plugin.sight.base.d.PFj = 1;
                com.tencent.mm.plugin.sight.base.d.PFk = 640000;
                continue;
                label915:
                Log.i("MicroMsg.SupportProfile", "load wechatsight");
                k.DA("wechatsight");
                Assert.assertTrue("Can't remove libwechatsight.so yet.", false);
                com.tencent.mm.plugin.sight.base.d.PFh = 1;
                com.tencent.mm.plugin.sight.base.d.PFj = 1;
                com.tencent.mm.plugin.sight.base.d.PFk = 640000;
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
    Log.v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.SupportProfile
 * JD-Core Version:    0.7.0.1
 */