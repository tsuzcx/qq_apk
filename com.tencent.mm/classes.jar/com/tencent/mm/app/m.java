package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.stubs.logger.Log.Logger;

public final class m
  implements Log.Logger
{
  public static m Md()
  {
    return a.cUK;
  }
  
  public final boolean isLoggable(String paramString, int paramInt)
  {
    return true;
  }
  
  public final void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(123466);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123466);
      return;
      ae.v(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      ae.d(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      ae.i(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      ae.w(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      ae.e(paramString1, paramString2);
    }
  }
  
  static final class a
  {
    static final m cUK;
    
    static
    {
      AppMethodBeat.i(123465);
      cUK = new m((byte)0);
      AppMethodBeat.o(123465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.m
 * JD-Core Version:    0.7.0.1
 */