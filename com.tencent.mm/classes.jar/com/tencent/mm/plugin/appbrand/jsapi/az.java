package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Map;

public final class az
  extends ay
{
  protected final Map<String, Object> d(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(45493);
    paramd = super.d(paramd);
    paramd.put("clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.DIc));
    paramd.put("x5Version", Integer.valueOf(com.tencent.xweb.x5.sdk.d.getTbsVersion(ai.getContext())));
    AppMethodBeat.o(45493);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.az
 * JD-Core Version:    0.7.0.1
 */