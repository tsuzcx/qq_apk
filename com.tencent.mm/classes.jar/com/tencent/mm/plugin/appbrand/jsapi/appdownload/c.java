package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y;
import java.util.HashMap;

public final class c
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "onDownloadAppStateChange";
  
  private c(y paramy)
  {
    super(paramy);
  }
  
  public static void n(y paramy)
  {
    AppMethodBeat.i(45741);
    if (rCp.containsKey(paramy.getAppId()))
    {
      AppMethodBeat.o(45741);
      return;
    }
    a(paramy, new c(paramy));
    AppMethodBeat.o(45741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.c
 * JD-Core Version:    0.7.0.1
 */