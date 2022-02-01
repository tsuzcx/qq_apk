package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.jl;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.o.a.a;
import com.tencent.mm.plugin.appbrand.o.a.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.lite.jsapi.b
{
  private void ba(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(231287);
    jl localjl = new jl();
    String str1 = paramJSONObject.optString("task_name");
    String str2 = paramJSONObject.optString("task_url");
    String str3 = paramJSONObject.optString("alternative_url");
    long l = paramJSONObject.optLong("task_size");
    String str4 = paramJSONObject.optString("file_md5");
    String str8 = paramJSONObject.optString("extInfo");
    String str5 = paramJSONObject.optString("fileType");
    String str6 = paramJSONObject.optString("appid");
    String str7 = paramJSONObject.optString("package_name");
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("downloader_type", 1);
    int k = paramJSONObject.optInt("download_type", 1);
    int m = paramJSONObject.optInt("ssid");
    int n = paramJSONObject.optInt("uiarea");
    int i1 = paramJSONObject.optInt("notice_id");
    localjl.fGJ.url = str2;
    localjl.fGJ.md5 = str4;
    localjl.fGJ.extInfo = str8;
    localjl.fGJ.appId = str6;
    localjl.fGJ.scene = i;
    EventCenter.instance.publish(localjl);
    paramJSONObject = new g.a();
    paramJSONObject.atc(str2);
    paramJSONObject.atd(str3);
    paramJSONObject.setFileSize(l);
    paramJSONObject.ate(str1);
    paramJSONObject.setFileMD5(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.setPackageName(str7);
    paramJSONObject.me(true);
    paramJSONObject.IS(Util.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.IW(k);
    paramJSONObject.IT(m);
    paramJSONObject.IU(n);
    paramJSONObject.IV(i1);
    paramJSONObject = paramJSONObject.uhY;
    if (j == 1) {}
    for (l = f.cPZ().b(paramJSONObject);; l = f.cPZ().a(paramJSONObject))
    {
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      if (l > 0L) {
        break;
      }
      this.Ega.aNa("fail");
      AppMethodBeat.o(231287);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      this.Ega.bd(paramJSONObject);
      AppMethodBeat.o(231287);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      this.Ega.aNa("exception");
      AppMethodBeat.o(231287);
    }
  }
  
  public final void a(final String paramString, final JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(231285);
    paramString = paramJSONObject.optString("task_url");
    long l = paramJSONObject.optLong("task_size");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("LiteAppJsApiAddDownloadTaskStraight", "url is null");
      this.Ega.aNa("uri is null");
      AppMethodBeat.o(231285);
      return;
    }
    final String str1 = paramJSONObject.optString("appid");
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("download_type", 1);
    int k = paramJSONObject.optInt("ssid");
    int m = paramJSONObject.optInt("uiarea");
    int n = paramJSONObject.optInt("notice_id");
    com.tencent.mm.plugin.downloader.f.a.a(9, new com.tencent.mm.plugin.downloader.f.b(str1, i, paramJSONObject.optString("extInfo"), m, k, n, j));
    final String str2 = paramJSONObject.optString("currentUrl");
    if (paramJSONObject.optBoolean("use_downloader_widget", false))
    {
      paramString = com.tencent.mm.plugin.downloader_app.a.a.aO(paramJSONObject);
      o.a(MMApplicationContext.getContext(), paramString, new o.a()
      {
        public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(231799);
          if (paramAnonymousString != null)
          {
            a.b(a.this).aNa(paramAnonymousString);
            AppMethodBeat.o(231799);
            return;
          }
          a.c(a.this).bd(paramAnonymousJSONObject);
          AppMethodBeat.o(231799);
        }
      });
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(231285);
      return;
    }
    final Context localContext = MMApplicationContext.getContext();
    if (!NetStatusUtil.isNetworkConnected(localContext))
    {
      this.Ega.aNa("fail_network_not_connected");
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231877);
          Toast.makeText(localContext, localContext.getString(a.b.game_download_network_unavailable), 0).show();
          AppMethodBeat.o(231877);
        }
      });
      Log.i("LiteAppJsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(231285);
      return;
    }
    if (!e.avA())
    {
      this.Ega.aNa("sdcard_not_ready");
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231017);
          Toast.makeText(localContext, localContext.getString(a.b.game_download_sdcard_unavailable), 0).show();
          AppMethodBeat.o(231017);
        }
      });
      Log.i("LiteAppJsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(231285);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.plugin.downloader.model.h.IO(l)) && (!com.tencent.mm.plugin.downloader.model.h.IN(l)))
    {
      this.Ega.aNa("has_not_enough_space");
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(230920);
          Toast.makeText(localContext, localContext.getString(a.b.game_download_not_enough_space), 0).show();
          AppMethodBeat.o(230920);
        }
      });
      Log.i("LiteAppJsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(231285);
      return;
    }
    if (NetStatusUtil.isWifi(localContext))
    {
      ba(paramJSONObject);
      AppMethodBeat.o(231285);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(14217, new Object[] { str1, Integer.valueOf(4), str2, paramString, Integer.valueOf(3) });
    com.tencent.mm.ui.base.h.a(localContext, localContext.getString(a.b.webview_download_ui_download_not_in_wifi_tips), localContext.getString(a.b.webview_download_ui_download_not_in_wifi_title), localContext.getString(a.b.webview_download_ui_btn_state_to_download), localContext.getString(a.b.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(231624);
        com.tencent.mm.plugin.report.service.h.IzE.a(14217, new Object[] { str1, Integer.valueOf(5), str2, paramString, Integer.valueOf(3) });
        a.a(a.this, paramJSONObject);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(231624);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(231505);
        com.tencent.mm.plugin.report.service.h.IzE.a(14217, new Object[] { str1, Integer.valueOf(6), str2, paramString, Integer.valueOf(3) });
        paramAnonymousDialogInterface.dismiss();
        a.a(a.this).aNa("network_not_wifi");
        AppMethodBeat.o(231505);
      }
    }, a.a.wechat_green);
    AppMethodBeat.o(231285);
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.a
 * JD-Core Version:    0.7.0.1
 */