package com.tencent.mm.compatible.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public enum a
{
  private static volatile a fzi;
  
  static
  {
    AppMethodBeat.i(155631);
    fzh = new a("INSTANCE");
    fzj = new a[] { fzh };
    fzi = new a()
    {
      public final void y(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(155626);
        ad.w("MicroMsg.ReportDelegate", "hy: dummy reportIDKey, do nothing");
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
      fzi = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void ll(long paramLong)
  {
    AppMethodBeat.i(155629);
    fzi.y(853L, paramLong);
    AppMethodBeat.o(155629);
  }
  
  public static void lm(long paramLong)
  {
    AppMethodBeat.i(155630);
    fzi.y(650L, paramLong);
    AppMethodBeat.o(155630);
  }
  
  public static abstract interface a
  {
    public abstract void y(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.c.a
 * JD-Core Version:    0.7.0.1
 */