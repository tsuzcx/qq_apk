package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg;
import com.tencent.mm.plugin.appbrand.z.g;
import org.json.JSONArray;

public final class j
  implements a
{
  private static boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(145380);
    paramPath.addRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, Path.Direction.CW);
    AppMethodBeat.o(145380);
    return true;
  }
  
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(145381);
    paramBasePathActionArg = (PathRectActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null)
    {
      AppMethodBeat.o(145381);
      return false;
    }
    boolean bool = a(paramPath, paramBasePathActionArg.x, paramBasePathActionArg.y, paramBasePathActionArg.width, paramBasePathActionArg.height);
    AppMethodBeat.o(145381);
    return bool;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145379);
    if (paramJSONArray.length() < 4)
    {
      AppMethodBeat.o(145379);
      return false;
    }
    boolean bool = a(paramPath, g.f(paramJSONArray, 0), g.f(paramJSONArray, 1), g.f(paramJSONArray, 2), g.f(paramJSONArray, 3));
    AppMethodBeat.o(145379);
    return bool;
  }
  
  public final BasePathActionArg bdz()
  {
    AppMethodBeat.i(145382);
    PathRectActionArg localPathRectActionArg = new PathRectActionArg();
    AppMethodBeat.o(145382);
    return localPathRectActionArg;
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