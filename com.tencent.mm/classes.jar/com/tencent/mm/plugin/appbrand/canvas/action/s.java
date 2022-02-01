package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg;
import org.json.JSONArray;

public final class s
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, int paramInt)
  {
    AppMethodBeat.i(144923);
    paramd.nTx.setTextSize(paramInt);
    paramd.nTw.setTextSize(paramInt);
    AppMethodBeat.o(144923);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144924);
    paramCanvas = (SetFontSizeActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144924);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.size);
    AppMethodBeat.o(144924);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144922);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(144922);
      return false;
    }
    boolean bool = a(paramd, g.c(paramJSONArray, 0));
    AppMethodBeat.o(144922);
    return bool;
  }
  
  public final BaseDrawActionArg bKy()
  {
    AppMethodBeat.i(144921);
    SetFontSizeActionArg localSetFontSizeActionArg = new SetFontSizeActionArg();
    AppMethodBeat.o(144921);
    return localSetFontSizeActionArg;
  }
  
  public final String getMethod()
  {
    return "setFontSize";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.s
 * JD-Core Version:    0.7.0.1
 */