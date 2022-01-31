package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineWidthActionArg;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class ab
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float paramFloat)
  {
    AppMethodBeat.i(103273);
    paramd.heC.setStrokeWidth(paramFloat);
    paramd.heB.setStrokeWidth(paramFloat);
    AppMethodBeat.o(103273);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103274);
    paramCanvas = (SetLineWidthActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103274);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.hfi);
    AppMethodBeat.o(103274);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103272);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(103272);
      return false;
    }
    boolean bool = a(paramd, g.d(paramJSONArray, 0));
    AppMethodBeat.o(103272);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103271);
    SetLineWidthActionArg localSetLineWidthActionArg = new SetLineWidthActionArg();
    AppMethodBeat.o(103271);
    return localSetLineWidthActionArg;
  }
  
  public final String getMethod()
  {
    return "setLineWidth";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ab
 * JD-Core Version:    0.7.0.1
 */