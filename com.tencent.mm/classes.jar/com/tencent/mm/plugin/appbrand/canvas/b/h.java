package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathMoveToActionArg;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class h
  implements a
{
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(103690);
    paramBasePathActionArg = (PathMoveToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null)
    {
      AppMethodBeat.o(103690);
      return false;
    }
    paramPath.moveTo(paramBasePathActionArg.x, paramBasePathActionArg.y);
    AppMethodBeat.o(103690);
    return true;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103689);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(103689);
      return false;
    }
    paramPath.moveTo(g.d(paramJSONArray, 0), g.d(paramJSONArray, 1));
    AppMethodBeat.o(103689);
    return true;
  }
  
  public final BasePathActionArg ayi()
  {
    AppMethodBeat.i(103691);
    PathMoveToActionArg localPathMoveToActionArg = new PathMoveToActionArg();
    AppMethodBeat.o(103691);
    return localPathMoveToActionArg;
  }
  
  public final String getMethod()
  {
    return "moveTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.h
 * JD-Core Version:    0.7.0.1
 */