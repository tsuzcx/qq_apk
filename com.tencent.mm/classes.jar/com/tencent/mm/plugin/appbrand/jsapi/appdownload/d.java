package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v;
import java.util.HashMap;

public final class d
  extends b
{
  public static final int CTRL_INDEX = 662;
  public static final String NAME = "onDownloadAppStateChangeForNative";
  
  private d(v paramv)
  {
    super(paramv);
  }
  
  public static void n(v paramv)
  {
    AppMethodBeat.i(45742);
    if (oyx.containsKey(paramv.getAppId()))
    {
      AppMethodBeat.o(45742);
      return;
    }
    a(paramv, new d(paramv));
    AppMethodBeat.o(45742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.d
 * JD-Core Version:    0.7.0.1
 */