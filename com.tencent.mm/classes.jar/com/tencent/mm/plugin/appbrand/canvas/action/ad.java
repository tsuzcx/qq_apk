package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetPixelsActionArg;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class ad
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(103281);
    if (paramCanvas.isHardwareAccelerated()) {
      if ((paramCanvas instanceof f))
      {
        ((f)paramCanvas).g(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
        com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      }
    }
    while ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(103281);
      return false;
      if (paramd.heG != null)
      {
        paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramd.heG);
        com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      }
      else
      {
        com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        continue;
        if (paramd.heG != null)
        {
          paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramd.heG);
          com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        }
        else
        {
          paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramd.heF);
          com.tencent.luggage.g.d.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        }
      }
    }
    paramCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new RectF(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), paramd.heB);
    AppMethodBeat.o(103281);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103282);
    paramDrawActionArg = (SetPixelsActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(103282);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.bitmap, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.width, paramDrawActionArg.height);
    AppMethodBeat.o(103282);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103280);
    int i = g.a(paramJSONArray, 0);
    int j = g.a(paramJSONArray, 1);
    int k = g.a(paramJSONArray, 2);
    int m = g.a(paramJSONArray, 3);
    try
    {
      paramJSONArray = (Bitmap)paramJSONArray.get(4);
      boolean bool = a(paramd, paramCanvas, paramJSONArray, i, j, k, m);
      AppMethodBeat.o(103280);
      return bool;
    }
    catch (Exception paramd)
    {
      com.tencent.luggage.g.d.w("MicroMsg.SetPixelsAction", "get bitmap data error, %s", new Object[] { Log.getStackTraceString(paramd) });
      AppMethodBeat.o(103280);
    }
    return false;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103279);
    SetPixelsActionArg localSetPixelsActionArg = new SetPixelsActionArg();
    AppMethodBeat.o(103279);
    return localSetPixelsActionArg;
  }
  
  public final String getMethod()
  {
    return "__setPixels";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ad
 * JD-Core Version:    0.7.0.1
 */