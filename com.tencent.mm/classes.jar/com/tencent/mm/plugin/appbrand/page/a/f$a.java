package com.tencent.mm.plugin.appbrand.page.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum f$a
{
  static
  {
    AppMethodBeat.i(135307);
    tCK = new a("LIGHT", 0);
    tCL = new a("DARK", 1);
    tCM = new a("IGNORE", 2);
    tCN = new a[] { tCK, tCL, tCM };
    AppMethodBeat.o(135307);
  }
  
  private f$a() {}
  
  public static a aN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(325035);
    if (TextUtils.isEmpty(paramString))
    {
      if (paramBoolean)
      {
        paramString = tCK;
        AppMethodBeat.o(325035);
        return paramString;
      }
      paramString = tCL;
      AppMethodBeat.o(325035);
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
        AppMethodBeat.o(325035);
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
      paramString = tCK;
      AppMethodBeat.o(325035);
      return paramString;
    }
    paramString = tCL;
    AppMethodBeat.o(325035);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f.a
 * JD-Core Version:    0.7.0.1
 */