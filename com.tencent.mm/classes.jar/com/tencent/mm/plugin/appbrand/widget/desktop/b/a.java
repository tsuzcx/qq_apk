package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.mm.ui.tools.f;

public final class a
{
  public static String wZ(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (f.aek(paramString) <= 12) {
          return paramString;
        }
        Object localObject = paramString.toCharArray();
        int m = localObject.length;
        int j = 0;
        int i = 0;
        int k = 0;
        while (j < m)
        {
          k += f.aek(String.valueOf(localObject[j]));
          if (k >= 12)
          {
            localObject = paramString.substring(0, i) + '…';
            return localObject;
          }
          j += 1;
          i += 1;
        }
        return paramString;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a
 * JD-Core Version:    0.7.0.1
 */