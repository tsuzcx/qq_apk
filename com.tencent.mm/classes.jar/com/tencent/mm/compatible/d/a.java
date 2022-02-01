package com.tencent.mm.compatible.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static volatile a lQO;
  
  static
  {
    AppMethodBeat.i(155631);
    lQN = new a("INSTANCE");
    lQP = new a[] { lQN };
    lQO = new a.1();
    AppMethodBeat.o(155631);
  }
  
  private a() {}
  
  public static void T(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(240799);
    lQO.U(paramLong1, paramLong2);
    AppMethodBeat.o(240799);
  }
  
  public static void a(a parama)
  {
    try
    {
      lQO = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void c(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(240804);
    lQO.d(paramInt, paramVarArgs);
    AppMethodBeat.o(240804);
  }
  
  public static void ho(long paramLong)
  {
    AppMethodBeat.i(155629);
    lQO.U(853L, paramLong);
    AppMethodBeat.o(155629);
  }
  
  public static abstract interface a
  {
    public abstract void U(long paramLong1, long paramLong2);
    
    public abstract void d(int paramInt, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.d.a
 * JD-Core Version:    0.7.0.1
 */