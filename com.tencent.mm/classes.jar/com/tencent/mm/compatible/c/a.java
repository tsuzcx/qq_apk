package com.tencent.mm.compatible.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public enum a
{
  private static volatile a fYj;
  
  static
  {
    AppMethodBeat.i(155631);
    fYi = new a("INSTANCE");
    fYk = new a[] { fYi };
    fYj = new a()
    {
      public final void u(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(155626);
        ae.w("MicroMsg.ReportDelegate", "hy: dummy reportIDKey, do nothing");
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
      fYj = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void rb(long paramLong)
  {
    AppMethodBeat.i(155629);
    fYj.u(853L, paramLong);
    AppMethodBeat.o(155629);
  }
  
  public static void rc(long paramLong)
  {
    AppMethodBeat.i(155630);
    fYj.u(650L, paramLong);
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