package com.tencent.mm.compatible.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static volatile a jnG;
  
  static
  {
    AppMethodBeat.i(155631);
    jnF = new a("INSTANCE");
    jnH = new a[] { jnF };
    jnG = new a.1();
    AppMethodBeat.o(155631);
  }
  
  private a() {}
  
  public static void EV(long paramLong)
  {
    AppMethodBeat.i(155629);
    jnG.w(853L, paramLong);
    AppMethodBeat.o(155629);
  }
  
  public static void a(a parama)
  {
    try
    {
      jnG = parama;
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
    AppMethodBeat.i(263121);
    jnG.c(paramInt, paramVarArgs);
    AppMethodBeat.o(263121);
  }
  
  public static void v(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263120);
    jnG.w(paramLong1, paramLong2);
    AppMethodBeat.o(263120);
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt, Object... paramVarArgs);
    
    public abstract void w(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.d.a
 * JD-Core Version:    0.7.0.1
 */