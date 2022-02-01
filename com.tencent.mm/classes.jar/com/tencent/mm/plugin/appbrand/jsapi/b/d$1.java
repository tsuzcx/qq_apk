package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class d$1
  implements Runnable
{
  d$1(d paramd, e parame, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(145530);
    if (!this.owM.isRunning())
    {
      Log.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
      this.owM.j(this.cuf, this.oNn.h("fail", null));
      AppMethodBeat.o(145530);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.g localg = ((com.tencent.mm.plugin.appbrand.jsapi.base.g)this.owM.K(com.tencent.mm.plugin.appbrand.jsapi.base.g.class)).c(this.owM, this.cui);
    if (localg == null)
    {
      Log.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
      this.owM.j(this.cuf, this.oNn.h("fail:page is null", null));
      AppMethodBeat.o(145530);
      return;
    }
    d locald = this.oNn;
    JSONObject localJSONObject = this.cui;
    com.tencent.mm.plugin.appbrand.jsapi.base.i locali = new com.tencent.mm.plugin.appbrand.jsapi.base.i(this.owM, this.cuf);
    int i;
    try
    {
      i = localJSONObject.getInt("canvasId");
      View localView1 = localg.hl(localJSONObject.optBoolean("independent", false)).bg(i);
      if (localView1 == null)
      {
        Log.w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
        locali.aho(locald.h("fail:get canvas by canvasId failed", null));
        AppMethodBeat.o(145530);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", new Object[] { localJSONException });
      locali.aho(locald.h("fail:canvasId do not exist", null));
      AppMethodBeat.o(145530);
      return;
    }
    if (!(localJSONException instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiCanvasToTempFilePath", "the view(%s) is not a instance of CoverViewContainer.", new Object[] { Integer.valueOf(i) });
      locali.aho(locald.h("fail:the view is not a instance of CoverViewContainer", null));
      AppMethodBeat.o(145530);
      return;
    }
    View localView2 = (View)((CoverViewContainer)localJSONException).aA(View.class);
    if (localView2 == null)
    {
      Log.w("MicroMsg.JsApiCanvasToTempFilePath", "getTargetView return null, viewId(%s).", new Object[] { Integer.valueOf(i) });
      locali.aho(locald.h("fail:target view is null.", null));
      AppMethodBeat.o(145530);
      return;
    }
    int j = localView2.getMeasuredWidth();
    int k = localView2.getMeasuredHeight();
    label1408:
    label1411:
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
        f3 = com.tencent.mm.plugin.appbrand.ac.g.i(localJSONObject, "x");
        f4 = com.tencent.mm.plugin.appbrand.ac.g.i(localJSONObject, "y");
        f1 = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "width", j);
        f2 = com.tencent.mm.plugin.appbrand.ac.g.a(localJSONObject, "height", k);
        if (f3 + f1 <= j) {
          break label1411;
        }
        f1 = j - f3;
        if (f4 + f2 <= k) {
          break label1408;
        }
        f2 = k - f4;
        f5 = Util.getFloat(localJSONObject.optString("destWidth"), f1);
        f6 = Util.getFloat(localJSONObject.optString("destHeight"), f2);
        if (((int)f3 < 0) || ((int)f4 < 0) || ((int)f1 <= 0) || ((int)f2 <= 0) || ((int)(f3 + f1) > j) || ((int)(f4 + f2) > k) || ((int)f5 <= 0) || ((int)f6 <= 0))
        {
          Log.e("MicroMsg.JsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i) });
          locali.aho(locald.h("fail:illegal arguments", null));
          AppMethodBeat.o(145530);
          return;
        }
      }
      catch (Exception localException1)
      {
        Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException1 });
        locali.aho(locald.h("fail:create bitmap failed", null));
        AppMethodBeat.o(145530);
        return;
      }
      catch (Throwable localThrowable1)
      {
        Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", new Object[] { Integer.valueOf(i), localThrowable1 });
        locali.aho(locald.h("fail:create bitmap failed", null));
        AppMethodBeat.o(145530);
        return;
      }
      Object localObject1;
      int m;
      int n;
      if ((localThrowable1 instanceof a))
      {
        ((a)localThrowable1).q(new f((Bitmap)localObject2));
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
          locali.aho(locald.h("fail:create bitmap failed", null));
          AppMethodBeat.o(145530);
          return;
        }
        catch (Throwable localThrowable2)
        {
          Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", new Object[] { Integer.valueOf(i), localThrowable2 });
          locali.aho(locald.h("fail:create bitmap failed", null));
          AppMethodBeat.o(145530);
          return;
        }
        try
        {
          localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, j, k, false);
          Log.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", new Object[] { localObject1 });
          ((Bitmap)localObject1).recycle();
          localCompressFormat = d.W(localJSONObject);
          if (localCompressFormat != Bitmap.CompressFormat.JPEG) {
            break label1160;
          }
          localObject1 = "jpg";
          localObject3 = localg.getFileSystem().adN("canvas_" + i + "." + (String)localObject1);
          if (localObject3 != null) {
            break label1168;
          }
          Log.e("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, alloc file failed");
          locali.aho(locald.h("fail alloc file failed", null));
          AppMethodBeat.o(145530);
          return;
        }
        catch (Exception localException3)
        {
          Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException3 });
          locali.aho(locald.h("fail:create bitmap failed", null));
          AppMethodBeat.o(145530);
          return;
        }
        catch (Throwable localThrowable3)
        {
          Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", new Object[] { Integer.valueOf(i), localThrowable3 });
          locali.aho(locald.h("fail:create bitmap failed", null));
          AppMethodBeat.o(145530);
          return;
        }
        ((View)localObject1).draw(new f((Bitmap)localObject2));
        break;
        str = "png";
      }
      label1168:
      Object localObject3 = ((q)localObject3).bOF();
      Log.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, savePath = %s", new Object[] { localObject3 });
      try
      {
        BitmapUtil.saveBitmapToImage((Bitmap)localObject2, d.V(localJSONObject), localCompressFormat, (String)localObject3, true);
        localObject2 = new com.tencent.mm.plugin.appbrand.ac.i();
        localg.getFileSystem().a(new q((String)localObject3), str, true, (com.tencent.mm.plugin.appbrand.ac.i)localObject2);
        str = (String)((com.tencent.mm.plugin.appbrand.ac.i)localObject2).value;
        Log.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, returnPath = %s", new Object[] { str });
        localObject2 = new HashMap();
        ((Map)localObject2).put("tempFilePath", str);
        locali.aho(locald.m("ok", (Map)localObject2));
        AppMethodBeat.o(145530);
        return;
      }
      catch (IOException localIOException)
      {
        Log.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", new Object[] { Integer.valueOf(i), localIOException });
        locali.aho(locald.h("fail:write file failed", null));
        AppMethodBeat.o(145530);
        return;
      }
      catch (Throwable localThrowable4)
      {
        Log.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). throwable : %s", new Object[] { Integer.valueOf(i), localThrowable4 });
        locali.aho(locald.h("fail:write file failed", null));
        AppMethodBeat.o(145530);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.d.1
 * JD-Core Version:    0.7.0.1
 */