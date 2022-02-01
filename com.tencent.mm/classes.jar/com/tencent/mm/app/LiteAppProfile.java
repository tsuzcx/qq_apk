package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.CommLibFileName;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/app/LiteAppProfile;", "Lcom/tencent/mm/compatible/loader/Profile;", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "onConfigurationChanged", "", "config", "Landroid/content/res/Configuration;", "onCreate", "onTrimMemory", "level", "", "app_release"})
public final class LiteAppProfile
  extends com.tencent.mm.compatible.loader.d
{
  private final String TAG;
  private final String dkO;
  
  public LiteAppProfile()
  {
    AppMethodBeat.i(230595);
    this.TAG = "MicroMsg.LiteAppProfile";
    this.dkO = (MMApplicationContext.getProcessName() + ":lite");
    AppMethodBeat.o(230595);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(230593);
    p.h(paramConfiguration, "config");
    Log.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(230593);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(230592);
    Log.i(this.TAG, "LiteAppProfile onCreate.");
    long l = System.currentTimeMillis();
    Object localObject1 = this.app;
    p.g(localObject1, "app");
    localObject1 = com.tencent.mm.booter.d.cg(((Application)localObject1).getBaseContext());
    p.g(localObject1, "debugger");
    localObject1 = new s((com.tencent.mm.booter.d)localObject1);
    ((s)localObject1).CN("LITE");
    ac.jNP = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.jNQ = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.jNR = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.jNS = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.jNT = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.jNU = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.jNY = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.jNZ = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.location_help"), false);
    ac.jOc = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.force_soso"), false);
    ac.jOd = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.jOe = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.jOf = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.jOi = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.jOj = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.testForPull"), false);
    int i = Util.nullAs(((s)localObject1).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.jOg = i;
    if ((i != 4) && (ac.jOg > 0))
    {
      com.tencent.mm.storage.aq.NSc = ac.jOg;
      Log.e(((s)localObject1).TAG, "cdn thread num " + ac.jOg);
    }
    ac.jOh = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      localObject2 = Integer.decode(((s)localObject1).getString(".com.tencent.mm.debug.log.setversion"));
      p.g(localObject2, "Integer.decode(getString…m.debug.log.setversion\"))");
      i = ((Integer)localObject2).intValue();
      com.tencent.mm.protocal.d.aiV(i);
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
    }
    catch (Exception localException4)
    {
      try
      {
        localObject2 = ((s)localObject1).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!Util.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.protocal.d.ics = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.KyK = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.KyM = String.valueOf(localObject2);
          CrashReportFactory.setDebugerApiLevel((String)localObject2);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.ics).append(" ").append(CrashReportFactory.getDebugerApiLevel());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject2 = Integer.decode(((s)localObject1).getString(".com.tencent.mm.debug.log.setuin"));
          p.g(localObject2, "Integer.decode(getString…nt.mm.debug.log.setuin\"))");
          i = ((Integer)localObject2).intValue();
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.KyN).append(" new: ").append(i);
          com.tencent.mm.protocal.d.KyN = i;
        }
        catch (Exception localException4)
        {
          try
          {
            Object localObject2 = Integer.decode(((s)localObject1).getString(".com.tencent.mm.debug.log.setchannel"));
            p.g(localObject2, "Integer.decode(getString…m.debug.log.setchannel\"))");
            i = ((Integer)localObject2).intValue();
            ((s)localObject1).akX().glq = i;
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append(']');
                ac.jOx = Util.nullAs(((s)localObject1).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                Log.d(((s)localObject1).TAG, "Test.jsapiPermission = " + ac.jOx);
                ac.jOy = Util.nullAs(((s)localObject1).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                Log.d(((s)localObject1).TAG, "Test.generalCtrl = " + ac.jOy);
                ac.jOz = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.skiploadurlcheck"), false);
                Log.d(((s)localObject1).TAG, "Test.skipLoadUrlCheck = " + ac.jOz);
                ac.jOA = Util.nullAs(((s)localObject1).CO(".com.tencent.mm.debug.forcex5webview"), false);
                Log.d(((s)localObject1).TAG, "Test.forceX5WebView = " + ac.jOA);
                f.bF((Context)((h)g.aAe().azG()).aAZ());
                com.tencent.mm.f.a.cc(MMApplicationContext.getContext());
                t.addOnUncaughtExceptionListener((MMUncaughtExceptionHandler.IOnUncaughtExceptionListener)new LiteAppProfile.a());
                t.d(false, this.dkO);
                ab.WH();
                a.VP();
                LiteAppProfile.class.getClassLoader();
                j.load("wechatxlog");
                j.Ed("wechatcommon");
                j.Ed("wechatbase");
                j.Ed("wechatmm");
                j.Ed(CommLibFileName.quic);
                j.load("wechatlv");
                j.load("liteapphelper");
                Log.i(this.TAG, "LiteAppProfile onCreate finish in %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                AppMethodBeat.o(230592);
                return;
                localException1 = localException1;
                Log.i(((s)localObject1).TAG, "no debugger was got");
                continue;
                localException2 = localException2;
                Log.i(((s)localObject1).TAG, "no debugger was got");
                continue;
                localException3 = localException3;
                Log.i(((s)localObject1).TAG, "no debugger was got");
                continue;
                localException4 = localException4;
                Log.i(((s)localObject1).TAG, "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                Log.i(((s)localObject1).TAG, "no debugger was got");
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(230594);
    super.onTrimMemory(paramInt);
    Log.v(this.TAG, "onTerminate(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(230594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.LiteAppProfile
 * JD-Core Version:    0.7.0.1
 */