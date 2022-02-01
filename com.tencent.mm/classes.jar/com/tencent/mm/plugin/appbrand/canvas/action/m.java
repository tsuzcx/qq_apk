package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import org.json.JSONArray;

public final class m
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas)
  {
    AppMethodBeat.i(144901);
    paramCanvas.restore();
    paramd.restore();
    AppMethodBeat.o(144901);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144902);
    boolean bool = a(paramd, paramCanvas);
    AppMethodBeat.o(144902);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144900);
    boolean bool = a(paramd, paramCanvas);
    AppMethodBeat.o(144900);
    return bool;
  }
  
  public final BaseDrawActionArg cjY()
  {
    AppMethodBeat.i(144899);
    DefaultDrawActionArg localDefaultDrawActionArg = new DefaultDrawActionArg();
    AppMethodBeat.o(144899);
    return localDefaultDrawActionArg;
  }
  
  public final String getMethod()
  {
    return "restore";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.m
 * JD-Core Version:    0.7.0.1
 */