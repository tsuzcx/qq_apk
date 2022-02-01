package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public class PluginFCM
  extends f
  implements com.tencent.mm.plugin.fcm.a.a
{
  private static boolean rFF = true;
  c rFG;
  c rFH;
  
  public PluginFCM()
  {
    AppMethodBeat.i(127584);
    this.rFG = new c() {};
    this.rFH = new c() {};
    AppMethodBeat.o(127584);
  }
  
  private boolean handleLogin()
  {
    AppMethodBeat.i(127588);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.w("MicroMsg.FCM.PluginFCM", "accout not ready");
      AppMethodBeat.o(127588);
      return false;
    }
    a locala = a.cxA();
    if (locala != null)
    {
      if (locala.cxC())
      {
        ad.i("MicroMsg.FCM.FcmRegister", "Google Play Services is available, " + Thread.currentThread().getId());
        if (locala.cxB())
        {
          String str = FirebaseInstanceId.xU().getToken();
          if (str == null) {
            ad.w("MicroMsg.FCM.FcmRegister", "token is null, not ready");
          }
          locala.agU(str);
          AppMethodBeat.o(127588);
          return true;
        }
        ad.w("MicroMsg.FCM.FcmRegister", "init fcm sdk failed!");
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(11250, "2,0");
        e.ygI.idkeyStat(901L, 0L, 1L, false);
        if (!locala.cxE()) {
          break;
        }
        locala.cxD();
        break;
        ad.w("MicroMsg.FCM.FcmRegister", "Google Play Services Unavailable");
      }
    }
    AppMethodBeat.o(127588);
    return false;
  }
  
  private boolean handleLogout()
  {
    AppMethodBeat.i(127589);
    a locala = a.cxA();
    if (locala != null)
    {
      ad.i("MicroMsg.FCM.FcmRegister", "FCM onLogout. isRegToSvr:" + locala.cxE());
      WCFirebaseMessagingService.cxG();
      if (locala.cxE()) {
        locala.cxD();
      }
      for (;;)
      {
        AppMethodBeat.o(127589);
        return true;
        e.ygI.idkeyStat(901L, 20L, 1L, false);
      }
    }
    AppMethodBeat.o(127589);
    return false;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(127586);
    super.configure(paramg);
    AppMethodBeat.o(127586);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(127587);
    if (paramg.akw())
    {
      ad.i("MicroMsg.FCM.PluginFCM", "register listener at " + paramg.mProcessName);
      if (d.e(paramg))
      {
        rFF = false;
        AppMethodBeat.o(127587);
        return;
      }
      com.tencent.mm.sdk.b.a.IbL.b(this.rFG);
      com.tencent.mm.sdk.b.a.IbL.b(this.rFH);
    }
    AppMethodBeat.o(127587);
  }
  
  public void installed()
  {
    AppMethodBeat.i(127585);
    super.installed();
    alias(com.tencent.mm.plugin.fcm.a.a.class);
    AppMethodBeat.o(127585);
  }
  
  public String name()
  {
    return "plugin-fcm";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.PluginFCM
 * JD-Core Version:    0.7.0.1
 */