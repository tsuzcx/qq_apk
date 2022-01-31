package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;

public final class d
  extends b
{
  public static final int CTRL_INDEX = 662;
  public static final String NAME = "onDownloadAppStateChangeForNative";
  
  private d(r paramr)
  {
    super(paramr);
  }
  
  public static void l(r paramr)
  {
    AppMethodBeat.i(143279);
    if (hAR.containsKey(paramr.getAppId()))
    {
      AppMethodBeat.o(143279);
      return;
    }
    a(paramr, new d(paramr));
    AppMethodBeat.o(143279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.d
 * JD-Core Version:    0.7.0.1
 */