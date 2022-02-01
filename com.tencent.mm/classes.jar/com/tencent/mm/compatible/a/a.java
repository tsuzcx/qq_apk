package com.tencent.mm.compatible.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

public final class a
{
  public static boolean a(int paramInt, a parama)
  {
    AppMethodBeat.i(157475);
    if (d.lA(paramInt))
    {
      parama.run();
      AppMethodBeat.o(157475);
      return true;
    }
    AppMethodBeat.o(157475);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.a.a
 * JD-Core Version:    0.7.0.1
 */