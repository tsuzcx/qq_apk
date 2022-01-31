package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg;
import org.json.JSONArray;

public final class n
  implements d
{
  private static boolean a(Canvas paramCanvas, float paramFloat)
  {
    AppMethodBeat.i(103222);
    paramCanvas.rotate((float)(paramFloat / 3.141592653589793D * 180.0D));
    AppMethodBeat.o(103222);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103223);
    paramd = (RotateActionArg)paramDrawActionArg;
    if (paramd == null)
    {
      AppMethodBeat.o(103223);
      return false;
    }
    boolean bool = a(paramCanvas, paramd.heZ);
    AppMethodBeat.o(103223);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103221);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(103221);
      return false;
    }
    boolean bool = a(paramCanvas, (float)paramJSONArray.optDouble(0));
    AppMethodBeat.o(103221);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103220);
    RotateActionArg localRotateActionArg = new RotateActionArg();
    AppMethodBeat.o(103220);
    return localRotateActionArg;
  }
  
  public final String getMethod()
  {
    return "rotate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.n
 * JD-Core Version:    0.7.0.1
 */