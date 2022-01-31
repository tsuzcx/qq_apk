package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.a.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetTextBaseLineActionArg;
import org.json.JSONArray;

public final class ah
  implements d
{
  private static boolean b(com.tencent.mm.plugin.appbrand.canvas.d paramd, String paramString)
  {
    c.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", new Object[] { paramString });
    if ("top".equalsIgnoreCase(paramString))
    {
      paramd.fLp.fMs = a.a.fMz;
      paramd.fLq.fMs = a.a.fMz;
    }
    do
    {
      return true;
      if ("middle".equalsIgnoreCase(paramString))
      {
        paramd.fLp.fMs = a.a.fMB;
        paramd.fLq.fMs = a.a.fMB;
        return true;
      }
      if ("bottom".equalsIgnoreCase(paramString))
      {
        paramd.fLp.fMs = a.a.fMA;
        paramd.fLq.fMs = a.a.fMA;
        return true;
      }
    } while (!"normal".equalsIgnoreCase(paramString));
    paramd.fLp.fMs = a.a.fMy;
    paramd.fLq.fMs = a.a.fMy;
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetTextBaseLineActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return b(paramd, paramCanvas.fMb);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() <= 0) {
      return false;
    }
    return b(paramd, paramJSONArray.optString(0));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetTextBaseLineActionArg();
  }
  
  public final String getMethod()
  {
    return "setTextBaseline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ah
 * JD-Core Version:    0.7.0.1
 */