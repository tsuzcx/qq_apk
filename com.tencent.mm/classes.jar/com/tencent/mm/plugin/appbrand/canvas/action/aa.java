package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Join;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineJoinActionArg;
import org.json.JSONArray;

public final class aa
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    AppMethodBeat.i(103269);
    if ("miter".equalsIgnoreCase(paramString))
    {
      paramd.heC.setStrokeJoin(Paint.Join.MITER);
      paramd.heB.setStrokeJoin(Paint.Join.MITER);
    }
    for (;;)
    {
      AppMethodBeat.o(103269);
      return true;
      if ("round".equalsIgnoreCase(paramString))
      {
        paramd.heC.setStrokeJoin(Paint.Join.ROUND);
        paramd.heB.setStrokeJoin(Paint.Join.ROUND);
      }
      else if ("bevel".equalsIgnoreCase(paramString))
      {
        paramd.heC.setStrokeJoin(Paint.Join.BEVEL);
        paramd.heB.setStrokeJoin(Paint.Join.BEVEL);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103270);
    paramCanvas = (SetLineJoinActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103270);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.hfh);
    AppMethodBeat.o(103270);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103268);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(103268);
      return false;
    }
    boolean bool = b(paramd, paramJSONArray.optString(0));
    AppMethodBeat.o(103268);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103267);
    SetLineJoinActionArg localSetLineJoinActionArg = new SetLineJoinActionArg();
    AppMethodBeat.o(103267);
    return localSetLineJoinActionArg;
  }
  
  public final String getMethod()
  {
    return "setLineJoin";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.aa
 * JD-Core Version:    0.7.0.1
 */