package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.x5.a.e;
import java.util.Map;

public final class bl
  extends bk
{
  protected final Map<String, Object> d(g paramg)
  {
    AppMethodBeat.i(45493);
    paramg = super.d(paramg);
    paramg.put("clientVersion", Integer.valueOf(d.Yxh));
    paramg.put("x5Version", Integer.valueOf(e.getTbsVersion(MMApplicationContext.getContext())));
    AppMethodBeat.o(45493);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bl
 * JD-Core Version:    0.7.0.1
 */