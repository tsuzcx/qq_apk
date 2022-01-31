package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class i
  extends b<e>
{
  public static final int CTRL_INDEX = 68;
  public static final String NAME = "removeCanvas";
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103856);
    int i = paramJSONObject.optInt("canvasId");
    AppMethodBeat.o(103856);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.i
 * JD-Core Version:    0.7.0.1
 */