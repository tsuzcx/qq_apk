package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class a
{
  public static UUID aas(String paramString)
  {
    AppMethodBeat.i(329516);
    int i = paramString.length();
    String str;
    if (i == 4) {
      str = "0000" + paramString + "-0000-1000-8000-00805F9B34FB";
    }
    do
    {
      for (;;)
      {
        paramString = UUID.fromString(str);
        AppMethodBeat.o(329516);
        return paramString;
        if (i != 8) {
          break;
        }
        str = paramString + "-0000-1000-8000-00805F9B34FB";
      }
      str = paramString;
    } while (i == 36);
    paramString = new IllegalArgumentException("Invalid UUID name: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(329516);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.a
 * JD-Core Version:    0.7.0.1
 */