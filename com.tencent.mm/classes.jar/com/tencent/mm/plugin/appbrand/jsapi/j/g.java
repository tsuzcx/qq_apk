package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.v;
import org.json.JSONObject;

public final class g
  extends h
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  
  public final void a(v paramv, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46375);
    super.a(paramv, paramJSONObject, paramInt);
    if ((this.oUM != null) && (this.oUM.oVh)) {
      AppBrandBackgroundRunningMonitor.a(paramv, 2, c.nSB.aOm);
    }
    AppMethodBeat.o(46375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.g
 * JD-Core Version:    0.7.0.1
 */