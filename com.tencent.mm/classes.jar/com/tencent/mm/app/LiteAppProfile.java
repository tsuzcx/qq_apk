package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/app/LiteAppProfile;", "Lcom/tencent/mm/compatible/loader/Profile;", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "onConfigurationChanged", "", "config", "Landroid/content/res/Configuration;", "onCreate", "onTrimMemory", "level", "", "app_release"})
public final class LiteAppProfile
  extends com.tencent.mm.compatible.loader.d
{
  private final String TAG;
  private final String cTJ;
  
  public LiteAppProfile()
  {
    AppMethodBeat.i(194838);
    this.TAG = "MicroMsg.LiteAppProfile";
    this.cTJ = (aj.getProcessName() + ":lite");
    AppMethodBeat.o(194838);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(194836);
    ad.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(194836);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(194835);
    ad.i(this.TAG, "LiteAppProfile onCreate.");
    long l = System.currentTimeMillis();
    Object localObject1 = this.app;
    p.g(localObject1, "app");
    localObject1 = com.tencent.mm.booter.d.bJ(((Application)localObject1).getBaseContext());
    p.g(localObject1, "debugger");
    localObject1 = new com.tencent.mm.booter.s((com.tencent.mm.booter.d)localObject1);
    ((com.tencent.mm.booter.s)localObject1).uc("LITE");
    ac.iOb = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.display_errcode"), false);
    ac.iOc = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.display_msgstate"), false);
    ac.iOd = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.network.simulate_fault"), false);
    ac.iOe = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.network.force_touch"), false);
    ac.iOf = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
    ac.iOg = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.crashIsExit"), false);
    ac.iOk = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.album_show_info"), false);
    ac.iOl = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.location_help"), false);
    ac.iOo = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.force_soso"), false);
    ac.iOp = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.simulatePostServerError"), false);
    ac.iOq = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
    ac.iOr = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
    ac.iOu = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.filterfpnp"), false);
    ac.iOv = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.testForPull"), false);
    int i = bt.a(((com.tencent.mm.booter.s)localObject1).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
    ac.iOs = i;
    if ((i != 4) && (ac.iOs > 0))
    {
      com.tencent.mm.storage.ak.IpL = ac.iOs;
      ad.e(((com.tencent.mm.booter.s)localObject1).TAG, "cdn thread num " + ac.iOs);
    }
    ac.iOt = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
    try
    {
      localObject2 = Integer.decode(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setversion"));
      p.g(localObject2, "malformVersion");
      com.tencent.mm.protocal.d.ZA(((Integer)localObject2).intValue());
      new StringBuilder("set up test protocal version = ").append(Integer.toHexString(((Integer)localObject2).intValue()));
    }
    catch (Exception localException4)
    {
      try
      {
        localObject2 = ((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setapilevel");
        if (!bt.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.protocal.d.hgH = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.Fnf = "android-".concat(String.valueOf(localObject2));
          com.tencent.mm.protocal.d.Fnh = String.valueOf(localObject2);
          b.aPX((String)localObject2);
          new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.hgH).append(" ").append(b.fjO());
        }
      }
      catch (Exception localException4)
      {
        try
        {
          localObject2 = Integer.decode(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setuin"));
          new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.Fni).append(" new: ").append(localObject2);
          com.tencent.mm.protocal.d.Fni = ((Integer)localObject2).intValue();
        }
        catch (Exception localException4)
        {
          try
          {
            Object localObject2 = Integer.decode(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.log.setchannel"));
            com.tencent.mm.booter.d locald = ((com.tencent.mm.booter.s)localObject1).Xc();
            p.g(localObject2, "setchannel");
            locald.fEd = ((Integer)localObject2).intValue();
            new StringBuilder("set up test channel = ").append(localObject2);
          }
          catch (Exception localException4)
          {
            try
            {
              for (;;)
              {
                boolean bool1 = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.report.debugmodel"), false);
                boolean bool2 = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.report.kvstat"), false);
                boolean bool3 = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.report.clientpref"), false);
                boolean bool4 = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.report.useraction"), false);
                c.d(bool1, bool2, bool3, bool4);
                new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append(']');
                ac.iOI = bt.bI(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                ad.d(((com.tencent.mm.booter.s)localObject1).TAG, "Test.jsapiPermission = " + ac.iOI);
                ac.iOJ = bt.bI(((com.tencent.mm.booter.s)localObject1).getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
                ad.d(((com.tencent.mm.booter.s)localObject1).TAG, "Test.generalCtrl = " + ac.iOJ);
                ac.iOK = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.skiploadurlcheck"), false);
                ad.d(((com.tencent.mm.booter.s)localObject1).TAG, "Test.skipLoadUrlCheck = " + ac.iOK);
                ac.iOL = bt.a(((com.tencent.mm.booter.s)localObject1).ud(".com.tencent.mm.debug.forcex5webview"), false);
                ad.d(((com.tencent.mm.booter.s)localObject1).TAG, "Test.forceX5WebView = " + ac.iOL);
                f.bk((Context)((h)g.ajz().ajb()).aku());
                com.tencent.mm.f.a.bF(aj.getContext());
                s.a((au.c)new LiteAppProfile.a());
                s.fk(this.cTJ);
                ab.MA();
                a.Lu();
                p.g(LiteAppProfile.class.getClassLoader(), "LiteAppProfile::class.java.classLoader");
                j.load("wechatxlog");
                j.vr("wechatcommon");
                j.vr("wechatbase");
                j.vr("wechatmm");
                j.vr(com.tencent.mm.sdk.a.IbC);
                j.load("wechatlv");
                ad.i(this.TAG, "LiteAppProfile onCreate finish in %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                AppMethodBeat.o(194835);
                return;
                localException1 = localException1;
                ad.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
                continue;
                localException2 = localException2;
                ad.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
                continue;
                localException3 = localException3;
                ad.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
                continue;
                localException4 = localException4;
                ad.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
              }
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                ad.i(((com.tencent.mm.booter.s)localObject1).TAG, "no debugger was got");
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(194837);
    super.onTrimMemory(paramInt);
    ad.v(this.TAG, "onTerminate(l : %d)", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(194837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.LiteAppProfile
 * JD-Core Version:    0.7.0.1
 */