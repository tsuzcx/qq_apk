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

public final class j
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, Path paramPath)
  {
    AppMethodBeat.i(103206);
    paramCanvas.drawPath(paramPath, paramd.heC);
    AppMethodBeat.o(103206);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103207);
    boolean bool = a(paramd, paramCanvas, e.a.hfO.a((PathActionArgWrapper)paramDrawActionArg));
    AppMethodBeat.o(103207);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103205);
    boolean bool = a(paramd, paramCanvas, e.a.hfO.g(paramJSONArray));
    AppMethodBeat.o(103205);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103204);
    PathActionArgWrapper localPathActionArgWrapper = new PathActionArgWrapper();
    AppMethodBeat.o(103204);
    return localPathActionArgWrapper;
  }
  
  public final String getMethod()
  {
    return "fillPath";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.j
 * JD-Core Version:    0.7.0.1
 */