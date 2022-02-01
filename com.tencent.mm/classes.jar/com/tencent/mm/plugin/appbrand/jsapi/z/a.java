package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

public final class a
  extends s
{
  private static final int CTRL_INDEX = 153;
  private static final String NAME = "onNetworkStatusChange";
  
  public static void m(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(134890);
    HashMap localHashMap = new HashMap();
    f.c localc = f.dS(MMApplicationContext.getContext());
    if (localc != f.c.mtL) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isConnected", Boolean.valueOf(bool));
      localHashMap.put("networkType", localc.value);
      Log.i("MicroMsg.AppBrandOnNetworkStatusChangeEvent", "networkType = %s", new Object[] { localc.value });
      new a().g(paramf).K(localHashMap).bEo();
      AppMethodBeat.o(134890);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a
 * JD-Core Version:    0.7.0.1
 */