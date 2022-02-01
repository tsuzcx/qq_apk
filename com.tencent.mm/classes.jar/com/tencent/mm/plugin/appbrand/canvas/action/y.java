package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg;
import org.json.JSONArray;
import org.json.JSONException;

public final class y
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float[] paramArrayOfFloat, float paramFloat)
  {
    AppMethodBeat.i(144947);
    if ((paramArrayOfFloat != null) && (paramFloat != 1.4E-45F)) {
      paramd.iYL.setPathEffect(new DashPathEffect(paramArrayOfFloat, paramFloat));
    }
    AppMethodBeat.o(144947);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144948);
    paramCanvas = (SetLineDashActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144948);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.iZo, paramCanvas.iZp);
    AppMethodBeat.o(144948);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144946);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(144946);
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getJSONArray(0);
      if (paramCanvas == null)
      {
        AppMethodBeat.o(144946);
        return false;
      }
      float[] arrayOfFloat = new float[paramCanvas.length()];
      int i = 0;
      while (i < arrayOfFloat.length)
      {
        arrayOfFloat[i] = g.f(paramCanvas, i);
        i += 1;
      }
      float f = g.f(paramJSONArray, 1);
      boolean bool = a(paramd, arrayOfFloat, f);
      AppMethodBeat.o(144946);
      return bool;
    }
    catch (JSONException paramd)
    {
      AppMethodBeat.o(144946);
    }
    return false;
  }
  
  public final BaseDrawActionArg aSP()
  {
    AppMethodBeat.i(144945);
    SetLineDashActionArg localSetLineDashActionArg = new SetLineDashActionArg();
    AppMethodBeat.o(144945);
    return localSetLineDashActionArg;
  }
  
  public final String getMethod()
  {
    return "setLineDash";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.y
 * JD-Core Version:    0.7.0.1
 */