package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import org.json.JSONObject;

public final class e
  extends f
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  
  public final void a(com.tencent.mm.plugin.appbrand.r paramr, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46375);
    super.a(paramr, paramJSONObject, paramInt);
    if ((this.kRV != null) && (this.kRV.kSo)) {
      AppBrandBackgroundRunningMonitor.a(paramr, 2, c.jVt.beO);
    }
    AppMethodBeat.o(46375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.e
 * JD-Core Version:    0.7.0.1
 */