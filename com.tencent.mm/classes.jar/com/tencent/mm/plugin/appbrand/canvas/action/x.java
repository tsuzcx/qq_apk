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
    AppMethodBeat.i(103260);
    if ("butt".equalsIgnoreCase(paramString))
    {
      paramd.heC.setStrokeCap(Paint.Cap.BUTT);
      paramd.heB.setStrokeCap(Paint.Cap.BUTT);
    }
    for (;;)
    {
      AppMethodBeat.o(103260);
      return true;
      if ("round".equalsIgnoreCase(paramString))
      {
        paramd.heC.setStrokeCap(Paint.Cap.ROUND);
        paramd.heB.setStrokeCap(Paint.Cap.ROUND);
      }
      else if ("square".equalsIgnoreCase(paramString))
      {
        paramd.heC.setStrokeCap(Paint.Cap.SQUARE);
        paramd.heB.setStrokeCap(Paint.Cap.SQUARE);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103261);
    paramCanvas = (SetLineCapActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103261);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.hfe);
    AppMethodBeat.o(103261);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103259);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(103259);
      return false;
    }
    boolean bool = b(paramd, paramJSONArray.optString(0));
    AppMethodBeat.o(103259);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103258);
    SetLineCapActionArg localSetLineCapActionArg = new SetLineCapActionArg();
    AppMethodBeat.o(103258);
    return localSetLineCapActionArg;
  }
  
  public final String getMethod()
  {
    return "setLineCap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.x
 * JD-Core Version:    0.7.0.1
 */