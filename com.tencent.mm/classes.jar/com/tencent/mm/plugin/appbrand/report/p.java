package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.xweb.WebView;
import java.util.Locale;

public enum p
{
  static
  {
    AppMethodBeat.i(48071);
    qJP = new p("X5", 0);
    qJQ = new p("Sys", 1);
    qJR = new p("XWalk", 2);
    qJS = new p("Invalid", 3);
    qJT = new p[] { qJP, qJQ, qJR, qJS };
    AppMethodBeat.o(48071);
  }
  
  private p() {}
  
  public static p chH()
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
        localObject = qJS;
        AppMethodBeat.o(48070);
        return localObject;
      }
    }
    if (bool3)
    {
      localObject = qJP;
      AppMethodBeat.o(48070);
      return localObject;
    }
    if (bool2)
    {
      localObject = qJR;
      AppMethodBeat.o(48070);
      return localObject;
    }
    Object localObject = qJQ;
    AppMethodBeat.o(48070);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.p
 * JD-Core Version:    0.7.0.1
 */