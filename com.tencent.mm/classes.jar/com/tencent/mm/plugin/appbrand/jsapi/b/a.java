package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.u.h;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 372;
  public static final String NAME = "canvasGetImageData";
  
  private static Map<String, Object> d(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    Object localObject = new byte[paramArrayOfInt.length * 4];
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfInt.length; j = k + 1)
    {
      k = j + 1;
      localObject[j] = ((byte)(paramArrayOfInt[i] >> 16 & 0xFF));
      j = k + 1;
      localObject[k] = ((byte)(paramArrayOfInt[i] >> 8 & 0xFF));
      k = j + 1;
      localObject[j] = ((byte)(paramArrayOfInt[i] & 0xFF));
      localObject[k] = ((byte)(paramArrayOfInt[i] >> 24 & 0xFF));
      i += 1;
    }
    paramArrayOfInt = ByteBuffer.wrap((byte[])localObject);
    localObject = new HashMap();
    ((Map)localObject).put("data", paramArrayOfInt);
    ((Map)localObject).put("width", Integer.valueOf(paramInt1));
    ((Map)localObject).put("height", Integer.valueOf(paramInt2));
    return localObject;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    int i7;
    try
    {
      i7 = paramJSONObject.getInt("canvasId");
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.i(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).a(paramc);
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, component view is null.");
        paramc.C(paramInt, h("fail:page is null", null));
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
      paramc.C(paramInt, h("fail:illegal canvasId", null));
      return;
    }
    Object localObject = ((e)localObject).agW().mg(i7);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", new Object[] { Integer.valueOf(i7) });
      paramc.C(paramInt, h("fail:view is null", null));
      return;
    }
    if (!(localObject instanceof CoverViewContainer))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", new Object[] { Integer.valueOf(i7) });
      paramc.C(paramInt, h("fail:illegal view type", null));
      return;
    }
    localObject = (View)((CoverViewContainer)localObject).K(View.class);
    if (!(localObject instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", new Object[] { Integer.valueOf(i7) });
      paramc.C(paramInt, h("fail:illegal view type", null));
      return;
    }
    float f = h.aqo();
    int m = paramJSONObject.optInt("x");
    int n = paramJSONObject.optInt("y");
    int i = paramJSONObject.optInt("width");
    int i1 = paramJSONObject.optInt("height");
    if ((i == 0) || (i1 == 0))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(i7) });
      paramc.C(paramInt, h("fail:width or height is 0", null));
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
        i = -i1;
        n += i1;
        i1 = i;
      }
      for (;;)
      {
        int j = Math.round(m * f);
        int i4 = Math.round(n * f);
        int i6 = Math.round(k * f);
        int i5 = Math.round(i1 * f);
        i = ((View)localObject).getMeasuredWidth();
        int i8 = ((View)localObject).getMeasuredHeight();
        if (j < 0) {}
        label784:
        label879:
        label886:
        for (int i2 = 0;; i2 = j)
        {
          if (i4 < 0) {}
          for (int i3 = 0;; i3 = i4)
          {
            if (j + i6 > i)
            {
              i -= i2;
              if (i4 + i5 <= i8) {
                break label784;
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
                paramJSONObject = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
                com.tencent.mm.plugin.appbrand.canvas.f localf = new com.tencent.mm.plugin.appbrand.canvas.f(paramJSONObject);
                localf.save();
                localf.translate(-i2, -i3);
                ((com.tencent.mm.plugin.appbrand.canvas.widget.a)localObject).f(localf);
                localf.restore();
                paramJSONObject = Bitmap.createScaledBitmap(paramJSONObject, i6, i8, false);
                localObject = new int[k * i1];
                paramJSONObject.getPixels((int[])localObject, (i5 - n) * k + (i4 - m), k, 0, 0, i6, i8);
                paramc.C(paramInt, a(paramc, "ok", d((int[])localObject, k, i1)));
                return;
              }
              catch (Exception paramJSONObject)
              {
                com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i7), paramJSONObject });
                paramc.C(paramInt, h("fail:create bitmap failed", null));
                return;
              }
              if (j < i) {
                break label886;
              }
              paramc.C(paramInt, a(paramc, "ok", d(new int[k * i1], k, i1)));
              return;
              if (i4 < i8) {
                break label879;
              }
              paramc.C(paramInt, a(paramc, "ok", d(new int[k * i1], k, i1)));
              return;
              if (j + i6 <= 0)
              {
                paramc.C(paramInt, a(paramc, "ok", d(new int[k * i1], k, i1)));
                return;
              }
              i = i6;
              if (j >= 0) {
                break;
              }
              i = i6 + j;
              break;
              if (i4 + i5 <= 0)
              {
                paramc.C(paramInt, a(paramc, "ok", d(new int[k * i1], k, i1)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.a
 * JD-Core Version:    0.7.0.1
 */