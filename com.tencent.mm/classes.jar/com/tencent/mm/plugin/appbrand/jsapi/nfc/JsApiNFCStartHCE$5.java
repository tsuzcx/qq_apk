package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

class JsApiNFCStartHCE$5
  extends ResultReceiver
{
  JsApiNFCStartHCE$5(d paramd, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver resultCode: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramBundle == null) || (paramInt != 10002)) {}
    String str1;
    String str2;
    do
    {
      return;
      i = paramBundle.getInt("key_event_type", -1);
      str1 = paramBundle.getString("key_appid");
      paramInt = paramBundle.getInt("errCode", -1);
      str2 = paramBundle.getString("errMsg");
      y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver onReceiveResult eventType: %d, appId: %s", new Object[] { Integer.valueOf(i), str1 });
      switch (i)
      {
      default: 
        return;
      }
    } while (paramBundle == null);
    paramBundle = this.gyb;
    synchronized (paramBundle.mLock)
    {
      boolean bool = paramBundle.gxZ;
      if (!bool) {
        paramBundle.gxZ = true;
      }
      if (bool)
      {
        y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
        return;
        a.a(this.gyb.gfZ, i, paramBundle);
        return;
      }
    }
    if (HCEEventLogic.ajF())
    {
      y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
      return;
    }
    ??? = new HashMap();
    int i = (int)(System.currentTimeMillis() - paramBundle.mStartTime);
    if (paramBundle.mTimer != null)
    {
      y.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
      paramBundle.mTimer.cancel();
    }
    if ((str1 != null) && (!str1.equals(paramBundle.gfZ.getAppId())))
    {
      y.e("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", new Object[] { str1 });
      ((Map)???).put("errCode", Integer.valueOf(13010));
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.E(paramBundle.gfZ.getAppId(), 13010, i);
      paramBundle.tT(paramBundle.h("fail: unknown error", (Map)???));
      return;
    }
    y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), str2 });
    if (paramInt == 0)
    {
      HCEEventLogic.uw(paramBundle.gfZ.getAppId());
      ((Map)???).put("errCode", Integer.valueOf(0));
      paramBundle.tT(paramBundle.h("ok", (Map)???));
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.E(paramBundle.gfZ.getAppId(), paramInt, i);
      HCEEventLogic.dq(true);
      return;
      ((Map)???).put("errCode", Integer.valueOf(paramInt));
      paramBundle.tT(paramBundle.h("fail: " + str2, (Map)???));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiNFCStartHCE.5
 * JD-Core Version:    0.7.0.1
 */