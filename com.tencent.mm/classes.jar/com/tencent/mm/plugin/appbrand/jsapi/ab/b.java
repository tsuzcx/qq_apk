package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

public final class b
  extends r
{
  private static final int CTRL_INDEX = -1;
  private static final String NAME = "onNetworkWeakChange";
  
  public static void a(e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(243116);
    HashMap localHashMap = new HashMap();
    g.c localc = g.dR(MMApplicationContext.getContext());
    localHashMap.put("networkType", localc.value);
    localHashMap.put("weakNet", Boolean.valueOf(paramBoolean));
    Log.i("MicroMsg.AppBrandOnNetworkWeakChangeEvent", "networkType = %s,weakNet = %b", new Object[] { localc.value, Boolean.valueOf(paramBoolean) });
    new b().i(parame).D(localHashMap).bPO();
    AppMethodBeat.o(243116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.b
 * JD-Core Version:    0.7.0.1
 */