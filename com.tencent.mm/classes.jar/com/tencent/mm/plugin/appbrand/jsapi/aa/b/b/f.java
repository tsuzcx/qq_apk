package com.tencent.mm.plugin.appbrand.jsapi.aa.b.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.b.d
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(139464);
    int i;
    if ((paramJSONObject != null) && (paramJSONObject.has("data"))) {
      i = 1;
    }
    int k;
    int m;
    float f1;
    float f2;
    Object localObject1;
    Object localObject2;
    int j;
    for (;;)
    {
      if (i == 0) {
        break label838;
      }
      ad.i("MicroMsg.JsApiXWebCanvasToTempFilePath", "invokeXWebCanvasJsApi data:%s", new Object[] { paramJSONObject });
      k = paramJSONObject.optInt("width", 300);
      m = paramJSONObject.optInt("height", 150);
      f1 = bt.getFloat(paramJSONObject.optString("destWidth"), k);
      f2 = bt.getFloat(paramJSONObject.optString("destHeight"), m);
      try
      {
        localObject1 = paramJSONObject.get("data");
        if (!(localObject1 instanceof ByteBuffer))
        {
          ad.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, value is not a ByteBuffer");
          paramc.h(paramInt, e("fail:illegal data", null));
          AppMethodBeat.o(139464);
          return;
          i = 0;
        }
        else
        {
          localObject1 = (ByteBuffer)localObject1;
          localObject1 = com.tencent.mm.plugin.appbrand.aa.d.q((ByteBuffer)localObject1);
          localObject2 = new int[localObject1.length / 4];
          j = 0;
          i = 0;
          while (i < localObject2.length)
          {
            int i1 = j + 1;
            int n = localObject1[j];
            j = i1 + 1;
            i1 = localObject1[i1];
            int i2 = j + 1;
            int i3 = localObject1[j];
            j = i2 + 1;
            localObject2[i] = ((localObject1[i2] & 0xFF) << 24 | i3 & 0xFF | (n & 0xFF) << 16 | (i1 & 0xFF) << 8);
            i += 1;
          }
          localObject1 = null;
        }
      }
      catch (JSONException paramJSONObject)
      {
        ad.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
        paramc.h(paramInt, e("fail:missing data", null));
        AppMethodBeat.o(139464);
        return;
      }
    }
    try
    {
      localObject2 = Bitmap.createBitmap((int[])localObject2, k, m, Bitmap.Config.ARGB_8888);
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ad.m("MicroMsg.JsApiXWebCanvasToTempFilePath", "create bitmap fail:%s", new Object[] { localException1 });
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        ad.m("MicroMsg.JsApiXWebCanvasToTempFilePath", "create bitmap fail:%s", new Object[] { localThrowable1 });
      }
      if (((Bitmap)localObject1).getWidth() != f1) {
        break label437;
      }
      Object localObject3 = localObject1;
      if (((Bitmap)localObject1).getHeight() == f2) {
        break label480;
      }
      label437:
      i = (int)f1;
      j = (int)f2;
      try
      {
        localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject1, i, j, false);
        ad.i("MicroMsg.JsApiXWebCanvasToTempFilePath", "bitmap recycle %s %s ", new Object[] { localObject1, localObject3 });
        label480:
        if (localObject3 != null) {
          break label562;
        }
        ad.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "oriBitmap is null, err, return");
        paramc.h(paramInt, e("fail:illegal bitmap", null));
        AppMethodBeat.o(139464);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.m("MicroMsg.JsApiXWebCanvasToTempFilePath", "create scaledbitmap fail:%s", new Object[] { localException2 });
          Object localObject4 = localObject1;
        }
      }
      catch (Throwable localThrowable2)
      {
        Object localObject5;
        for (;;)
        {
          ad.m("MicroMsg.JsApiXWebCanvasToTempFilePath", "create scaledbitmap fail:%s", new Object[] { localThrowable2 });
          localObject5 = localObject1;
        }
        label562:
        Bitmap.CompressFormat localCompressFormat = L(paramJSONObject);
        if (localCompressFormat != Bitmap.CompressFormat.JPEG) {
          break label653;
        }
        label653:
        for (localObject1 = "jpg";; localObject1 = "png")
        {
          localObject6 = paramc.Ee().ER("canvas_" + System.currentTimeMillis() + "." + (String)localObject1);
          if (localObject6 != null) {
            break;
          }
          ad.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, alloc file failed");
          paramc.h(paramInt, e("fail alloc file failed", null));
          AppMethodBeat.o(139464);
          return;
        }
        Object localObject6 = q.B(((e)localObject6).fhU());
        ad.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, savePath = %s", new Object[] { localObject6 });
        try
        {
          com.tencent.mm.sdk.platformtools.f.a(localObject5, K(paramJSONObject), localCompressFormat, (String)localObject6, true);
          paramJSONObject = new i();
          paramc.Ee().a(new e((String)localObject6), (String)localObject1, true, paramJSONObject);
          paramJSONObject = (String)paramJSONObject.value;
          ad.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, returnPath = %s", new Object[] { paramJSONObject });
          localObject1 = new HashMap();
          ((Map)localObject1).put("tempFilePath", paramJSONObject);
          paramc.h(paramInt, k("ok", (Map)localObject1));
          AppMethodBeat.o(139464);
          return;
        }
        catch (IOException paramJSONObject)
        {
          ad.w("MicroMsg.JsApiXWebCanvasToTempFilePath", "save bitmap to file failed. exception : %s", new Object[] { paramJSONObject });
          paramc.h(paramInt, e("fail:write file failed", null));
          AppMethodBeat.o(139464);
          return;
        }
      }
    }
    if (localObject1 == null)
    {
      ad.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "oriBitmap is null, err, return");
      paramc.h(paramInt, e("fail:illegal bitmap", null));
      AppMethodBeat.o(139464);
      return;
    }
    label838:
    super.a(paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(139464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.b.b.f
 * JD-Core Version:    0.7.0.1
 */