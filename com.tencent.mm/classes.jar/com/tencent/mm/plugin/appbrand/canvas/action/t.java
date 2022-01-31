package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFontStyleActionArg;
import org.json.JSONArray;
import org.json.JSONException;

public final class t
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
        if (paramString.equals("oblique"))
        {
          i = 0;
          continue;
          if (paramString.equals("italic"))
          {
            i = 1;
            continue;
            if (paramString.equals("normal")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramd.fLp.kC(2);
    paramd.fLq.kC(2);
    return true;
    paramd.fLp.kC(2);
    paramd.fLq.kC(2);
    return true;
    paramd.fLp.kC(0);
    paramd.fLq.kC(0);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetFontStyleActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return b(paramd, paramCanvas.fLS);
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
      c.i("MicroMsg.SetFontStyle", "get 'fontStyle' error.");
    }
    return false;
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetFontStyleActionArg();
  }
  
  public final String getMethod()
  {
    return "setFontStyle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.t
 * JD-Core Version:    0.7.0.1
 */