package com.tencent.mm.app;

import com.tencent.f.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  implements b.a
{
  public final boolean isLoggable(String paramString, int paramInt)
  {
    return true;
  }
  
  public final void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(3231);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(3231);
      return;
      ab.v(paramString1, paramString2);
      AppMethodBeat.o(3231);
      return;
      ab.d(paramString1, paramString2);
      AppMethodBeat.o(3231);
      return;
      ab.i(paramString1, paramString2);
      AppMethodBeat.o(3231);
      return;
      ab.w(paramString1, paramString2);
      AppMethodBeat.o(3231);
      return;
      ab.e(paramString1, paramString2);
    }
  }
  
  static final class a
  {
    static final i bXZ;
    
    static
    {
      AppMethodBeat.i(3230);
      bXZ = new i((byte)0);
      AppMethodBeat.o(3230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.i
 * JD-Core Version:    0.7.0.1
 */