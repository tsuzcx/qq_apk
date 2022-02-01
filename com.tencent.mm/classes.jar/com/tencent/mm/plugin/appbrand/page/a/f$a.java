package com.tencent.mm.plugin.appbrand.page.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum f$a
{
  static
  {
    AppMethodBeat.i(135307);
    qxG = new a("LIGHT", 0);
    qxH = new a("DARK", 1);
    qxI = new a("IGNORE", 2);
    qxJ = new a[] { qxG, qxH, qxI };
    AppMethodBeat.o(135307);
  }
  
  private f$a() {}
  
  public static a aB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(243335);
    if (TextUtils.isEmpty(paramString))
    {
      if (paramBoolean)
      {
        paramString = qxG;
        AppMethodBeat.o(243335);
        return paramString;
      }
      paramString = qxH;
      AppMethodBeat.o(243335);
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
        AppMethodBeat.o(243335);
        return locala;
        bool = false;
        continue;
        bool = str.equalsIgnoreCase(paramString);
      }
      i += 1;
    }
    Log.e("Luggage.AppBrandPageViewPullDownExtension.BackgroundTextStyle", "fromString(%s), unrecognized", new Object[] { paramString });
    if (paramBoolean)
    {
      paramString = qxG;
      AppMethodBeat.o(243335);
      return paramString;
    }
    paramString = qxH;
    AppMethodBeat.o(243335);
    return paramString;
  }
  
  public final String cfF()
  {
    AppMethodBeat.i(292939);
    String str = name().toLowerCase();
    AppMethodBeat.o(292939);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f.a
 * JD-Core Version:    0.7.0.1
 */