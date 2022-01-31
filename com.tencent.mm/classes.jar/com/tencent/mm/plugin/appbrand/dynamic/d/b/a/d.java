package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import org.json.JSONObject;

public final class d
  extends a
{
  public final int azU()
  {
    return 0;
  }
  
  public final DrawCanvasArg c(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(10898);
    paramString = super.c(paramJSONObject, paramString);
    paramString.h(paramJSONObject.optJSONArray("actions"));
    AppMethodBeat.o(10898);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */