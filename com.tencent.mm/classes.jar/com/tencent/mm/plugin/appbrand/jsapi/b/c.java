package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.d<f>
{
  public static final int CTRL_INDEX = 373;
  public static final String NAME = "canvasPutImageData";
  
  private static int[] m(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(145529);
    paramByteBuffer = com.tencent.mm.plugin.appbrand.ac.d.p(paramByteBuffer);
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
    AppMethodBeat.o(145529);
    return arrayOfInt;
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145528);
    int n;
    try
    {
      n = paramJSONObject.getInt("canvasId");
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramf.M(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramf, paramJSONObject);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasPutImageData", "invoke JsApi canvasPutImageData failed, component view is null.");
        paramf.i(paramInt, h("fail:page is null", null));
        AppMethodBeat.o(145528);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiCanvasPutImageData", "get canvas id failed, %s", new Object[] { android.util.Log.getStackTraceString(paramJSONObject) });
      paramf.i(paramInt, h("fail:illegal canvasId", null));
      AppMethodBeat.o(145528);
      return;
    }
    Object localObject1 = ((h)localObject1).gA(paramJSONObject.optBoolean("independent", false)).getViewById(n);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasPutImageData", "view(%s) is null.", new Object[] { Integer.valueOf(n) });
      paramf.i(paramInt, h("fail:view is null", null));
      AppMethodBeat.o(145528);
      return;
    }
    if (!(localObject1 instanceof CoverViewContainer))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasPutImageData", "the viewId is not a canvas(%s).", new Object[] { Integer.valueOf(n) });
      paramf.i(paramInt, h("fail:illegal view type", null));
      AppMethodBeat.o(145528);
      return;
    }
    localObject1 = (View)((CoverViewContainer)localObject1).aB(View.class);
    if (!(localObject1 instanceof a))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiCanvasPutImageData", "the view is not a instance of CanvasView.(%s)", new Object[] { Integer.valueOf(n) });
      paramf.i(paramInt, h("fail:illegal view type", null));
      AppMethodBeat.o(145528);
      return;
    }
    float f = com.tencent.mm.plugin.appbrand.ac.g.bZk();
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
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiCanvasPutImageData", "width(%s) or height(%s) is 0.(%s)", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n) });
      paramf.i(paramInt, h("fail:width or height is 0", null));
      AppMethodBeat.o(145528);
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
        try
        {
          Object localObject2;
          JSONObject localJSONObject;
          JSONArray localJSONArray;
          for (;;)
          {
            paramJSONObject = paramJSONObject.get("data");
            if (!(paramJSONObject instanceof ByteBuffer))
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, value is not a ByteBuffer");
              paramf.i(paramInt, h("fail:illegal data", null));
              AppMethodBeat.o(145528);
              return;
            }
            localObject2 = (ByteBuffer)paramJSONObject;
            paramJSONObject = new JSONArray();
            localObject2 = m((ByteBuffer)localObject2);
            localJSONObject = new JSONObject();
          }
        }
        catch (JSONException paramJSONObject)
        {
          try
          {
            localJSONArray = new JSONArray();
            localJSONArray.put(j);
            localJSONArray.put(m);
            localJSONArray.put(i);
            localJSONArray.put(k);
            localJSONArray.put(Bitmap.createBitmap((int[])localObject2, i, k, Bitmap.Config.ARGB_8888));
            localJSONObject.put("method", "__setPixels");
            localJSONObject.put("data", localJSONArray);
            paramJSONObject.put(localJSONObject);
            localObject1 = (a)localObject1;
            ((a)localObject1).b(paramJSONObject, new a.a()
            {
              public final void a(DrawCanvasArg paramAnonymousDrawCanvasArg)
              {
                AppMethodBeat.i(145527);
                paramf.i(paramInt, c.this.h("ok", null));
                AppMethodBeat.o(145527);
              }
            });
            ((a)localObject1).bzg();
            AppMethodBeat.o(145528);
            return;
          }
          catch (JSONException paramJSONObject)
          {
            com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiCanvasPutImageData", "put json value error : %s", new Object[] { paramJSONObject });
            paramf.i(paramInt, h("fail:build action JSON error", null));
            AppMethodBeat.o(145528);
            return;
          }
          paramJSONObject = paramJSONObject;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, %s", new Object[] { android.util.Log.getStackTraceString(paramJSONObject) });
          paramf.i(paramInt, h("fail:missing data", null));
          AppMethodBeat.o(145528);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.c
 * JD-Core Version:    0.7.0.1
 */