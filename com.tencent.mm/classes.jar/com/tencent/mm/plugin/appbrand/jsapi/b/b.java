package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.u.d;
import com.tencent.mm.plugin.appbrand.u.h;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 373;
  public static final String NAME = "canvasPutImageData";
  
  private static int[] i(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = d.k(paramByteBuffer);
    int[] arrayOfInt = new int[paramByteBuffer.length / 4];
    int i = 0;
    int k;
    for (int j = 0; i < arrayOfInt.length; j = k + 1)
    {
      k = j + 1;
      j = paramByteBuffer[j];
      int m = k + 1;
      int n = paramByteBuffer[k];
      k = m + 1;
      m = paramByteBuffer[m];
      arrayOfInt[i] = ((paramByteBuffer[k] & 0xFF) << 24 | m & 0xFF | (n & 0xFF) << 8 | (j & 0xFF) << 16);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    int n;
    try
    {
      n = paramJSONObject.getInt("canvasId");
      localObject1 = ((f)paramc.i(f.class)).a(paramc);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasPutImageData", "invoke JsApi canvasPutImageData failed, component view is null.");
        paramc.C(paramInt, h("fail:page is null", null));
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiCanvasPutImageData", "get canvas id failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
      paramc.C(paramInt, h("fail:illegal canvasId", null));
      return;
    }
    Object localObject1 = ((e)localObject1).agW().mg(n);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasPutImageData", "view(%s) is null.", new Object[] { Integer.valueOf(n) });
      paramc.C(paramInt, h("fail:view is null", null));
      return;
    }
    if (!(localObject1 instanceof CoverViewContainer))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasPutImageData", "the viewId is not a canvas(%s).", new Object[] { Integer.valueOf(n) });
      paramc.C(paramInt, h("fail:illegal view type", null));
      return;
    }
    localObject1 = (View)((CoverViewContainer)localObject1).K(View.class);
    if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiCanvasPutImageData", "the view is not a instance of CanvasView.(%s)", new Object[] { Integer.valueOf(n) });
      paramc.C(paramInt, h("fail:illegal view type", null));
      return;
    }
    float f = h.aqo();
    int j = paramJSONObject.optInt("x");
    int m = paramJSONObject.optInt("y");
    int i = paramJSONObject.optInt("width");
    int k = paramJSONObject.optInt("height");
    Math.round(j * f);
    Math.round(m * f);
    Math.round(i * f);
    Math.round(f * k);
    if ((i == 0) || (k == 0))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiCanvasPutImageData", "width(%s) or height(%s) is 0.(%s)", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n) });
      paramc.C(paramInt, h("fail:width or height is 0", null));
      return;
    }
    if (i < 0)
    {
      j += i;
      i = -i;
    }
    for (;;)
    {
      if (k < 0)
      {
        m += k;
        k = -k;
      }
      for (;;)
      {
        try
        {
          paramJSONObject = paramJSONObject.get("data");
          if (!(paramJSONObject instanceof ByteBuffer))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, value is not a ByteBuffer");
            paramc.C(paramInt, h("fail:illegal data", null));
            return;
          }
        }
        catch (JSONException paramJSONObject)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
          paramc.C(paramInt, h("fail:missing data", null));
          return;
        }
        Object localObject2 = (ByteBuffer)paramJSONObject;
        paramJSONObject = new JSONArray();
        localObject2 = i((ByteBuffer)localObject2);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put(j);
          localJSONArray.put(m);
          localJSONArray.put(i);
          localJSONArray.put(k);
          localJSONArray.put(Bitmap.createBitmap((int[])localObject2, i, k, Bitmap.Config.ARGB_8888));
          localJSONObject.put("method", "__setPixels");
          localJSONObject.put("data", localJSONArray);
          paramJSONObject.put(localJSONObject);
          localObject1 = (com.tencent.mm.plugin.appbrand.canvas.widget.a)localObject1;
          ((com.tencent.mm.plugin.appbrand.canvas.widget.a)localObject1).b(paramJSONObject, new b.1(this, paramc, paramInt));
          ((com.tencent.mm.plugin.appbrand.canvas.widget.a)localObject1).adB();
          return;
        }
        catch (JSONException paramJSONObject)
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasPutImageData", "put json value error : %s", new Object[] { paramJSONObject });
          paramc.C(paramInt, h("fail:build action JSON error", null));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.b
 * JD-Core Version:    0.7.0.1
 */