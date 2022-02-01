package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.c<v>
{
  public static final int CTRL_INDEX = 787;
  public static final String NAME = "previewMedia";
  private final int pbL;
  final int pbM;
  
  public m()
  {
    AppMethodBeat.i(180248);
    this.pbL = 524288;
    this.pbM = com.tencent.luggage.sdk.h.a.aI(this);
    AppMethodBeat.o(180248);
  }
  
  private String a(Context paramContext, ad paramad, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180249);
    Object localObject2 = paramJSONObject.optJSONArray("sources");
    if ((localObject2 == null) || (paramad == null) || (paramad.getActivity() == null))
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
      ((AppBrandMediaSource)localObject3).kVJ = ((JSONObject)localObject4).optString("type");
      ((AppBrandMediaSource)localObject3).kVK = ((JSONObject)localObject4).optString("poster");
      arrayOfString[i] = ((AppBrandMediaSource)localObject3).url;
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).kVK))
      {
        localObject4 = paramad.getFileSystem().adL(((AppBrandMediaSource)localObject3).kVK);
        if (localObject4 != null) {
          ((AppBrandMediaSource)localObject3).kVK = ((q)localObject4).bOF();
        }
      }
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).url))
      {
        localObject4 = paramad.getFileSystem().adL(((AppBrandMediaSource)localObject3).url);
        if (localObject4 != null)
        {
          arrayOfString[i] = ((q)localObject4).bOF();
          ((AppBrandMediaSource)localObject3).url = ((q)localObject4).bOF();
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
      localObject3 = com.tencent.mm.plugin.appbrand.jsapi.ae.a.p(arrayOfString);
      arrayOfString = com.tencent.mm.plugin.appbrand.jsapi.ae.a.a((String[])localObject3, arrayOfString);
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
        ((Intent)localObject2).putExtra("KOrientation", paramad.getActivity().getResources().getConfiguration().orientation);
        Log.i("MicroMsg.JsApiPreviewMedia", "KOrientation:%d", new Object[] { Integer.valueOf(paramad.getActivity().getResources().getConfiguration().orientation) });
        ((Intent)localObject2).putExtra("showmenu", bool);
        localObject1 = (com.tencent.mm.plugin.appbrand.s.a)paramad.au(com.tencent.mm.plugin.appbrand.s.a.class);
        if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.s.a)localObject1).referer))) {
          s.a(paramad, paramJSONObject, (Intent)localObject2, ((com.tencent.mm.plugin.appbrand.s.a)localObject1).referer);
        }
        for (;;)
        {
          paramJSONObject = (AppBrandInitConfigWC)paramad.getRuntime().Sq();
          if (paramJSONObject != null)
          {
            ((Intent)localObject2).putExtra("wxaSessionId", paramJSONObject.cwP);
            ((Intent)localObject2).putExtra("isFromAppBrandGame", paramJSONObject.Qv());
            if (paramJSONObject.cxf != null) {
              ((Intent)localObject2).putExtra("wxaScene", paramJSONObject.cxf.scene);
            }
          }
          ((Intent)localObject2).putExtra("shouldShowScanQrCodeMenu", true);
          ((Intent)localObject2).putExtra("scanQrCodeGetA8KeyScene", 44);
          paramJSONObject = new Bundle();
          paramJSONObject.putInt("stat_scene", 6);
          paramJSONObject.putString("stat_app_id", paramString);
          paramJSONObject.putString("stat_url", paramad.oxe);
          paramJSONObject.putString("wxappPathWithQuery", paramad.qoI);
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
        f.aI(paramContext).b(new f.c()
        {
          public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(180247);
            if (m.this.pbM == paramAnonymousInt1)
            {
              com.tencent.mm.plugin.appbrand.jsapi.ae.a.q(arrayOfString);
              AppMethodBeat.o(180247);
              return true;
            }
            AppMethodBeat.o(180247);
            return false;
          }
        });
        com.tencent.mm.by.c.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2, this.pbM, false);
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