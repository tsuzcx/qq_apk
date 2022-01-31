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

public final class m
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas)
  {
    paramCanvas.restore();
    if (!paramd.fLr.isEmpty())
    {
      paramCanvas = paramd.fLp;
      a locala = paramd.fLq;
      paramd.fLp = ((a)paramd.fLr.pop());
      paramd.fLq = ((a)paramd.fLs.pop());
      if (paramd.fLy)
      {
        if (paramd.fLp != paramCanvas) {
          i.adO().a(paramCanvas);
        }
        if (paramd.fLq != locala) {
          e.adK().a(locala);
        }
      }
    }
    return true;
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
    return "restore";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.m
 * JD-Core Version:    0.7.0.1
 */