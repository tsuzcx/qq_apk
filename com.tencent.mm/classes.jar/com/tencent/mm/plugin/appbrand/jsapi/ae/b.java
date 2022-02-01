package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

public final class b
  extends s
{
  private static final int CTRL_INDEX = -1;
  private static final String NAME = "onNetworkWeakChange";
  
  public static void a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(326058);
    HashMap localHashMap = new HashMap();
    MMApplicationContext.getContext();
    k.c localc = k.cuM();
    localHashMap.put("networkType", localc.value);
    localHashMap.put("weakNet", Boolean.valueOf(paramBoolean));
    Log.i("MicroMsg.AppBrandOnNetworkWeakChangeEvent", "networkType = %s,weakNet = %b", new Object[] { localc.value, Boolean.valueOf(paramBoolean) });
    new b().h(paramf).K(localHashMap).cpV();
    AppMethodBeat.o(326058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.b
 * JD-Core Version:    0.7.0.1
 */