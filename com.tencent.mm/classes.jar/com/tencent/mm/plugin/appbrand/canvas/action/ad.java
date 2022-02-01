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
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONArray;

public final class ad
  implements d
{
  private static boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(144964);
    if (paramCanvas.isHardwareAccelerated()) {
      if ((paramCanvas instanceof f))
      {
        ((f)paramCanvas).j(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
        ac.v("MicroMsg.SetPixelsAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      }
    }
    while ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(144964);
      return false;
      if (paramd.jzg != null)
      {
        paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramd.jzg);
        ac.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      }
      else
      {
        ac.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        continue;
        if (paramd.jzg != null)
        {
          paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramd.jzg);
          ac.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        }
        else
        {
          paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramd.jzf);
          ac.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        }
      }
    }
    paramCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new RectF(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), paramd.jzb);
    AppMethodBeat.o(144964);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144965);
    paramDrawActionArg = (SetPixelsActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(144965);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.bitmap, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.width, paramDrawActionArg.height);
    AppMethodBeat.o(144965);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144963);
    int i = g.c(paramJSONArray, 0);
    int j = g.c(paramJSONArray, 1);
    int k = g.c(paramJSONArray, 2);
    int m = g.c(paramJSONArray, 3);
    try
    {
      paramJSONArray = (Bitmap)paramJSONArray.get(4);
      boolean bool = a(paramd, paramCanvas, paramJSONArray, i, j, k, m);
      AppMethodBeat.o(144963);
      return bool;
    }
    catch (Exception paramd)
    {
      ac.w("MicroMsg.SetPixelsAction", "get bitmap data error, %s", new Object[] { Log.getStackTraceString(paramd) });
      AppMethodBeat.o(144963);
    }
    return false;
  }
  
  public final BaseDrawActionArg aZO()
  {
    AppMethodBeat.i(144962);
    SetPixelsActionArg localSetPixelsActionArg = new SetPixelsActionArg();
    AppMethodBeat.o(144962);
    return localSetPixelsActionArg;
  }
  
  public final String getMethod()
  {
    return "__setPixels";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.ad
 * JD-Core Version:    0.7.0.1
 */