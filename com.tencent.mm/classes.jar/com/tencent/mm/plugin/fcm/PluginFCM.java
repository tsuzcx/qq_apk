package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hj;
import com.tencent.mm.f.a.hk;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginFCM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.fcm.a.a
{
  private static boolean wUc = true;
  IListener wUd;
  IListener wUe;
  
  public PluginFCM()
  {
    AppMethodBeat.i(127584);
    this.wUd = new IListener() {};
    this.wUe = new IListener() {};
    AppMethodBeat.o(127584);
  }
  
  private boolean handleLogin()
  {
    AppMethodBeat.i(127588);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.w("MicroMsg.FCM.PluginFCM", "accout not ready");
      AppMethodBeat.o(127588);
      return false;
    }
    b localb = b.dmn();
    if (localb != null)
    {
      if (localb.dmp())
      {
        Log.i("MicroMsg.FCM.FcmRegister", "Google Play Services is available, " + Thread.currentThread().getId());
        if (localb.dmo())
        {
          String str = FirebaseInstanceId.yw().getToken();
          if (str == null) {
            Log.w("MicroMsg.FCM.FcmRegister", "token is null, not ready");
          }
          localb.aAE(str);
          AppMethodBeat.o(127588);
          return true;
        }
        Log.w("MicroMsg.FCM.FcmRegister", "init fcm sdk failed!");
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(11250, "2,0");
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(901L, 0L, 1L, false);
        if (!localb.dmr()) {
          break;
        }
        localb.dmq();
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
    b localb = b.dmn();
    if (localb != null)
    {
      Log.i("MicroMsg.FCM.FcmRegister", "FCM onLogout. isRegToSvr:" + localb.dmr());
      WCFirebaseMessagingService.dmt();
      if (localb.dmr()) {
        localb.dmq();
      }
      for (;;)
      {
        AppMethodBeat.o(127589);
        return true;
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(901L, 20L, 1L, false);
      }
    }
    AppMethodBeat.o(127589);
    return false;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(127586);
    super.configure(paramg);
    AppMethodBeat.o(127586);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(127587);
    if (paramg.aIE())
    {
      Log.i("MicroMsg.FCM.PluginFCM", "register listener at " + paramg.mProcessName);
      if (!a.fo(paramg.Zw))
      {
        wUc = false;
        AppMethodBeat.o(127587);
        return;
      }
      EventCenter.instance.add(this.wUd);
      EventCenter.instance.add(this.wUe);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.PluginFCM
 * JD-Core Version:    0.7.0.1
 */