package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  static final class a
    implements c.b
  {
    public final void e(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(201247);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(201247);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(201247);
      }
    }
    
    public final void i(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(201245);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(201245);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(201245);
      }
    }
    
    public final void w(String paramString1, String paramString2, Object... paramVarArgs)
    {
      AppMethodBeat.i(201246);
      if (paramVarArgs != null) {}
      try
      {
        if (paramVarArgs.length > 0) {
          String.format(paramString2, paramVarArgs);
        }
        AppMethodBeat.o(201246);
        return;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(201246);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.a.c
 * JD-Core Version:    0.7.0.1
 */