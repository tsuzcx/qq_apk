package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o.a;
import org.json.JSONObject;

public final class ap
  extends aa
{
  private static final int CTRL_INDEX = 396;
  private static final String NAME = "saveFileSync";
  
  public final String a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128901);
    parame = ao.e(parame, paramJSONObject);
    parame = m(parame.errMsg, parame.values);
    AppMethodBeat.o(128901);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ap
 * JD-Core Version:    0.7.0.1
 */