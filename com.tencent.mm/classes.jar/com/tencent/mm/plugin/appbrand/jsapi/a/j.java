package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class j
  extends b<e>
{
  public static final int CTRL_INDEX = 68;
  public static final String NAME = "removeCanvas";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145542);
    int i = paramJSONObject.optInt("canvasId");
    AppMethodBeat.o(145542);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.j
 * JD-Core Version:    0.7.0.1
 */