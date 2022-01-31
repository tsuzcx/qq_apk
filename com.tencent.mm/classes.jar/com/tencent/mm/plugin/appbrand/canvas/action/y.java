package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;
import org.json.JSONException;

public final class y
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((paramArrayOfFloat != null) && (paramFloat != 1.4E-45F)) {
      paramd.fLp.setPathEffect(new DashPathEffect(paramArrayOfFloat, paramFloat));
    }
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramCanvas = (SetLineDashActionArg)paramDrawActionArg;
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.fLV, paramCanvas.fLW);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {}
    for (;;)
    {
      return false;
      try
      {
        paramCanvas = paramJSONArray.getJSONArray(0);
        if (paramCanvas != null)
        {
          float[] arrayOfFloat = new float[paramCanvas.length()];
          int i = 0;
          while (i < arrayOfFloat.length)
          {
            arrayOfFloat[i] = h.d(paramCanvas, i);
            i += 1;
          }
          float f = h.d(paramJSONArray, 1);
          return a(paramd, arrayOfFloat, f);
        }
      }
      catch (JSONException paramd) {}
    }
    return false;
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetLineDashActionArg();
  }
  
  public final String getMethod()
  {
    return "setLineDash";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.y
 * JD-Core Version:    0.7.0.1
 */