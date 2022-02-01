package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.f;

public final class a
{
  public static String afX(String paramString)
  {
    AppMethodBeat.i(49863);
    if (paramString != null) {
      try
      {
        int i = f.bnP(paramString);
        if (i <= 12)
        {
          AppMethodBeat.o(49863);
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        i = 0;
        int k = 0;
        while (j < m)
        {
          k += f.bnP(String.valueOf(localObject[j]));
          if (k >= 12)
          {
            localObject = paramString.substring(0, i) + '…';
            AppMethodBeat.o(49863);
            return localObject;
          }
          j += 1;
          i += 1;
        }
        AppMethodBeat.o(49863);
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(49863);
        return paramString;
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a
 * JD-Core Version:    0.7.0.1
 */