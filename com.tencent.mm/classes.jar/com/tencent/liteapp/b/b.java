package com.tencent.liteapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a coO;
  
  static
  {
    AppMethodBeat.i(258531);
    coO = new a();
    AppMethodBeat.o(258531);
  }
  
  public static void a(a parama)
  {
    coO = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(258526);
    coO.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(258526);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(258530);
    coO.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(258530);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(258527);
    coO.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(258527);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(258525);
    coO.v(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(258525);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(258528);
    coO.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(258528);
  }
  
  static final class a
    implements a
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(258521);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(258521);
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(258524);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(258524);
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(258522);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(258522);
    }
    
    public final void v(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(258520);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(258520);
    }
    
    public final void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(258523);
      String.format(paramString2, paramVarArgs);
      AppMethodBeat.o(258523);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.b.b
 * JD-Core Version:    0.7.0.1
 */