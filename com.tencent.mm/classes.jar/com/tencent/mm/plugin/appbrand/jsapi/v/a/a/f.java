package com.tencent.mm.plugin.appbrand.jsapi.v.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.v.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.b.c
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(154468);
    int i;
    if ((paramJSONObject != null) && (paramJSONObject.has("data"))) {
      i = 1;
    }
    Object localObject1;
    int k;
    int m;
    float f1;
    float f2;
    for (;;)
    {
      if (i != 0)
      {
        ab.i("MicroMsg.JsApiXWebCanvasToTempFilePath", "invokeXWebCanvasJsApi data:%s", new Object[] { paramJSONObject });
        i = paramJSONObject.optInt("canvasId", 0);
        if (i == 0)
        {
          ab.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "canvasId is invalid, return");
          paramc.h(paramInt, j("fail:illegal canvasId", null));
          AppMethodBeat.o(154468);
          return;
          i = 0;
        }
        else
        {
          localObject1 = a.ov(i);
          k = paramJSONObject.optInt("width", ((a)localObject1).mWidth);
          m = paramJSONObject.optInt("height", ((a)localObject1).mHeight);
          f1 = bo.getFloat(paramJSONObject.optString("destWidth"), k);
          f2 = bo.getFloat(paramJSONObject.optString("destHeight"), m);
          try
          {
            localObject1 = paramJSONObject.get("data");
            if (!(localObject1 instanceof ByteBuffer))
            {
              ab.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, value is not a ByteBuffer");
              paramc.h(paramInt, j("fail:illegal data", null));
              AppMethodBeat.o(154468);
              return;
            }
            localObject1 = (ByteBuffer)localObject1;
            localObject1 = com.tencent.mm.plugin.appbrand.s.d.m((ByteBuffer)localObject1);
            Object localObject3 = new int[localObject1.length / 4];
            int j = 0;
            i = 0;
            while (i < localObject3.length)
            {
              int i1 = j + 1;
              int n = localObject1[j];
              j = i1 + 1;
              i1 = localObject1[i1];
              int i2 = j + 1;
              int i3 = localObject1[j];
              j = i2 + 1;
              localObject3[i] = ((localObject1[i2] & 0xFF) << 24 | i3 & 0xFF | (n & 0xFF) << 16 | (i1 & 0xFF) << 8);
              i += 1;
            }
            try
            {
              localObject1 = Bitmap.createBitmap((int[])localObject3, k, m, Bitmap.Config.ARGB_8888);
              if (localObject1 == null)
              {
                ab.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "oriBitmap is null, err, return");
                paramc.h(paramInt, j("fail:illegal bitmap", null));
                AppMethodBeat.o(154468);
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ab.b("MicroMsg.JsApiXWebCanvasToTempFilePath", "", new Object[] { localException });
                localObject2 = null;
              }
              if (((Bitmap)localObject2).getWidth() == f1)
              {
                localObject3 = localObject2;
                if (((Bitmap)localObject2).getHeight() == f2) {}
              }
              else
              {
                localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject2, (int)f1, (int)f2, false);
                ab.i("MicroMsg.JsApiXWebCanvasToTempFilePath", "bitmap recycle %s", new Object[] { localObject2 });
                ((Bitmap)localObject2).recycle();
              }
              Bitmap.CompressFormat localCompressFormat = C(paramJSONObject);
              if (localCompressFormat == Bitmap.CompressFormat.JPEG) {}
              for (Object localObject2 = "jpg";; localObject2 = "png")
              {
                localObject4 = paramc.wX().zh("canvas_" + System.currentTimeMillis() + "." + (String)localObject2);
                if (localObject4 != null) {
                  break;
                }
                ab.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, alloc file failed");
                paramc.h(paramInt, j("fail alloc file failed", null));
                AppMethodBeat.o(154468);
                return;
              }
              Object localObject4 = com.tencent.mm.vfs.j.p(((b)localObject4).dQJ());
              ab.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, savePath = %s", new Object[] { localObject4 });
              try
              {
                com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject3, B(paramJSONObject), localCompressFormat, (String)localObject4, true);
                paramJSONObject = new com.tencent.mm.plugin.appbrand.s.j();
                paramc.wX().a(new File((String)localObject4), (String)localObject2, true, paramJSONObject);
                paramJSONObject = (String)paramJSONObject.value;
                ab.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, returnPath = %s", new Object[] { paramJSONObject });
                localObject2 = new HashMap();
                ((Map)localObject2).put("tempFilePath", paramJSONObject);
                paramc.h(paramInt, j("ok", (Map)localObject2));
                AppMethodBeat.o(154468);
                return;
              }
              catch (IOException paramJSONObject)
              {
                ab.w("MicroMsg.JsApiXWebCanvasToTempFilePath", "save bitmap to file failed. exception : %s", new Object[] { paramJSONObject });
                paramc.h(paramInt, j("fail:write file failed", null));
                AppMethodBeat.o(154468);
                return;
              }
            }
          }
          catch (JSONException paramJSONObject)
          {
            ab.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, %s", new Object[] { Log.getStackTraceString(paramJSONObject) });
            paramc.h(paramInt, j("fail:missing data", null));
            AppMethodBeat.o(154468);
            return;
          }
        }
      }
    }
    super.a(paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(154468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.a.f
 * JD-Core Version:    0.7.0.1
 */