package com.tencent.mm.plugin.appbrand.page.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  public final int iAo;
  
  static
  {
    AppMethodBeat.i(87351);
    iAm = new a("BLACK", 0, -16777216);
    iAn = new a("WHITE", 1, -1);
    iAp = new a[] { iAm, iAn };
    AppMethodBeat.o(87351);
  }
  
  private d$a(int paramInt)
  {
    this.iAo = paramInt;
  }
  
  public static a Es(String paramString)
  {
    AppMethodBeat.i(87350);
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
          AppMethodBeat.o(87350);
          return locala;
        }
        i += 1;
      }
    }
    paramString = iAn;
    AppMethodBeat.o(87350);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.d.a
 * JD-Core Version:    0.7.0.1
 */