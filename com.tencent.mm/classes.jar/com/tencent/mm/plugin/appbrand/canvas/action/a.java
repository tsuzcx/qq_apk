package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.ClearRectActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class a
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(103174);
    if (paramCanvas.isHardwareAccelerated())
    {
      if ((paramCanvas instanceof f))
      {
        ((f)paramCanvas).g(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4);
        com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) });
        AppMethodBeat.o(103174);
        return true;
      }
      if (paramd.heG != null)
      {
        paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, paramd.heG);
        com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) });
        AppMethodBeat.o(103174);
        return true;
      }
      com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) });
      AppMethodBeat.o(103174);
      return false;
    }
    if (paramd.heG != null)
    {
      paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, paramd.heG);
      com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) });
      AppMethodBeat.o(103174);
      return true;
    }
    paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, paramd.heF);
    com.tencent.luggage.g.d.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) });
    AppMethodBeat.o(103174);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103175);
    if ((paramDrawActionArg == null) || (!(paramDrawActionArg instanceof ClearRectActionArg)))
    {
      AppMethodBeat.o(103175);
      return false;
    }
    paramDrawActionArg = (ClearRectActionArg)paramDrawActionArg;
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.width, paramDrawActionArg.height);
    AppMethodBeat.o(103175);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103173);
    if (paramJSONArray.length() < 4)
    {
      AppMethodBeat.o(103173);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, g.d(paramJSONArray, 0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), g.d(paramJSONArray, 3));
    AppMethodBeat.o(103173);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103172);
    ClearRectActionArg localClearRectActionArg = new ClearRectActionArg();
    AppMethodBeat.o(103172);
    return localClearRectActionArg;
  }
  
  public final String getMethod()
  {
    return "clearRect";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.a
 * JD-Core Version:    0.7.0.1
 */