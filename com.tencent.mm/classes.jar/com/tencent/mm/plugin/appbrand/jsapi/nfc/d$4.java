package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

final class d$4
  extends TimerTask
{
  d$4(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(141908);
    d locald = this.hUA;
    synchronized (locald.mLock)
    {
      boolean bool = locald.eRZ;
      if (!bool) {
        locald.eRZ = true;
      }
      if (bool)
      {
        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
        AppMethodBeat.o(141908);
        return;
      }
    }
    if (HCEEventLogic.aDY())
    {
      ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
      AppMethodBeat.o(141908);
      return;
    }
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
    HCEEventLogic.ev(true);
    if (localObject1.hAC != null) {
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.Q(localObject1.hAC.getAppId(), 13007, -2);
    }
    ??? = new HashMap();
    ((Map)???).put("errCode", Integer.valueOf(13007));
    localObject1.BS(localObject1.j("fail: start HCEService failed", (Map)???));
    AppMethodBeat.o(141908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d.4
 * JD-Core Version:    0.7.0.1
 */