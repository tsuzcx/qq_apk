package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.protocal.protobuf.esc;

public final class a
{
  public static boolean a(int paramInt1, int paramInt2, esc paramesc)
  {
    return (paramInt1 == 0) && (paramInt2 == 0) && (paramesc != null);
  }
  
  public static boolean d(b.a<?> parama)
  {
    AppMethodBeat.i(180325);
    if ((parama != null) && (a(parama.errType, parama.errCode, parama.ott)))
    {
      AppMethodBeat.o(180325);
      return true;
    }
    AppMethodBeat.o(180325);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a
 * JD-Core Version:    0.7.0.1
 */