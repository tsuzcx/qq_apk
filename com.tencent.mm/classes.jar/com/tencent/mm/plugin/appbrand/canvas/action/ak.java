package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg;
import com.tencent.mm.plugin.appbrand.z.g;
import org.json.JSONArray;

public final class ak
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144991);
    paramd = (TranslateActionArg)paramDrawActionArg;
    if (paramd == null)
    {
      AppMethodBeat.o(144991);
      return false;
    }
    paramCanvas.translate(paramd.x, paramd.y);
    AppMethodBeat.o(144991);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144990);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(144990);
      return false;
    }
    paramCanvas.translate(g.f(paramJSONArray, 0), g.f(paramJSONArray, 1));
    AppMethodBeat.o(144990);
    return true;
  }
  
  public final BaseDrawActionArg bdn()
  {
    AppMethodBeat.i(144989);
    TranslateActionArg localTranslateActionArg = new TranslateActionArg();
    AppMethodBeat.o(144989);
    return localTranslateActionArg;
  }
  
  public final String getMethod()
  {
    return "translate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ak
 * JD-Core Version:    0.7.0.1
 */