package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Cap;
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
    if ("butt".equalsIgnoreCase(paramString))
    {
      paramd.fLq.setStrokeCap(Paint.Cap.BUTT);
      paramd.fLp.setStrokeCap(Paint.Cap.BUTT);
    }
    for (;;)
    {
      return true;
      if ("round".equalsIgnoreCase(paramString))
      {
        paramd.fLq.setStrokeCap(Paint.Cap.ROUND);
        paramd.fLp.setStrokeCap(Paint.Cap.ROUND);
      }
      else if ("square".equalsIgnoreCase(paramString))
      {
        paramd.fLq.setStrokeCap(Paint.Cap.SQUARE);
        paramd.fLp.setStrokeCap(Paint.Cap.SQUARE);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetLineCapActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return b(paramd, paramCanvas.fLU);
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
    return new SetLineCapActionArg();
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