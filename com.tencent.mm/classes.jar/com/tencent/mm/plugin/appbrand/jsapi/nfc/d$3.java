package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

final class d$3
  extends TimerTask
{
  d$3(d paramd) {}
  
  public final void run()
  {
    d locald = this.gyb;
    synchronized (locald.mLock)
    {
      boolean bool = locald.gxZ;
      if (!bool) {
        locald.gxZ = true;
      }
      if (bool)
      {
        y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
        return;
      }
    }
    if (HCEEventLogic.ajF())
    {
      y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
      return;
    }
    y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
    HCEEventLogic.dq(true);
    if (localObject1.gfZ != null) {
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.E(localObject1.gfZ.getAppId(), 13007, -2);
    }
    ??? = new HashMap();
    ((Map)???).put("errCode", Integer.valueOf(13007));
    localObject1.tT(localObject1.h("fail: start HCEService failed", (Map)???));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d.3
 * JD-Core Version:    0.7.0.1
 */