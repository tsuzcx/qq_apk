package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class af
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramDrawActionArg = (SetStrokeStyleActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null) {
      return false;
    }
    return paramDrawActionArg.a(paramd, paramCanvas);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    paramCanvas = paramJSONArray.optString(0);
    float f1;
    float f2;
    float f3;
    float[] arrayOfFloat;
    int i;
    JSONArray localJSONArray;
    if ("linear".equalsIgnoreCase(paramCanvas))
    {
      if (paramJSONArray.length() < 3) {
        return false;
      }
      paramCanvas = paramJSONArray.optJSONArray(1);
      if ((paramCanvas == null) || (paramCanvas.length() < 4)) {
        return false;
      }
      f1 = h.d(paramCanvas, 0);
      f2 = h.d(paramCanvas, 1);
      f3 = h.d(paramCanvas, 2);
      float f4 = h.d(paramCanvas, 3);
      paramCanvas = paramJSONArray.optJSONArray(2);
      if ((paramCanvas == null) || (paramCanvas.length() == 0)) {
        return false;
      }
      paramJSONArray = new int[paramCanvas.length()];
      arrayOfFloat = new float[paramCanvas.length()];
      i = 0;
      while (i < paramCanvas.length())
      {
        localJSONArray = paramCanvas.optJSONArray(i);
        if (localJSONArray.length() >= 2)
        {
          arrayOfFloat[i] = ((float)localJSONArray.optDouble(0));
          paramJSONArray[i] = h.l(localJSONArray.optJSONArray(1));
        }
        i += 1;
      }
      paramCanvas = new LinearGradient(f1, f2, f3, f4, paramJSONArray, arrayOfFloat, Shader.TileMode.CLAMP);
      paramd.fLp.setShader(paramCanvas);
    }
    for (;;)
    {
      return true;
      if ("radial".equalsIgnoreCase(paramCanvas))
      {
        if (paramJSONArray.length() < 3) {
          return false;
        }
        paramCanvas = paramJSONArray.optJSONArray(1);
        if ((paramCanvas == null) || (paramCanvas.length() < 3)) {
          return false;
        }
        f1 = h.d(paramCanvas, 1);
        f2 = h.d(paramCanvas, 2);
        f3 = h.d(paramCanvas, 3);
        paramCanvas = paramJSONArray.optJSONArray(2);
        paramJSONArray = new int[paramCanvas.length()];
        arrayOfFloat = new float[paramCanvas.length()];
        i = 0;
        while (i < paramCanvas.length())
        {
          localJSONArray = paramCanvas.optJSONArray(i);
          if (localJSONArray.length() >= 2)
          {
            arrayOfFloat[i] = ((float)localJSONArray.optDouble(0));
            paramJSONArray[i] = h.l(localJSONArray.optJSONArray(1));
          }
          i += 1;
        }
        paramCanvas = new RadialGradient(f1, f2, f3, paramJSONArray, arrayOfFloat, Shader.TileMode.CLAMP);
        paramd.fLp.setShader(paramCanvas);
      }
      else if ("normal".equalsIgnoreCase(paramCanvas))
      {
        paramCanvas = paramJSONArray.optJSONArray(1);
        if ((paramCanvas == null) || (paramCanvas.length() < 4)) {
          return false;
        }
        paramd.fLp.setColor(h.l(paramCanvas));
      }
    }
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetStrokeStyleActionArg();
  }
  
  public final String getMethod()
  {
    return "setStrokeStyle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.af
 * JD-Core Version:    0.7.0.1
 */