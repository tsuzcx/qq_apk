package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Join;
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
    if ("miter".equalsIgnoreCase(paramString))
    {
      paramd.fLq.setStrokeJoin(Paint.Join.MITER);
      paramd.fLp.setStrokeJoin(Paint.Join.MITER);
    }
    for (;;)
    {
      return true;
      if ("round".equalsIgnoreCase(paramString))
      {
        paramd.fLq.setStrokeJoin(Paint.Join.ROUND);
        paramd.fLp.setStrokeJoin(Paint.Join.ROUND);
      }
      else if ("bevel".equalsIgnoreCase(paramString))
      {
        paramd.fLq.setStrokeJoin(Paint.Join.BEVEL);
        paramd.fLp.setStrokeJoin(Paint.Join.BEVEL);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetLineJoinActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return b(paramd, paramCanvas.fLX);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() <= 0) {
      return false;
    }
    return b(paramd, paramJSONArray.optString(0));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetLineJoinActionArg();
  }
  
  public final String getMethod()
  {
    return "setLineJoin";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.aa
 * JD-Core Version:    0.7.0.1
 */