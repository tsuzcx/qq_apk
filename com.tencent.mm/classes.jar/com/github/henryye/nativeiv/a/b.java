package com.github.henryye.nativeiv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b cEL;
  
  static
  {
    AppMethodBeat.i(127390);
    cEL = new b.a((byte)0);
    AppMethodBeat.o(127390);
  }
  
  public static void a(b paramb)
  {
    cEL = paramb;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127385);
    cEL.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(127385);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127388);
    cEL.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(127388);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127386);
    cEL.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(127386);
  }
  
  public static void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127389);
    cEL.printStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(127389);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127387);
    cEL.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(127387);
  }
  
  public static abstract interface b
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.a.b
 * JD-Core Version:    0.7.0.1
 */