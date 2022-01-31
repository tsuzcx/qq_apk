package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class j
  implements a
{
  private static boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramPath.addRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, Path.Direction.CW);
    return true;
  }
  
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    paramBasePathActionArg = (PathRectActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null) {
      return false;
    }
    return a(paramPath, paramBasePathActionArg.x, paramBasePathActionArg.y, paramBasePathActionArg.width, paramBasePathActionArg.height);
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
    return new PathRectActionArg();
  }
  
  public final String getMethod()
  {
    return "rect";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.j
 * JD-Core Version:    0.7.0.1
 */