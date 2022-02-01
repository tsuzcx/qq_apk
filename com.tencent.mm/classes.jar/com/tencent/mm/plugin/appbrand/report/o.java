package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.xweb.WebView;
import java.util.Locale;

public enum o
{
  static
  {
    AppMethodBeat.i(48071);
    nHD = new o("X5", 0);
    nHE = new o("Sys", 1);
    nHF = new o("XWalk", 2);
    nHG = new o("Invalid", 3);
    nHH = new o[] { nHD, nHE, nHF, nHG };
    AppMethodBeat.o(48071);
  }
  
  private o() {}
  
  public static o bUx()
  {
    AppMethodBeat.i(48070);
    boolean bool1 = WebView.isSys();
    boolean bool2 = WebView.isXWalk();
    boolean bool3 = WebView.isX5();
    int i = 0;
    int k;
    for (int j = 0; i < 3; j = k)
    {
      k = j;
      if (new boolean[] { bool1, bool2, bool3 }[i] != 0) {
        k = j + 1;
      }
      i += 1;
    }
    if (j == 1) {
      i = 1;
    }
    while (i == 0) {
      if (BuildInfo.DEBUG)
      {
        localObject = new IllegalStateException(String.format(Locale.US, "WebViewType invalid sys[%B] xw[%B] x5[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
        AppMethodBeat.o(48070);
        throw ((Throwable)localObject);
        i = 0;
      }
      else
      {
        localObject = nHG;
        AppMethodBeat.o(48070);
        return localObject;
      }
    }
    if (bool3)
    {
      localObject = nHD;
      AppMethodBeat.o(48070);
      return localObject;
    }
    if (bool2)
    {
      localObject = nHF;
      AppMethodBeat.o(48070);
      return localObject;
    }
    Object localObject = nHE;
    AppMethodBeat.o(48070);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.o
 * JD-Core Version:    0.7.0.1
 */