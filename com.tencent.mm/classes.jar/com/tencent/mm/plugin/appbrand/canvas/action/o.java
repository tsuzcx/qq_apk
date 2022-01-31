package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DefaultDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import java.util.Stack;
import org.json.JSONArray;

public final class o
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas = paramd.fLp;
    paramd.fLr.push(paramd.fLp);
    if (paramd.fLy)
    {
      paramd.fLp = i.adO().adG();
      paramCanvas.b(paramd.fLp);
      if (paramd.fLp == null) {
        paramd.fLp = paramCanvas;
      }
      paramCanvas = paramd.fLq;
      paramd.fLs.push(paramd.fLq);
      if (!paramd.fLy) {
        break label128;
      }
    }
    label128:
    for (paramd.fLq = e.adK().adG();; paramd.fLq = paramCanvas.adP())
    {
      paramCanvas.b(paramd.fLq);
      if (paramd.fLq == null) {
        paramd.fLq = paramCanvas;
      }
      return true;
      paramd.fLp = paramCanvas.adP();
      break;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    return a(paramd, paramCanvas);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    return a(paramd, paramCanvas);
  }
  
  public final BaseDrawActionArg adE()
  {
    return new DefaultDrawActionArg();
  }
  
  public final String getMethod()
  {
    return "save";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.o
 * JD-Core Version:    0.7.0.1
 */