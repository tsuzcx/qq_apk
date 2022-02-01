package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.FillRectActionArg;
import org.json.JSONArray;

public final class k
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(144893);
    paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, paramd.qTj);
    AppMethodBeat.o(144893);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144894);
    paramDrawActionArg = (FillRectActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(144894);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.width, paramDrawActionArg.height);
    AppMethodBeat.o(144894);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144892);
    if (paramJSONArray.length() < 4)
    {
      AppMethodBeat.o(144892);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, i.f(paramJSONArray, 0), i.f(paramJSONArray, 1), i.f(paramJSONArray, 2), i.f(paramJSONArray, 3));
    AppMethodBeat.o(144892);
    return bool;
  }
  
  public final BaseDrawActionArg cjY()
  {
    AppMethodBeat.i(144891);
    FillRectActionArg localFillRectActionArg = new FillRectActionArg();
    AppMethodBeat.o(144891);
    return localFillRectActionArg;
  }
  
  public final String getMethod()
  {
    return "fillRect";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.k
 * JD-Core Version:    0.7.0.1
 */