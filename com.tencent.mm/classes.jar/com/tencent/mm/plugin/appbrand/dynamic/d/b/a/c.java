package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import org.json.JSONObject;

public final class c
  extends a
{
  public final DrawCanvasArg b(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(121376);
    paramJSONObject = super.b(paramJSONObject, paramString);
    paramJSONObject.jUl = true;
    AppMethodBeat.o(121376);
    return paramJSONObject;
  }
  
  public final int bgd()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c
 * JD-Core Version:    0.7.0.1
 */