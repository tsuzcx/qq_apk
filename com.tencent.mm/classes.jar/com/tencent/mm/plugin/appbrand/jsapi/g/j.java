package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d;
import org.json.JSONObject;

public final class j
  extends k
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  
  public final void b(com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46381);
    super.b(paramq, paramJSONObject, paramInt);
    if ((this.kOt != null) && (!this.kOt.kOG)) {
      AppBrandBackgroundRunningMonitor.a(paramq, 2, d.jSc.beO);
    }
    AppMethodBeat.o(46381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.j
 * JD-Core Version:    0.7.0.1
 */