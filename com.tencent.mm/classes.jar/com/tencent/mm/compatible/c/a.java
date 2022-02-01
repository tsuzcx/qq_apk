package com.tencent.mm.compatible.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public enum a
{
  private static volatile a fCP;
  
  static
  {
    AppMethodBeat.i(155631);
    fCO = new a("INSTANCE");
    fCQ = new a[] { fCO };
    fCP = new a()
    {
      public final void u(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(155626);
        ac.w("MicroMsg.ReportDelegate", "hy: dummy reportIDKey, do nothing");
        AppMethodBeat.o(155626);
      }
    };
    AppMethodBeat.o(155631);
  }
  
  private a() {}
  
  public static void a(a parama)
  {
    try
    {
      fCP = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void oO(long paramLong)
  {
    AppMethodBeat.i(155629);
    fCP.u(853L, paramLong);
    AppMethodBeat.o(155629);
  }
  
  public static void oP(long paramLong)
  {
    AppMethodBeat.i(155630);
    fCP.u(650L, paramLong);
    AppMethodBeat.o(155630);
  }
  
  public static abstract interface a
  {
    public abstract void u(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.c.a
 * JD-Core Version:    0.7.0.1
 */