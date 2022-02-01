package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import org.json.JSONObject;

public final class l
  extends c
{
  public static final int CTRL_INDEX = 83;
  public static final String NAME = "updateCanvas";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145543);
    int i = paramJSONObject.optInt("canvasId");
    AppMethodBeat.o(145543);
    return i;
  }
  
  public final boolean aYx()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.l
 * JD-Core Version:    0.7.0.1
 */