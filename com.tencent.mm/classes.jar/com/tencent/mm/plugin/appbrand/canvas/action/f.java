package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONArray;

public final class f
  implements d
{
  private boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, int paramInt1, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(103191);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(103191);
      return false;
    }
    float f1;
    float f2;
    float f3;
    if (paramInt1 >= 5)
    {
      if ((paramFloat3 == 0.0F) || (paramFloat4 == 0.0F))
      {
        AppMethodBeat.o(103191);
        return true;
      }
      if (paramFloat3 < 0.0F)
      {
        f1 = paramFloat1 + paramFloat3;
        paramFloat3 = -paramFloat3;
        if (paramFloat4 < 0.0F)
        {
          f2 = -paramFloat4;
          paramFloat1 = paramFloat2 + paramFloat4;
          f3 = paramFloat3;
          paramFloat2 = f1;
        }
      }
    }
    for (;;)
    {
      paramFloat3 = paramFloat2 + f3;
      paramFloat4 = paramFloat1 + f2;
      if (paramInt1 >= 9)
      {
        if ((paramInt4 == 0) || (paramInt5 == 0))
        {
          AppMethodBeat.o(103191);
          return true;
        }
        if (paramInt4 >= 0) {
          break label593;
        }
        paramInt1 = paramInt2 + paramInt4;
        paramInt4 = -paramInt4;
      }
      for (;;)
      {
        if (paramInt5 < 0)
        {
          paramInt2 = paramInt3 + paramInt5;
          paramInt5 = -paramInt5;
        }
        for (;;)
        {
          if ((paramInt1 + paramInt4 <= 0) || (paramInt2 + paramInt5 <= 0))
          {
            AppMethodBeat.o(103191);
            return true;
          }
          if (paramInt1 > 0)
          {
            paramInt3 = paramInt1;
            if (paramInt2 <= 0) {
              break label272;
            }
          }
          Object localObject;
          label272:
          for (int i = paramInt2;; i = 0)
          {
            localObject = new Rect(paramInt3, i, paramInt1 + paramInt4, paramInt2 + paramInt5);
            paramString = paramd.heH.a(paramd, paramString, (Rect)localObject, new f.1(this));
            if ((paramString != null) && (!paramString.isRecycled())) {
              break label278;
            }
            AppMethodBeat.o(103191);
            return false;
            paramInt3 = 0;
            break;
          }
          label278:
          paramInt1 = g.pO(paramInt1);
          paramInt2 = g.pO(paramInt2);
          paramInt4 = g.pO(paramInt4);
          paramInt5 = g.pO(paramInt5);
          paramInt3 = g.pO(paramInt3);
          i = g.pO(i);
          int j = g.pO(paramString.getWidth());
          int k = g.pO(paramString.getHeight());
          paramFloat3 = f3 / paramInt4;
          paramFloat4 = f2 / paramInt5;
          f1 = paramFloat2 + (paramInt3 - paramInt1) * paramFloat3;
          f3 = paramFloat1 + (i - paramInt2) * paramFloat4;
          float f4 = f1 + j * paramFloat3;
          paramFloat4 = k * paramFloat4 + f3;
          for (;;)
          {
            paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            paramCanvas.drawBitmap(paramString, new Rect(0, 0, paramString.getWidth(), paramString.getHeight()), new RectF(f1, f3, f4, paramFloat4), paramd.heC);
            AppMethodBeat.o(103191);
            return true;
            localObject = paramd.heH.a(paramd, paramString, new f.2(this));
            if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
            {
              AppMethodBeat.o(103191);
              return false;
            }
            if (f3 == 0.0F) {
              paramFloat3 = g.pO(((Bitmap)localObject).getWidth()) + paramFloat2;
            }
            f4 = paramFloat3;
            f3 = paramFloat1;
            f1 = paramFloat2;
            paramString = (String)localObject;
            if (f2 == 0.0F)
            {
              paramFloat4 = g.pO(((Bitmap)localObject).getHeight()) + paramFloat1;
              f4 = paramFloat3;
              f3 = paramFloat1;
              f1 = paramFloat2;
              paramString = (String)localObject;
            }
          }
          paramInt2 = paramInt3;
        }
        label593:
        paramInt1 = paramInt2;
      }
      paramFloat1 = paramFloat2;
      paramFloat2 = f1;
      f3 = paramFloat3;
      f2 = paramFloat4;
      continue;
      f1 = paramFloat1;
      break;
      f1 = paramFloat1;
      paramFloat1 = paramFloat2;
      paramFloat2 = f1;
      f3 = paramFloat3;
      f2 = paramFloat4;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(103190);
    paramDrawActionArg = (DrawImageActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(103190);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, paramDrawActionArg.heP, paramDrawActionArg.url, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.width, paramDrawActionArg.height, paramDrawActionArg.heQ, paramDrawActionArg.heR, paramDrawActionArg.arn, paramDrawActionArg.aro);
    AppMethodBeat.o(103190);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(103189);
    int i = paramJSONArray.length();
    if (i < 3)
    {
      AppMethodBeat.o(103189);
      return false;
    }
    boolean bool = a(paramd, paramCanvas, i, paramJSONArray.optString(0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), g.d(paramJSONArray, 3), g.d(paramJSONArray, 4), paramJSONArray.optInt(5), paramJSONArray.optInt(6), paramJSONArray.optInt(7), paramJSONArray.optInt(8));
    AppMethodBeat.o(103189);
    return bool;
  }
  
  public final BaseDrawActionArg axW()
  {
    AppMethodBeat.i(103188);
    DrawImageActionArg localDrawImageActionArg = new DrawImageActionArg();
    AppMethodBeat.o(103188);
    return localDrawImageActionArg;
  }
  
  public final String getMethod()
  {
    return "drawImage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.f
 * JD-Core Version:    0.7.0.1
 */