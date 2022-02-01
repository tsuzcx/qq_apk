package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg;
import org.json.JSONArray;

public final class ab
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float paramFloat)
  {
    AppMethodBeat.i(144956);
    paramd.kZm.setStrokeWidth(paramFloat);
    paramd.kZl.setStrokeWidth(paramFloat);
    AppMethodBeat.o(144956);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144957);
    paramCanvas = (SetLineWidthActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144957);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.kZO);
    AppMethodBeat.o(144957);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144955);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(144955);
      return false;
    }
    boolean bool = a(paramd, g.f(paramJSONArray, 0));
    AppMethodBeat.o(144955);
    return bool;
  }
  
  public final BaseDrawActionArg bzj()
  {
    AppMethodBeat.i(144954);
    SetLineWidthActionArg localSetLineWidthActionArg = new SetLineWidthActionArg();
    AppMethodBeat.o(144954);
    return localSetLineWidthActionArg;
  }
  
  public final String getMethod()
  {
    return "setLineWidth";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ab
 * JD-Core Version:    0.7.0.1
 */