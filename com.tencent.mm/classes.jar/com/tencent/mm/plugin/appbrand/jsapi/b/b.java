package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 373;
  public static final String NAME = "canvasPutImageData";
  
  private static int[] j(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(103843);
    paramByteBuffer = d.m(paramByteBuffer);
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
    AppMethodBeat.o(103843);
    return arrayOfInt;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(103842);
    int n;
    try
    {
      n = paramJSONObject.getInt("canvasId");
      localObject1 = ((f)paramc.q(f.class)).d(paramc);
      if (localObject1 == null)
      {
        ab.w("MicroMsg.JsApiCanvasPutImageData", "invoke JsApi canvasPutImageData failed, component view is null.");
        paramc.h(paramInt, j("fail:page is null", null));
        AppMethodBeat.o(103842);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      ab.i("MicroMsg.JsApiCanvasPutImageData", "get canvas id failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
      paramc.h(paramInt, j("fail:illegal canvasId", null));
      AppMethodBeat.o(103842);
      return;
    }
    Object localObject1 = ((e)localObject1).vC().getViewById(n);
    if (localObject1 == null)
    {
      ab.w("MicroMsg.JsApiCanvasPutImageData", "view(%s) is null.", new Object[] { Integer.valueOf(n) });
      paramc.h(paramInt, j("fail:view is null", null));
      AppMethodBeat.o(103842);
      return;
    }
    if (!(localObject1 instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiCanvasPutImageData", "the viewId is not a canvas(%s).", new Object[] { Integer.valueOf(n) });
      paramc.h(paramInt, j("fail:illegal view type", null));
      AppMethodBeat.o(103842);
      return;
    }
    localObject1 = (View)((CoverViewContainer)localObject1).aa(View.class);
    if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a))
    {
      ab.i("MicroMsg.JsApiCanvasPutImageData", "the view is not a instance of CanvasView.(%s)", new Object[] { Integer.valueOf(n) });
      paramc.h(paramInt, j("fail:illegal view type", null));
      AppMethodBeat.o(103842);
      return;
    }
    float f = g.aNP();
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
      ab.i("MicroMsg.JsApiCanvasPutImageData", "width(%s) or height(%s) is 0.(%s)", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n) });
      paramc.h(paramInt, j("fail:width or height is 0", null));
      AppMethodBeat.o(103842);
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
              ab.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, value is not a ByteBuffer");
              paramc.h(paramInt, j("fail:illegal data", null));
              AppMethodBeat.o(103842);
              return;
            }
            localObject2 = (ByteBuffer)paramJSONObject;
            paramJSONObject = new JSONArray();
            localObject2 = j((ByteBuffer)localObject2);
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
            localObject1 = (com.tencent.mm.plugin.appbrand.canvas.widget.a)localObject1;
            ((com.tencent.mm.plugin.appbrand.canvas.widget.a)localObject1).b(paramJSONObject, new b.1(this, paramc, paramInt));
            ((com.tencent.mm.plugin.appbrand.canvas.widget.a)localObject1).axT();
            AppMethodBeat.o(103842);
            return;
          }
          catch (JSONException paramJSONObject)
          {
            ab.w("MicroMsg.JsApiCanvasPutImageData", "put json value error : %s", new Object[] { paramJSONObject });
            paramc.h(paramInt, j("fail:build action JSON error", null));
            AppMethodBeat.o(103842);
            return;
          }
          paramJSONObject = paramJSONObject;
          ab.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
          paramc.h(paramInt, j("fail:missing data", null));
          AppMethodBeat.o(103842);
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