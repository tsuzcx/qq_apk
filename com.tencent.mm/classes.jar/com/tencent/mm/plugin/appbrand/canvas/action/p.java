package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg;
import org.json.JSONArray;

public final class p
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144913);
    paramd = (ScaleActionArg)paramDrawActionArg;
    if (paramd == null)
    {
      AppMethodBeat.o(144913);
      return false;
    }
    paramCanvas.scale(paramd.jWE, paramd.jWF);
    AppMethodBeat.o(144913);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144912);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(144912);
      return false;
    }
    paramCanvas.scale((float)paramJSONArray.optDouble(0), (float)paramJSONArray.optDouble(1));
    AppMethodBeat.o(144912);
    return true;
  }
  
  public final BaseDrawActionArg bdS()
  {
    AppMethodBeat.i(144911);
    ScaleActionArg localScaleActionArg = new ScaleActionArg();
    AppMethodBeat.o(144911);
    return localScaleActionArg;
  }
  
  public final String getMethod()
  {
    return "scale";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.p
 * JD-Core Version:    0.7.0.1
 */