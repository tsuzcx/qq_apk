package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;
import org.json.JSONException;

@Deprecated
public final class z
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() == 0) {
      return false;
    }
    try
    {
      h.m(paramJSONArray);
      return false;
    }
    catch (JSONException paramd)
    {
      c.i("MicroMsg.SetLineHeight", "get 'lineHeight' error");
    }
    return false;
  }
  
  public final BaseDrawActionArg adE()
  {
    return null;
  }
  
  public final String getMethod()
  {
    return "setLineHeight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.z
 * JD-Core Version:    0.7.0.1
 */