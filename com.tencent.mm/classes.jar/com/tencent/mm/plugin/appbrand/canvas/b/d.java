package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathBezierCurveToActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class d
  implements a
{
  private static boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    paramPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    return true;
  }
  
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    paramBasePathActionArg = (PathBezierCurveToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null) {
      return false;
    }
    return a(paramPath, paramBasePathActionArg.x1, paramBasePathActionArg.y1, paramBasePathActionArg.x2, paramBasePathActionArg.y2, paramBasePathActionArg.x3, paramBasePathActionArg.y3);
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 6) {
      return false;
    }
    return a(paramPath, h.d(paramJSONArray, 0), h.d(paramJSONArray, 1), h.d(paramJSONArray, 2), h.d(paramJSONArray, 3), h.d(paramJSONArray, 4), h.d(paramJSONArray, 5));
  }
  
  public final BasePathActionArg adQ()
  {
    return new PathBezierCurveToActionArg();
  }
  
  public final String getMethod()
  {
    return "bezierCurveTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.d
 * JD-Core Version:    0.7.0.1
 */