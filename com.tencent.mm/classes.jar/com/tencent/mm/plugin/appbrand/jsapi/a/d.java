package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  public static int K(JSONObject paramJSONObject)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(145532);
    float f2 = (float)paramJSONObject.optDouble("quality", 1.0D);
    if (f2 < 0.0F) {}
    for (;;)
    {
      int i = (int)f1;
      AppMethodBeat.o(145532);
      return i;
      if (f2 > 1.0F) {
        f1 = 100.0F;
      } else {
        f1 = f2 * 100.0F;
      }
    }
  }
  
  public static Bitmap.CompressFormat L(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145533);
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    if ("jpg".equalsIgnoreCase(paramJSONObject.optString("fileType"))) {
      localCompressFormat = Bitmap.CompressFormat.JPEG;
    }
    AppMethodBeat.o(145533);
    return localCompressFormat;
  }
  
  public void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145531);
    l.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145530);
        if (!paramc.isRunning())
        {
          ac.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
          paramc.h(paramInt, d.this.e("fail", null));
          AppMethodBeat.o(145530);
          return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.e locale = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.K(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).c(paramc, paramJSONObject);
        if (locale == null)
        {
          ac.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
          paramc.h(paramInt, d.this.e("fail:page is null", null));
          AppMethodBeat.o(145530);
          return;
        }
        d locald = d.this;
        JSONObject localJSONObject = paramJSONObject;
        com.tencent.mm.plugin.appbrand.jsapi.base.g localg = new com.tencent.mm.plugin.appbrand.jsapi.base.g(paramc, paramInt);
        int i;
        try
        {
          i = localJSONObject.getInt("canvasId");
          View localView1 = locale.fC(localJSONObject.optBoolean("independent", false)).getViewById(i);
          if (localView1 == null)
          {
            ac.w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
            localg.LV(locald.e("fail:get canvas by canvasId failed", null));
            AppMethodBeat.o(145530);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          ac.w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", new Object[] { localJSONException });
          localg.LV(locald.e("fail:canvasId do not exist", null));
          AppMethodBeat.o(145530);
          return;
        }
        if (!(localJSONException instanceof CoverViewContainer))
        {
          ac.w("MicroMsg.JsApiCanvasToTempFilePath", "the view(%s) is not a instance of CoverViewContainer.", new Object[] { Integer.valueOf(i) });
          localg.LV(locald.e("fail:the view is not a instance of CoverViewContainer", null));
          AppMethodBeat.o(145530);
          return;
        }
        View localView2 = (View)((CoverViewContainer)localJSONException).ax(View.class);
        if (localView2 == null)
        {
          ac.w("MicroMsg.JsApiCanvasToTempFilePath", "getTargetView return null, viewId(%s).", new Object[] { Integer.valueOf(i) });
          localg.LV(locald.e("fail:target view is null.", null));
          AppMethodBeat.o(145530);
          return;
        }
        int j = localView2.getMeasuredWidth();
        int k = localView2.getMeasuredHeight();
        label1411:
        label1414:
        for (;;)
        {
          Object localObject2;
          float f3;
          float f4;
          float f1;
          float f2;
          float f5;
          float f6;
          try
          {
            localObject2 = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
            f3 = com.tencent.mm.plugin.appbrand.z.g.g(localJSONObject, "x");
            f4 = com.tencent.mm.plugin.appbrand.z.g.g(localJSONObject, "y");
            f1 = com.tencent.mm.plugin.appbrand.z.g.a(localJSONObject, "width", j);
            f2 = com.tencent.mm.plugin.appbrand.z.g.a(localJSONObject, "height", k);
            if (f3 + f1 <= j) {
              break label1414;
            }
            f1 = j - f3;
            if (f4 + f2 <= k) {
              break label1411;
            }
            f2 = k - f4;
            f5 = bs.getFloat(localJSONObject.optString("destWidth"), f1);
            f6 = bs.getFloat(localJSONObject.optString("destHeight"), f2);
            if (((int)f3 < 0) || ((int)f4 < 0) || ((int)f1 <= 0) || ((int)f2 <= 0) || ((int)(f3 + f1) > j) || ((int)(f4 + f2) > k) || ((int)f5 <= 0) || ((int)f6 <= 0))
            {
              ac.e("MicroMsg.JsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i) });
              localg.LV(locald.e("fail:illegal arguments", null));
              AppMethodBeat.o(145530);
              return;
            }
          }
          catch (Exception localException1)
          {
            ac.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException1 });
            localg.LV(locald.e("fail:create bitmap failed", null));
            AppMethodBeat.o(145530);
            return;
          }
          catch (Throwable localThrowable1)
          {
            ac.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", new Object[] { Integer.valueOf(i), localThrowable1 });
            localg.LV(locald.e("fail:create bitmap failed", null));
            AppMethodBeat.o(145530);
            return;
          }
          Object localObject1;
          int m;
          int n;
          if ((localThrowable1 instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a))
          {
            ((com.tencent.mm.plugin.appbrand.canvas.widget.a)localThrowable1).h(new com.tencent.mm.plugin.appbrand.canvas.f((Bitmap)localObject2));
            if (f1 == j)
            {
              localObject1 = localObject2;
              if (f2 == k) {}
            }
            else
            {
              j = (int)f3;
              k = (int)f4;
              m = (int)f1;
              n = (int)f2;
            }
          }
          Bitmap.CompressFormat localCompressFormat;
          label1160:
          String str;
          for (;;)
          {
            try
            {
              localObject1 = Bitmap.createBitmap((Bitmap)localObject2, j, k, m, n, null, false);
              ac.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", new Object[] { localObject2 });
              ((Bitmap)localObject2).recycle();
              if (f1 == f5)
              {
                localObject2 = localObject1;
                if (f2 == f6) {}
              }
              else
              {
                j = (int)f5;
                k = (int)f6;
              }
            }
            catch (Exception localException2)
            {
              ac.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException2 });
              localg.LV(locald.e("fail:create bitmap failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            catch (Throwable localThrowable2)
            {
              ac.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", new Object[] { Integer.valueOf(i), localThrowable2 });
              localg.LV(locald.e("fail:create bitmap failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            try
            {
              localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, j, k, false);
              ac.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", new Object[] { localObject1 });
              ((Bitmap)localObject1).recycle();
              localCompressFormat = d.L(localJSONObject);
              if (localCompressFormat != Bitmap.CompressFormat.JPEG) {
                break label1160;
              }
              localObject1 = "jpg";
              localObject3 = locale.DH().IU("canvas_" + i + "." + (String)localObject1);
              if (localObject3 != null) {
                break label1168;
              }
              ac.e("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, alloc file failed");
              localg.LV(locald.e("fail alloc file failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            catch (Exception localException3)
            {
              ac.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException3 });
              localg.LV(locald.e("fail:create bitmap failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            catch (Throwable localThrowable3)
            {
              ac.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", new Object[] { Integer.valueOf(i), localThrowable3 });
              localg.LV(locald.e("fail:create bitmap failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            ((View)localObject1).draw(new com.tencent.mm.plugin.appbrand.canvas.f((Bitmap)localObject2));
            break;
            str = "png";
          }
          label1168:
          Object localObject3 = q.B(((com.tencent.mm.vfs.e)localObject3).fxV());
          ac.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, savePath = %s", new Object[] { localObject3 });
          try
          {
            com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, d.K(localJSONObject), localCompressFormat, (String)localObject3, true);
            localObject2 = new i();
            locale.DH().a(new com.tencent.mm.vfs.e((String)localObject3), str, true, (i)localObject2);
            str = (String)((i)localObject2).value;
            ac.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, returnPath = %s", new Object[] { str });
            localObject2 = new HashMap();
            ((Map)localObject2).put("tempFilePath", str);
            localg.LV(locald.k("ok", (Map)localObject2));
            AppMethodBeat.o(145530);
            return;
          }
          catch (IOException localIOException)
          {
            ac.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", new Object[] { Integer.valueOf(i), localIOException });
            localg.LV(locald.e("fail:write file failed", null));
            AppMethodBeat.o(145530);
            return;
          }
          catch (Throwable localThrowable4)
          {
            ac.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). throwable : %s", new Object[] { Integer.valueOf(i), localThrowable4 });
            localg.LV(locald.e("fail:write file failed", null));
            AppMethodBeat.o(145530);
            return;
          }
        }
      }
    });
    AppMethodBeat.o(145531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.d
 * JD-Core Version:    0.7.0.1
 */