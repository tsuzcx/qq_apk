package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

public class FCMInstanceIDListenerService
  extends FirebaseInstanceIdService
{
  public final void onTokenRefresh()
  {
    AppMethodBeat.i(127565);
    String str = FirebaseInstanceId.Yh().getToken();
    Log.i("MicroMsg.FCM.FCMInstanceIDListenerService", "Refreshed token: ".concat(String.valueOf(str)));
    h.baC();
    if (com.tencent.mm.kernel.b.aZM())
    {
      b localb = b.dTd();
      if (localb != null)
      {
        localb.auM(str);
        AppMethodBeat.o(127565);
        return;
      }
      Log.w("MicroMsg.FCM.FCMInstanceIDListenerService", "fcmRegister null, not reg token");
      AppMethodBeat.o(127565);
      return;
    }
    Log.w("MicroMsg.FCM.FCMInstanceIDListenerService", "User is not logined, not reg token");
    AppMethodBeat.o(127565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.FCMInstanceIDListenerService
 * JD-Core Version:    0.7.0.1
 */