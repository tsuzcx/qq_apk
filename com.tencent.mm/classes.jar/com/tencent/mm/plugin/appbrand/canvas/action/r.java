package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontFamilyActionArg;
import org.json.JSONArray;
import org.json.JSONException;

public final class r
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramd.fLp.rN(paramString);
      paramd.fLq.rN(paramString);
      return true;
    }
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetFontFamilyActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return b(paramd, paramCanvas.aPg);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() == 0) {
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      return b(paramd, paramCanvas);
    }
    catch (JSONException paramd)
    {
      c.i("MicroMsg.SetFontFamily", "get 'fontFamily' error.");
    }
    return false;
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetFontFamilyActionArg();
  }
  
  public final String getMethod()
  {
    return "setFontFamily";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.r
 * JD-Core Version:    0.7.0.1
 */