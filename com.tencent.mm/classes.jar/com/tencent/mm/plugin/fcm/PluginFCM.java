package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public class PluginFCM
  extends f
  implements com.tencent.mm.plugin.fcm.a.a
{
  private static boolean qVr = true;
  c qVs;
  c qVt;
  
  public PluginFCM()
  {
    AppMethodBeat.i(127584);
    this.qVs = new c() {};
    this.qVt = new c() {};
    AppMethodBeat.o(127584);
  }
  
  private boolean handleLogin()
  {
    AppMethodBeat.i(127588);
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.w("MicroMsg.FCM.PluginFCM", "accout not ready");
      AppMethodBeat.o(127588);
      return false;
    }
    a locala = a.crO();
    if (locala != null)
    {
      if (locala.crQ())
      {
        ac.i("MicroMsg.FCM.FcmRegister", "Google Play Services is available, " + Thread.currentThread().getId());
        if (locala.crP())
        {
          String str = FirebaseInstanceId.wx().getToken();
          if (str == null) {
            ac.w("MicroMsg.FCM.FcmRegister", "token is null, not ready");
          }
          locala.adf(str);
          AppMethodBeat.o(127588);
          return true;
        }
        ac.w("MicroMsg.FCM.FcmRegister", "init fcm sdk failed!");
      }
      for (;;)
      {
        h.wUl.kvStat(11250, "2,0");
        e.wTc.idkeyStat(901L, 0L, 1L, false);
        if (!locala.crS()) {
          break;
        }
        locala.crR();
        break;
        ac.w("MicroMsg.FCM.FcmRegister", "Google Play Services Unavailable");
      }
    }
    AppMethodBeat.o(127588);
    return false;
  }
  
  private boolean handleLogout()
  {
    AppMethodBeat.i(127589);
    a locala = a.crO();
    if (locala != null)
    {
      ac.i("MicroMsg.FCM.FcmRegister", "FCM onLogout. isRegToSvr:" + locala.crS());
      WCFirebaseMessagingService.crU();
      if (locala.crS()) {
        locala.crR();
      }
      for (;;)
      {
        AppMethodBeat.o(127589);
        return true;
        e.wTc.idkeyStat(901L, 20L, 1L, false);
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
    if (paramg.ahL())
    {
      ac.i("MicroMsg.FCM.PluginFCM", "register listener at " + paramg.mProcessName);
      if (d.e(paramg))
      {
        qVr = false;
        AppMethodBeat.o(127587);
        return;
      }
      com.tencent.mm.sdk.b.a.GpY.b(this.qVs);
      com.tencent.mm.sdk.b.a.GpY.b(this.qVt);
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