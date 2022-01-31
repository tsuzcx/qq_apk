package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class e
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    AppMethodBeat.i(103184);
    paramCanvas.drawArc(new RectF(paramFloat1 - paramFloat3, paramFloat2 - paramFloat3, paramFloat1 + paramFloat3, paramFloat2 + paramFloat3), (float)(paramFloat4 / 3.141592653589793D * 180.0D), (float)(paramFloat5 / 3.141592653589793D * 180.0D), true, paramd.heB);
    AppMethodBeat.o(103184);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103185);
    paramDrawActionArg = (DrawArcActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(103185);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.radius, paramDrawActionArg.heN, paramDrawActionArg.heO);
    AppMethodBeat.o(103185);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103183);
    if (paramJSONArray.length() < 5)
    {
      AppMethodBeat.o(103183);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, g.d(paramJSONArray, 0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), (float)paramJSONArray.optDouble(3), (float)paramJSONArray.optDouble(4));
    AppMethodBeat.o(103183);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103182);
    DrawArcActionArg localDrawArcActionArg = new DrawArcActionArg();
    AppMethodBeat.o(103182);
    return localDrawArcActionArg;
  }
  
  public final String getMethod()
  {
    return "arc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.e
 * JD-Core Version:    0.7.0.1
 */