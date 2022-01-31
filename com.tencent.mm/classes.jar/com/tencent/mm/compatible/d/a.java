package com.tencent.mm.compatible.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static volatile a.a emz;
  
  static
  {
    AppMethodBeat.i(92909);
    emy = new a("INSTANCE");
    emA = new a[] { emy };
    emz = new a.1();
    AppMethodBeat.o(92909);
  }
  
  private a() {}
  
  public static void a(a.a parama)
  {
    try
    {
      emz = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void ga(long paramLong)
  {
    AppMethodBeat.i(92907);
    emz.w(853L, paramLong);
    AppMethodBeat.o(92907);
  }
  
  public static void gb(long paramLong)
  {
    AppMethodBeat.i(92908);
    emz.w(650L, paramLong);
    AppMethodBeat.o(92908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.d.a
 * JD-Core Version:    0.7.0.1
 */