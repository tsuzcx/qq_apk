package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  public static int t(JSONObject paramJSONObject)
  {
    float f1 = 0.0F;
    float f2 = (float)paramJSONObject.optDouble("quality", 1.0D);
    if (f2 < 0.0F) {}
    for (;;)
    {
      return (int)f1;
      if (f2 > 1.0F) {
        f1 = 100.0F;
      } else {
        f1 = f2 * 100.0F;
      }
    }
  }
  
  public static Bitmap.CompressFormat u(JSONObject paramJSONObject)
  {
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    if ("jpg".equalsIgnoreCase(paramJSONObject.optString("fileType"))) {
      localCompressFormat = Bitmap.CompressFormat.JPEG;
    }
    return localCompressFormat;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    n.DS().O(new Runnable()
    {
      public final void run()
      {
        if (!paramc.isRunning())
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
          paramc.C(paramInt, c.this.h("fail", null));
          return;
        }
        e locale = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.i(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).a(paramc);
        if (locale == null)
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
          paramc.C(paramInt, c.this.h("fail:page is null", null));
          return;
        }
        c localc = c.this;
        JSONObject localJSONObject = paramJSONObject;
        g localg = new g(paramc, paramInt);
        int i;
        try
        {
          i = localJSONObject.getInt("canvasId");
          View localView1 = locale.agW().mg(i);
          if (localView1 == null)
          {
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
            localg.tT(localc.h("fail:get canvas by canvasId failed", null));
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", new Object[] { localJSONException });
          localg.tT(localc.h("fail:canvasId do not exist", null));
          return;
        }
        if (!(localJSONException instanceof CoverViewContainer))
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasToTempFilePath", "the view(%s) is not a instance of CoverViewContainer.", new Object[] { Integer.valueOf(i) });
          localg.tT(localc.h("fail:the view is not a instance of CoverViewContainer", null));
          return;
        }
        View localView2 = (View)((CoverViewContainer)localJSONException).K(View.class);
        if (localView2 == null)
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasToTempFilePath", "getTargetView return null, viewId(%s).", new Object[] { Integer.valueOf(i) });
          localg.tT(localc.h("fail:target view is null.", null));
          return;
        }
        int j = localView2.getMeasuredWidth();
        int k = localView2.getMeasuredHeight();
        label821:
        label829:
        label1014:
        label1017:
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
            f3 = h.j(localJSONObject, "x");
            f4 = h.j(localJSONObject, "y");
            f1 = h.a(localJSONObject, "width", j);
            f2 = h.a(localJSONObject, "height", k);
            if (f3 + f1 <= j) {
              break label1017;
            }
            f1 = j - f3;
            if (f4 + f2 <= k) {
              break label1014;
            }
            f2 = k - f4;
            f5 = bk.getFloat(localJSONObject.optString("destWidth"), f1);
            f6 = bk.getFloat(localJSONObject.optString("destHeight"), f2);
            if ((f3 < 0.0F) || (f4 < 0.0F) || (f1 <= 0.0F) || (f2 <= 0.0F) || (f3 + f1 > j) || (f4 + f2 > k) || (f5 <= 0.0F) || (f6 <= 0.0F))
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i) });
              localg.tT(localc.h("fail:illegal arguments", null));
              return;
            }
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException });
            localg.tT(localc.h("fail:create bitmap failed", null));
            return;
          }
          Bitmap.CompressFormat localCompressFormat;
          if ((localException instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a))
          {
            ((com.tencent.mm.plugin.appbrand.canvas.widget.a)localException).f(new com.tencent.mm.plugin.appbrand.canvas.f((Bitmap)localObject2));
            if (f1 == j)
            {
              localObject1 = localObject2;
              if (f2 == k) {}
            }
            else
            {
              localObject1 = Bitmap.createBitmap((Bitmap)localObject2, (int)f3, (int)f4, (int)f1, (int)f2, null, false);
              ((Bitmap)localObject2).recycle();
            }
            if (f1 == f5)
            {
              localObject2 = localObject1;
              if (f2 == f6) {}
            }
            else
            {
              localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)f5, (int)f6, false);
              ((Bitmap)localObject1).recycle();
            }
            localCompressFormat = c.u(localJSONObject);
            if (localCompressFormat != Bitmap.CompressFormat.JPEG) {
              break label821;
            }
          }
          for (Object localObject1 = "jpg";; localObject1 = "png")
          {
            localObject3 = locale.Zl().ry("canvas_" + i + "." + (String)localObject1);
            if (localObject3 != null) {
              break label829;
            }
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, alloc file failed");
            localg.tT(localc.h("fail alloc file failed", null));
            return;
            ((View)localObject1).draw(new com.tencent.mm.plugin.appbrand.canvas.f((Bitmap)localObject2));
            break;
          }
          Object localObject3 = j.n(((b)localObject3).cLr());
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, savePath = %s", new Object[] { localObject3 });
          try
          {
            com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject2, c.t(localJSONObject), localCompressFormat, (String)localObject3, true);
            localObject2 = new com.tencent.mm.plugin.appbrand.u.k();
            locale.Zl().a(new File((String)localObject3), (String)localObject1, true, (com.tencent.mm.plugin.appbrand.u.k)localObject2);
            localObject1 = (String)((com.tencent.mm.plugin.appbrand.u.k)localObject2).value;
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, returnPath = %s", new Object[] { localObject1 });
            localObject2 = new HashMap();
            ((Map)localObject2).put("tempFilePath", localObject1);
            localg.tT(localc.h("ok", (Map)localObject2));
            return;
          }
          catch (IOException localIOException)
          {
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", new Object[] { Integer.valueOf(i), localIOException });
            localg.tT(localc.h("fail:write file failed", null));
            return;
          }
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.c
 * JD-Core Version:    0.7.0.1
 */