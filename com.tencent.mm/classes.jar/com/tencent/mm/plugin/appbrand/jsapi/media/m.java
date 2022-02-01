package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import org.json.JSONArray;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.plugin.appbrand.jsapi.c<y>
{
  public static final int CTRL_INDEX = 30;
  public static final String NAME = "previewImage";
  private final int sgZ;
  final int sha;
  
  public m()
  {
    AppMethodBeat.i(174842);
    this.sgZ = 524288;
    this.sha = com.tencent.luggage.sdk.h.a.ce(this);
    AppMethodBeat.o(174842);
  }
  
  private String a(Context paramContext, ad paramad, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46577);
    Object localObject1 = paramJSONObject.optJSONArray("urls");
    if ((localObject1 == null) || (paramad == null) || (paramad.getActivity() == null))
    {
      paramContext = ZP("fail:invalid data");
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
    localObject1 = paramJSONObject.opt("current");
    if ((localObject1 instanceof Integer)) {
      i = ((Integer)localObject1).intValue();
    }
    for (;;)
    {
      int j = 0;
      while (j < localObject3.length)
      {
        localObject2 = paramad.getFileSystem().Wm(localObject3[j]);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramad.getFileSystem().Wj(localObject3[j]);
        }
        if (localObject1 != null) {
          localObject3[j] = ah.v(((u)localObject1).jKT());
        }
        j += 1;
        continue;
        if (!(localObject1 instanceof String)) {
          break label833;
        }
        j = 0;
        int k = 0;
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
      }
      String[] arrayOfString = com.tencent.mm.plugin.appbrand.jsapi.ah.a.p((String[])localObject3);
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a(arrayOfString, (String[])localObject3);
      j = i;
      if (i >= arrayOfString.length) {
        j = 0;
      }
      if (!(paramContext instanceof Activity))
      {
        paramContext = ZP("fail:internal error invalid android context");
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
      i = paramad.getActivity().getResources().getConfiguration().orientation;
      if (i == 2)
      {
        i = 0;
        Log.i("MicroMsg.JsApiPreviewImage", "KOrientation:%d", new Object[] { Integer.valueOf(i) });
        ((Intent)localObject2).putExtra("KOrientation", i);
        localObject3 = (com.tencent.mm.plugin.appbrand.t.a)paramad.aN(com.tencent.mm.plugin.appbrand.t.a.class);
        if ((localObject3 == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.t.a)localObject3).referer))) {
          break label744;
        }
        t.a(paramad, paramJSONObject, (Intent)localObject2, ((com.tencent.mm.plugin.appbrand.t.a)localObject3).referer);
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
            break label784;
          }
          Log.e("MicroMsg.JsApiPreviewImage", "data too large size:%d", new Object[] { Integer.valueOf(i) });
          paramContext = ZP("fail:data too large");
          AppMethodBeat.o(46577);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          label744:
          Log.printErrStackTrace("MicroMsg.JsApiPreviewImage", paramContext, "JsApiPreviewImage get size error", new Object[0]);
          paramContext = ZP("fail");
          AppMethodBeat.o(46577);
          return paramContext;
        }
        if (i == 1)
        {
          i = 1;
          break;
        }
        i = -1;
        break;
        Log.w("MicroMsg.JsApiPreviewImage", "config.referer is null");
      }
      label784:
      e.bt(paramContext).b(new e.c()
      {
        public final boolean onResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(174841);
          if (m.this.sha == paramAnonymousInt1)
          {
            com.tencent.mm.plugin.appbrand.jsapi.ah.a.q(this.shb);
            AppMethodBeat.o(174841);
            return true;
          }
          AppMethodBeat.o(174841);
          return false;
        }
      });
      com.tencent.mm.br.c.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2, this.sha, false);
      paramContext = ZP("ok");
      AppMethodBeat.o(46577);
      return paramContext;
      label833:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.m
 * JD-Core Version:    0.7.0.1
 */