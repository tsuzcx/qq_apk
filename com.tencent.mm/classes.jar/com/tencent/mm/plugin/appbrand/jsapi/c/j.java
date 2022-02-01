package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import org.json.JSONObject;

public final class j
  extends c<h>
{
  public static final int CTRL_INDEX = 68;
  public static final String NAME = "removeCanvas";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145542);
    int i = paramJSONObject.optInt("canvasId");
    AppMethodBeat.o(145542);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.j
 * JD-Core Version:    0.7.0.1
 */