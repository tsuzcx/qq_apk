package com.github.henryye.nativeiv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b aRb;
  
  static
  {
    AppMethodBeat.i(127390);
    aRb = new a((byte)0);
    AppMethodBeat.o(127390);
  }
  
  public static void a(b paramb)
  {
    aRb = paramb;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127385);
    aRb.d(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(127385);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127388);
    aRb.e(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(127388);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127386);
    aRb.i(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(127386);
  }
  
  public static void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127389);
    aRb.printStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(127389);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(127387);
    aRb.w(paramString1, paramString2, paramVarArgs);
    AppMethodBeat.o(127387);
  }
  
  static final class a
    implements b.b
  {
    public final void d(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(127380);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(127380);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(127380);
      }
    }
    
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(127383);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(127383);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(127383);
      }
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(127381);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(127381);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(127381);
      }
    }
    
    public final void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(127384);
      if (paramThrowable != null)
      {
        if (paramVarArgs != null) {}
        try
        {
          if (paramVarArgs.length > 0) {
            String.format(paramString2, paramVarArgs);
          }
          AppMethodBeat.o(127384);
          return;
        }
        catch (Exception paramString1) {}
      }
      AppMethodBeat.o(127384);
    }
    
    public final void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(127382);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(127382);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(127382);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.a.b
 * JD-Core Version:    0.7.0.1
 */