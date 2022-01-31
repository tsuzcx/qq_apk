package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.TranslateActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class ak
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramd = (TranslateActionArg)paramDrawActionArg;
    if (paramd == null) {
      return false;
    }
    paramCanvas.translate(paramd.x, paramd.y);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    paramCanvas.translate(h.d(paramJSONArray, 0), h.d(paramJSONArray, 1));
    return true;
  }
  
  public final BaseDrawActionArg adE()
  {
    return new TranslateActionArg();
  }
  
  public final String getMethod()
  {
    return "translate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ak
 * JD-Core Version:    0.7.0.1
 */