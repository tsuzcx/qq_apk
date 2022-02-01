package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = 30;
  public static final String NAME = "previewImage";
  private final int kYJ;
  final int kYK;
  
  public l()
  {
    AppMethodBeat.i(174842);
    this.kYJ = 524288;
    this.kYK = com.tencent.luggage.sdk.g.a.aC(this);
    AppMethodBeat.o(174842);
  }
  
  private String a(Context paramContext, z paramz, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46577);
    Object localObject1 = paramJSONObject.optJSONArray("urls");
    if (localObject1 == null)
    {
      paramContext = e("fail:invalid data", null);
      AppMethodBeat.o(46577);
      return paramContext;
    }
    Object localObject3 = new String[((JSONArray)localObject1).length()];
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      localObject3[i] = ((JSONArray)localObject1).optString(i);
      i += 1;
    }
    int k = 0;
    i = 0;
    localObject1 = paramJSONObject.opt("current");
    if ((localObject1 instanceof Integer)) {
      i = ((Integer)localObject1).intValue();
    }
    while (!(localObject1 instanceof String))
    {
      j = 0;
      while (j < localObject3.length)
      {
        localObject2 = paramz.Fl().MP(localObject3[j]);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramz.Fl().MM(localObject3[j]);
        }
        if (localObject1 != null) {
          localObject3[j] = w.B(((k)localObject1).fTh());
        }
        j += 1;
      }
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= localObject3.length) {
        break;
      }
      if (localObject1.equals(localObject3[j])) {
        k = j;
      }
      j += 1;
    }
    String[] arrayOfString = com.tencent.mm.plugin.appbrand.jsapi.aa.a.o((String[])localObject3);
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.aa.a.a(arrayOfString, (String[])localObject3);
    j = i;
    if (i >= arrayOfString.length) {
      j = 0;
    }
    if (!(paramContext instanceof Activity))
    {
      paramContext = e("fail:internal error invalid android context", null);
      AppMethodBeat.o(46577);
      return paramContext;
    }
    boolean bool = paramJSONObject.optBoolean("showmenu", true);
    ae.i("MicroMsg.JsApiPreviewImage", "showmenu:%b", new Object[] { Boolean.valueOf(bool) });
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("nowUrl", arrayOfString[j]);
    ((Intent)localObject2).putExtra("urlList", arrayOfString);
    ((Intent)localObject2).putExtra("type", -255);
    ((Intent)localObject2).putExtra("isFromWebView", true);
    ((Intent)localObject2).putExtra("isFromAppBrand", true);
    ((Intent)localObject2).putExtra("showmenu", bool);
    localObject3 = (com.tencent.mm.plugin.appbrand.o.a)paramz.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    if ((localObject3 != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.appbrand.o.a)localObject3).referer))) {
      s.a(paramz, paramJSONObject, (Intent)localObject2, ((com.tencent.mm.plugin.appbrand.o.a)localObject3).referer);
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("shouldShowScanQrCodeMenu", true);
      ((Intent)localObject2).putExtra("scanQrCodeGetA8KeyScene", 44);
      ((Intent)localObject2).putExtra("scanCodeTypes", new int[] { 3 });
      ((Intent)localObject2).putExtra("scanResultCodeTypes", new int[] { 22 });
      paramJSONObject = new Bundle();
      paramJSONObject.putInt("stat_scene", 6);
      paramJSONObject.putString("stat_app_id", paramString);
      paramJSONObject.putString("stat_url", paramz.kxv);
      ((Intent)localObject2).putExtra("_stat_obj", paramJSONObject);
      ((Intent)localObject2).setClassName(paramContext, paramContext.getPackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
      try
      {
        i = ((Intent)localObject2).getExtras().toString().length();
        if (i <= 524288) {
          break;
        }
        ae.e("MicroMsg.JsApiPreviewImage", "data too large size:%d", new Object[] { Integer.valueOf(i) });
        paramContext = e("fail:data too large", null);
        AppMethodBeat.o(46577);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        ae.printErrStackTrace("MicroMsg.JsApiPreviewImage", paramContext, "JsApiPreviewImage get size error", new Object[0]);
        paramContext = e("fail", null);
        AppMethodBeat.o(46577);
        return paramContext;
      }
      ae.w("MicroMsg.JsApiPreviewImage", "config.referer is null");
    }
    e.aB(paramContext).b(new e.c()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174841);
        if (l.this.kYK == paramAnonymousInt1)
        {
          com.tencent.mm.plugin.appbrand.jsapi.aa.a.p(this.kYL);
          AppMethodBeat.o(174841);
          return true;
        }
        AppMethodBeat.o(174841);
        return false;
      }
    });
    d.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2, this.kYK, false);
    paramContext = e("ok", null);
    AppMethodBeat.o(46577);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.l
 * JD-Core Version:    0.7.0.1
 */