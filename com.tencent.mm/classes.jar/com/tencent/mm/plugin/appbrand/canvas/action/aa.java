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
    AppMethodBeat.i(144952);
    if ("miter".equalsIgnoreCase(paramString))
    {
      paramd.kZm.setStrokeJoin(Paint.Join.MITER);
      paramd.kZl.setStrokeJoin(Paint.Join.MITER);
    }
    for (;;)
    {
      AppMethodBeat.o(144952);
      return true;
      if ("round".equalsIgnoreCase(paramString))
      {
        paramd.kZm.setStrokeJoin(Paint.Join.ROUND);
        paramd.kZl.setStrokeJoin(Paint.Join.ROUND);
      }
      else if ("bevel".equalsIgnoreCase(paramString))
      {
        paramd.kZm.setStrokeJoin(Paint.Join.BEVEL);
        paramd.kZl.setStrokeJoin(Paint.Join.BEVEL);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144953);
    paramCanvas = (SetLineJoinActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144953);
      return false;
    }
    boolean bool = b(paramd, paramCanvas.kZN);
    AppMethodBeat.o(144953);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144951);
    if (paramJSONArray.length() <= 0)
    {
      AppMethodBeat.o(144951);
      return false;
    }
    boolean bool = b(paramd, paramJSONArray.optString(0));
    AppMethodBeat.o(144951);
    return bool;
  }
  
  public final BaseDrawActionArg bzj()
  {
    AppMethodBeat.i(144950);
    SetLineJoinActionArg localSetLineJoinActionArg = new SetLineJoinActionArg();
    AppMethodBeat.o(144950);
    return localSetLineJoinActionArg;
  }
  
  public final String getMethod()
  {
    return "setLineJoin";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.aa
 * JD-Core Version:    0.7.0.1
 */