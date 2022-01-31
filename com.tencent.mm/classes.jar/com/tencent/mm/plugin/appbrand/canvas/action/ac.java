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
    AppMethodBeat.i(103277);
    paramd.heC.setStrokeMiter(paramFloat);
    paramd.heB.setStrokeMiter(paramFloat);
    AppMethodBeat.o(103277);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103278);
    paramCanvas = (SeMiterLimitActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103278);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.hfa);
    AppMethodBeat.o(103278);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103276);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(103276);
      return false;
    }
    boolean bool = a(paramd, (float)paramJSONArray.optDouble(0));
    AppMethodBeat.o(103276);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103275);
    SeMiterLimitActionArg localSeMiterLimitActionArg = new SeMiterLimitActionArg();
    AppMethodBeat.o(103275);
    return localSeMiterLimitActionArg;
  }
  
  public final String getMethod()
  {
    return "setMiterLimit";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ac
 * JD-Core Version:    0.7.0.1
 */