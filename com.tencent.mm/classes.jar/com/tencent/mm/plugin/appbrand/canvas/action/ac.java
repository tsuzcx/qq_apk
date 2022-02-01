package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg;
import org.json.JSONArray;

public final class ac
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float paramFloat)
  {
    AppMethodBeat.i(144960);
    paramd.qTj.setStrokeMiter(paramFloat);
    paramd.qTi.setStrokeMiter(paramFloat);
    AppMethodBeat.o(144960);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144961);
    paramCanvas = (SeMiterLimitActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144961);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.qTE);
    AppMethodBeat.o(144961);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144959);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(144959);
      return false;
    }
    boolean bool = a(paramd, (float)paramJSONArray.optDouble(0));
    AppMethodBeat.o(144959);
    return bool;
  }
  
  public final BaseDrawActionArg cjY()
  {
    AppMethodBeat.i(144958);
    SeMiterLimitActionArg localSeMiterLimitActionArg = new SeMiterLimitActionArg();
    AppMethodBeat.o(144958);
    return localSeMiterLimitActionArg;
  }
  
  public final String getMethod()
  {
    return "setMiterLimit";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ac
 * JD-Core Version:    0.7.0.1
 */