package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.xweb.WebView;
import java.util.Locale;

public enum m
{
  static
  {
    AppMethodBeat.i(48071);
    lRR = new m("X5", 0);
    lRS = new m("Sys", 1);
    lRT = new m("XWalk", 2);
    lRU = new m("Invalid", 3);
    lRV = new m[] { lRR, lRS, lRT, lRU };
    AppMethodBeat.o(48071);
  }
  
  private m() {}
  
  public static m bti()
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
      if (h.DEBUG)
      {
        localObject = new IllegalStateException(String.format(Locale.US, "WebViewType invalid sys[%B] xw[%B] x5[%B]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
        AppMethodBeat.o(48070);
        throw ((Throwable)localObject);
        i = 0;
      }
      else
      {
        localObject = lRU;
        AppMethodBeat.o(48070);
        return localObject;
      }
    }
    if (bool3)
    {
      localObject = lRR;
      AppMethodBeat.o(48070);
      return localObject;
    }
    if (bool2)
    {
      localObject = lRT;
      AppMethodBeat.o(48070);
      return localObject;
    }
    Object localObject = lRS;
    AppMethodBeat.o(48070);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.m
 * JD-Core Version:    0.7.0.1
 */