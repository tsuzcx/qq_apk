package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONArray;

public final class q
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    paramDrawActionArg = (SetFillStyleActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null) {
      return false;
    }
    return paramDrawActionArg.a(paramd, paramCanvas);
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    Object localObject = paramJSONArray.optString(0);
    paramCanvas = paramd.fLq;
    float f1;
    float f2;
    float f3;
    JSONArray localJSONArray;
    if ("linear".equalsIgnoreCase((String)localObject))
    {
      if (paramJSONArray.length() < 3) {
        return false;
      }
      paramd = paramJSONArray.optJSONArray(1);
      if ((paramd == null) || (paramd.length() < 4)) {
        return false;
      }
      f1 = h.d(paramd, 0);
      f2 = h.d(paramd, 1);
      f3 = h.d(paramd, 2);
      float f4 = h.d(paramd, 3);
      paramd = paramJSONArray.optJSONArray(2);
      if ((paramd == null) || (paramd.length() == 0)) {
        return false;
      }
      paramJSONArray = new int[paramd.length()];
      localObject = new float[paramd.length()];
      i = 0;
      while (i < paramd.length())
      {
        localJSONArray = paramd.optJSONArray(i);
        if (localJSONArray.length() >= 2)
        {
          localObject[i] = ((float)localJSONArray.optDouble(0));
          paramJSONArray[i] = h.l(localJSONArray.optJSONArray(1));
        }
        i += 1;
      }
      paramCanvas.setShader(new LinearGradient(f1, f2, f3, f4, paramJSONArray, (float[])localObject, Shader.TileMode.CLAMP));
    }
    do
    {
      do
      {
        for (;;)
        {
          return true;
          if ("radial".equalsIgnoreCase((String)localObject))
          {
            if (paramJSONArray.length() < 3) {
              return false;
            }
            paramd = paramJSONArray.optJSONArray(1);
            if ((paramd == null) || (paramd.length() < 3)) {
              return false;
            }
            f1 = h.d(paramd, 0);
            f2 = h.d(paramd, 1);
            f3 = h.d(paramd, 2);
            if (f3 <= 0.0F)
            {
              c.i("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle(radial) failed, sr(%s) <= 0.", new Object[] { Float.valueOf(f3) });
              return false;
            }
            paramd = paramJSONArray.optJSONArray(2);
            paramJSONArray = new int[paramd.length()];
            localObject = new float[paramd.length()];
            i = 0;
            while (i < paramd.length())
            {
              localJSONArray = paramd.optJSONArray(i);
              if (localJSONArray.length() >= 2)
              {
                localObject[i] = ((float)localJSONArray.optDouble(0));
                paramJSONArray[i] = h.l(localJSONArray.optJSONArray(1));
              }
              i += 1;
            }
            paramCanvas.setShader(new RadialGradient(f1, f2, f3, paramJSONArray, (float[])localObject, Shader.TileMode.CLAMP));
          }
          else
          {
            if (!"normal".equalsIgnoreCase((String)localObject)) {
              break;
            }
            paramd = paramJSONArray.optJSONArray(1);
            if ((paramd == null) || (paramd.length() < 4)) {
              return false;
            }
            paramCanvas.setShader(null);
            paramCanvas.setColor(h.l(paramd));
          }
        }
      } while (!"pattern".equalsIgnoreCase((String)localObject));
      localObject = paramJSONArray.optString(1);
      paramJSONArray = paramJSONArray.optString(2);
      if (bk.bl((String)localObject))
      {
        c.w("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle failed, type is pattern but image path is null or nil.");
        return false;
      }
      paramd = paramd.fLv.a(paramd, (String)localObject);
    } while ((paramd == null) || (paramd.isRecycled()));
    int j = h.my(paramd.getWidth());
    int k = h.my(paramd.getHeight());
    int i = -1;
    switch (paramJSONArray.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        label592:
        paramd = null;
      }
      break;
    }
    for (;;)
    {
      paramCanvas.setShader(paramd);
      break;
      if (!paramJSONArray.equals("repeat")) {
        break label592;
      }
      i = 0;
      break label592;
      if (!paramJSONArray.equals("repeat-x")) {
        break label592;
      }
      i = 1;
      break label592;
      if (!paramJSONArray.equals("repeat-y")) {
        break label592;
      }
      i = 2;
      break label592;
      if (!paramJSONArray.equals("no-repeat")) {
        break label592;
      }
      i = 3;
      break label592;
      paramd = new BitmapShader(Bitmap.createScaledBitmap(paramd, j, k, false), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      continue;
      paramJSONArray = Bitmap.createBitmap(j, k + 1, Bitmap.Config.ARGB_8888);
      new Canvas(paramJSONArray).drawBitmap(paramd, new Rect(0, 0, paramd.getWidth(), paramd.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      paramd = new BitmapShader(paramJSONArray, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
      continue;
      paramJSONArray = Bitmap.createBitmap(j + 1, k, Bitmap.Config.ARGB_8888);
      new Canvas(paramJSONArray).drawBitmap(paramd, new Rect(0, 0, paramd.getWidth(), paramd.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      paramd = new BitmapShader(paramJSONArray, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
      continue;
      paramJSONArray = Bitmap.createBitmap(j + 1, k + 1, Bitmap.Config.ARGB_8888);
      new Canvas(paramJSONArray).drawBitmap(paramd, new Rect(0, 0, paramd.getWidth(), paramd.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      paramd = new BitmapShader(paramJSONArray, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }
  }
  
  public final BaseDrawActionArg adE()
  {
    return new SetFillStyleActionArg();
  }
  
  public final String getMethod()
  {
    return "setFillStyle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.q
 * JD-Core Version:    0.7.0.1
 */