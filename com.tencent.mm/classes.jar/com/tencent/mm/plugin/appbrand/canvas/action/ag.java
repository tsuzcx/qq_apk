package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextAlignActionArg;
import org.json.JSONArray;

public final class ag
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(103292);
    if ("left".equalsIgnoreCase(paramString))
    {
      paramd.heB.setTextAlign(Paint.Align.LEFT);
      paramd.heC.setTextAlign(Paint.Align.LEFT);
    }
    for (;;)
    {
      AppMethodBeat.o(103292);
      return true;
      if ("right".equalsIgnoreCase(paramString))
      {
        paramd.heB.setTextAlign(Paint.Align.RIGHT);
        paramd.heC.setTextAlign(Paint.Align.RIGHT);
      }
      else if ("center".equalsIgnoreCase(paramString))
      {
        paramd.heB.setTextAlign(Paint.Align.CENTER);
        paramd.heC.setTextAlign(Paint.Align.CENTER);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103293);
    paramCanvas = (SetTextAlignActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103293);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.hfl);
    AppMethodBeat.o(103293);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103291);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(103291);
      return false;
    }
    boolean bool = b(paramd, paramJSONArray.optString(0));
    AppMethodBeat.o(103291);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103290);
    SetTextAlignActionArg localSetTextAlignActionArg = new SetTextAlignActionArg();
    AppMethodBeat.o(103290);
    return localSetTextAlignActionArg;
  }
  
  public final String getMethod()
  {
    return "setTextAlign";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ag
 * JD-Core Version:    0.7.0.1
 */