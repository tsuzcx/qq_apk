package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class ae
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    paramd.fLq.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    paramd.fLp.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetShadowActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.x, paramCanvas.y, paramCanvas.fLZ, paramCanvas.color);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 4) {}
    float f1;
    float f2;
    float f3;
    do
    {
      return false;
      f1 = h.d(paramJSONArray, 0);
      f2 = h.d(paramJSONArray, 1);
      f3 = h.d(paramJSONArray, 2);
      paramCanvas = paramJSONArray.optJSONArray(3);
    } while ((paramCanvas == null) || (paramCanvas.length() < 4));
    return a(paramd, f1, f2, f3, h.l(paramCanvas));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetShadowActionArg();
  }
  
  public final String getMethod()
  {
    return "setShadow";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ae
 * JD-Core Version:    0.7.0.1
 */