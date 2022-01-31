package com.tencent.mm.plugin.appbrand.jsapi.v.b.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.a
{
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(140053);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140053);
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, bitmap is null");
      parama.ck("fail:snapshot error");
      AppMethodBeat.o(140053);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.f.b)parama).hrA;
    String str = e.esr + String.format(Locale.US, "%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    com.tencent.mm.plugin.appbrand.s.j localj;
    try
    {
      d.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      localj = new com.tencent.mm.plugin.appbrand.s.j();
      if (localc.wX() != null)
      {
        if (localc.wX().a(new File(str), "jpg", true, localj) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA) {
          break label254;
        }
        ab.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save snapshot failed");
        parama.ck("fail:snapshot error");
        AppMethodBeat.o(140053);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.ck("fail:snapshot error");
      AppMethodBeat.o(140053);
      return;
    }
    parama.ck("fail");
    AppMethodBeat.o(140053);
    return;
    label254:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ab.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ab.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, localj.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", localj.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.d("ok", paramBitmap);
    AppMethodBeat.o(140053);
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, a.a parama1)
  {
    AppMethodBeat.i(140051);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140051);
      return;
    }
    parama = (com.tencent.mm.plugin.appbrand.f.b)parama;
    Object localObject = parama.xk();
    String str = ((JSONObject)localObject).optString("backgroundImage");
    localObject = ((JSONObject)localObject).optString("backgroundMD5");
    if (bo.isNullOrNil(str))
    {
      ab.i("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "convertBackgroundImageToLocalPath, url is null");
      AppMethodBeat.o(140051);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a(parama.hrA, str, (String)localObject, new a.1(this, parama1, str));
    AppMethodBeat.o(140051);
  }
  
  public final void b(com.tencent.luggage.xweb_ext.extendplugin.a parama, a.a parama1)
  {
    AppMethodBeat.i(140052);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140052);
      return;
    }
    com.tencent.mm.plugin.appbrand.f.b localb = (com.tencent.mm.plugin.appbrand.f.b)parama;
    String str = localb.xk().optString("url");
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.SameLayer.AppBrandLivePusherCustomHandler", "operatePlayBgm, url is nil");
      parama.ck("fail:invalid data");
      AppMethodBeat.o(140052);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a(localb.hrA, str, null, new a.2(this, parama1, str));
    AppMethodBeat.o(140052);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.b xy()
  {
    AppMethodBeat.i(140049);
    b localb = new b();
    AppMethodBeat.o(140049);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.c xz()
  {
    AppMethodBeat.i(140050);
    com.tencent.mm.plugin.appbrand.jsapi.v.b.b localb = new com.tencent.mm.plugin.appbrand.jsapi.v.b.b();
    AppMethodBeat.o(140050);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a
 * JD-Core Version:    0.7.0.1
 */