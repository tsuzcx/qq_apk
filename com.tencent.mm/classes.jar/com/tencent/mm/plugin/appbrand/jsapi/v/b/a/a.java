package com.tencent.mm.plugin.appbrand.jsapi.v.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.a
{
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a parama, Bitmap paramBitmap)
  {
    AppMethodBeat.i(140043);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140043);
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, bitmap is null");
      parama.ck("fail:snapshot error");
      AppMethodBeat.o(140043);
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
        ab.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save snapshot failed");
        parama.ck("fail:snapshot error");
        AppMethodBeat.o(140043);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, save bitmap exception", new Object[] { paramBitmap });
      parama.ck("fail:snapshot error");
      AppMethodBeat.o(140043);
      return;
    }
    parama.ck("fail");
    AppMethodBeat.o(140043);
    return;
    label254:
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ab.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ab.i("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "operateSnapshot, actualPath:%s path:%s", new Object[] { str, localj.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", localj.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    parama.d("ok", paramBitmap);
    AppMethodBeat.o(140043);
  }
  
  public final boolean b(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(140041);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140041);
      return false;
    }
    Object localObject = parama.xk();
    com.tencent.mm.plugin.appbrand.jsapi.c localc = ((com.tencent.mm.plugin.appbrand.f.b)parama).hrA;
    parama = null;
    if ((localc instanceof v)) {
      parama = (v)localc;
    }
    while (parama == null)
    {
      ab.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, page view is null");
      AppMethodBeat.o(140041);
      return false;
      if ((localc instanceof r)) {
        parama = ((r)localc).getCurrentPageView();
      }
    }
    if ((localObject != null) && (((JSONObject)localObject).has("data")))
    {
      localObject = ((JSONObject)localObject).optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        ab.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "requestFullscreen, data array is null");
        AppMethodBeat.o(140041);
        return false;
      }
      int i;
      switch (((JSONArray)localObject).optInt(0, 0))
      {
      default: 
        i = 90;
      }
      for (;;)
      {
        parama.A(new a.1(this, parama, i));
        AppMethodBeat.o(140041);
        return true;
        i = 90;
        continue;
        i = -90;
        continue;
        i = 0;
      }
    }
    AppMethodBeat.o(140041);
    return false;
  }
  
  public final boolean c(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(140042);
    if (!(parama instanceof com.tencent.mm.plugin.appbrand.f.b))
    {
      AppMethodBeat.o(140042);
      return false;
    }
    parama = ((com.tencent.mm.plugin.appbrand.f.b)parama).hrA;
    if ((parama instanceof v)) {
      parama = (v)parama;
    }
    for (;;)
    {
      if (parama == null)
      {
        ab.w("MicroMsg.SameLayer.AppBrandLivePlayerCustomHandler", "exitFullscreen, page view is null");
        AppMethodBeat.o(140042);
        return false;
        if ((parama instanceof r)) {
          parama = ((r)parama).getCurrentPageView();
        }
      }
      else
      {
        parama.A(new a.2(this, parama));
        AppMethodBeat.o(140042);
        return true;
      }
      parama = null;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.b xv()
  {
    AppMethodBeat.i(140039);
    b localb = new b();
    AppMethodBeat.o(140039);
    return localb;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.c xw()
  {
    AppMethodBeat.i(140040);
    com.tencent.mm.plugin.appbrand.jsapi.v.b.b localb = new com.tencent.mm.plugin.appbrand.jsapi.v.b.b();
    AppMethodBeat.o(140040);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a
 * JD-Core Version:    0.7.0.1
 */