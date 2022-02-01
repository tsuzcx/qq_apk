package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;

public final class JsApiAddToFavorites
  extends a<c>
{
  public static final int CTRL_INDEX = 800;
  public static final String NAME = "addToFavorites";
  
  private static void a(c.a parama, z paramz, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(222388);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        long l = System.currentTimeMillis();
        h.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        ae.i("MicroMsg.JsApiAddToFavorites", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { paramz.getAppId(), Integer.valueOf(paramz.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
        parama.Nr(paramString);
      }
      for (;;)
      {
        return;
        ae.w("MicroMsg.JsApiAddToFavorites", "snapshot can not be taken");
        parama.Nr("");
      }
      AppMethodBeat.o(222388);
    }
    catch (Exception paramz)
    {
      ae.w("MicroMsg.JsApiAddToFavorites", "save temp bitmap to file failed, . exception : %s", new Object[] { paramz });
      parama.Nr("");
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(222388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites
 * JD-Core Version:    0.7.0.1
 */