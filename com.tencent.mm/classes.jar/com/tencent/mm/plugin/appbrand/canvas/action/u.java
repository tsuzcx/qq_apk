package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontWeightArg;
import org.json.JSONArray;
import org.json.JSONException;

public final class u
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return true;
        if (paramString.equals("bold"))
        {
          i = 0;
          continue;
          if (paramString.equals("normal")) {
            i = 1;
          }
        }
        break;
      }
    }
    paramd.fLp.setFakeBoldText(true);
    paramd.fLq.setFakeBoldText(true);
    return true;
    paramd.fLp.setFakeBoldText(false);
    paramd.fLq.setFakeBoldText(false);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetFontWeightArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return b(paramd, paramCanvas.fLT);
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
      c.i("MicroMsg.SetFontWeight", "get 'fontWeight' error.");
    }
    return false;
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetFontWeightArg();
  }
  
  public final String getMethod()
  {
    return "setFontWeight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.u
 * JD-Core Version:    0.7.0.1
 */