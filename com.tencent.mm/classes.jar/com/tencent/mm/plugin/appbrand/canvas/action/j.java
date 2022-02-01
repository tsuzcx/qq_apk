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
    AppMethodBeat.i(144889);
    paramCanvas.drawPath(paramPath, paramd.iYM);
    AppMethodBeat.o(144889);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144890);
    boolean bool = a(paramd, paramCanvas, e.a.iZZ.a((PathActionArgWrapper)paramDrawActionArg));
    AppMethodBeat.o(144890);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144888);
    boolean bool = a(paramd, paramCanvas, e.a.iZZ.g(paramJSONArray));
    AppMethodBeat.o(144888);
    return bool;
  }
  
  public final BaseDrawActionArg aSP()
  {
    AppMethodBeat.i(144887);
    PathActionArgWrapper localPathActionArgWrapper = new PathActionArgWrapper();
    AppMethodBeat.o(144887);
    return localPathActionArgWrapper;
  }
  
  public final String getMethod()
  {
    return "fillPath";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.j
 * JD-Core Version:    0.7.0.1
 */