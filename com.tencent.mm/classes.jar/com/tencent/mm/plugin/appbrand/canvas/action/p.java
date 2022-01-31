package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.ScaleActionArg;
import org.json.JSONArray;

public final class p
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramd = (ScaleActionArg)paramDrawActionArg;
    if (paramd == null) {
      return false;
    }
    paramCanvas.scale(paramd.fLI, paramd.fLJ);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    paramCanvas.scale((float)paramJSONArray.optDouble(0), (float)paramJSONArray.optDouble(1));
    return true;
  }
  
  public final BaseDrawActionArg adE()
  {
    return new ScaleActionArg();
  }
  
  public final String getMethod()
  {
    return "scale";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.p
 * JD-Core Version:    0.7.0.1
 */