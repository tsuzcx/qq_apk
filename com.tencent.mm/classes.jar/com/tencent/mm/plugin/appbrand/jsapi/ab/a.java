package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

public final class a
  extends r
{
  private static final int CTRL_INDEX = 153;
  private static final String NAME = "onNetworkStatusChange";
  
  public static void o(e parame)
  {
    AppMethodBeat.i(134890);
    HashMap localHashMap = new HashMap();
    g.c localc = g.dR(MMApplicationContext.getContext());
    if (localc != g.c.prW) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isConnected", Boolean.valueOf(bool));
      localHashMap.put("networkType", localc.value);
      Log.i("MicroMsg.AppBrandOnNetworkStatusChangeEvent", "networkType = %s", new Object[] { localc.value });
      new a().i(parame).D(localHashMap).bPO();
      AppMethodBeat.o(134890);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a
 * JD-Core Version:    0.7.0.1
 */