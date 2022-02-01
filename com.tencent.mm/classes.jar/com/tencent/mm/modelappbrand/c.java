package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static String opP;
  public static String opQ;
  
  public static String bED()
  {
    AppMethodBeat.i(153189);
    Object localObject = new StringBuilder("sid_");
    h.baC();
    opP = b.getUin() + "_" + Util.nowMilliSecond();
    Log.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[] { opP });
    localObject = opP;
    AppMethodBeat.o(153189);
    return localObject;
  }
  
  public static void bEE()
  {
    AppMethodBeat.i(233813);
    f.Ozc.idkeyStat(365L, 5L, 1L, false);
    AppMethodBeat.o(233813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.c
 * JD-Core Version:    0.7.0.1
 */