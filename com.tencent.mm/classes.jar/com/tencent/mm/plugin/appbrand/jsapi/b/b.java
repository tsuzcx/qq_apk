package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends d<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 372;
  public static final String NAME = "canvasGetImageData";
  
  private static Map<String, Object> e(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145525);
    paramArrayOfInt = v(paramArrayOfInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramArrayOfInt);
    localHashMap.put("width", Integer.valueOf(paramInt1));
    localHashMap.put("height", Integer.valueOf(paramInt2));
    AppMethodBeat.o(145525);
    return localHashMap;
  }
  
  private static ByteBuffer v(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(145526);
    byte[] arrayOfByte = new byte[paramArrayOfInt.length * 4];
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfInt.length; j = k + 1)
    {
      k = j + 1;
      arrayOfByte[j] = ((byte)(paramArrayOfInt[i] >> 16 & 0xFF));
      j = k + 1;
      arrayOfByte[k] = ((byte)(paramArrayOfInt[i] >> 8 & 0xFF));
      k = j + 1;
      arrayOfByte[j] = ((byte)(paramArrayOfInt[i] & 0xFF));
      arrayOfByte[k] = ((byte)(paramArrayOfInt[i] >> 24 & 0xFF));
      i += 1;
    }
    paramArrayOfInt = ByteBuffer.wrap(arrayOfByte);
    AppMethodBeat.o(145526);
    return paramArrayOfInt;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145524);
    int i7;
    try
    {
      i7 = paramJSONObject.getInt("canvasId");
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramf.M(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramf, paramJSONObject);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, component view is null.");
        paramf.i(paramInt, h("fail:page is null", null));
        AppMethodBeat.o(145524);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", new Object[] { android.util.Log.getStackTraceString(paramJSONObject) });
      paramf.i(paramInt, h("fail:illegal canvasId", null));
      AppMethodBeat.o(145524);
      return;
    }
    Object localObject1 = ((h)localObject1).gA(paramJSONObject.optBoolean("independent", false)).getViewById(i7);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", new Object[] { Integer.valueOf(i7) });
      paramf.i(paramInt, h("fail:view is null", null));
      AppMethodBeat.o(145524);
      return;
    }
    if (!(localObject1 instanceof CoverViewContainer))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", new Object[] { Integer.valueOf(i7) });
      paramf.i(paramInt, h("fail:illegal view type", null));
      AppMethodBeat.o(145524);
      return;
    }
    localObject1 = (View)((CoverViewContainer)localObject1).aB(View.class);
    if (!(localObject1 instanceof a))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", new Object[] { Integer.valueOf(i7) });
      paramf.i(paramInt, h("fail:illegal view type", null));
      AppMethodBeat.o(145524);
      return;
    }
    float f = com.tencent.mm.plugin.appbrand.ac.g.bZk();
    int m = paramJSONObject.optInt("x");
    int n = paramJSONObject.optInt("y");
    int i = paramJSONObject.optInt("width");
    int i1 = paramJSONObject.optInt("height");
    if ((i == 0) || (i1 == 0))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(i7) });
      paramf.i(paramInt, h("fail:width or height is 0", null));
      AppMethodBeat.o(145524);
      return;
    }
    int k;
    if (i < 0)
    {
      k = -i;
      m += i;
    }
    for (;;)
    {
      if (i1 < 0)
      {
        n += i1;
        i1 = -i1;
      }
      for (;;)
      {
        int j = Math.round(m * f);
        int i4 = Math.round(n * f);
        int i6 = Math.round(k * f);
        int i5 = Math.round(i1 * f);
        i = ((View)localObject1).getMeasuredWidth();
        int i8 = ((View)localObject1).getMeasuredHeight();
        if (j < 0) {}
        label1057:
        label1064:
        for (int i2 = 0;; i2 = j)
        {
          if (i4 < 0) {}
          for (int i3 = 0;; i3 = i4)
          {
            if (j + i6 > i)
            {
              i -= i2;
              if (i4 + i5 <= i8) {
                break label850;
              }
              j = i8 - i3;
            }
            for (;;)
            {
              i4 = Math.round(i2 / f);
              i5 = Math.round(i3 / f);
              i6 = Math.round(i / f);
              i8 = Math.round(j / f);
              try
              {
                localObject2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
                com.tencent.mm.plugin.appbrand.canvas.f localf = new com.tencent.mm.plugin.appbrand.canvas.f((Bitmap)localObject2);
                localf.save();
                localf.translate(-i2, -i3);
                ((a)localObject1).o(localf);
                localf.restore();
                localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, i6, i8, false);
                localObject2 = new int[k * i1];
              }
              catch (Exception paramJSONObject)
              {
                Object localObject2;
                com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i7), paramJSONObject });
                paramf.i(paramInt, h("fail:create bitmap failed", null));
                AppMethodBeat.o(145524);
                return;
              }
              try
              {
                ((Bitmap)localObject1).getPixels((int[])localObject2, (i5 - n) * k + (i4 - m), k, 0, 0, i6, i8);
                paramf.i(paramInt, a(paramf, "ok", e((int[])localObject2, k, i1)));
                AppMethodBeat.o(145524);
                return;
              }
              catch (Exception localException)
              {
                com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasGetImageData", "getPixels failed, viewId(%s). Exception: %s", new Object[] { Integer.valueOf(i7), localException });
                com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasGetImageData", "getPixels failed. finalXDp:%d finalYDp:%d finalWidthDp:%d finalHeightDp:%d wDp:%d data:%s", new Object[] { Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i8), Integer.valueOf(k), paramJSONObject });
                paramf.i(paramInt, h("fail: getPixels failed", null));
                AppMethodBeat.o(145524);
                return;
              }
              if (j < i) {
                break label1064;
              }
              paramf.i(paramInt, a(paramf, "ok", e(new int[k * i1], k, i1)));
              AppMethodBeat.o(145524);
              return;
              if (i4 < i8) {
                break label1057;
              }
              paramf.i(paramInt, a(paramf, "ok", e(new int[k * i1], k, i1)));
              AppMethodBeat.o(145524);
              return;
              if (j + i6 <= 0)
              {
                paramf.i(paramInt, a(paramf, "ok", e(new int[k * i1], k, i1)));
                AppMethodBeat.o(145524);
                return;
              }
              i = i6;
              if (j >= 0) {
                break;
              }
              i = i6 + j;
              break;
              label850:
              if (i4 + i5 <= 0)
              {
                paramf.i(paramInt, a(paramf, "ok", e(new int[k * i1], k, i1)));
                AppMethodBeat.o(145524);
                return;
              }
              j = i5;
              if (i4 < 0) {
                j = i5 + i4;
              }
            }
          }
        }
      }
      k = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.b
 * JD-Core Version:    0.7.0.1
 */