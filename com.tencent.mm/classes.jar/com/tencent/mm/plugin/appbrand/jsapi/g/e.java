package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d;
import org.json.JSONObject;

public final class e
  extends f
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  
  public final void a(com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46375);
    super.a(paramq, paramJSONObject, paramInt);
    if ((this.kOt != null) && (this.kOt.kOG)) {
      AppBrandBackgroundRunningMonitor.a(paramq, 2, d.jSc.beO);
    }
    AppMethodBeat.o(46375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.e
 * JD-Core Version:    0.7.0.1
 */