package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.protocal.protobuf.dpc;
import java.util.Locale;

public final class a
{
  public static boolean a(int paramInt1, int paramInt2, dpc paramdpc)
  {
    return (paramInt1 == 0) && (paramInt2 == 0) && (paramdpc != null);
  }
  
  public static boolean d(c.a<?> parama)
  {
    AppMethodBeat.i(180325);
    if ((parama != null) && (a(parama.errType, parama.errCode, parama.iLC)))
    {
      AppMethodBeat.o(180325);
      return true;
    }
    AppMethodBeat.o(180325);
    return false;
  }
  
  public static String e(c.a parama)
  {
    AppMethodBeat.i(180326);
    if (parama == null)
    {
      AppMethodBeat.o(180326);
      return "null";
    }
    parama = String.format(Locale.US, "%d %d %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
    AppMethodBeat.o(180326);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a
 * JD-Core Version:    0.7.0.1
 */