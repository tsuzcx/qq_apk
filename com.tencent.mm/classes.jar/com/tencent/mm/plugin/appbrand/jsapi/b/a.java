package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.sdk.platformtools.ab;
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
  
  private static Map<String, Object> e(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103839);
    paramArrayOfInt = q(paramArrayOfInt);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramArrayOfInt);
    localHashMap.put("width", Integer.valueOf(paramInt1));
    localHashMap.put("height", Integer.valueOf(paramInt2));
    AppMethodBeat.o(103839);
    return localHashMap;
  }
  
  private static ByteBuffer q(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(103840);
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
    AppMethodBeat.o(103840);
    return paramArrayOfInt;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(103838);
    int i7;
    try
    {
      i7 = paramJSONObject.getInt("canvasId");
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.q(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).d(paramc);
      if (localObject == null)
      {
        ab.w("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, component view is null.");
        paramc.h(paramInt, j("fail:page is null", null));
        AppMethodBeat.o(103838);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      ab.i("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
      paramc.h(paramInt, j("fail:illegal canvasId", null));
      AppMethodBeat.o(103838);
      return;
    }
    Object localObject = ((e)localObject).vC().getViewById(i7);
    if (localObject == null)
    {
      ab.w("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", new Object[] { Integer.valueOf(i7) });
      paramc.h(paramInt, j("fail:view is null", null));
      AppMethodBeat.o(103838);
      return;
    }
    if (!(localObject instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", new Object[] { Integer.valueOf(i7) });
      paramc.h(paramInt, j("fail:illegal view type", null));
      AppMethodBeat.o(103838);
      return;
    }
    localObject = (View)((CoverViewContainer)localObject).aa(View.class);
    if (!(localObject instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a))
    {
      ab.i("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", new Object[] { Integer.valueOf(i7) });
      paramc.h(paramInt, j("fail:illegal view type", null));
      AppMethodBeat.o(103838);
      return;
    }
    float f = g.aNP();
    int m = paramJSONObject.optInt("x");
    int n = paramJSONObject.optInt("y");
    int i = paramJSONObject.optInt("width");
    int i1 = paramJSONObject.optInt("height");
    if ((i == 0) || (i1 == 0))
    {
      ab.i("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(i7) });
      paramc.h(paramInt, j("fail:width or height is 0", null));
      AppMethodBeat.o(103838);
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
        label944:
        label951:
        for (int i2 = 0;; i2 = j)
        {
          if (i4 < 0) {}
          for (int i3 = 0;; i3 = i4)
          {
            if (j + i6 > i)
            {
              i -= i2;
              if (i4 + i5 <= i8) {
                break label839;
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
                paramc.h(paramInt, a(paramc, "ok", e((int[])localObject, k, i1)));
                AppMethodBeat.o(103838);
                return;
              }
              catch (Exception paramJSONObject)
              {
                ab.w("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i7), paramJSONObject });
                paramc.h(paramInt, j("fail:create bitmap failed", null));
                AppMethodBeat.o(103838);
                return;
              }
              if (j < i) {
                break label951;
              }
              paramc.h(paramInt, a(paramc, "ok", e(new int[k * i1], k, i1)));
              AppMethodBeat.o(103838);
              return;
              if (i4 < i8) {
                break label944;
              }
              paramc.h(paramInt, a(paramc, "ok", e(new int[k * i1], k, i1)));
              AppMethodBeat.o(103838);
              return;
              if (j + i6 <= 0)
              {
                paramc.h(paramInt, a(paramc, "ok", e(new int[k * i1], k, i1)));
                AppMethodBeat.o(103838);
                return;
              }
              i = i6;
              if (j >= 0) {
                break;
              }
              i = i6 + j;
              break;
              label839:
              if (i4 + i5 <= 0)
              {
                paramc.h(paramInt, a(paramc, "ok", e(new int[k * i1], k, i1)));
                AppMethodBeat.o(103838);
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