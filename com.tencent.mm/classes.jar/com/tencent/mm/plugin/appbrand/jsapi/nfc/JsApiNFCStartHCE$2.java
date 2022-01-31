package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

class JsApiNFCStartHCE$2
  extends ResultReceiver
{
  JsApiNFCStartHCE$2(d paramd, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI ResultReceiver resultCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramBundle == null) || (paramInt != 10001)) {
      return;
    }
    paramInt = paramBundle.getInt("errCode", -1);
    paramBundle = paramBundle.getString("errMsg");
    d locald = this.gyb;
    y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramBundle });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      locald.onSuccess();
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.E(locald.gfZ.getAppId(), paramInt, -1);
    locald.tT(locald.h("fail: " + paramBundle, localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiNFCStartHCE.2
 * JD-Core Version:    0.7.0.1
 */