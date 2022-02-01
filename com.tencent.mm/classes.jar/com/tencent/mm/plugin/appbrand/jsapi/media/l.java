package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends d<com.tencent.mm.plugin.appbrand.s>
{
  public static final int CTRL_INDEX = 30;
  public static final String NAME = "previewImage";
  private final int mdT;
  final int mdU;
  
  public l()
  {
    AppMethodBeat.i(174842);
    this.mdT = 524288;
    this.mdU = com.tencent.luggage.sdk.g.a.aK(this);
    AppMethodBeat.o(174842);
  }
  
  private String a(Context paramContext, ac paramac, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46577);
    Object localObject1 = paramJSONObject.optJSONArray("urls");
    if (localObject1 == null)
    {
      paramContext = h("fail:invalid data", null);
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
        localObject2 = paramac.getFileSystem().VY(localObject3[j]);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramac.getFileSystem().VV(localObject3[j]);
        }
        if (localObject1 != null) {
          localObject3[j] = aa.z(((o)localObject1).her());
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
    String[] arrayOfString = com.tencent.mm.plugin.appbrand.jsapi.ac.a.q((String[])localObject3);
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.ac.a.a(arrayOfString, (String[])localObject3);
    j = i;
    if (i >= arrayOfString.length) {
      j = 0;
    }
    if (!(paramContext instanceof Activity))
    {
      paramContext = h("fail:internal error invalid android context", null);
      AppMethodBeat.o(46577);
      return paramContext;
    }
    boolean bool = paramJSONObject.optBoolean("showmenu", true);
    Log.i("MicroMsg.JsApiPreviewImage", "showmenu:%b", new Object[] { Boolean.valueOf(bool) });
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("nowUrl", arrayOfString[j]);
    ((Intent)localObject2).putExtra("urlList", arrayOfString);
    ((Intent)localObject2).putExtra("type", -255);
    ((Intent)localObject2).putExtra("isFromWebView", true);
    ((Intent)localObject2).putExtra("isFromAppBrand", true);
    ((Intent)localObject2).putExtra("showmenu", bool);
    localObject3 = (com.tencent.mm.plugin.appbrand.s.a)paramac.av(com.tencent.mm.plugin.appbrand.s.a.class);
    if ((localObject3 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.s.a)localObject3).referer))) {
      s.a(paramac, paramJSONObject, (Intent)localObject2, ((com.tencent.mm.plugin.appbrand.s.a)localObject3).referer);
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
      paramJSONObject.putString("stat_url", paramac.lBI);
      ((Intent)localObject2).putExtra("_stat_obj", paramJSONObject);
      ((Intent)localObject2).setClassName(paramContext, MMApplicationContext.getSourcePackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
      try
      {
        i = ((Intent)localObject2).getExtras().toString().length();
        if (i <= 524288) {
          break;
        }
        Log.e("MicroMsg.JsApiPreviewImage", "data too large size:%d", new Object[] { Integer.valueOf(i) });
        paramContext = h("fail:data too large", null);
        AppMethodBeat.o(46577);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.JsApiPreviewImage", paramContext, "JsApiPreviewImage get size error", new Object[0]);
        paramContext = h("fail", null);
        AppMethodBeat.o(46577);
        return paramContext;
      }
      Log.w("MicroMsg.JsApiPreviewImage", "config.referer is null");
    }
    f.aK(paramContext).b(new f.c()
    {
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174841);
        if (l.this.mdU == paramAnonymousInt1)
        {
          com.tencent.mm.plugin.appbrand.jsapi.ac.a.r(this.mdV);
          AppMethodBeat.o(174841);
          return true;
        }
        AppMethodBeat.o(174841);
        return false;
      }
    });
    c.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2, this.mdU, false);
    paramContext = h("ok", null);
    AppMethodBeat.o(46577);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.l
 * JD-Core Version:    0.7.0.1
 */