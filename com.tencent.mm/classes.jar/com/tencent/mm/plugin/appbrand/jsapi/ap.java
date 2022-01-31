package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;

public final class ap
  extends ao
{
  protected final Map<String, Object> b(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(130434);
    paramd = super.b(paramd);
    paramd.put("clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.whH));
    paramd.put("x5Version", Integer.valueOf(com.tencent.xweb.x5.sdk.d.getTbsVersion(ah.getContext())));
    AppMethodBeat.o(130434);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */