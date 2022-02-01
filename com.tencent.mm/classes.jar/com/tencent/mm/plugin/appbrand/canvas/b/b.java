package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathArcActionArg;
import org.json.JSONArray;

public final class b
  implements a
{
  private static boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    AppMethodBeat.i(145350);
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
          break label281;
        }
        paramPath.arcTo(new RectF(f1, f2, f3, f4), paramFloat4, paramFloat1, false);
        paramPath.addArc(new RectF(f1, f2, f3, f4), paramFloat4, paramFloat1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(145350);
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
      label281:
      paramPath.arcTo(new RectF(f1, f2, f3, f4), paramFloat4, paramFloat1, false);
    }
  }
  
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(145348);
    if ((paramBasePathActionArg == null) || (!(paramBasePathActionArg instanceof PathArcActionArg)))
    {
      AppMethodBeat.o(145348);
      return false;
    }
    paramBasePathActionArg = (PathArcActionArg)paramBasePathActionArg;
    boolean bool = a(paramPath, paramBasePathActionArg.x, paramBasePathActionArg.y, paramBasePathActionArg.radius, paramBasePathActionArg.js, paramBasePathActionArg.iZz, paramBasePathActionArg.iZA);
    AppMethodBeat.o(145348);
    return bool;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145347);
    if (paramJSONArray.length() < 5)
    {
      AppMethodBeat.o(145347);
      return false;
    }
    boolean bool = a(paramPath, g.f(paramJSONArray, 0), g.f(paramJSONArray, 1), g.f(paramJSONArray, 2), (float)paramJSONArray.optDouble(3), (float)paramJSONArray.optDouble(4), paramJSONArray.optBoolean(5));
    AppMethodBeat.o(145347);
    return bool;
  }
  
  public final BasePathActionArg aTb()
  {
    AppMethodBeat.i(145349);
    PathArcActionArg localPathArcActionArg = new PathArcActionArg();
    AppMethodBeat.o(145349);
    return localPathArcActionArg;
  }
  
  public final String getMethod()
  {
    return "arc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.b
 * JD-Core Version:    0.7.0.1
 */