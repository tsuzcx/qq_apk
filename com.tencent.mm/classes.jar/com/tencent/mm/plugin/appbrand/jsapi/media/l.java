package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = 30;
  public static final String NAME = "previewImage";
  private final int kVb;
  final int kVc;
  
  public l()
  {
    AppMethodBeat.i(174842);
    this.kVb = 524288;
    this.kVc = com.tencent.luggage.sdk.g.a.aC(this);
    AppMethodBeat.o(174842);
  }
  
  private String a(Context paramContext, aa paramaa, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46577);
    Object localObject1 = paramJSONObject.optJSONArray("urls");
    if (localObject1 == null)
    {
      paramContext = e("fail:invalid data", null);
      AppMethodBeat.o(46577);
      return paramContext;
    }
    final String[] arrayOfString = new String[((JSONArray)localObject1).length()];
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      arrayOfString[i] = ((JSONArray)localObject1).optString(i);
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
      while (j < arrayOfString.length)
      {
        localObject1 = paramaa.Fg().Mj(arrayOfString[j]);
        if (localObject1 != null) {
          arrayOfString[j] = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject1).fOK());
        }
        j += 1;
      }
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= arrayOfString.length) {
        break;
      }
      if (localObject1.equals(arrayOfString[j])) {
        k = j;
      }
      j += 1;
    }
    Object localObject2 = com.tencent.mm.plugin.appbrand.jsapi.z.a.o(arrayOfString);
    arrayOfString = com.tencent.mm.plugin.appbrand.jsapi.z.a.a((String[])localObject2, arrayOfString);
    j = i;
    if (i >= localObject2.length) {
      j = 0;
    }
    if (!(paramContext instanceof Activity))
    {
      paramContext = e("fail:internal error invalid android context", null);
      AppMethodBeat.o(46577);
      return paramContext;
    }
    boolean bool = paramJSONObject.optBoolean("showmenu", true);
    ad.i("MicroMsg.JsApiPreviewImage", "showmenu:%b", new Object[] { Boolean.valueOf(bool) });
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("nowUrl", localObject2[j]);
    ((Intent)localObject1).putExtra("urlList", (String[])localObject2);
    ((Intent)localObject1).putExtra("type", -255);
    ((Intent)localObject1).putExtra("isFromWebView", true);
    ((Intent)localObject1).putExtra("isFromAppBrand", true);
    ((Intent)localObject1).putExtra("showmenu", bool);
    localObject2 = (com.tencent.mm.plugin.appbrand.o.a)paramaa.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    if ((localObject2 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.appbrand.o.a)localObject2).referer))) {
      s.a(paramaa, paramJSONObject, (Intent)localObject1, ((com.tencent.mm.plugin.appbrand.o.a)localObject2).referer);
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("shouldShowScanQrCodeMenu", true);
      ((Intent)localObject1).putExtra("scanQrCodeGetA8KeyScene", 44);
      ((Intent)localObject1).putExtra("scanCodeTypes", new int[] { 3 });
      ((Intent)localObject1).putExtra("scanResultCodeTypes", new int[] { 22 });
      paramJSONObject = new Bundle();
      paramJSONObject.putInt("stat_scene", 6);
      paramJSONObject.putString("stat_app_id", paramString);
      paramJSONObject.putString("stat_url", paramaa.kuf);
      ((Intent)localObject1).putExtra("_stat_obj", paramJSONObject);
      ((Intent)localObject1).setClassName(paramContext, paramContext.getPackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
      try
      {
        i = ((Intent)localObject1).getExtras().toString().length();
        if (i <= 524288) {
          break;
        }
        ad.e("MicroMsg.JsApiPreviewImage", "data too large size:%d", new Object[] { Integer.valueOf(i) });
        paramContext = e("fail:data too large", null);
        AppMethodBeat.o(46577);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        ad.printErrStackTrace("MicroMsg.JsApiPreviewImage", paramContext, "JsApiPreviewImage get size error", new Object[0]);
        paramContext = e("fail", null);
        AppMethodBeat.o(46577);
        return paramContext;
      }
      ad.w("MicroMsg.JsApiPreviewImage", "config.referer is null");
    }
    com.tencent.luggage.h.e.aA(paramContext).b(new e.c()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174841);
        if (l.this.kVc == paramAnonymousInt1)
        {
          com.tencent.mm.plugin.appbrand.jsapi.z.a.p(arrayOfString);
          AppMethodBeat.o(174841);
          return true;
        }
        AppMethodBeat.o(174841);
        return false;
      }
    });
    d.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject1, this.kVc, false);
    paramContext = e("ok", null);
    AppMethodBeat.o(46577);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.l
 * JD-Core Version:    0.7.0.1
 */