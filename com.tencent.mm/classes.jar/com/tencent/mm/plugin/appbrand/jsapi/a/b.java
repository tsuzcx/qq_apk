package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 372;
  public static final String NAME = "canvasGetImageData";
  
  private static Map<String, Object> e(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145525);
    paramArrayOfInt = u(paramArrayOfInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramArrayOfInt);
    localHashMap.put("width", Integer.valueOf(paramInt1));
    localHashMap.put("height", Integer.valueOf(paramInt2));
    AppMethodBeat.o(145525);
    return localHashMap;
  }
  
  private static ByteBuffer u(int[] paramArrayOfInt)
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
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145524);
    int i7;
    try
    {
      i7 = paramJSONObject.getInt("canvasId");
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramc.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramc, paramJSONObject);
      if (localObject1 == null)
      {
        ad.w("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, component view is null.");
        paramc.h(paramInt, e("fail:page is null", null));
        AppMethodBeat.o(145524);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      ad.i("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
      paramc.h(paramInt, e("fail:illegal canvasId", null));
      AppMethodBeat.o(145524);
      return;
    }
    Object localObject1 = ((e)localObject1).fG(paramJSONObject.optBoolean("independent", false)).getViewById(i7);
    if (localObject1 == null)
    {
      ad.w("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", new Object[] { Integer.valueOf(i7) });
      paramc.h(paramInt, e("fail:view is null", null));
      AppMethodBeat.o(145524);
      return;
    }
    if (!(localObject1 instanceof CoverViewContainer))
    {
      ad.w("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", new Object[] { Integer.valueOf(i7) });
      paramc.h(paramInt, e("fail:illegal view type", null));
      AppMethodBeat.o(145524);
      return;
    }
    localObject1 = (View)((CoverViewContainer)localObject1).ax(View.class);
    if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a))
    {
      ad.i("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", new Object[] { Integer.valueOf(i7) });
      paramc.h(paramInt, e("fail:illegal view type", null));
      AppMethodBeat.o(145524);
      return;
    }
    float f = com.tencent.mm.plugin.appbrand.z.g.bBm();
    int m = paramJSONObject.optInt("x");
    int n = paramJSONObject.optInt("y");
    int i = paramJSONObject.optInt("width");
    int i1 = paramJSONObject.optInt("height");
    if ((i == 0) || (i1 == 0))
    {
      ad.i("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(i7) });
      paramc.h(paramInt, e("fail:width or height is 0", null));
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
                f localf = new f((Bitmap)localObject2);
                localf.save();
                localf.translate(-i2, -i3);
                ((com.tencent.mm.plugin.appbrand.canvas.widget.a)localObject1).h(localf);
                localf.restore();
                localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, i6, i8, false);
                localObject2 = new int[k * i1];
              }
              catch (Exception paramJSONObject)
              {
                Object localObject2;
                ad.w("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i7), paramJSONObject });
                paramc.h(paramInt, e("fail:create bitmap failed", null));
                AppMethodBeat.o(145524);
                return;
              }
              try
              {
                ((Bitmap)localObject1).getPixels((int[])localObject2, (i5 - n) * k + (i4 - m), k, 0, 0, i6, i8);
                paramc.h(paramInt, a(paramc, "ok", e((int[])localObject2, k, i1)));
                AppMethodBeat.o(145524);
                return;
              }
              catch (Exception localException)
              {
                ad.w("MicroMsg.JsApiCanvasGetImageData", "getPixels failed, viewId(%s). Exception: %s", new Object[] { Integer.valueOf(i7), localException });
                ad.w("MicroMsg.JsApiCanvasGetImageData", "getPixels failed. finalXDp:%f finalYDp:%f finalWidthDp:%f finalHeightDp:%f wDp:%f data:%s", new Object[] { Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i8), Integer.valueOf(k), paramJSONObject });
                paramc.h(paramInt, e("fail: getPixels failed", null));
                AppMethodBeat.o(145524);
                return;
              }
              if (j < i) {
                break label1064;
              }
              paramc.h(paramInt, a(paramc, "ok", e(new int[k * i1], k, i1)));
              AppMethodBeat.o(145524);
              return;
              if (i4 < i8) {
                break label1057;
              }
              paramc.h(paramInt, a(paramc, "ok", e(new int[k * i1], k, i1)));
              AppMethodBeat.o(145524);
              return;
              if (j + i6 <= 0)
              {
                paramc.h(paramInt, a(paramc, "ok", e(new int[k * i1], k, i1)));
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
                paramc.h(paramInt, a(paramc, "ok", e(new int[k * i1], k, i1)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.b
 * JD-Core Version:    0.7.0.1
 */