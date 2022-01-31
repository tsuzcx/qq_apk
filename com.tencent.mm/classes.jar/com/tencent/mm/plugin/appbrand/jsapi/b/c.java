package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  public static int B(JSONObject paramJSONObject)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(103846);
    float f2 = (float)paramJSONObject.optDouble("quality", 1.0D);
    if (f2 < 0.0F) {}
    for (;;)
    {
      int i = (int)f1;
      AppMethodBeat.o(103846);
      return i;
      if (f2 > 1.0F) {
        f1 = 100.0F;
      } else {
        f1 = f2 * 100.0F;
      }
    }
  }
  
  public static Bitmap.CompressFormat C(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103847);
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
    if ("jpg".equalsIgnoreCase(paramJSONObject.optString("fileType"))) {
      localCompressFormat = Bitmap.CompressFormat.JPEG;
    }
    AppMethodBeat.o(103847);
    return localCompressFormat;
  }
  
  public void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(103845);
    com.tencent.mm.plugin.appbrand.s.m.aNS().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(103844);
        if (!paramc.isRunning())
        {
          ab.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
          paramc.h(paramInt, c.this.j("fail", null));
          AppMethodBeat.o(103844);
          return;
        }
        e locale = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.q(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).d(paramc);
        if (locale == null)
        {
          ab.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
          paramc.h(paramInt, c.this.j("fail:page is null", null));
          AppMethodBeat.o(103844);
          return;
        }
        c localc = c.this;
        JSONObject localJSONObject = paramJSONObject;
        com.tencent.mm.plugin.appbrand.jsapi.base.g localg = new com.tencent.mm.plugin.appbrand.jsapi.base.g(paramc, paramInt);
        int i;
        try
        {
          i = localJSONObject.getInt("canvasId");
          View localView1 = locale.vC().getViewById(i);
          if (localView1 == null)
          {
            ab.w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", new Object[] { Integer.valueOf(i) });
            localg.BS(localc.j("fail:get canvas by canvasId failed", null));
            AppMethodBeat.o(103844);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          ab.w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", new Object[] { localJSONException });
          localg.BS(localc.j("fail:canvasId do not exist", null));
          AppMethodBeat.o(103844);
          return;
        }
        if (!(localJSONException instanceof CoverViewContainer))
        {
          ab.w("MicroMsg.JsApiCanvasToTempFilePath", "the view(%s) is not a instance of CoverViewContainer.", new Object[] { Integer.valueOf(i) });
          localg.BS(localc.j("fail:the view is not a instance of CoverViewContainer", null));
          AppMethodBeat.o(103844);
          return;
        }
        View localView2 = (View)((CoverViewContainer)localJSONException).aa(View.class);
        if (localView2 == null)
        {
          ab.w("MicroMsg.JsApiCanvasToTempFilePath", "getTargetView return null, viewId(%s).", new Object[] { Integer.valueOf(i) });
          localg.BS(localc.j("fail:target view is null.", null));
          AppMethodBeat.o(103844);
          return;
        }
        int j = localView2.getMeasuredWidth();
        int k = localView2.getMeasuredHeight();
        label897:
        label905:
        label1100:
        label1103:
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
            f3 = com.tencent.mm.plugin.appbrand.s.g.h(localJSONObject, "x");
            f4 = com.tencent.mm.plugin.appbrand.s.g.h(localJSONObject, "y");
            f1 = com.tencent.mm.plugin.appbrand.s.g.a(localJSONObject, "width", j);
            f2 = com.tencent.mm.plugin.appbrand.s.g.a(localJSONObject, "height", k);
            if (f3 + f1 <= j) {
              break label1103;
            }
            f1 = j - f3;
            if (f4 + f2 <= k) {
              break label1100;
            }
            f2 = k - f4;
            f5 = bo.getFloat(localJSONObject.optString("destWidth"), f1);
            f6 = bo.getFloat(localJSONObject.optString("destHeight"), f2);
            if (((int)f3 < 0) || ((int)f4 < 0) || ((int)f1 <= 0) || ((int)f2 <= 0) || ((int)(f3 + f1) > j) || ((int)(f4 + f2) > k) || ((int)f5 <= 0) || ((int)f6 <= 0))
            {
              ab.e("MicroMsg.JsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i) });
              localg.BS(localc.j("fail:illegal arguments", null));
              AppMethodBeat.o(103844);
              return;
            }
          }
          catch (Exception localException)
          {
            ab.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[] { Integer.valueOf(i), localException });
            localg.BS(localc.j("fail:create bitmap failed", null));
            AppMethodBeat.o(103844);
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
              ab.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", new Object[] { localObject2 });
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
              ab.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", new Object[] { localObject1 });
              ((Bitmap)localObject1).recycle();
            }
            localCompressFormat = c.C(localJSONObject);
            if (localCompressFormat != Bitmap.CompressFormat.JPEG) {
              break label897;
            }
          }
          for (Object localObject1 = "jpg";; localObject1 = "png")
          {
            localObject3 = locale.wX().zh("canvas_" + i + "." + (String)localObject1);
            if (localObject3 != null) {
              break label905;
            }
            ab.e("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, alloc file failed");
            localg.BS(localc.j("fail alloc file failed", null));
            AppMethodBeat.o(103844);
            return;
            ((View)localObject1).draw(new com.tencent.mm.plugin.appbrand.canvas.f((Bitmap)localObject2));
            break;
          }
          Object localObject3 = com.tencent.mm.vfs.j.p(((b)localObject3).dQJ());
          ab.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, savePath = %s", new Object[] { localObject3 });
          try
          {
            d.a((Bitmap)localObject2, c.B(localJSONObject), localCompressFormat, (String)localObject3, true);
            localObject2 = new com.tencent.mm.plugin.appbrand.s.j();
            locale.wX().a(new File((String)localObject3), (String)localObject1, true, (com.tencent.mm.plugin.appbrand.s.j)localObject2);
            localObject1 = (String)((com.tencent.mm.plugin.appbrand.s.j)localObject2).value;
            ab.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, returnPath = %s", new Object[] { localObject1 });
            localObject2 = new HashMap();
            ((Map)localObject2).put("tempFilePath", localObject1);
            localg.BS(localc.j("ok", (Map)localObject2));
            AppMethodBeat.o(103844);
            return;
          }
          catch (IOException localIOException)
          {
            ab.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", new Object[] { Integer.valueOf(i), localIOException });
            localg.BS(localc.j("fail:write file failed", null));
            AppMethodBeat.o(103844);
            return;
          }
        }
      }
    });
    AppMethodBeat.o(103845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.c
 * JD-Core Version:    0.7.0.1
 */