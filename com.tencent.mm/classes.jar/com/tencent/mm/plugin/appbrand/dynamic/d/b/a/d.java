package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import org.json.JSONObject;

public final class d
  extends a
{
  public final int cnP()
  {
    return 0;
  }
  
  public final DrawCanvasArg d(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(121378);
    paramString = super.d(paramJSONObject, paramString);
    paramString.k(paramJSONObject.optJSONArray("actions"));
    AppMethodBeat.o(121378);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d
 * JD-Core Version:    0.7.0.1
 */