package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTransformActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;
import org.json.JSONException;

public final class ai
  implements d
{
  private static boolean a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.setValues(new float[] { paramFloat1, paramFloat3, paramFloat5, paramFloat2, paramFloat4, paramFloat6, 0.0F, 0.0F, 1.0F });
    paramCanvas.setMatrix(localMatrix);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramd = (SetTransformActionArg)paramDrawActionArg;
    if (paramd == null) {
      return false;
    }
    return a(paramCanvas, paramd.scaleX, paramd.fMc, paramd.fMd, paramd.scaleY, paramd.translateX, paramd.translateY);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 6) {
      return false;
    }
    try
    {
      boolean bool = a(paramCanvas, (float)paramJSONArray.getDouble(0), (float)paramJSONArray.getDouble(1), (float)paramJSONArray.getDouble(2), (float)paramJSONArray.getDouble(3), h.c(paramJSONArray, 4), h.c(paramJSONArray, 5));
      return bool;
    }
    catch (JSONException paramd) {}
    return false;
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetTransformActionArg();
  }
  
  public final String getMethod()
  {
    return "setTransform";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ai
 * JD-Core Version:    0.7.0.1
 */