package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;

public final class a
  extends p
{
  private static final int CTRL_INDEX = 153;
  private static final String NAME = "onNetworkStatusChange";
  
  public static void m(c paramc)
  {
    AppMethodBeat.i(134890);
    HashMap localHashMap = new HashMap();
    f.c localc = f.dv(ai.getContext());
    if (localc != f.c.kMR) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isConnected", Boolean.valueOf(bool));
      localHashMap.put("networkType", localc.value);
      ac.i("MicroMsg.AppBrandOnNetworkStatusChangeEvent", "networkType = %s", new Object[] { localc.value });
      new a().g(paramc).A(localHashMap).beN();
      AppMethodBeat.o(134890);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a
 * JD-Core Version:    0.7.0.1
 */