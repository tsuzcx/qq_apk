package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

class JsApiNFCStartHCE$3
  extends ResultReceiver
{
  JsApiNFCStartHCE$3(d paramd, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(141906);
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI ResultReceiver resultCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramBundle == null) || (paramInt != 10001))
    {
      AppMethodBeat.o(141906);
      return;
    }
    paramInt = paramBundle.getInt("errCode", -1);
    paramBundle = paramBundle.getString("errMsg");
    d locald = this.hUA;
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramBundle });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      locald.onSuccess();
      AppMethodBeat.o(141906);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.Q(locald.hAC.getAppId(), paramInt, -1);
    locald.BS(locald.j("fail: ".concat(String.valueOf(paramBundle)), localHashMap));
    AppMethodBeat.o(141906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiNFCStartHCE.3
 * JD-Core Version:    0.7.0.1
 */