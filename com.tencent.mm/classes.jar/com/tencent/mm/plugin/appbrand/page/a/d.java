package com.tencent.mm.plugin.appbrand.page.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface d
{
  public static enum a
  {
    public final int lGx;
    
    static
    {
      AppMethodBeat.i(135288);
      lGv = new a("BLACK", 0, -16777216);
      lGw = new a("WHITE", 1, -1);
      lGy = new a[] { lGv, lGw };
      AppMethodBeat.o(135288);
    }
    
    private a(int paramInt)
    {
      this.lGx = paramInt;
    }
    
    public static a PW(String paramString)
    {
      AppMethodBeat.i(135287);
      if (!TextUtils.isEmpty(paramString))
      {
        a[] arrayOfa = values();
        int j = arrayOfa.length;
        int i = 0;
        while (i < j)
        {
          a locala = arrayOfa[i];
          if (locala.name().equalsIgnoreCase(paramString))
          {
            AppMethodBeat.o(135287);
            return locala;
          }
          i += 1;
        }
      }
      paramString = lGw;
      AppMethodBeat.o(135287);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.d
 * JD-Core Version:    0.7.0.1
 */