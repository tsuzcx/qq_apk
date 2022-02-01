package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import org.json.JSONArray;

public final class o
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(144909);
    paramCanvas.save();
    paramd.save();
    AppMethodBeat.o(144909);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144910);
    boolean bool = a(paramd, paramCanvas);
    AppMethodBeat.o(144910);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144908);
    boolean bool = a(paramd, paramCanvas);
    AppMethodBeat.o(144908);
    return bool;
  }
  
  public final BaseDrawActionArg aSP()
  {
    AppMethodBeat.i(144907);
    DefaultDrawActionArg localDefaultDrawActionArg = new DefaultDrawActionArg();
    AppMethodBeat.o(144907);
    return localDefaultDrawActionArg;
  }
  
  public final String getMethod()
  {
    return "save";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.o
 * JD-Core Version:    0.7.0.1
 */