package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathLineToActionArg;
import org.json.JSONArray;

public final class g
  implements a
{
  public final boolean a(Path paramPath, BasePathActionArg paramBasePathActionArg)
  {
    AppMethodBeat.i(103687);
    paramBasePathActionArg = (PathLineToActionArg)paramBasePathActionArg;
    if (paramBasePathActionArg == null)
    {
      AppMethodBeat.o(103687);
      return false;
    }
    paramPath.lineTo(paramBasePathActionArg.x, paramBasePathActionArg.y);
    AppMethodBeat.o(103687);
    return true;
  }
  
  public final boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103686);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(103686);
      return false;
    }
    paramPath.lineTo(com.tencent.mm.plugin.appbrand.s.g.d(paramJSONArray, 0), com.tencent.mm.plugin.appbrand.s.g.d(paramJSONArray, 1));
    AppMethodBeat.o(103686);
    return true;
  }
  
  public final BasePathActionArg ayi()
  {
    AppMethodBeat.i(103688);
    PathLineToActionArg localPathLineToActionArg = new PathLineToActionArg();
    AppMethodBeat.o(103688);
    return localPathLineToActionArg;
  }
  
  public final String getMethod()
  {
    return "lineTo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.g
 * JD-Core Version:    0.7.0.1
 */