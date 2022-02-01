package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.menu.r;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;

public final class JsApiAddToFavorites
  extends a<c>
{
  public static final int CTRL_INDEX = 800;
  public static final String NAME = "addToFavorites";
  
  private static void a(b.a parama, aa paramaa, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(188262);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        long l = System.currentTimeMillis();
        g.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        ad.i("MicroMsg.JsApiAddToFavorites", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { paramaa.getAppId(), Integer.valueOf(paramaa.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
        parama.MK(paramString);
      }
      for (;;)
      {
        return;
        ad.w("MicroMsg.JsApiAddToFavorites", "snapshot can not be taken");
        parama.MK("");
      }
      AppMethodBeat.o(188262);
    }
    catch (Exception paramaa)
    {
      ad.w("MicroMsg.JsApiAddToFavorites", "save temp bitmap to file failed, . exception : %s", new Object[] { paramaa });
      parama.MK("");
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(188262);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites
 * JD-Core Version:    0.7.0.1
 */