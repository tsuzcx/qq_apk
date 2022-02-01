package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v;
import java.util.HashMap;

public final class c
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onDownloadAppStateChange";
  
  private c(v paramv)
  {
    super(paramv);
  }
  
  public static void n(v paramv)
  {
    AppMethodBeat.i(45741);
    if (oyx.containsKey(paramv.getAppId()))
    {
      AppMethodBeat.o(45741);
      return;
    }
    a(paramv, new c(paramv));
    AppMethodBeat.o(45741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.c
 * JD-Core Version:    0.7.0.1
 */