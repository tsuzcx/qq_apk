package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d$a
{
  public static Object resolveObj(int paramInt, String paramString)
  {
    AppMethodBeat.i(131869);
    switch (paramInt)
    {
    }
    try
    {
      Log.e("MicroMsg.Debugger.Resolver", "unknown type");
      label51:
      AppMethodBeat.o(131869);
      return null;
      paramString = Integer.valueOf(paramString);
      AppMethodBeat.o(131869);
      return paramString;
      paramString = Long.valueOf(paramString);
      AppMethodBeat.o(131869);
      return paramString;
      AppMethodBeat.o(131869);
      return paramString;
      paramString = Boolean.valueOf(paramString);
      AppMethodBeat.o(131869);
      return paramString;
      paramString = Float.valueOf(paramString);
      AppMethodBeat.o(131869);
      return paramString;
      paramString = Double.valueOf(paramString);
      AppMethodBeat.o(131869);
      return paramString;
    }
    catch (Exception paramString)
    {
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.d.a
 * JD-Core Version:    0.7.0.1
 */