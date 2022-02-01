package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m
  extends d<com.tencent.mm.plugin.appbrand.s>
{
  public static final int CTRL_INDEX = 787;
  public static final String NAME = "previewMedia";
  private final int mdT;
  final int mdU;
  
  public m()
  {
    AppMethodBeat.i(180248);
    this.mdT = 524288;
    this.mdU = com.tencent.luggage.sdk.g.a.aK(this);
    AppMethodBeat.o(180248);
  }
  
  private String a(Context paramContext, ac paramac, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180249);
    Object localObject2 = paramJSONObject.optJSONArray("sources");
    if (localObject2 == null)
    {
      paramContext = h("fail:invalid data", null);
      AppMethodBeat.o(180249);
      return paramContext;
    }
    final String[] arrayOfString = new String[((JSONArray)localObject2).length()];
    Object localObject1 = new ArrayList();
    int i = 0;
    Object localObject3;
    while (i < ((JSONArray)localObject2).length())
    {
      Object localObject4 = ((JSONArray)localObject2).optJSONObject(i);
      localObject3 = new AppBrandMediaSource();
      ((AppBrandMediaSource)localObject3).url = ((JSONObject)localObject4).optString("url");
      ((AppBrandMediaSource)localObject3).igV = ((JSONObject)localObject4).optString("type");
      ((AppBrandMediaSource)localObject3).igW = ((JSONObject)localObject4).optString("poster");
      arrayOfString[i] = ((AppBrandMediaSource)localObject3).url;
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).igW))
      {
        localObject4 = paramac.getFileSystem().VY(((AppBrandMediaSource)localObject3).igW);
        if (localObject4 != null) {
          ((AppBrandMediaSource)localObject3).igW = aa.z(((o)localObject4).her());
        }
      }
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).url))
      {
        localObject4 = paramac.getFileSystem().VY(((AppBrandMediaSource)localObject3).url);
        if (localObject4 != null)
        {
          arrayOfString[i] = aa.z(((o)localObject4).her());
          ((AppBrandMediaSource)localObject3).url = aa.z(((o)localObject4).her());
        }
      }
      ((ArrayList)localObject1).add(localObject3);
      i += 1;
    }
    int k = 0;
    int j = 0;
    localObject2 = paramJSONObject.opt("current");
    if ((localObject2 instanceof Integer)) {}
    for (j = ((Integer)localObject2).intValue();; j = k)
    {
      if (j >= 0)
      {
        i = j;
        if (j < arrayOfString.length) {}
      }
      else
      {
        i = 0;
      }
      localObject3 = com.tencent.mm.plugin.appbrand.jsapi.ac.a.q(arrayOfString);
      arrayOfString = com.tencent.mm.plugin.appbrand.jsapi.ac.a.a((String[])localObject3, arrayOfString);
      j = i;
      if (i >= localObject3.length) {
        j = 0;
      }
      if (!(paramContext instanceof Activity))
      {
        paramContext = h("fail:internal error invalid android context", null);
        AppMethodBeat.o(180249);
        return paramContext;
        if ((localObject2 instanceof String))
        {
          i = 0;
          for (;;)
          {
            k = j;
            if (i >= arrayOfString.length) {
              break;
            }
            if (localObject2.equals(arrayOfString[i])) {
              j = i;
            }
            i += 1;
          }
        }
      }
      else
      {
        boolean bool = paramJSONObject.optBoolean("showmenu", true);
        Log.i("MicroMsg.JsApiPreviewMedia", "showmenu:%b", new Object[] { Boolean.valueOf(bool) });
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("nowUrl", localObject3[j]);
        ((Intent)localObject2).putParcelableArrayListExtra("mediaSource", (ArrayList)localObject1);
        ((Intent)localObject2).putExtra("urlList", (String[])localObject3);
        ((Intent)localObject2).putExtra("type", -255);
        ((Intent)localObject2).putExtra("isFromWebView", true);
        ((Intent)localObject2).putExtra("isFromAppBrand", true);
        ((Intent)localObject2).putExtra("showmenu", bool);
        localObject1 = (com.tencent.mm.plugin.appbrand.s.a)paramac.av(com.tencent.mm.plugin.appbrand.s.a.class);
        if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.s.a)localObject1).referer))) {
          s.a(paramac, paramJSONObject, (Intent)localObject2, ((com.tencent.mm.plugin.appbrand.s.a)localObject1).referer);
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
            Log.e("MicroMsg.JsApiPreviewMedia", "data too large size:%d", new Object[] { Integer.valueOf(i) });
            paramContext = h("fail:data too large", null);
            AppMethodBeat.o(180249);
            return paramContext;
          }
          catch (Exception paramContext)
          {
            Log.printErrStackTrace("MicroMsg.JsApiPreviewMedia", paramContext, "JsApiPreviewImage get size error", new Object[0]);
            paramContext = h("fail", null);
            AppMethodBeat.o(180249);
            return paramContext;
          }
          Log.w("MicroMsg.JsApiPreviewMedia", "config.referer is null");
        }
        f.aK(paramContext).b(new f.c()
        {
          public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(180247);
            if (m.this.mdU == paramAnonymousInt1)
            {
              com.tencent.mm.plugin.appbrand.jsapi.ac.a.r(arrayOfString);
              AppMethodBeat.o(180247);
              return true;
            }
            AppMethodBeat.o(180247);
            return false;
          }
        });
        c.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2, this.mdU, false);
        paramContext = h("ok", null);
        AppMethodBeat.o(180249);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.m
 * JD-Core Version:    0.7.0.1
 */