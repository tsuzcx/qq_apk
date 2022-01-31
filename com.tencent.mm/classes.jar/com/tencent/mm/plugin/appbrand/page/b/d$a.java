package com.tencent.mm.plugin.appbrand.page.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public enum d$a
{
  static
  {
    AppMethodBeat.i(141710);
    iAu = new a("LIGHT", 0);
    iAv = new a("DARK", 1);
    iAw = new a("IGNORE", 2);
    iAx = new a[] { iAu, iAv, iAw };
    AppMethodBeat.o(141710);
  }
  
  private d$a() {}
  
  public static a Et(String paramString)
  {
    AppMethodBeat.i(141709);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = iAv;
      AppMethodBeat.o(141709);
      return paramString;
    }
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      String str = locala.name().toLowerCase();
      boolean bool;
      if (str == null) {
        if (paramString == null) {
          bool = true;
        }
      }
      while (bool)
      {
        AppMethodBeat.o(141709);
        return locala;
        bool = false;
        continue;
        bool = str.equalsIgnoreCase(paramString);
      }
      i += 1;
    }
    ab.e("Luggage.AppBrandPageViewPullDownExtension.BackgroundTextStyle", "fromString(%s), unrecognized", new Object[] { paramString });
    paramString = iAv;
    AppMethodBeat.o(141709);
    return paramString;
  }
  
  public final String aKf()
  {
    AppMethodBeat.i(156864);
    String str = name().toLowerCase();
    AppMethodBeat.o(156864);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.d.a
 * JD-Core Version:    0.7.0.1
 */