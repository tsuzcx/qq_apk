package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

class JsApiNFCStartHCE$6
  extends ResultReceiver
{
  JsApiNFCStartHCE$6(d paramd, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(141909);
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver resultCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramBundle == null) || (paramInt != 10002))
    {
      AppMethodBeat.o(141909);
      return;
    }
    int i = paramBundle.getInt("key_event_type", -1);
    String str1 = paramBundle.getString("key_appid");
    paramInt = paramBundle.getInt("errCode", -1);
    String str2 = paramBundle.getString("errMsg");
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver onReceiveResult eventType: %d, appId: %s", new Object[] { Integer.valueOf(i), str1 });
    switch (i)
    {
    }
    do
    {
      AppMethodBeat.o(141909);
      return;
      a.a(this.hUA.hAC, i, paramBundle);
      AppMethodBeat.o(141909);
      return;
    } while (paramBundle == null);
    paramBundle = this.hUA;
    synchronized (paramBundle.mLock)
    {
      boolean bool = paramBundle.eRZ;
      if (!bool) {
        paramBundle.eRZ = true;
      }
      if (bool)
      {
        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
        AppMethodBeat.o(141909);
        return;
      }
    }
    if (HCEEventLogic.aDY())
    {
      ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
      AppMethodBeat.o(141909);
      return;
    }
    ??? = new HashMap();
    i = (int)(System.currentTimeMillis() - paramBundle.mStartTime);
    if (paramBundle.mTimer != null)
    {
      ab.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
      paramBundle.mTimer.cancel();
    }
    if ((str1 != null) && (!str1.equals(paramBundle.hAC.getAppId())))
    {
      ab.e("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", new Object[] { str1 });
      ((Map)???).put("errCode", Integer.valueOf(13010));
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.Q(paramBundle.hAC.getAppId(), 13010, i);
      paramBundle.BS(paramBundle.j("fail: unknown error", (Map)???));
      AppMethodBeat.o(141909);
      return;
    }
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), str2 });
    if (paramInt == 0)
    {
      HCEEventLogic.CG(paramBundle.hAC.getAppId());
      ((Map)???).put("errCode", Integer.valueOf(0));
      paramBundle.BS(paramBundle.j("ok", (Map)???));
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.Q(paramBundle.hAC.getAppId(), paramInt, i);
      HCEEventLogic.ev(true);
      break;
      ((Map)???).put("errCode", Integer.valueOf(paramInt));
      paramBundle.BS(paramBundle.j("fail: ".concat(String.valueOf(str2)), (Map)???));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiNFCStartHCE.6
 * JD-Core Version:    0.7.0.1
 */