package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcToActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class c
  implements a
{
  private static boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    float f1 = paramFloat1 - paramFloat3;
    float f2 = paramFloat2 - paramFloat3;
    float f3 = paramFloat1 + paramFloat3;
    float f4 = paramFloat2 + paramFloat3;
    paramFloat4 = (float)Math.toDegrees(paramFloat4);
    paramFloat1 = (float)Math.toDegrees(paramFloat5);
    paramFloat5 = (float)(360.0D / (6.283185307179586D * paramFloat3));
    if (paramBoolean) {
      if (paramFloat4 - paramFloat1 >= 360.0F)
      {
        paramFloat1 = -360.0F;
        paramFloat2 = paramFloat1 % 360.0F;
        if ((paramFloat2 > paramFloat5) || (paramFloat2 < -paramFloat5)) {
          break label271;
        }
        paramPath.arcTo(new RectF(f1, f2, f3, f4), paramFloat4, paramFloat1, false);
        paramPath.addArc(new RectF(f1, f2, f3, f4), paramFloat4, paramFloat1);
      }
    }
    for (;;)
    {
      return true;
      paramFloat2 = paramFloat4 % 360.0F;
      paramFloat3 = paramFloat1 % 360.0F;
      paramFloat1 = paramFloat2;
      if (paramFloat2 < 0.0F) {
        paramFloat1 = paramFloat2 + 360.0F;
      }
      paramFloat2 = paramFloat3;
      if (paramFloat3 < 0.0F) {
        paramFloat2 = paramFloat3 + 360.0F;
      }
      if (paramFloat2 >= paramFloat1)
      {
        paramFloat1 = paramFloat2 - paramFloat1 - 360.0F;
        break;
      }
      paramFloat1 = paramFloat2 - paramFloat1;
      break;
      if (paramFloat1 - paramFloat4 >= 360.0F)
      {
        paramFloat1 = 360.0F;
        break;
      }
      paramFloat2 = paramFloat4 % 360.0F;
      paramFloat3 = paramFloat1 % 360.0F;
      paramFloat1 = paramFloat2;
      if (paramFloat2 < 0.0F) {
        paramFloat1 = paramFloat2 + 360.0F;
      }
      paramFloat2 = paramFloat3;
      if (paramFloat3 < 0.0F) {
        paramFloat2 = paramFloat3 + 360.0F;
      }
      if (paramFloat2 >= paramFloat1)
      {
        paramFloat1 = paramFloat2 - paramFloat1;
        break;
      }
      paramFloat1 = paramFloat2 + 360.0F - paramFloat1;
      break;
      label271:
      paramPath.arcTo(new RectF(f1, f2, f3, f4), paramFloat4, paramFloat1, false);
    }
  }
  
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    paramBasePathActionArg = (PathArcToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null) {
      return false;
    }
    return a(paramPath, paramBasePathActionArg.x, paramBasePathActionArg.y, paramBasePathActionArg.radius, paramBasePathActionArg.fLC, paramBasePathActionArg.fMe, paramBasePathActionArg.fMf);
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 6) {
      return false;
    }
    return a(paramPath, h.d(paramJSONArray, 0), h.d(paramJSONArray, 1), h.d(paramJSONArray, 2), (float)paramJSONArray.optDouble(3), (float)paramJSONArray.optDouble(4), paramJSONArray.optBoolean(5));
  }
  
  public final BasePathActionArg adQ()
  {
    return new PathArcToActionArg();
  }
  
  public final String getMethod()
  {
    return "arcTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.c
 * JD-Core Version:    0.7.0.1
 */