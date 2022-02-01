package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import org.json.JSONObject;

public final class ar
  extends ab
{
  private static final int CTRL_INDEX = 396;
  private static final String NAME = "saveFileSync";
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128901);
    paramf = aq.e(paramf, paramJSONObject);
    paramf = m(paramf.errMsg, paramf.values);
    AppMethodBeat.o(128901);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ar
 * JD-Core Version:    0.7.0.1
 */