package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg;
import org.json.JSONArray;

public final class ah
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(103296);
    com.tencent.luggage.g.d.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", new Object[] { paramString });
    if ("top".equalsIgnoreCase(paramString))
    {
      paramd.heB.hfC = a.a.hfJ;
      paramd.heC.hfC = a.a.hfJ;
    }
    for (;;)
    {
      AppMethodBeat.o(103296);
      return true;
      if ("middle".equalsIgnoreCase(paramString))
      {
        paramd.heB.hfC = a.a.hfL;
        paramd.heC.hfC = a.a.hfL;
      }
      else if ("bottom".equalsIgnoreCase(paramString))
      {
        paramd.heB.hfC = a.a.hfK;
        paramd.heC.hfC = a.a.hfK;
      }
      else if ("normal".equalsIgnoreCase(paramString))
      {
        paramd.heB.hfC = a.a.hfI;
        paramd.heC.hfC = a.a.hfI;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103297);
    paramCanvas = (SetTextBaseLineActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103297);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.hfl);
    AppMethodBeat.o(103297);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103295);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(103295);
      return false;
    }
    boolean bool = b(paramd, paramJSONArray.optString(0));
    AppMethodBeat.o(103295);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103294);
    SetTextBaseLineActionArg localSetTextBaseLineActionArg = new SetTextBaseLineActionArg();
    AppMethodBeat.o(103294);
    return localSetTextBaseLineActionArg;
  }
  
  public final String getMethod()
  {
    return "setTextBaseline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ah
 * JD-Core Version:    0.7.0.1
 */