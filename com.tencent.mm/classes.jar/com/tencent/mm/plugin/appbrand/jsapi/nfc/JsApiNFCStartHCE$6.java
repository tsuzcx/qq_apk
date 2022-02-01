package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

class JsApiNFCStartHCE$6
  extends ResultReceiver
{
  JsApiNFCStartHCE$6(e parame, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(136113);
    ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver resultCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramBundle == null) || (paramInt != 10002))
    {
      AppMethodBeat.o(136113);
      return;
    }
    int i = paramBundle.getInt("key_event_type", -1);
    String str1 = paramBundle.getString("key_appid");
    paramInt = paramBundle.getInt("errCode", -1);
    String str2 = paramBundle.getString("errMsg");
    ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver onReceiveResult eventType: %d, appId: %s", new Object[] { Integer.valueOf(i), str1 });
    switch (i)
    {
    }
    do
    {
      AppMethodBeat.o(136113);
      return;
      a.a(this.kCa.kay, i, paramBundle);
      AppMethodBeat.o(136113);
      return;
    } while (paramBundle == null);
    paramBundle = this.kCa;
    synchronized (paramBundle.mLock)
    {
      boolean bool = paramBundle.gnd;
      if (!bool) {
        paramBundle.gnd = true;
      }
      if (bool)
      {
        ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
        AppMethodBeat.o(136113);
        return;
      }
    }
    if (HCEEventLogic.bhT())
    {
      ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
      AppMethodBeat.o(136113);
      return;
    }
    ??? = new HashMap();
    i = (int)(System.currentTimeMillis() - paramBundle.mStartTime);
    if (paramBundle.mTimer != null)
    {
      ac.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
      paramBundle.mTimer.cancel();
    }
    if ((str1 != null) && (!str1.equals(paramBundle.kay.getAppId())))
    {
      ac.e("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", new Object[] { str1 });
      ((Map)???).put("errCode", Integer.valueOf(13010));
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.M(paramBundle.kay.getAppId(), 13010, i);
      paramBundle.LV(paramBundle.k("fail: unknown error", (Map)???));
      AppMethodBeat.o(136113);
      return;
    }
    ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), str2 });
    if (paramInt == 0)
    {
      HCEEventLogic.MN(paramBundle.kay.getAppId());
      ((Map)???).put("errCode", Integer.valueOf(0));
      paramBundle.LV(paramBundle.k("ok", (Map)???));
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.M(paramBundle.kay.getAppId(), paramInt, i);
      HCEEventLogic.gG(true);
      break;
      ((Map)???).put("errCode", Integer.valueOf(paramInt));
      paramBundle.LV(paramBundle.k("fail: ".concat(String.valueOf(str2)), (Map)???));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiNFCStartHCE.6
 * JD-Core Version:    0.7.0.1
 */