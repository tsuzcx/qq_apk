package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathQuadraticCurveToActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class i
  implements a
{
  private static boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramPath.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return true;
  }
  
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    PathQuadraticCurveToActionArg localPathQuadraticCurveToActionArg = (PathQuadraticCurveToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null) {
      return false;
    }
    return a(paramPath, localPathQuadraticCurveToActionArg.x1, localPathQuadraticCurveToActionArg.y1, localPathQuadraticCurveToActionArg.x2, localPathQuadraticCurveToActionArg.y2);
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 4) {
      return false;
    }
    return a(paramPath, h.d(paramJSONArray, 0), h.d(paramJSONArray, 1), h.d(paramJSONArray, 2), h.d(paramJSONArray, 3));
  }
  
  public final BasePathActionArg adQ()
  {
    return new PathQuadraticCurveToActionArg();
  }
  
  public final String getMethod()
  {
    return "quadraticCurveTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.i
 * JD-Core Version:    0.7.0.1
 */