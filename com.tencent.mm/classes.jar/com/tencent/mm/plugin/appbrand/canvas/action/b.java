package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import com.tencent.mm.plugin.appbrand.canvas.b.e;
import com.tencent.mm.plugin.appbrand.canvas.b.e.a;
import org.json.JSONArray;

public final class b
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103178);
    paramCanvas.clipPath(e.a.hfO.a((PathActionArgWrapper)paramDrawActionArg));
    AppMethodBeat.o(103178);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103177);
    paramCanvas.clipPath(e.a.hfO.g(paramJSONArray));
    AppMethodBeat.o(103177);
    return true;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103176);
    PathActionArgWrapper localPathActionArgWrapper = new PathActionArgWrapper();
    AppMethodBeat.o(103176);
    return localPathActionArgWrapper;
  }
  
  public final String getMethod()
  {
    return "clip";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.b
 * JD-Core Version:    0.7.0.1
 */