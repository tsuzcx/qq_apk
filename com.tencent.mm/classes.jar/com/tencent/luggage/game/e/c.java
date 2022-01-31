package com.tencent.luggage.game.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.file.h.a;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = 100;
  public static final String NAME = "canvasToTempFilePath";
  
  public static h.a a(v paramv, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(140416);
    for (;;)
    {
      Object localObject1;
      float f8;
      float f9;
      float f4;
      float f5;
      float f3;
      float f6;
      float f7;
      float f1;
      label399:
      Object localObject2;
      try
      {
        i = paramJSONObject.getInt("canvasId");
        if (paramv == null)
        {
          paramv = new h.a("fail: no page", new Object[0]);
          AppMethodBeat.o(140416);
          return paramv;
        }
      }
      catch (JSONException paramv)
      {
        int i;
        ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", new Object[] { paramv });
        paramv = new h.a("fail:canvasId do not exist", new Object[0]);
        AppMethodBeat.o(140416);
        return paramv;
        localObject1 = (com.tencent.luggage.game.page.d)paramv.x(com.tencent.luggage.game.page.d.class);
        if (localObject1 == null) {
          break label1528;
        }
        localObject1 = ((com.tencent.luggage.game.page.d)localObject1).r(i, paramBoolean);
        if (localObject1 == null)
        {
          ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "get screenBitmap return null.");
          paramv = new h.a("fail:get bitmap failed", new Object[0]);
          AppMethodBeat.o(140416);
          return paramv;
        }
        f8 = ((Bitmap)localObject1).getWidth();
        f9 = ((Bitmap)localObject1).getHeight();
        float f10 = ((Bitmap)localObject1).getWidth();
        f4 = ((Bitmap)localObject1).getHeight();
        ab.i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenWidth:%f,screenHeight:%f,canvasWidth:%f,canvasHeight:%f", new Object[] { Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10), Float.valueOf(f4) });
        f5 = (float)paramJSONObject.optDouble("x", 0.0D);
        f3 = (float)paramJSONObject.optDouble("y", 0.0D);
        f6 = (float)paramJSONObject.optDouble("width", f10);
        f7 = (float)paramJSONObject.optDouble("height", f4);
        ab.i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,width:%f,height:%f", new Object[] { Float.valueOf(f5), Float.valueOf(f3), Float.valueOf(f6), Float.valueOf(f7) });
        if ((f10 <= 0.0F) || (f4 <= 0.0F) || ((f8 == f10) && (f9 == f4))) {
          break label1510;
        }
        f1 = f5;
        if (f5 > 0.0F) {
          f1 = f5 / f10 * f8;
        }
        f2 = f3;
        if (f3 > 0.0F) {
          f2 = f3 / f4 * f9;
        }
        f3 = f6 / f10 * f8;
        f5 = f7 / f4 * f9;
        f4 = f2;
        f2 = f5;
        break label1534;
        f5 = (float)paramJSONObject.optDouble("destWidth", f3);
        f6 = (float)paramJSONObject.optDouble("destHeight", f2);
        ab.i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,screenWidth:%f,screenHeight:%f,width:%f,height:%f,imgWidth:%f,imgHeight:%f", new Object[] { Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f5), Float.valueOf(f6) });
        if (((int)f1 < 0) || ((int)f4 < 0) || ((int)f3 <= 0) || ((int)f2 <= 0) || ((int)(f1 + f3) > (int)f8) || ((int)(f4 + f2) > (int)f9) || ((int)f5 <= 0) || ((int)f6 <= 0))
        {
          ab.e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, canvasId(%s).", new Object[] { Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(i) });
          paramv = new h.a("fail:illegal arguments", new Object[0]);
          AppMethodBeat.o(140416);
          return paramv;
        }
        if ((f3 != f8) || (f2 != f9))
        {
          int j = (int)f1;
          int k = (int)f4;
          int m = (int)f3;
          int n = (int)f2;
          localObject2 = Bitmap.createBitmap((Bitmap)localObject1, j, k, m, n, null, false);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          if (localObject1 == null)
          {
            ab.e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content null!");
            paramv = new h.a("fail:gen bitmap failed!", new Object[0]);
            AppMethodBeat.o(140416);
            return paramv;
          }
          if ((((Bitmap)localObject1).getWidth() <= 0) || (((Bitmap)localObject1).getHeight() <= 0))
          {
            ab.e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content width or height <=0!");
            paramv = new h.a("fail:gen bitmap failed!", new Object[0]);
            AppMethodBeat.o(140416);
            return paramv;
          }
          if (f3 == f5)
          {
            localObject2 = localObject1;
            if (f2 == f6) {}
          }
          else
          {
            j = (int)f5;
            k = (int)f6;
          }
          try
          {
            localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, j, k, false);
            ((Bitmap)localObject1).recycle();
            if (localObject2 != null) {}
          }
          catch (NullPointerException paramv)
          {
            try
            {
              Bitmap.CompressFormat localCompressFormat;
              com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, com.tencent.mm.plugin.appbrand.jsapi.b.c.B(paramJSONObject), localCompressFormat, (String)localObject2, true);
              paramJSONObject = paramv.getAppId();
              if (localCompressFormat != Bitmap.CompressFormat.JPEG) {
                continue;
              }
              paramv = "jpg";
              paramv = AppBrandLocalMediaObjectManager.b(paramJSONObject, (String)localObject2, paramv, true);
              if (paramv != null) {
                continue;
              }
              ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "gen temp file failed, canvasId : %s.", new Object[] { Integer.valueOf(i) });
              paramv = new h.a("fail:gen temp file failed", new Object[0]);
              AppMethodBeat.o(140416);
              return paramv;
            }
            catch (IOException paramv)
            {
              ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", new Object[] { Integer.valueOf(i), paramv });
              paramv = new h.a("fail:write file failed", new Object[0]);
              AppMethodBeat.o(140416);
              return paramv;
            }
            paramv = paramv;
            ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception npe: %d, %d, %f, %f", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()), Float.valueOf(f5), Float.valueOf(f6) });
            ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", paramv, "hy: weired exception occured!!", new Object[0]);
            ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(807L, 9L, 1L, false);
            paramv = new h.a("fail:gen bitmap failed because of null pointer!", new Object[0]);
            AppMethodBeat.o(140416);
            return paramv;
          }
          catch (IllegalArgumentException paramv)
          {
            localObject2 = localObject1;
            ab.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception ilae: %d, %d, %f, %f", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()), Float.valueOf(f5), Float.valueOf(f6) });
            ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", paramv, "hy: illegalArgument exception occured!!", new Object[0]);
            ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(807L, 10L, 1L, false);
            paramv = new h.a("fail:gen bitmap failed because of illegal argument!", new Object[0]);
            AppMethodBeat.o(140416);
            return paramv;
          }
          try
          {
            paramv = (com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class);
            if (paramv != null) {
              paramv.idkeyStat(807L, 9L, 1L, false);
            }
            paramv = new h.a("fail:gen bitmap failed because of null pointer!", new Object[0]);
            AppMethodBeat.o(140416);
            return paramv;
          }
          catch (IllegalArgumentException paramv)
          {
            continue;
          }
          catch (NullPointerException paramv)
          {
            localObject1 = localObject2;
            continue;
            localObject1 = localObject2;
            continue;
          }
          localCompressFormat = com.tencent.mm.plugin.appbrand.jsapi.b.c.C(paramJSONObject);
          if (localCompressFormat == Bitmap.CompressFormat.PNG)
          {
            localObject1 = Bitmap.createBitmap(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), Bitmap.Config.RGB_565);
            new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, null);
            localObject2 = AppBrandLocalMediaObjectManager.genMediaFilePath(paramv.getAppId(), "canvas_".concat(String.valueOf(i)));
            paramv = "png";
            continue;
            paramJSONObject = new HashMap();
            paramJSONObject.put("tempFilePath", paramv.ctV);
            ab.v("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save file(id : %s) to path : %s", new Object[] { paramv.ctV, paramv.fod });
            paramv = new h.a("ok", new Object[0]).z(paramJSONObject);
            AppMethodBeat.o(140416);
            return paramv;
          }
        }
      }
      catch (OutOfMemoryError paramv)
      {
        ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", paramv, "hy: out of memory!!", new Object[0]);
        ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(807L, 12L, 1L, false);
        paramv = new h.a("fail:out of memory!", new Object[0]);
        AppMethodBeat.o(140416);
        return paramv;
      }
      catch (RuntimeException paramv)
      {
        ab.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", paramv, "hy: runtime exception!", new Object[0]);
        ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(807L, 13L, 1L, false);
        paramv = new h.a("fail:runtime exception! %s", new Object[] { paramv.toString() });
        AppMethodBeat.o(140416);
        return paramv;
      }
      continue;
      label1510:
      label1528:
      label1534:
      do
      {
        break label399;
        for (;;)
        {
          break label1550;
          f4 = f3;
          f2 = f7;
          f3 = f6;
          f1 = f5;
          break label1534;
          localObject1 = null;
          break;
          if (f1 + f3 > f8) {
            f3 = f8 - f1;
          }
        }
      } while (f4 + f2 <= f9);
      label1550:
      float f2 = f9 - f4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.game.e.c
 * JD-Core Version:    0.7.0.1
 */