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
    AppMethodBeat.i(144905);
    paramCanvas.rotate((float)(paramFloat / 3.141592653589793D * 180.0D));
    AppMethodBeat.o(144905);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144906);
    paramd = (RotateActionArg)paramDrawActionArg;
    if (paramd == null)
    {
      AppMethodBeat.o(144906);
      return false;
    }
    boolean bool = a(paramCanvas, paramd.degrees);
    AppMethodBeat.o(144906);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144904);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(144904);
      return false;
    }
    boolean bool = a(paramCanvas, (float)paramJSONArray.optDouble(0));
    AppMethodBeat.o(144904);
    return bool;
  }
  
  public final BaseDrawActionArg bzj()
  {
    AppMethodBeat.i(144903);
    RotateActionArg localRotateActionArg = new RotateActionArg();
    AppMethodBeat.o(144903);
    return localRotateActionArg;
  }
  
  public final String getMethod()
  {
    return "rotate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.n
 * JD-Core Version:    0.7.0.1
 */