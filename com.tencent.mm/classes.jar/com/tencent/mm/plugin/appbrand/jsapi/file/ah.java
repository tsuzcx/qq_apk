package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

public final class ah
  extends u
{
  private static final int CTRL_INDEX = 396;
  private static final String NAME = "saveFileSync";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102809);
    paramc = ag.d(paramc, paramJSONObject);
    paramc = j(paramc.errMsg, paramc.values);
    AppMethodBeat.o(102809);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ah
 * JD-Core Version:    0.7.0.1
 */