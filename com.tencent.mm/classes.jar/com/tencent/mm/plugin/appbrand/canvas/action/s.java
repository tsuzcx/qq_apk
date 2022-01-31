package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontSizeActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class s
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, int paramInt)
  {
    paramd.fLq.setTextSize(paramInt);
    paramd.fLp.setTextSize(paramInt);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetFontSizeActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.size);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() <= 0) {
      return false;
    }
    return a(paramd, h.a(paramJSONArray, 0));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetFontSizeActionArg();
  }
  
  public final String getMethod()
  {
    return "setFontSize";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.s
 * JD-Core Version:    0.7.0.1
 */