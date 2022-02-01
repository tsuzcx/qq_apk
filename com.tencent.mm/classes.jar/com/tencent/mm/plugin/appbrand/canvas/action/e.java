package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg;
import org.json.JSONArray;

public final class e
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    AppMethodBeat.i(144867);
    paramCanvas.drawArc(new RectF(paramFloat1 - paramFloat3, paramFloat2 - paramFloat3, paramFloat1 + paramFloat3, paramFloat2 + paramFloat3), (float)(paramFloat4 / 3.141592653589793D * 180.0D), (float)(paramFloat5 / 3.141592653589793D * 180.0D), true, paramd.iYL);
    AppMethodBeat.o(144867);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144868);
    paramDrawActionArg = (DrawArcActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(144868);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.radius, paramDrawActionArg.js, paramDrawActionArg.jt);
    AppMethodBeat.o(144868);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144866);
    if (paramJSONArray.length() < 5)
    {
      AppMethodBeat.o(144866);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, g.f(paramJSONArray, 0), g.f(paramJSONArray, 1), g.f(paramJSONArray, 2), (float)paramJSONArray.optDouble(3), (float)paramJSONArray.optDouble(4));
    AppMethodBeat.o(144866);
    return bool;
  }
  
  public final BaseDrawActionArg aSP()
  {
    AppMethodBeat.i(144865);
    DrawArcActionArg localDrawArcActionArg = new DrawArcActionArg();
    AppMethodBeat.o(144865);
    return localDrawArcActionArg;
  }
  
  public final String getMethod()
  {
    return "arc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.e
 * JD-Core Version:    0.7.0.1
 */