package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetStrokeStyleActionArg;
import org.json.JSONArray;

public final class af
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144972);
    paramDrawActionArg = (SetStrokeStyleActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(144972);
      return false;
    }
    boolean bool = paramDrawActionArg.a(paramd, paramCanvas);
    AppMethodBeat.o(144972);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144971);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(144971);
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
      if (paramJSONArray.length() < 3)
      {
        AppMethodBeat.o(144971);
        return false;
      }
      paramCanvas = paramJSONArray.optJSONArray(1);
      if ((paramCanvas == null) || (paramCanvas.length() < 4))
      {
        AppMethodBeat.o(144971);
        return false;
      }
      f1 = g.f(paramCanvas, 0);
      f2 = g.f(paramCanvas, 1);
      f3 = g.f(paramCanvas, 2);
      float f4 = g.f(paramCanvas, 3);
      paramCanvas = paramJSONArray.optJSONArray(2);
      if ((paramCanvas == null) || (paramCanvas.length() == 0))
      {
        AppMethodBeat.o(144971);
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
          paramJSONArray[i] = g.p(localJSONArray.optJSONArray(1));
        }
        i += 1;
      }
      paramCanvas = new LinearGradient(f1, f2, f3, f4, paramJSONArray, arrayOfFloat, Shader.TileMode.CLAMP);
      paramd.iYL.setShader(paramCanvas);
    }
    for (;;)
    {
      AppMethodBeat.o(144971);
      return true;
      if ("radial".equalsIgnoreCase(paramCanvas))
      {
        if (paramJSONArray.length() < 3)
        {
          AppMethodBeat.o(144971);
          return false;
        }
        paramCanvas = paramJSONArray.optJSONArray(1);
        if ((paramCanvas == null) || (paramCanvas.length() < 3))
        {
          AppMethodBeat.o(144971);
          return false;
        }
        f1 = g.f(paramCanvas, 1);
        f2 = g.f(paramCanvas, 2);
        f3 = g.f(paramCanvas, 3);
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
            paramJSONArray[i] = g.p(localJSONArray.optJSONArray(1));
          }
          i += 1;
        }
        paramCanvas = new RadialGradient(f1, f2, f3, paramJSONArray, arrayOfFloat, Shader.TileMode.CLAMP);
        paramd.iYL.setShader(paramCanvas);
      }
      else if ("normal".equalsIgnoreCase(paramCanvas))
      {
        paramCanvas = paramJSONArray.optJSONArray(1);
        if ((paramCanvas == null) || (paramCanvas.length() < 4))
        {
          AppMethodBeat.o(144971);
          return false;
        }
        paramd.iYL.setColor(g.p(paramCanvas));
      }
    }
  }
  
  public final BaseDrawActionArg aSP()
  {
    AppMethodBeat.i(144970);
    SetStrokeStyleActionArg localSetStrokeStyleActionArg = new SetStrokeStyleActionArg();
    AppMethodBeat.o(144970);
    return localSetStrokeStyleActionArg;
  }
  
  public final String getMethod()
  {
    return "setStrokeStyle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.af
 * JD-Core Version:    0.7.0.1
 */