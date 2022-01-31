package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawRectActionArg;
import org.json.JSONArray;

public final class h
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, paramd.fLp);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramDrawActionArg = (DrawRectActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null) {
      return false;
    }
    return a(paramd, paramCanvas, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.width, paramDrawActionArg.height);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 4) {
      return false;
    }
    return a(paramd, paramCanvas, com.tencent.mm.plugin.appbrand.u.h.d(paramJSONArray, 0), com.tencent.mm.plugin.appbrand.u.h.d(paramJSONArray, 1), com.tencent.mm.plugin.appbrand.u.h.d(paramJSONArray, 2), com.tencent.mm.plugin.appbrand.u.h.d(paramJSONArray, 3));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new DrawRectActionArg();
  }
  
  public final String getMethod()
  {
    return "strokeRect";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.h
 * JD-Core Version:    0.7.0.1
 */