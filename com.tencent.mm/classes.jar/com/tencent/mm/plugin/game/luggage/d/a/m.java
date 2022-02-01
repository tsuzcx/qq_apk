package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p.a.a;
import com.tencent.mm.plugin.appbrand.p.a.b;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.k;
import org.json.JSONObject;

public class m
  extends e
{
  private void rE(long paramLong)
  {
    AppMethodBeat.i(277062);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(paramLong);
    if ((locala != null) && (locala.field_fromDownloadApp))
    {
      locala.field_fromDownloadApp = false;
      locala.field_showNotification = true;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    if (f.duv().kU(paramLong)) {
      this.JZj.fTW();
    }
    for (;;)
    {
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(277062);
      return;
      this.JZj.aJV("fail");
    }
  }
  
  public final void a(String paramString, final JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277113);
    final long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.e("LiteAppJsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.JZj.aJV("invalid_downloadid");
      AppMethodBeat.o(277113);
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
      paramString = com.tencent.mm.plugin.downloader.model.d.la(l);
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
        localb.costTime = 0L;
        com.tencent.mm.plugin.downloader.e.a.a(10, localb);
      }
      boolean bool1 = paramJSONObject.optBoolean("use_downloader_widget", false);
      boolean bool2 = paramJSONObject.optBoolean("download_in_wifi", false);
      paramString = MMApplicationContext.getContext();
      if (!bool1) {
        break;
      }
      o.a(MMApplicationContext.getContext(), l, bool2, paramBoolean, new o.a()
      {
        public final void j(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(277090);
          if (paramAnonymousString != null)
          {
            m.b(m.this).aJV(paramAnonymousString);
            AppMethodBeat.o(277090);
            return;
          }
          m.c(m.this).bq(paramAnonymousJSONObject);
          AppMethodBeat.o(277090);
        }
      });
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(277113);
      return;
    }
    if (NetStatusUtil.isWifi(paramString))
    {
      rE(l);
      AppMethodBeat.o(277113);
      return;
    }
    k.a(paramString, paramString.getString(a.b.webview_download_ui_download_not_in_wifi_tips), paramString.getString(a.b.webview_download_ui_download_not_in_wifi_title), paramString.getString(a.b.webview_download_ui_btn_state_to_download), paramString.getString(a.b.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(277092);
        m.a(m.this, l);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(277092);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(277089);
        paramAnonymousDialogInterface.dismiss();
        m.a(m.this).aJV("fail_network_not_wifi");
        AppMethodBeat.o(277089);
      }
    }, a.a.wechat_green);
    AppMethodBeat.o(277113);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.m
 * JD-Core Version:    0.7.0.1
 */