package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import org.json.JSONObject;

public final class al
  extends y
{
  private static final int CTRL_INDEX = 396;
  private static final String NAME = "saveFileSync";
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128901);
    paramc = ak.f(paramc, paramJSONObject);
    paramc = k(paramc.errMsg, paramc.values);
    AppMethodBeat.o(128901);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.al
 * JD-Core Version:    0.7.0.1
 */