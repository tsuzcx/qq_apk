package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.stubs.logger.Log.Logger;

public final class m
  implements Log.Logger
{
  public static m Wp()
  {
    return a.dle;
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
      Log.v(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      Log.d(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      Log.i(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      Log.w(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      Log.e(paramString1, paramString2);
    }
  }
  
  static final class a
  {
    static final m dle;
    
    static
    {
      AppMethodBeat.i(123465);
      dle = new m((byte)0);
      AppMethodBeat.o(123465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.m
 * JD-Core Version:    0.7.0.1
 */