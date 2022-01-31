package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class ae
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(103285);
    paramd.heC.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    paramd.heB.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    AppMethodBeat.o(103285);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103286);
    paramCanvas = (SetShadowActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(103286);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.x, paramCanvas.y, paramCanvas.hfj, paramCanvas.color);
    AppMethodBeat.o(103286);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103284);
    if (paramJSONArray.length() < 4)
    {
      AppMethodBeat.o(103284);
      return false;
    }
    float f1 = g.d(paramJSONArray, 0);
    float f2 = g.d(paramJSONArray, 1);
    float f3 = g.d(paramJSONArray, 2);
    paramCanvas = paramJSONArray.optJSONArray(3);
    if ((paramCanvas == null) || (paramCanvas.length() < 4))
    {
      AppMethodBeat.o(103284);
      return false;
    }
    boolean bool = a(paramd, f1, f2, f3, g.o(paramCanvas));
    AppMethodBeat.o(103284);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103283);
    SetShadowActionArg localSetShadowActionArg = new SetShadowActionArg();
    AppMethodBeat.o(103283);
    return localSetShadowActionArg;
  }
  
  public final String getMethod()
  {
    return "setShadow";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ae
 * JD-Core Version:    0.7.0.1
 */