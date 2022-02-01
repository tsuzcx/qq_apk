package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  public static int R(JSONObject paramJSONObject)
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
  
  public static Bitmap.CompressFormat S(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145533);
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    if ("jpg".equalsIgnoreCase(paramJSONObject.optString("fileType"))) {
      localCompressFormat = Bitmap.CompressFormat.JPEG;
    }
    AppMethodBeat.o(145533);
    return localCompressFormat;
  }
  
  public void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145531);
    m.bZn().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145530);
        if (!paramf.isRunning())
        {
          Log.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
          paramf.i(paramInt, d.this.h("fail", null));
          AppMethodBeat.o(145530);
          return;
        }
        h localh = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)paramf.M(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(paramf, paramJSONObject);
        if (localh == null)
        {
          Log.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
          paramf.i(paramInt, d.this.h("fail:page is null", null));
          AppMethodBeat.o(145530);
          return;
        }
        d locald = d.this;
        JSONObject localJSONObject = paramJSONObject;
        com.tencent.mm.plugin.appbrand.jsapi.base.i locali = new com.tencent.mm.plugin.appbrand.jsapi.base.i(paramf, paramInt);
        int i;
        try
        {
          i = localJSONObject.getInt("canvasId");
          View localView1 = localh.gA(localJSONObject.optBoolean("independent", false)).getViewById(i);
          if (localView1 == null)
          {
            Log.w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
            locali.ZA(locald.h("fail:get canvas by canvasId failed", null));
            AppMethodBeat.o(145530);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          Log.w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", new Object[] { localJSONException });
          locali.ZA(locald.h("fail:canvasId do not exist", null));
          AppMethodBeat.o(145530);
          return;
        }
        if (!(localJSONException instanceof CoverViewContainer))
        {
          Log.w("MicroMsg.JsApiCanvasToTempFilePath", "the view(%s) is not a instance of CoverViewContainer.", new Object[] { Integer.valueOf(i) });
          locali.ZA(locald.h("fail:the view is not a instance of CoverViewContainer", null));
          AppMethodBeat.o(145530);
          return;
        }
        View localView2 = (View)((CoverViewContainer)localJSONException).aB(View.class);
        if (localView2 == null)
        {
          Log.w("MicroMsg.JsApiCanvasToTempFilePath", "getTargetView return null, viewId(%s).", new Object[] { Integer.valueOf(i) });
          locali.ZA(locald.h("fail:target view is null.", null));
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
            f3 = com.tencent.mm.plugin.appbrand.ac.g.h(localJSONObject, "x");
            f4 = com.tencent.mm.plugin.appbrand.ac.g.h(localJSONObject, "y");
            f1 = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "width", j);
            f2 = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "height", k);
            if (f3 + f1 <= j) {
              break label1414;
            }
            f1 = j - f3;
            if (f4 + f2 <= k) {
              break label1411;
            }
            f2 = k - f4;
            f5 = Util.getFloat(localJSONObject.optString("destWidth"), f1);
            f6 = Util.getFloat(localJSONObject.optString("destHeight"), f2);
            if (((int)f3 < 0) || ((int)f4 < 0) || ((int)f1 <= 0) || ((int)f2 <= 0) || ((int)(f3 + f1) > j) || ((int)(f4 + f2) > k) || ((int)f5 <= 0) || ((int)f6 <= 0))
            {
              Log.e("MicroMsg.JsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i) });
              locali.ZA(locald.h("fail:illegal arguments", null));
              AppMethodBeat.o(145530);
              return;
            }
          }
          catch (Exception localException1)
          {
            Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException1 });
            locali.ZA(locald.h("fail:create bitmap failed", null));
            AppMethodBeat.o(145530);
            return;
          }
          catch (Throwable localThrowable1)
          {
            Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", new Object[] { Integer.valueOf(i), localThrowable1 });
            locali.ZA(locald.h("fail:create bitmap failed", null));
            AppMethodBeat.o(145530);
            return;
          }
          Object localObject1;
          int m;
          int n;
          if ((localThrowable1 instanceof a))
          {
            ((a)localThrowable1).o(new com.tencent.mm.plugin.appbrand.canvas.f((Bitmap)localObject2));
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
              Log.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", new Object[] { localObject2 });
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
              Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException2 });
              locali.ZA(locald.h("fail:create bitmap failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            catch (Throwable localThrowable2)
            {
              Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", new Object[] { Integer.valueOf(i), localThrowable2 });
              locali.ZA(locald.h("fail:create bitmap failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            try
            {
              localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, j, k, false);
              Log.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", new Object[] { localObject1 });
              ((Bitmap)localObject1).recycle();
              localCompressFormat = d.S(localJSONObject);
              if (localCompressFormat != Bitmap.CompressFormat.JPEG) {
                break label1160;
              }
              localObject1 = "jpg";
              localObject3 = localh.getFileSystem().Wa("canvas_" + i + "." + (String)localObject1);
              if (localObject3 != null) {
                break label1168;
              }
              Log.e("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, alloc file failed");
              locali.ZA(locald.h("fail alloc file failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            catch (Exception localException3)
            {
              Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException3 });
              locali.ZA(locald.h("fail:create bitmap failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            catch (Throwable localThrowable3)
            {
              Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", new Object[] { Integer.valueOf(i), localThrowable3 });
              locali.ZA(locald.h("fail:create bitmap failed", null));
              AppMethodBeat.o(145530);
              return;
            }
            ((View)localObject1).draw(new com.tencent.mm.plugin.appbrand.canvas.f((Bitmap)localObject2));
            break;
            str = "png";
          }
          label1168:
          Object localObject3 = aa.z(((o)localObject3).her());
          Log.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, savePath = %s", new Object[] { localObject3 });
          try
          {
            BitmapUtil.saveBitmapToImage((Bitmap)localObject2, d.R(localJSONObject), localCompressFormat, (String)localObject3, true);
            localObject2 = new com.tencent.mm.plugin.appbrand.ac.i();
            localh.getFileSystem().a(new o((String)localObject3), str, true, (com.tencent.mm.plugin.appbrand.ac.i)localObject2);
            str = (String)((com.tencent.mm.plugin.appbrand.ac.i)localObject2).value;
            Log.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, returnPath = %s", new Object[] { str });
            localObject2 = new HashMap();
            ((Map)localObject2).put("tempFilePath", str);
            locali.ZA(locald.n("ok", (Map)localObject2));
            AppMethodBeat.o(145530);
            return;
          }
          catch (IOException localIOException)
          {
            Log.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", new Object[] { Integer.valueOf(i), localIOException });
            locali.ZA(locald.h("fail:write file failed", null));
            AppMethodBeat.o(145530);
            return;
          }
          catch (Throwable localThrowable4)
          {
            Log.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). throwable : %s", new Object[] { Integer.valueOf(i), localThrowable4 });
            locali.ZA(locald.h("fail:write file failed", null));
            AppMethodBeat.o(145530);
            return;
          }
        }
      }
    });
    AppMethodBeat.o(145531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.d
 * JD-Core Version:    0.7.0.1
 */