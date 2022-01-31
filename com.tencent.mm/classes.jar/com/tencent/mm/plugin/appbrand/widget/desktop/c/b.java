package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.f;

public final class b
{
  public static String FF(String paramString)
  {
    AppMethodBeat.i(134251);
    if (paramString != null) {
      try
      {
        int i = f.auQ(paramString);
        if (i <= 12)
        {
          AppMethodBeat.o(134251);
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        i = 0;
        int k = 0;
        while (j < m)
        {
          k += f.auQ(String.valueOf(localObject[j]));
          if (k >= 12)
          {
            localObject = paramString.substring(0, i) + '…';
            AppMethodBeat.o(134251);
            return localObject;
          }
          j += 1;
          i += 1;
        }
        AppMethodBeat.o(134251);
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(134251);
        return paramString;
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.b
 * JD-Core Version:    0.7.0.1
 */