package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.b.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class a$1
  implements b.a
{
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(236816);
    long l = Util.currentTicks();
    j.load(paramString);
    Log.i("MicroMsg.AppBrandCommonBinding", "hy: test loading %s using %d ms", new Object[] { paramString, Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(236816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.a.1
 * JD-Core Version:    0.7.0.1
 */