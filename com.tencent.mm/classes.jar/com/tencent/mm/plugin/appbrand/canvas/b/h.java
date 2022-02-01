package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg;
import org.json.JSONArray;

public final class h
  implements a
{
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(145373);
    paramBasePathActionArg = (PathMoveToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null)
    {
      AppMethodBeat.o(145373);
      return false;
    }
    paramPath.moveTo(paramBasePathActionArg.x, paramBasePathActionArg.y);
    AppMethodBeat.o(145373);
    return true;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145372);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(145372);
      return false;
    }
    paramPath.moveTo(g.f(paramJSONArray, 0), g.f(paramJSONArray, 1));
    AppMethodBeat.o(145372);
    return true;
  }
  
  public final BasePathActionArg bKK()
  {
    AppMethodBeat.i(145374);
    PathMoveToActionArg localPathMoveToActionArg = new PathMoveToActionArg();
    AppMethodBeat.o(145374);
    return localPathMoveToActionArg;
  }
  
  public final String getMethod()
  {
    return "moveTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.h
 * JD-Core Version:    0.7.0.1
 */