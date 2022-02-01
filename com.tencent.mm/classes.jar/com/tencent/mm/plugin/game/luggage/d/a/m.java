package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.a.a;
import com.tencent.mm.plugin.appbrand.o.a.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public class m
  extends com.tencent.mm.plugin.lite.jsapi.b
{
  private void NN(long paramLong)
  {
    AppMethodBeat.i(231085);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
    if ((locala != null) && (locala.field_fromDownloadApp))
    {
      locala.field_fromDownloadApp = false;
      locala.field_showNotification = true;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    if (f.cPZ().Iz(paramLong)) {
      this.Ega.eLC();
    }
    for (;;)
    {
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(231085);
      return;
      this.Ega.aNa("fail");
    }
  }
  
  public final void a(String paramString, final JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(231083);
    final long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.e("LiteAppJsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.Ega.aNa("invalid_downloadid");
      AppMethodBeat.o(231083);
      return;
    }
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("uiarea");
    int k = paramJSONObject.optInt("notice_id");
    int m = paramJSONObject.optInt("ssid");
    int n = paramJSONObject.optInt("download_type", 1);
    if (paramJSONObject.optInt("ignoreNetwork", 0) == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString = com.tencent.mm.plugin.downloader.model.d.IF(l);
      paramString.field_scene = i;
      paramString.field_uiarea = j;
      paramString.field_noticeId = k;
      paramString.field_ssid = m;
      paramString.field_downloadType = n;
      com.tencent.mm.plugin.downloader.model.d.e(paramString);
      if (paramString != null)
      {
        com.tencent.mm.plugin.downloader.f.b localb = new com.tencent.mm.plugin.downloader.f.b();
        localb.k(paramString);
        localb.costTime = 0L;
        com.tencent.mm.plugin.downloader.f.a.a(10, localb);
      }
      boolean bool1 = paramJSONObject.optBoolean("use_downloader_widget", false);
      boolean bool2 = paramJSONObject.optBoolean("download_in_wifi", false);
      paramString = MMApplicationContext.getContext();
      if (!bool1) {
        break;
      }
      o.a(MMApplicationContext.getContext(), l, bool2, paramBoolean, new o.a()
      {
        public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(231128);
          if (paramAnonymousString != null)
          {
            m.b(m.this).aNa(paramAnonymousString);
            AppMethodBeat.o(231128);
            return;
          }
          m.c(m.this).bd(paramAnonymousJSONObject);
          AppMethodBeat.o(231128);
        }
      });
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(231083);
      return;
    }
    if (NetStatusUtil.isWifi(paramString))
    {
      NN(l);
      AppMethodBeat.o(231083);
      return;
    }
    h.a(paramString, paramString.getString(a.b.webview_download_ui_download_not_in_wifi_tips), paramString.getString(a.b.webview_download_ui_download_not_in_wifi_title), paramString.getString(a.b.webview_download_ui_btn_state_to_download), paramString.getString(a.b.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(232071);
        m.a(m.this, l);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(232071);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(231044);
        paramAnonymousDialogInterface.dismiss();
        m.a(m.this).aNa("fail_network_not_wifi");
        AppMethodBeat.o(231044);
      }
    }, a.a.wechat_green);
    AppMethodBeat.o(231083);
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.m
 * JD-Core Version:    0.7.0.1
 */