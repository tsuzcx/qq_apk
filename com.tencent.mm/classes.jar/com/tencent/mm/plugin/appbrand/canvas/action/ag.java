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
    AppMethodBeat.i(144975);
    if ("left".equalsIgnoreCase(paramString))
    {
      paramd.qTi.setTextAlign(Paint.Align.LEFT);
      paramd.qTj.setTextAlign(Paint.Align.LEFT);
    }
    for (;;)
    {
      AppMethodBeat.o(144975);
      return true;
      if ("right".equalsIgnoreCase(paramString))
      {
        paramd.qTi.setTextAlign(Paint.Align.RIGHT);
        paramd.qTj.setTextAlign(Paint.Align.RIGHT);
      }
      else if ("center".equalsIgnoreCase(paramString))
      {
        paramd.qTi.setTextAlign(Paint.Align.CENTER);
        paramd.qTj.setTextAlign(Paint.Align.CENTER);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144976);
    paramCanvas = (SetTextAlignActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144976);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.qTN);
    AppMethodBeat.o(144976);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144974);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(144974);
      return false;
    }
    boolean bool = b(paramd, paramJSONArray.optString(0));
    AppMethodBeat.o(144974);
    return bool;
  }
  
  public final BaseDrawActionArg cjY()
  {
    AppMethodBeat.i(144973);
    SetTextAlignActionArg localSetTextAlignActionArg = new SetTextAlignActionArg();
    AppMethodBeat.o(144973);
    return localSetTextAlignActionArg;
  }
  
  public final String getMethod()
  {
    return "setTextAlign";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ag
 * JD-Core Version:    0.7.0.1
 */