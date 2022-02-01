package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg;
import org.json.JSONArray;

public final class g
  implements a
{
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(145370);
    paramBasePathActionArg = (PathLineToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null)
    {
      AppMethodBeat.o(145370);
      return false;
    }
    paramPath.lineTo(paramBasePathActionArg.x, paramBasePathActionArg.y);
    AppMethodBeat.o(145370);
    return true;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(145369);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(145369);
      return false;
    }
    paramPath.lineTo(i.f(paramJSONArray, 0), i.f(paramJSONArray, 1));
    AppMethodBeat.o(145369);
    return true;
  }
  
  public final BasePathActionArg ckk()
  {
    AppMethodBeat.i(145371);
    PathLineToActionArg localPathLineToActionArg = new PathLineToActionArg();
    AppMethodBeat.o(145371);
    return localPathLineToActionArg;
  }
  
  public final String getMethod()
  {
    return "lineTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.g
 * JD-Core Version:    0.7.0.1
 */