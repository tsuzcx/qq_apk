package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import java.util.HashMap;

public final class d
  extends b
{
  public static final int CTRL_INDEX = 662;
  public static final String NAME = "onDownloadAppStateChangeForNative";
  
  private d(s params)
  {
    super(params);
  }
  
  public static void n(s params)
  {
    AppMethodBeat.i(45742);
    if (lCV.containsKey(params.getAppId()))
    {
      AppMethodBeat.o(45742);
      return;
    }
    a(params, new d(params));
    AppMethodBeat.o(45742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.d
 * JD-Core Version:    0.7.0.1
 */