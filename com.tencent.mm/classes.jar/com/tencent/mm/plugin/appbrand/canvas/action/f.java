package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONArray;

public final class f
  implements d
{
  private boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, int paramInt1, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    float f1;
    float f2;
    float f3;
    if (paramInt1 >= 5)
    {
      if ((paramFloat3 == 0.0F) || (paramFloat4 == 0.0F)) {
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
        if ((paramInt4 == 0) || (paramInt5 == 0)) {
          return true;
        }
        if (paramInt4 >= 0) {
          break label540;
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
          if ((paramInt1 + paramInt4 <= 0) || (paramInt2 + paramInt5 <= 0)) {
            return true;
          }
          if (paramInt1 > 0)
          {
            paramInt3 = paramInt1;
            if (paramInt2 <= 0) {
              break label242;
            }
          }
          Object localObject;
          label242:
          for (int i = paramInt2;; i = 0)
          {
            localObject = new Rect(paramInt3, i, paramInt1 + paramInt4, paramInt2 + paramInt5);
            paramString = paramd.fLv.a(paramd, paramString, (Rect)localObject, new f.1(this));
            if ((paramString != null) && (!paramString.isRecycled())) {
              break label248;
            }
            return false;
            paramInt3 = 0;
            break;
          }
          label248:
          paramInt1 = h.my(paramInt1);
          paramInt2 = h.my(paramInt2);
          paramInt4 = h.my(paramInt4);
          paramInt5 = h.my(paramInt5);
          paramInt3 = h.my(paramInt3);
          i = h.my(i);
          int j = h.my(paramString.getWidth());
          int k = h.my(paramString.getHeight());
          paramFloat3 = f3 / paramInt4;
          paramFloat4 = f2 / paramInt5;
          f1 = paramFloat2 + (paramInt3 - paramInt1) * paramFloat3;
          f3 = paramFloat1 + (i - paramInt2) * paramFloat4;
          float f4 = f1 + j * paramFloat3;
          paramFloat4 = k * paramFloat4 + f3;
          for (;;)
          {
            paramCanvas.drawBitmap(paramString, new Rect(0, 0, paramString.getWidth(), paramString.getHeight()), new RectF(f1, f3, f4, paramFloat4), paramd.fLq);
            return true;
            localObject = paramd.fLv.a(paramd, paramString, new e.a()
            {
              public final void a(com.tencent.mm.plugin.appbrand.canvas.d paramAnonymousd)
              {
                paramAnonymousd.invalidate();
              }
            });
            if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
              return false;
            }
            if (f3 == 0.0F) {
              paramFloat3 = h.my(((Bitmap)localObject).getWidth()) + paramFloat2;
            }
            f4 = paramFloat3;
            f3 = paramFloat1;
            f1 = paramFloat2;
            paramString = (String)localObject;
            if (f2 == 0.0F)
            {
              paramFloat4 = h.my(((Bitmap)localObject).getHeight()) + paramFloat1;
              f4 = paramFloat3;
              f3 = paramFloat1;
              f1 = paramFloat2;
              paramString = (String)localObject;
            }
          }
          paramInt2 = paramInt3;
        }
        label540:
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
    paramDrawActionArg = (DrawImageActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null) {
      return false;
    }
    return a(paramd, paramCanvas, paramDrawActionArg.fLE, paramDrawActionArg.url, paramDrawActionArg.x, paramDrawActionArg.y, paramDrawActionArg.width, paramDrawActionArg.height, paramDrawActionArg.fLF, paramDrawActionArg.fLG, paramDrawActionArg.aoT, paramDrawActionArg.aoU);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    int i = paramJSONArray.length();
    if (i < 3) {
      return false;
    }
    return a(paramd, paramCanvas, i, paramJSONArray.optString(0), h.d(paramJSONArray, 1), h.d(paramJSONArray, 2), h.d(paramJSONArray, 3), h.d(paramJSONArray, 4), paramJSONArray.optInt(5), paramJSONArray.optInt(6), paramJSONArray.optInt(7), paramJSONArray.optInt(8));
  }
  
  public final BaseDrawActionArg adE()
  {
    return new DrawImageActionArg();
  }
  
  public final String getMethod()
  {
    return "drawImage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.f
 * JD-Core Version:    0.7.0.1
 */