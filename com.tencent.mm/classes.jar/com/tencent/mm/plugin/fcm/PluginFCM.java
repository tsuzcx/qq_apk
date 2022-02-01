package com.tencent.mm.plugin.fcm;

import androidx.lifecycle.q;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hu;
import com.tencent.mm.autogen.a.hv;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginFCM
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.fcm.a.a
{
  private static boolean AqF = true;
  IListener AqG;
  IListener AqH;
  
  public PluginFCM()
  {
    AppMethodBeat.i(127584);
    this.AqG = new IListener(com.tencent.mm.app.f.hfK) {};
    this.AqH = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(127584);
  }
  
  private boolean handleLogin()
  {
    AppMethodBeat.i(127588);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.w("MicroMsg.FCM.PluginFCM", "accout not ready");
      AppMethodBeat.o(127588);
      return false;
    }
    b localb = b.dTd();
    if (localb != null)
    {
      if (localb.dTf())
      {
        Log.i("MicroMsg.FCM.FcmRegister", "Google Play Services is available, " + Thread.currentThread().getId());
        if (localb.dTe())
        {
          String str = FirebaseInstanceId.Yh().getToken();
          if (str == null) {
            Log.w("MicroMsg.FCM.FcmRegister", "token is null, not ready");
          }
          localb.auM(str);
          AppMethodBeat.o(127588);
          return true;
        }
        Log.w("MicroMsg.FCM.FcmRegister", "init fcm sdk failed!");
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(11250, "2,0");
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(901L, 0L, 1L, false);
        if (!localb.dTh()) {
          break;
        }
        localb.dTg();
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
    b localb = b.dTd();
    if (localb != null)
    {
      Log.i("MicroMsg.FCM.FcmRegister", "FCM onLogout. isRegToSvr:" + localb.dTh());
      WCFirebaseMessagingService.dTj();
      if (localb.dTh()) {
        localb.dTg();
      }
      for (;;)
      {
        AppMethodBeat.o(127589);
        return true;
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(901L, 20L, 1L, false);
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
    if (paramg.bbA())
    {
      Log.i("MicroMsg.FCM.PluginFCM", "register listener at " + paramg.mProcessName);
      if (!a.gm(paramg.bGP))
      {
        AqF = false;
        AppMethodBeat.o(127587);
        return;
      }
      this.AqG.alive();
      this.AqH.alive();
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