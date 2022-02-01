package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import com.tencent.mm.plugin.appbrand.canvas.b.e;
import com.tencent.mm.plugin.appbrand.canvas.b.e.a;
import org.json.JSONArray;

public final class c
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144864);
    paramCanvas.clipPath(e.a.jXy.a((PathActionArgWrapper)paramDrawActionArg));
    AppMethodBeat.o(144864);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144863);
    paramCanvas.clipPath(e.a.jXy.g(paramJSONArray));
    AppMethodBeat.o(144863);
    return true;
  }
  
  public final BaseDrawActionArg bdS()
  {
    AppMethodBeat.i(144862);
    PathActionArgWrapper localPathActionArgWrapper = new PathActionArgWrapper();
    AppMethodBeat.o(144862);
    return localPathActionArgWrapper;
  }
  
  public final String getMethod()
  {
    return "clipPath";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.c
 * JD-Core Version:    0.7.0.1
 */