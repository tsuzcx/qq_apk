package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class e
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramCanvas.drawArc(new RectF(paramFloat1 - paramFloat3, paramFloat2 - paramFloat3, paramFloat1 + paramFloat3, paramFloat2 + paramFloat3), (float)(paramFloat4 / 3.141592653589793D * 180.0D), (float)(paramFloat5 / 3.141592653589793D * 180.0D), true, paramd.fLp);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramDrawActionArg = (DrawArcActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null) {
      return false;
    }
    return a(paramd, paramCanvas, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.radius, paramDrawActionArg.fLC, paramDrawActionArg.fLD);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 5) {
      return false;
    }
    return a(paramd, paramCanvas, h.d(paramJSONArray, 0), h.d(paramJSONArray, 1), h.d(paramJSONArray, 2), (float)paramJSONArray.optDouble(3), (float)paramJSONArray.optDouble(4));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new DrawArcActionArg();
  }
  
  public final String getMethod()
  {
    return "arc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.e
 * JD-Core Version:    0.7.0.1
 */