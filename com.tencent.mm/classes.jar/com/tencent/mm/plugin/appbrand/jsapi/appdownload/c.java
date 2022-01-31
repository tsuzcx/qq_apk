package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;

public final class c
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onDownloadAppStateChange";
  
  private c(r paramr)
  {
    super(paramr);
    AppMethodBeat.i(130646);
    AppMethodBeat.o(130646);
  }
  
  public static void l(r paramr)
  {
    AppMethodBeat.i(130647);
    if (hAR.containsKey(paramr.getAppId()))
    {
      AppMethodBeat.o(130647);
      return;
    }
    a(paramr, new c(paramr));
    AppMethodBeat.o(130647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.c
 * JD-Core Version:    0.7.0.1
 */