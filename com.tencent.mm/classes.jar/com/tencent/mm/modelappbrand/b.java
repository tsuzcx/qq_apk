package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  public static String lyo;
  public static String lyp;
  
  public static String bgL()
  {
    AppMethodBeat.i(153189);
    Object localObject = new StringBuilder("sid_");
    h.aHE();
    lyo = com.tencent.mm.kernel.b.getUin() + "_" + Util.nowMilliSecond();
    Log.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[] { lyo });
    localObject = lyo;
    AppMethodBeat.o(153189);
    return localObject;
  }
  
  public static void bgM()
  {
    AppMethodBeat.i(191302);
    f.Iyx.idkeyStat(365L, 5L, 1L, false);
    AppMethodBeat.o(191302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.b
 * JD-Core Version:    0.7.0.1
 */