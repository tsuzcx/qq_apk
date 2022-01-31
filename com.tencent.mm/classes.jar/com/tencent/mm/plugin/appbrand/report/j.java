package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.xweb.WebView;

public enum j
{
  static
  {
    AppMethodBeat.i(132568);
    iFZ = new j("X5", 0);
    iGa = new j("Sys", 1);
    iGb = new j("XWalk", 2);
    iGc = new j("Invalid", 3);
    iGd = new j[] { iFZ, iGa, iGb, iGc };
    AppMethodBeat.o(132568);
  }
  
  private j() {}
  
  public static j aLa()
  {
    AppMethodBeat.i(132567);
    boolean bool1 = WebView.isSys();
    boolean bool2 = WebView.isXWalk();
    boolean bool3 = WebView.isX5();
    if (((!bool1) || (bool2) || (bool3)) && ((bool1) || (!bool2) || (bool3)) && ((bool1) || (bool2) || (!bool3)))
    {
      if (f.DEBUG)
      {
        localObject = new IllegalStateException("WebViewType invalid");
        AppMethodBeat.o(132567);
        throw ((Throwable)localObject);
      }
      localObject = iGc;
      AppMethodBeat.o(132567);
      return localObject;
    }
    if (bool3)
    {
      localObject = iFZ;
      AppMethodBeat.o(132567);
      return localObject;
    }
    if (bool2)
    {
      localObject = iGb;
      AppMethodBeat.o(132567);
      return localObject;
    }
    Object localObject = iGa;
    AppMethodBeat.o(132567);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.j
 * JD-Core Version:    0.7.0.1
 */