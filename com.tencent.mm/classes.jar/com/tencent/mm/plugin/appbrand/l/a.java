package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.protocal.protobuf.bvk;
import java.util.Locale;

public final class a
{
  public static boolean a(int paramInt1, int paramInt2, bvk parambvk)
  {
    return (paramInt1 == 0) && (paramInt2 == 0) && (parambvk != null);
  }
  
  public static boolean b(a.a<?> parama)
  {
    AppMethodBeat.i(132307);
    if ((parama != null) && (a(parama.errType, parama.errCode, parama.fsN)))
    {
      AppMethodBeat.o(132307);
      return true;
    }
    AppMethodBeat.o(132307);
    return false;
  }
  
  public static String c(a.a parama)
  {
    AppMethodBeat.i(132308);
    if (parama == null)
    {
      AppMethodBeat.o(132308);
      return "null";
    }
    parama = String.format(Locale.US, "%d %d %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
    AppMethodBeat.o(132308);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.a
 * JD-Core Version:    0.7.0.1
 */