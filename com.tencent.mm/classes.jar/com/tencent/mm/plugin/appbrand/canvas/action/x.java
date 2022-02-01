package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineCapActionArg;
import org.json.JSONArray;

public final class x
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(144943);
    if ("butt".equalsIgnoreCase(paramString))
    {
      paramd.qTj.setStrokeCap(Paint.Cap.BUTT);
      paramd.qTi.setStrokeCap(Paint.Cap.BUTT);
    }
    for (;;)
    {
      AppMethodBeat.o(144943);
      return true;
      if ("round".equalsIgnoreCase(paramString))
      {
        paramd.qTj.setStrokeCap(Paint.Cap.ROUND);
        paramd.qTi.setStrokeCap(Paint.Cap.ROUND);
      }
      else if ("square".equalsIgnoreCase(paramString))
      {
        paramd.qTj.setStrokeCap(Paint.Cap.SQUARE);
        paramd.qTi.setStrokeCap(Paint.Cap.SQUARE);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144944);
    paramCanvas = (SetLineCapActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144944);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.qTG);
    AppMethodBeat.o(144944);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144942);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(144942);
      return false;
    }
    boolean bool = b(paramd, paramJSONArray.optString(0));
    AppMethodBeat.o(144942);
    return bool;
  }
  
  public final BaseDrawActionArg cjY()
  {
    AppMethodBeat.i(144941);
    SetLineCapActionArg localSetLineCapActionArg = new SetLineCapActionArg();
    AppMethodBeat.o(144941);
    return localSetLineCapActionArg;
  }
  
  public final String getMethod()
  {
    return "setLineCap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.x
 * JD-Core Version:    0.7.0.1
 */