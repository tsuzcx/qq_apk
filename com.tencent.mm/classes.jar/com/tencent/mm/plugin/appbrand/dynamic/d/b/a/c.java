package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import org.json.JSONObject;

public final class c
  extends a
{
  public final int cnP()
  {
    return 2;
  }
  
  public final DrawCanvasArg d(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(121376);
    paramJSONObject = super.d(paramJSONObject, paramString);
    paramJSONObject.qUt = true;
    AppMethodBeat.o(121376);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c
 * JD-Core Version:    0.7.0.1
 */