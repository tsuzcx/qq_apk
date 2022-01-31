package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginFCM
  extends f
  implements com.tencent.mm.plugin.fcm.a.a
{
  private static boolean mET = true;
  c mEU;
  c mEV;
  
  public PluginFCM()
  {
    AppMethodBeat.i(56446);
    this.mEU = new PluginFCM.1(this);
    this.mEV = new PluginFCM.2(this);
    AppMethodBeat.o(56446);
  }
  
  private boolean handleLogin()
  {
    AppMethodBeat.i(56450);
    if (!com.tencent.mm.kernel.g.RG())
    {
      ab.w("MicroMsg.FCM.PluginFCM", "accout not ready");
      AppMethodBeat.o(56450);
      return false;
    }
    a locala = a.byx();
    if (locala != null)
    {
      String str;
      if (locala.byy())
      {
        ab.i("MicroMsg.FCM.FcmRegister", "Google Play Services is avaiable," + Long.toString(Thread.currentThread().getId()));
        com.google.firebase.a.ac(locala.context);
        com.google.firebase.messaging.a.si().bfN.rU();
        str = FirebaseInstanceId.rL().getToken();
        if (str == null) {
          ab.w("MicroMsg.FCM.FcmRegister", "token is null, not ready");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(56450);
        return true;
        locala.Oi(str);
        continue;
        ab.w("MicroMsg.FCM.FcmRegister", "Google Play Services Unavaiable");
        h.qsU.kvStat(11250, "2,0");
        e.qrI.idkeyStat(901L, 0L, 1L, false);
        if (locala.byA()) {
          locala.byz();
        }
      }
    }
    AppMethodBeat.o(56450);
    return false;
  }
  
  private boolean handleLogout()
  {
    AppMethodBeat.i(56451);
    a locala = a.byx();
    if (locala != null)
    {
      ab.i("MicroMsg.FCM.FcmRegister", "FCM onLogout. isRegToSvr:" + locala.byA());
      WCFirebaseMessagingService.byC();
      if (locala.byA()) {
        locala.byz();
      }
      for (;;)
      {
        AppMethodBeat.o(56451);
        return true;
        e.qrI.idkeyStat(901L, 20L, 1L, false);
      }
    }
    AppMethodBeat.o(56451);
    return false;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(56448);
    super.configure(paramg);
    AppMethodBeat.o(56448);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(56449);
    if (paramg.SD())
    {
      ab.i("MicroMsg.FCM.PluginFCM", "register listener at " + paramg.mProcessName);
      if (d.e(paramg))
      {
        mET = false;
        AppMethodBeat.o(56449);
        return;
      }
      com.tencent.mm.sdk.b.a.ymk.b(this.mEU);
      com.tencent.mm.sdk.b.a.ymk.b(this.mEV);
    }
    AppMethodBeat.o(56449);
  }
  
  public void installed()
  {
    AppMethodBeat.i(56447);
    super.installed();
    alias(com.tencent.mm.plugin.fcm.a.a.class);
    AppMethodBeat.o(56447);
  }
  
  public String name()
  {
    return "plugin-fcm";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.PluginFCM
 * JD-Core Version:    0.7.0.1
 */