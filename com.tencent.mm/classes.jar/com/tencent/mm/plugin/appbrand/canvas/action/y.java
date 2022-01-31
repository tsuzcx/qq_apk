package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetLineDashActionArg;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;
import org.json.JSONException;

public final class y
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float[] paramArrayOfFloat, float paramFloat)
  {
    AppMethodBeat.i(103264);
    if ((paramArrayOfFloat != null) && (paramFloat != 1.4E-45F)) {
      paramd.heB.setPathEffect(new DashPathEffect(paramArrayOfFloat, paramFloat));
    }
    AppMethodBeat.o(103264);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103265);
    paramCanvas = (SetLineDashActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103265);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.hff, paramCanvas.hfg);
    AppMethodBeat.o(103265);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103263);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(103263);
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getJSONArray(0);
      if (paramCanvas == null)
      {
        AppMethodBeat.o(103263);
        return false;
      }
      float[] arrayOfFloat = new float[paramCanvas.length()];
      int i = 0;
      while (i < arrayOfFloat.length)
      {
        arrayOfFloat[i] = g.d(paramCanvas, i);
        i += 1;
      }
      float f = g.d(paramJSONArray, 1);
      boolean bool = a(paramd, arrayOfFloat, f);
      AppMethodBeat.o(103263);
      return bool;
    }
    catch (JSONException paramd)
    {
      AppMethodBeat.o(103263);
    }
    return false;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103262);
    SetLineDashActionArg localSetLineDashActionArg = new SetLineDashActionArg();
    AppMethodBeat.o(103262);
    return localSetLineDashActionArg;
  }
  
  public final String getMethod()
  {
    return "setLineDash";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.y
 * JD-Core Version:    0.7.0.1
 */