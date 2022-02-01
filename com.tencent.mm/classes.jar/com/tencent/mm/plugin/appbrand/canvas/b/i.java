package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathQuadraticCurveToActionArg;
import com.tencent.mm.plugin.appbrand.z.g;
import org.json.JSONArray;

public final class i
  implements a
{
  private static boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(145376);
    paramPath.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    AppMethodBeat.o(145376);
    return true;
  }
  
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(145377);
    PathQuadraticCurveToActionArg localPathQuadraticCurveToActionArg = (PathQuadraticCurveToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null)
    {
      AppMethodBeat.o(145377);
      return false;
    }
    boolean bool = a(paramPath, localPathQuadraticCurveToActionArg.x1, localPathQuadraticCurveToActionArg.y1, localPathQuadraticCurveToActionArg.x2, localPathQuadraticCurveToActionArg.y2);
    AppMethodBeat.o(145377);
    return bool;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145375);
    if (paramJSONArray.length() < 4)
    {
      AppMethodBeat.o(145375);
      return false;
    }
    boolean bool = a(paramPath, g.f(paramJSONArray, 0), g.f(paramJSONArray, 1), g.f(paramJSONArray, 2), g.f(paramJSONArray, 3));
    AppMethodBeat.o(145375);
    return bool;
  }
  
  public final BasePathActionArg baa()
  {
    AppMethodBeat.i(145378);
    PathQuadraticCurveToActionArg localPathQuadraticCurveToActionArg = new PathQuadraticCurveToActionArg();
    AppMethodBeat.o(145378);
    return localPathQuadraticCurveToActionArg;
  }
  
  public final String getMethod()
  {
    return "quadraticCurveTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.i
 * JD-Core Version:    0.7.0.1
 */