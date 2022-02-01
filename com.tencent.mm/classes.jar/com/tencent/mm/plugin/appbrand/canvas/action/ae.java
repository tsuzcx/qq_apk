package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetShadowActionArg;
import org.json.JSONArray;

public final class ae
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    AppMethodBeat.i(144968);
    paramd.qTj.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    paramd.qTi.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    AppMethodBeat.o(144968);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144969);
    paramCanvas = (SetShadowActionArg)paramDrawActionArg;
    if (paramCanvas == null)
    {
      AppMethodBeat.o(144969);
      return false;
    }
    boolean bool = a(paramd, paramCanvas.x, paramCanvas.y, paramCanvas.qTL, paramCanvas.color);
    AppMethodBeat.o(144969);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144967);
    if (paramJSONArray.length() < 4)
    {
      AppMethodBeat.o(144967);
      return false;
    }
    float f1 = i.f(paramJSONArray, 0);
    float f2 = i.f(paramJSONArray, 1);
    float f3 = i.f(paramJSONArray, 2);
    paramCanvas = paramJSONArray.optJSONArray(3);
    if ((paramCanvas == null) || (paramCanvas.length() < 4))
    {
      AppMethodBeat.o(144967);
      return false;
    }
    boolean bool = a(paramd, f1, f2, f3, i.u(paramCanvas));
    AppMethodBeat.o(144967);
    return bool;
  }
  
  public final BaseDrawActionArg cjY()
  {
    AppMethodBeat.i(144966);
    SetShadowActionArg localSetShadowActionArg = new SetShadowActionArg();
    AppMethodBeat.o(144966);
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