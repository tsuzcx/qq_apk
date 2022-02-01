package com.tencent.liteapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a ega;
  
  static
  {
    AppMethodBeat.i(219110);
    ega = new a();
    AppMethodBeat.o(219110);
  }
  
  public static void a(a parama)
  {
    ega = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(219084);
    ega.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(219084);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(219105);
    ega.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(219105);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(219090);
    ega.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(219090);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(219077);
    ega.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(219077);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(219096);
    ega.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(219096);
  }
  
  static final class a
    implements a
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(219091);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(219091);
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(219126);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(219126);
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(219104);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(219104);
    }
    
    public final void v(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(219082);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(219082);
    }
    
    public final void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(219113);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(219113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.b.b
 * JD-Core Version:    0.7.0.1
 */