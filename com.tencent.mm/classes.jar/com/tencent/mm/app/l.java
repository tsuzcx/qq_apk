package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.stubs.logger.Log.Logger;

public final class l
  implements Log.Logger
{
  public static l Ks()
  {
    return a.cID;
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
      ac.v(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      ac.d(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      ac.i(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      ac.w(paramString1, paramString2);
      AppMethodBeat.o(123466);
      return;
      ac.e(paramString1, paramString2);
    }
  }
  
  static final class a
  {
    static final l cID;
    
    static
    {
      AppMethodBeat.i(123465);
      cID = new l((byte)0);
      AppMethodBeat.o(123465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.l
 * JD-Core Version:    0.7.0.1
 */