package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SeMiterLimitActionArg;
import org.json.JSONArray;

public final class ac
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float paramFloat)
  {
    paramd.fLq.setStrokeMiter(paramFloat);
    paramd.fLp.setStrokeMiter(paramFloat);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SeMiterLimitActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.fLQ);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() <= 0) {
      return false;
    }
    return a(paramd, (float)paramJSONArray.optDouble(0));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SeMiterLimitActionArg();
  }
  
  public final String getMethod()
  {
    return "setMiterLimit";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ac
 * JD-Core Version:    0.7.0.1
 */