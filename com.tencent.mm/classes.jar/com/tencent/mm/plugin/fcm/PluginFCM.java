package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginFCM
  extends f
  implements com.tencent.mm.plugin.fcm.a.a
{
  private static boolean tnE = true;
  IListener tnF;
  IListener tnG;
  
  public PluginFCM()
  {
    AppMethodBeat.i(127584);
    this.tnF = new IListener() {};
    this.tnG = new IListener() {};
    AppMethodBeat.o(127584);
  }
  
  private boolean handleLogin()
  {
    AppMethodBeat.i(127588);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.w("MicroMsg.FCM.PluginFCM", "accout not ready");
      AppMethodBeat.o(127588);
      return false;
    }
    b localb = b.cXf();
    if (localb != null)
    {
      if (localb.cXh())
      {
        Log.i("MicroMsg.FCM.FcmRegister", "Google Play Services is available, " + Thread.currentThread().getId());
        if (localb.cXg())
        {
          String str = FirebaseInstanceId.yc().getToken();
          if (str == null) {
            Log.w("MicroMsg.FCM.FcmRegister", "token is null, not ready");
          }
          localb.asA(str);
          AppMethodBeat.o(127588);
          return true;
        }
        Log.w("MicroMsg.FCM.FcmRegister", "init fcm sdk failed!");
      }
      for (;;)
      {
        h.CyF.kvStat(11250, "2,0");
        e.Cxv.idkeyStat(901L, 0L, 1L, false);
        if (!localb.cXj()) {
          break;
        }
        localb.cXi();
        break;
        Log.w("MicroMsg.FCM.FcmRegister", "Google Play Services Unavailable");
      }
    }
    AppMethodBeat.o(127588);
    return false;
  }
  
  private boolean handleLogout()
  {
    AppMethodBeat.i(127589);
    b localb = b.cXf();
    if (localb != null)
    {
      Log.i("MicroMsg.FCM.FcmRegister", "FCM onLogout. isRegToSvr:" + localb.cXj());
      WCFirebaseMessagingService.cXl();
      if (localb.cXj()) {
        localb.cXi();
      }
      for (;;)
      {
        AppMethodBeat.o(127589);
        return true;
        e.Cxv.idkeyStat(901L, 20L, 1L, false);
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
    if (paramg.aBb())
    {
      Log.i("MicroMsg.FCM.PluginFCM", "register listener at " + paramg.mProcessName);
      if (!a.fj(paramg.ca))
      {
        tnE = false;
        AppMethodBeat.o(127587);
        return;
      }
      EventCenter.instance.add(this.tnF);
      EventCenter.instance.add(this.tnG);
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