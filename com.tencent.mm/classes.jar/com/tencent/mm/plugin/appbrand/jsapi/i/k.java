package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import org.json.JSONObject;

public final class k
  extends l
{
  private static final int CTRL_INDEX = 340;
  private static final String NAME = "enableLocationUpdate";
  
  public final void b(com.tencent.mm.plugin.appbrand.s params, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46381);
    super.b(params, paramJSONObject, paramInt);
    if ((this.lXb != null) && (!this.lXb.lXu)) {
      AppBrandBackgroundRunningMonitor.a(params, 2, c.kYp.beL);
    }
    AppMethodBeat.o(46381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.k
 * JD-Core Version:    0.7.0.1
 */