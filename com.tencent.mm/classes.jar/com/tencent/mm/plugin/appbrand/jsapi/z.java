package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.plugin.appbrand.game.f.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;

public final class z
  extends y
{
  public final Bitmap a(o paramo)
  {
    if (paramo.getRuntime().ZH())
    {
      paramo = a.gdf.ahl();
      if (paramo != null) {
        return paramo.content;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiCaptureScreenWC", "mbCanvasContentHolder is null");
      return null;
    }
    return (Bitmap)new z.1(this, (s)paramo.E(s.class)).b(new ah(Looper.getMainLooper()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z
 * JD-Core Version:    0.7.0.1
 */