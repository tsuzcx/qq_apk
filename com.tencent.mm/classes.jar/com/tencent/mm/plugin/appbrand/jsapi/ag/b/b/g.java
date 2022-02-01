package com.tencent.mm.plugin.appbrand.jsapi.ag.b.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends d
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "xwebCanvasToTempFilePath";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(215837);
    Log.i("MicroMsg.JsApiXWebCanvasToTempFilePath2", "invokeXWebCanvasJsApi data:%s", new Object[] { paramJSONObject });
    int i = (int)Util.getFloat(paramJSONObject.optString("x"), 0.0F);
    int j = (int)Util.getFloat(paramJSONObject.optString("y"), 0.0F);
    int k = (int)Util.getFloat(paramJSONObject.optString("width"), 0.0F);
    int m = (int)Util.getFloat(paramJSONObject.optString("height"), 0.0F);
    int n = paramJSONObject.optInt("viewId", 0);
    Object localObject1 = b.xS(n);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath2", "get skiaCanvasView failed, viewId:%d", new Object[] { Integer.valueOf(n) });
      paramf.i(paramInt, h("fail:internal error", null));
      AppMethodBeat.o(215837);
      return;
    }
    Object localObject4 = ((SkiaCanvasView)localObject1).getSnapshot(new Rect(i, j, k, m));
    if (localObject4 == null)
    {
      Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath2", "oriBitmap is null, err, return");
      paramf.i(paramInt, h("fail:illegal bitmap", null));
      AppMethodBeat.o(215837);
      return;
    }
    float f1 = Util.getFloat(paramJSONObject.optString("destWidth"), k);
    float f2 = Util.getFloat(paramJSONObject.optString("destHeight"), m);
    if (((Bitmap)localObject4).getWidth() == f1)
    {
      localObject1 = localObject4;
      if (((Bitmap)localObject4).getHeight() == f2) {}
    }
    else
    {
      i = (int)f1;
      j = (int)f2;
    }
    try
    {
      localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, j, false);
      Log.i("MicroMsg.JsApiXWebCanvasToTempFilePath2", "bitmap recycle %s %s ", new Object[] { localObject4, localObject1 });
      if (localObject1 == null)
      {
        Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath2", "oriBitmap is null, err, return");
        paramf.i(paramInt, h("fail:illegal bitmap", null));
        AppMethodBeat.o(215837);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printInfoStack("MicroMsg.JsApiXWebCanvasToTempFilePath2", "create scaledbitmap fail:%s", new Object[] { localException });
        Object localObject2 = localObject4;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject3;
      for (;;)
      {
        Log.printInfoStack("MicroMsg.JsApiXWebCanvasToTempFilePath2", "create scaledbitmap fail:%s", new Object[] { localThrowable });
        localObject3 = localObject4;
      }
      Bitmap.CompressFormat localCompressFormat = S(paramJSONObject);
      if (localCompressFormat == Bitmap.CompressFormat.JPEG) {}
      for (localObject4 = "jpg";; localObject4 = "png")
      {
        localObject5 = paramf.getFileSystem().Wa("canvas_" + System.currentTimeMillis() + "." + (String)localObject4);
        if (localObject5 != null) {
          break;
        }
        Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath2", "toTempFilePath, alloc file failed");
        paramf.i(paramInt, h("fail alloc file failed", null));
        AppMethodBeat.o(215837);
        return;
      }
      Object localObject5 = aa.z(((o)localObject5).her());
      Log.d("MicroMsg.JsApiXWebCanvasToTempFilePath2", "toTempFilePath, savePath = %s", new Object[] { localObject5 });
      try
      {
        BitmapUtil.saveBitmapToImage((Bitmap)localObject3, R(paramJSONObject), localCompressFormat, (String)localObject5, true);
        paramJSONObject = new i();
        paramf.getFileSystem().a(new o((String)localObject5), (String)localObject4, false, paramJSONObject);
        paramJSONObject = (String)paramJSONObject.value;
        Log.d("MicroMsg.JsApiXWebCanvasToTempFilePath2", "toTempFilePath, returnPath = %s", new Object[] { paramJSONObject });
        localObject3 = new HashMap();
        ((Map)localObject3).put("tempFilePath", paramJSONObject);
        paramf.i(paramInt, n("ok", (Map)localObject3));
        AppMethodBeat.o(215837);
        return;
      }
      catch (IOException paramJSONObject)
      {
        Log.w("MicroMsg.JsApiXWebCanvasToTempFilePath2", "save bitmap to file failed. exception : %s", new Object[] { paramJSONObject });
        paramf.i(paramInt, h("fail:write file failed", null));
        AppMethodBeat.o(215837);
      }
    }
  }
  
  public final boolean bEa()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.g
 * JD-Core Version:    0.7.0.1
 */