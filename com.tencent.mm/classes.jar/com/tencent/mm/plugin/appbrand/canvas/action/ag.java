package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
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
    if ("left".equalsIgnoreCase(paramString))
    {
      paramd.fLp.setTextAlign(Paint.Align.LEFT);
      paramd.fLq.setTextAlign(Paint.Align.LEFT);
    }
    for (;;)
    {
      return true;
      if ("right".equalsIgnoreCase(paramString))
      {
        paramd.fLp.setTextAlign(Paint.Align.RIGHT);
        paramd.fLq.setTextAlign(Paint.Align.RIGHT);
      }
      else if ("center".equalsIgnoreCase(paramString))
      {
        paramd.fLp.setTextAlign(Paint.Align.CENTER);
        paramd.fLq.setTextAlign(Paint.Align.CENTER);
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetTextAlignActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return b(paramd, paramCanvas.fMb);
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
    return new SetTextAlignActionArg();
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