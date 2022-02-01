package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = 787;
  public static final String NAME = "previewMedia";
  private final int kVb;
  final int kVc;
  
  public m()
  {
    AppMethodBeat.i(180248);
    this.kVb = 524288;
    this.kVc = com.tencent.luggage.sdk.g.a.aC(this);
    AppMethodBeat.o(180248);
  }
  
  private String a(Context paramContext, aa paramaa, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180249);
    Object localObject2 = paramJSONObject.optJSONArray("sources");
    if (localObject2 == null)
    {
      paramContext = e("fail:invalid data", null);
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
      ((AppBrandMediaSource)localObject3).hkO = ((JSONObject)localObject4).optString("type");
      ((AppBrandMediaSource)localObject3).hkP = ((JSONObject)localObject4).optString("poster");
      arrayOfString[i] = ((AppBrandMediaSource)localObject3).url;
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).hkP))
      {
        localObject4 = paramaa.Fg().Mj(((AppBrandMediaSource)localObject3).hkP);
        if (localObject4 != null) {
          ((AppBrandMediaSource)localObject3).hkP = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject4).fOK());
        }
      }
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).url))
      {
        localObject4 = paramaa.Fg().Mj(((AppBrandMediaSource)localObject3).url);
        if (localObject4 != null)
        {
          arrayOfString[i] = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject4).fOK());
          ((AppBrandMediaSource)localObject3).url = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject4).fOK());
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
      localObject3 = com.tencent.mm.plugin.appbrand.jsapi.z.a.o(arrayOfString);
      arrayOfString = com.tencent.mm.plugin.appbrand.jsapi.z.a.a((String[])localObject3, arrayOfString);
      j = i;
      if (i >= localObject3.length) {
        j = 0;
      }
      if (!(paramContext instanceof Activity))
      {
        paramContext = e("fail:internal error invalid android context", null);
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
        ad.i("MicroMsg.JsApiPreviewMedia", "showmenu:%b", new Object[] { Boolean.valueOf(bool) });
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("nowUrl", localObject3[j]);
        ((Intent)localObject2).putParcelableArrayListExtra("mediaSource", (ArrayList)localObject1);
        ((Intent)localObject2).putExtra("urlList", (String[])localObject3);
        ((Intent)localObject2).putExtra("type", -255);
        ((Intent)localObject2).putExtra("isFromWebView", true);
        ((Intent)localObject2).putExtra("isFromAppBrand", true);
        ((Intent)localObject2).putExtra("showmenu", bool);
        localObject1 = (com.tencent.mm.plugin.appbrand.o.a)paramaa.ar(com.tencent.mm.plugin.appbrand.o.a.class);
        if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.appbrand.o.a)localObject1).referer))) {
          s.a(paramaa, paramJSONObject, (Intent)localObject2, ((com.tencent.mm.plugin.appbrand.o.a)localObject1).referer);
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
          paramJSONObject.putString("stat_url", paramaa.kuf);
          ((Intent)localObject2).putExtra("_stat_obj", paramJSONObject);
          ((Intent)localObject2).setClassName(paramContext, paramContext.getPackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
          try
          {
            i = ((Intent)localObject2).getExtras().toString().length();
            if (i <= 524288) {
              break;
            }
            ad.e("MicroMsg.JsApiPreviewMedia", "data too large size:%d", new Object[] { Integer.valueOf(i) });
            paramContext = e("fail:data too large", null);
            AppMethodBeat.o(180249);
            return paramContext;
          }
          catch (Exception paramContext)
          {
            ad.printErrStackTrace("MicroMsg.JsApiPreviewMedia", paramContext, "JsApiPreviewImage get size error", new Object[0]);
            paramContext = e("fail", null);
            AppMethodBeat.o(180249);
            return paramContext;
          }
          ad.w("MicroMsg.JsApiPreviewMedia", "config.referer is null");
        }
        com.tencent.luggage.h.e.aA(paramContext).b(new e.c()
        {
          public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(180247);
            if (m.this.kVc == paramAnonymousInt1)
            {
              com.tencent.mm.plugin.appbrand.jsapi.z.a.p(arrayOfString);
              AppMethodBeat.o(180247);
              return true;
            }
            AppMethodBeat.o(180247);
            return false;
          }
        });
        d.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2, this.kVc, false);
        paramContext = e("ok", null);
        AppMethodBeat.o(180249);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.m
 * JD-Core Version:    0.7.0.1
 */