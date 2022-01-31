package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class ak
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103308);
    paramd = (TranslateActionArg)paramDrawActionArg;
    if (paramd == null)
    {
      AppMethodBeat.o(103308);
      return false;
    }
    paramCanvas.translate(paramd.x, paramd.y);
    AppMethodBeat.o(103308);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103307);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(103307);
      return false;
    }
    paramCanvas.translate(g.d(paramJSONArray, 0), g.d(paramJSONArray, 1));
    AppMethodBeat.o(103307);
    return true;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103306);
    TranslateActionArg localTranslateActionArg = new TranslateActionArg();
    AppMethodBeat.o(103306);
    return localTranslateActionArg;
  }
  
  public final String getMethod()
  {
    return "translate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ak
 * JD-Core Version:    0.7.0.1
 */