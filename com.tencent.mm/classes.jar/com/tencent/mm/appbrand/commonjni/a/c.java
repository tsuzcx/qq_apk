package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  static final class a
    implements c.b
  {
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(238557);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(238557);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(238557);
      }
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(238550);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(238550);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(238550);
      }
    }
    
    public final void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(238562);
      if (paramThrowable != null)
      {
        if (paramVarArgs != null) {}
        try
        {
          if (paramVarArgs.length > 0) {
            String.format(paramString2, paramVarArgs);
          }
          AppMethodBeat.o(238562);
          return;
        }
        catch (Exception paramString1) {}
      }
      AppMethodBeat.o(238562);
    }
  }
  
  public static abstract interface b
  {
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
  }
  
  public static final class c
  {
    private static c.b hlD;
    
    static
    {
      AppMethodBeat.i(238561);
      hlD = new c.a((byte)0);
      AppMethodBeat.o(238561);
    }
    
    public static void a(c.b paramb)
    {
      hlD = paramb;
    }
    
    public static void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(238551);
      hlD.e(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(238551);
    }
    
    public static void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(238545);
      hlD.i(paramString1, paramString2, paramVarArgs);
      AppMethodBeat.o(238545);
    }
    
    public static void printStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(238556);
      hlD.printStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
      AppMethodBeat.o(238556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.a.c
 * JD-Core Version:    0.7.0.1
 */