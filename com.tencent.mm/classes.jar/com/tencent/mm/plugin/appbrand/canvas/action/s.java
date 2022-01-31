package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class s
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, int paramInt)
  {
    AppMethodBeat.i(103240);
    paramd.heC.setTextSize(paramInt);
    paramd.heB.setTextSize(paramInt);
    AppMethodBeat.o(103240);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103241);
    paramCanvas = (SetFontSizeActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103241);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.size);
    AppMethodBeat.o(103241);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103239);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(103239);
      return false;
    }
    boolean bool = a(paramd, g.a(paramJSONArray, 0));
    AppMethodBeat.o(103239);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103238);
    SetFontSizeActionArg localSetFontSizeActionArg = new SetFontSizeActionArg();
    AppMethodBeat.o(103238);
    return localSetFontSizeActionArg;
  }
  
  public final String getMethod()
  {
    return "setFontSize";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.s
 * JD-Core Version:    0.7.0.1
 */