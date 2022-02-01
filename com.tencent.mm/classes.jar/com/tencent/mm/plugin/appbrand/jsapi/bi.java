package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public final class bi
  extends bh
{
  protected final Map<String, Object> d(g paramg)
  {
    AppMethodBeat.i(45493);
    paramg = super.d(paramg);
    paramg.put("clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.RAD));
    paramg.put("x5Version", Integer.valueOf(com.tencent.xweb.x5.sdk.d.getTbsVersion(MMApplicationContext.getContext())));
    AppMethodBeat.o(45493);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bi
 * JD-Core Version:    0.7.0.1
 */