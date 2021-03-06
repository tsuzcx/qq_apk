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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;

public final class q
  implements d
{
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, DrawActionArg paramDrawActionArg)
  {
    AppMethodBeat.i(144916);
    paramDrawActionArg = (SetFillStyleActionArg)paramDrawActionArg;
    if (paramDrawActionArg == null)
    {
      AppMethodBeat.o(144916);
      return false;
    }
    boolean bool = paramDrawActionArg.a(paramd, paramCanvas);
    AppMethodBeat.o(144916);
    return bool;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.canvas.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(144915);
    if (paramJSONArray.length() < 2)
    {
      AppMethodBeat.o(144915);
      return false;
    }
    Object localObject = paramJSONArray.optString(0);
    paramCanvas = paramd.qTj;
    float f1;
    float f2;
    float f3;
    JSONArray localJSONArray;
    if ("linear".equalsIgnoreCase((String)localObject))
    {
      if (paramJSONArray.length() < 3)
      {
        AppMethodBeat.o(144915);
        return false;
      }
      paramd = paramJSONArray.optJSONArray(1);
      if ((paramd == null) || (paramd.length() < 4))
      {
        AppMethodBeat.o(144915);
        return false;
      }
      f1 = i.f(paramd, 0);
      f2 = i.f(paramd, 1);
      f3 = i.f(paramd, 2);
      float f4 = i.f(paramd, 3);
      paramd = paramJSONArray.optJSONArray(2);
      if ((paramd == null) || (paramd.length() == 0))
      {
        AppMethodBeat.o(144915);
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
          paramJSONArray[i] = i.u(localJSONArray.optJSONArray(1));
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
          AppMethodBeat.o(144915);
          return true;
          if ("radial".equalsIgnoreCase((String)localObject))
          {
            if (paramJSONArray.length() < 3)
            {
              AppMethodBeat.o(144915);
              return false;
            }
            paramd = paramJSONArray.optJSONArray(1);
            if ((paramd == null) || (paramd.length() < 3))
            {
              AppMethodBeat.o(144915);
              return false;
            }
            f1 = i.f(paramd, 0);
            f2 = i.f(paramd, 1);
            f3 = i.f(paramd, 2);
            if (f3 <= 0.0F)
            {
              Log.i("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle(radial) failed, sr(%s) <= 0.", new Object[] { Float.valueOf(f3) });
              AppMethodBeat.o(144915);
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
                paramJSONArray[i] = i.u(localJSONArray.optJSONArray(1));
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
            if ((paramd == null) || (paramd.length() < 4))
            {
              AppMethodBeat.o(144915);
              return false;
            }
            paramCanvas.setShader(null);
            paramCanvas.setColor(i.u(paramd));
          }
        }
      } while (!"pattern".equalsIgnoreCase((String)localObject));
      localObject = paramJSONArray.optString(1);
      paramJSONArray = paramJSONArray.optString(2);
      if (Util.isNullOrNil((String)localObject))
      {
        Log.w("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle failed, type is pattern but image path is null or nil.");
        AppMethodBeat.o(144915);
        return false;
      }
      paramd = paramd.qTo.a(paramd, (String)localObject);
    } while ((paramd == null) || (paramd.isRecycled()));
    int j = i.DC(paramd.getWidth());
    int k = i.DC(paramd.getHeight());
    int i = -1;
    switch (paramJSONArray.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        label648:
        paramd = null;
      }
      break;
    }
    for (;;)
    {
      paramCanvas.setShader(paramd);
      break;
      if (!paramJSONArray.equals("repeat")) {
        break label648;
      }
      i = 0;
      break label648;
      if (!paramJSONArray.equals("repeat-x")) {
        break label648;
      }
      i = 1;
      break label648;
      if (!paramJSONArray.equals("repeat-y")) {
        break label648;
      }
      i = 2;
      break label648;
      if (!paramJSONArray.equals("no-repeat")) {
        break label648;
      }
      i = 3;
      break label648;
      paramd = Bitmap.createScaledBitmap(paramd, j, k, false);
      paramJSONArray = Shader.TileMode.REPEAT;
      paramd = new BitmapShader(paramd, paramJSONArray, paramJSONArray);
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
      paramd = Shader.TileMode.CLAMP;
      paramd = new BitmapShader(paramJSONArray, paramd, paramd);
    }
  }
  
  public final BaseDrawActionArg cjY()
  {
    AppMethodBeat.i(144914);
    SetFillStyleActionArg localSetFillStyleActionArg = new SetFillStyleActionArg();
    AppMethodBeat.o(144914);
    return localSetFillStyleActionArg;
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