package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import org.json.JSONObject;

public final class c
  extends a
{
  public final int azU()
  {
    return 2;
  }
  
  public final DrawCanvasArg c(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(10896);
    paramJSONObject = super.c(paramJSONObject, paramString);
    paramJSONObject.hfS = true;
    AppMethodBeat.o(10896);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c
 * JD-Core Version:    0.7.0.1
 */