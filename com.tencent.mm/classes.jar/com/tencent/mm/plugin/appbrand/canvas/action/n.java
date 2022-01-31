package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg;
import org.json.JSONArray;

public final class n
  implements d
{
  private static boolean a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.rotate((float)(paramFloat / 3.141592653589793D * 180.0D));
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramd = (RotateActionArg)paramDrawActionArg;
    if (paramd == null) {
      return false;
    }
    return a(paramCanvas, paramd.fLP);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() <= 0) {
      return false;
    }
    return a(paramCanvas, (float)paramJSONArray.optDouble(0));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new RotateActionArg();
  }
  
  public final String getMethod()
  {
    return "rotate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.n
 * JD-Core Version:    0.7.0.1
 */