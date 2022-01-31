package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetGlobalAlphaActionArg;
import org.json.JSONArray;
import org.json.JSONException;

public final class v
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, int paramInt)
  {
    paramd.fLp.ad(paramInt / 255.0F);
    paramd.fLq.ad(paramInt / 255.0F);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetGlobalAlphaActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.alpha);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    try
    {
      int i = paramJSONArray.getInt(0);
      return a(paramd, i);
    }
    catch (JSONException paramd)
    {
      c.e("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", new Object[] { paramd });
    }
    return false;
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetGlobalAlphaActionArg();
  }
  
  public final String getMethod()
  {
    return "setGlobalAlpha";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.v
 * JD-Core Version:    0.7.0.1
 */