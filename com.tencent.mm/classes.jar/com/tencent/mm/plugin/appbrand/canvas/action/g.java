package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import com.tencent.mm.plugin.appbrand.canvas.b.e;
import com.tencent.mm.plugin.appbrand.canvas.b.e.a;
import org.json.JSONArray;

public final class g
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, Path paramPath)
  {
    AppMethodBeat.i(144877);
    paramCanvas.drawPath(paramPath, paramd.jWp);
    AppMethodBeat.o(144877);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144878);
    boolean bool = a(paramd, paramCanvas, e.a.jXy.a((PathActionArgWrapper)paramDrawActionArg));
    AppMethodBeat.o(144878);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144876);
    boolean bool = a(paramd, paramCanvas, e.a.jXy.g(paramJSONArray));
    AppMethodBeat.o(144876);
    return bool;
  }
  
  public final BaseDrawActionArg bdS()
  {
    AppMethodBeat.i(144875);
    PathActionArgWrapper localPathActionArgWrapper = new PathActionArgWrapper();
    AppMethodBeat.o(144875);
    return localPathActionArgWrapper;
  }
  
  public final String getMethod()
  {
    return "strokePath";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.g
 * JD-Core Version:    0.7.0.1
 */