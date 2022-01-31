package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

public class FCMInstanceIDListenerService
  extends FirebaseInstanceIdService
{
  public final void onTokenRefresh()
  {
    AppMethodBeat.i(56426);
    String str = FirebaseInstanceId.rL().getToken();
    ab.i("MicroMsg.FCM.FCMInstanceIDListenerService", "Refreshed token: ".concat(String.valueOf(str)));
    g.RJ();
    if (com.tencent.mm.kernel.a.QT())
    {
      a locala = a.byx();
      if (locala != null)
      {
        locala.Oi(str);
        AppMethodBeat.o(56426);
        return;
      }
      ab.w("MicroMsg.FCM.FCMInstanceIDListenerService", "fcmRegister null, not reg token");
      AppMethodBeat.o(56426);
      return;
    }
    ab.w("MicroMsg.FCM.FCMInstanceIDListenerService", "User is not logined, not reg token");
    AppMethodBeat.o(56426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.FCMInstanceIDListenerService
 * JD-Core Version:    0.7.0.1
 */