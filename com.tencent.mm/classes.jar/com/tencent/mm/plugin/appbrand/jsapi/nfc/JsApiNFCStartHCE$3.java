package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

class JsApiNFCStartHCE$3
  extends ResultReceiver
{
  JsApiNFCStartHCE$3(e parame, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(136110);
    ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI ResultReceiver resultCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramBundle == null) || (paramInt != 10001))
    {
      AppMethodBeat.o(136110);
      return;
    }
    paramInt = paramBundle.getInt("errCode", -1);
    paramBundle = paramBundle.getString("errMsg");
    e locale = this.kbn;
    ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramBundle });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      locale.onSuccess();
      AppMethodBeat.o(136110);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.N(locale.jAc.getAppId(), paramInt, -1);
    locale.HQ(locale.k("fail: ".concat(String.valueOf(paramBundle)), localHashMap));
    AppMethodBeat.o(136110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiNFCStartHCE.3
 * JD-Core Version:    0.7.0.1
 */