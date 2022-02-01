package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
  extends com.tencent.mm.plugin.appbrand.jsapi.c<y>
{
  public static final int CTRL_INDEX = 787;
  public static final String NAME = "previewMedia";
  private final int sgZ;
  final int sha;
  
  public n()
  {
    AppMethodBeat.i(180248);
    this.sgZ = 524288;
    this.sha = com.tencent.luggage.sdk.h.a.ce(this);
    AppMethodBeat.o(180248);
  }
  
  private String a(Context paramContext, ad paramad, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180249);
    Object localObject2 = paramJSONObject.optJSONArray("sources");
    if ((localObject2 == null) || (paramad == null) || (paramad.getActivity() == null))
    {
      paramContext = ZP("fail:invalid data");
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
      ((AppBrandMediaSource)localObject3).nBd = ((JSONObject)localObject4).optString("type");
      ((AppBrandMediaSource)localObject3).nBe = ((JSONObject)localObject4).optString("poster");
      arrayOfString[i] = ((AppBrandMediaSource)localObject3).url;
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).nBe))
      {
        localObject4 = paramad.getFileSystem().Wm(((AppBrandMediaSource)localObject3).nBe);
        if (localObject4 != null) {
          ((AppBrandMediaSource)localObject3).nBe = ah.v(((u)localObject4).jKT());
        }
      }
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).url))
      {
        localObject4 = paramad.getFileSystem().Wm(((AppBrandMediaSource)localObject3).url);
        if (localObject4 != null)
        {
          arrayOfString[i] = ah.v(((u)localObject4).jKT());
          ((AppBrandMediaSource)localObject3).url = ah.v(((u)localObject4).jKT());
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
      localObject3 = com.tencent.mm.plugin.appbrand.jsapi.ah.a.p(arrayOfString);
      arrayOfString = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a((String[])localObject3, arrayOfString);
      j = i;
      if (i >= localObject3.length) {
        j = 0;
      }
      if (!(paramContext instanceof Activity))
      {
        paramContext = ZP("fail:internal error invalid android context");
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
        i = paramad.getActivity().getResources().getConfiguration().orientation;
        if (i == 2)
        {
          i = 0;
          ((Intent)localObject2).putExtra("KOrientation", i);
          Log.i("MicroMsg.JsApiPreviewMedia", "KOrientation:%d", new Object[] { Integer.valueOf(i) });
          ((Intent)localObject2).putExtra("showmenu", bool);
          localObject1 = (com.tencent.mm.plugin.appbrand.t.a)paramad.aN(com.tencent.mm.plugin.appbrand.t.a.class);
          if ((localObject1 == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.t.a)localObject1).referer))) {
            break label873;
          }
          t.a(paramad, paramJSONObject, (Intent)localObject2, ((com.tencent.mm.plugin.appbrand.t.a)localObject1).referer);
        }
        for (;;)
        {
          paramJSONObject = (AppBrandInitConfigWC)paramad.getRuntime().asH();
          if (paramJSONObject != null)
          {
            ((Intent)localObject2).putExtra("wxaSessionId", paramJSONObject.eoP);
            ((Intent)localObject2).putExtra("isFromAppBrandGame", paramJSONObject.aqJ());
            if (paramJSONObject.epn != null) {
              ((Intent)localObject2).putExtra("wxaScene", paramJSONObject.epn.scene);
            }
          }
          ((Intent)localObject2).putExtra("shouldShowScanQrCodeMenu", true);
          ((Intent)localObject2).putExtra("scanQrCodeGetA8KeyScene", 44);
          paramJSONObject = new Bundle();
          paramJSONObject.putInt("stat_scene", 6);
          paramJSONObject.putString("stat_app_id", paramString);
          paramJSONObject.putString("stat_url", paramad.cgR());
          paramJSONObject.putString("wxappPathWithQuery", paramad.cEE());
          ((Intent)localObject2).putExtra("_stat_obj", paramJSONObject);
          ((Intent)localObject2).setClassName(paramContext, MMApplicationContext.getSourcePackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
          try
          {
            i = ((Intent)localObject2).getExtras().toString().length();
            if (i <= 524288) {
              break label913;
            }
            Log.e("MicroMsg.JsApiPreviewMedia", "data too large size:%d", new Object[] { Integer.valueOf(i) });
            paramContext = ZP("fail:data too large");
            AppMethodBeat.o(180249);
            return paramContext;
          }
          catch (Exception paramContext)
          {
            label873:
            Log.printErrStackTrace("MicroMsg.JsApiPreviewMedia", paramContext, "JsApiPreviewImage get size error", new Object[0]);
            paramContext = ZP("fail");
            AppMethodBeat.o(180249);
            return paramContext;
          }
          if (i == 1)
          {
            i = 1;
            break;
          }
          i = -1;
          break;
          Log.w("MicroMsg.JsApiPreviewMedia", "config.referer is null");
        }
        label913:
        e.bt(paramContext).b(new e.c()
        {
          public final boolean onResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(180247);
            if (n.this.sha == paramAnonymousInt1)
            {
              com.tencent.mm.plugin.appbrand.jsapi.ah.a.q(arrayOfString);
              AppMethodBeat.o(180247);
              return true;
            }
            AppMethodBeat.o(180247);
            return false;
          }
        });
        com.tencent.mm.br.c.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2, this.sha, false);
        paramContext = ZP("ok");
        AppMethodBeat.o(180249);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.n
 * JD-Core Version:    0.7.0.1
 */