package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import java.util.HashMap;

public final class c
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onDownloadAppStateChange";
  
  private c(s params)
  {
    super(params);
  }
  
  public static void n(s params)
  {
    AppMethodBeat.i(45741);
    if (lCV.containsKey(params.getAppId()))
    {
      AppMethodBeat.o(45741);
      return;
    }
    a(params, new c(params));
    AppMethodBeat.o(45741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.c
 * JD-Core Version:    0.7.0.1
 */