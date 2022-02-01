package com.tencent.mm.compatible.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum a
{
  private static volatile a gDw;
  
  static
  {
    AppMethodBeat.i(155631);
    gDv = new a("INSTANCE");
    gDx = new a[] { gDv };
    gDw = new a()
    {
      public final void c(int paramAnonymousInt, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(215247);
        Log.w("MicroMsg.ReportDelegate", "hy: dummy reportKV, do nothing");
        AppMethodBeat.o(215247);
      }
      
      public final void w(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(155626);
        Log.w("MicroMsg.ReportDelegate", "hy: dummy reportIDKey, do nothing");
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
      gDw = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void b(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215249);
    gDw.c(paramInt, paramVarArgs);
    AppMethodBeat.o(215249);
  }
  
  public static void v(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(215248);
    gDw.w(paramLong1, paramLong2);
    AppMethodBeat.o(215248);
  }
  
  public static void yT(long paramLong)
  {
    AppMethodBeat.i(155629);
    gDw.w(853L, paramLong);
    AppMethodBeat.o(155629);
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt, Object... paramVarArgs);
    
    public abstract void w(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.d.a
 * JD-Core Version:    0.7.0.1
 */