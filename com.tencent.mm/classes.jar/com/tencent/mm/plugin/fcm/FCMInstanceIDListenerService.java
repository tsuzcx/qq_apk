package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

public class FCMInstanceIDListenerService
  extends FirebaseInstanceIdService
{
  public final void onTokenRefresh()
  {
    AppMethodBeat.i(127565);
    String str = FirebaseInstanceId.wK().getToken();
    ad.i("MicroMsg.FCM.FCMInstanceIDListenerService", "Refreshed token: ".concat(String.valueOf(str)));
    g.afz();
    if (com.tencent.mm.kernel.a.aeH())
    {
      a locala = a.ckh();
      if (locala != null)
      {
        locala.YJ(str);
        AppMethodBeat.o(127565);
        return;
      }
      ad.w("MicroMsg.FCM.FCMInstanceIDListenerService", "fcmRegister null, not reg token");
      AppMethodBeat.o(127565);
      return;
    }
    ad.w("MicroMsg.FCM.FCMInstanceIDListenerService", "User is not logined, not reg token");
    AppMethodBeat.o(127565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.FCMInstanceIDListenerService
 * JD-Core Version:    0.7.0.1
 */