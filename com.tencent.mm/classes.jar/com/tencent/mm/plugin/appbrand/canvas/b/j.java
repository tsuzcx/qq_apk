package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathRectActionArg;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class j
  implements a
{
  private static boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(103697);
    paramPath.addRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, Path.Direction.CW);
    AppMethodBeat.o(103697);
    return true;
  }
  
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(103698);
    paramBasePathActionArg = (PathRectActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null)
    {
      AppMethodBeat.o(103698);
      return false;
    }
    boolean bool = a(paramPath, paramBasePathActionArg.x, paramBasePathActionArg.y, paramBasePathActionArg.width, paramBasePathActionArg.height);
    AppMethodBeat.o(103698);
    return bool;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103696);
    if (paramJSONArray.length() < 4)
    {
      AppMethodBeat.o(103696);
      return false;
    }
    boolean bool = a(paramPath, g.d(paramJSONArray, 0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), g.d(paramJSONArray, 3));
    AppMethodBeat.o(103696);
    return bool;
  }
  
  public final BasePathActionArg ayi()
  {
    AppMethodBeat.i(103699);
    PathRectActionArg localPathRectActionArg = new PathRectActionArg();
    AppMethodBeat.o(103699);
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