package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public class k
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  private void xX(long paramLong)
  {
    AppMethodBeat.i(193045);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(paramLong);
    if ((locala != null) && (locala.field_fromDownloadApp))
    {
      locala.field_fromDownloadApp = false;
      locala.field_showNotification = true;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    if (f.cdA().ul(paramLong)) {
      this.vko.cZN();
    }
    for (;;)
    {
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(193045);
      return;
      this.vko.ZC("fail");
    }
  }
  
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193044);
    final long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      ae.e("LiteAppJsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.vko.ZC("invalid_downloadid");
      AppMethodBeat.o(193044);
      return;
    }
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("uiarea");
    int k = paramJSONObject.optInt("notice_id");
    int m = paramJSONObject.optInt("ssid");
    int n = paramJSONObject.optInt("download_type", 1);
    paramString = com.tencent.mm.plugin.downloader.model.d.ur(l);
    paramString.field_scene = i;
    paramString.field_uiarea = j;
    paramString.field_noticeId = k;
    paramString.field_ssid = m;
    paramString.field_downloadType = n;
    com.tencent.mm.plugin.downloader.model.d.e(paramString);
    if (paramString != null)
    {
      b localb = new b();
      localb.k(paramString);
      localb.mxN = 0L;
      com.tencent.mm.plugin.downloader.f.a.a(10, localb);
    }
    boolean bool1 = paramJSONObject.optBoolean("use_downloader_widget", false);
    boolean bool2 = paramJSONObject.optBoolean("download_in_wifi", false);
    paramString = ak.getContext();
    if (bool1)
    {
      o.a(ak.getContext(), l, bool2, new o.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(193043);
          if (paramAnonymousString != null)
          {
            k.b(k.this).ZC(paramAnonymousString);
            AppMethodBeat.o(193043);
            return;
          }
          k.c(k.this).aA(paramAnonymousJSONObject);
          AppMethodBeat.o(193043);
        }
      });
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(193044);
      return;
    }
    if (az.isWifi(paramString))
    {
      xX(l);
      AppMethodBeat.o(193044);
      return;
    }
    h.a(paramString, paramString.getString(2131766086), paramString.getString(2131766087), paramString.getString(2131766081), paramString.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(193041);
        k.a(k.this, l);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(193041);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(193042);
        paramAnonymousDialogInterface.dismiss();
        k.a(k.this).ZC("fail_network_not_wifi");
        AppMethodBeat.o(193042);
      }
    }, 2131101171);
    AppMethodBeat.o(193044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.k
 * JD-Core Version:    0.7.0.1
 */