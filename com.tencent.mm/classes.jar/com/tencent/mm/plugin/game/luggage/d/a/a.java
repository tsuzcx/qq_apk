package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.km;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.p.a.a;
import com.tencent.mm.plugin.appbrand.p.a.b;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.threadpool.i;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.lite.api.e
{
  private void bn(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(277093);
    km localkm = new km();
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
    localkm.hMf.url = str2;
    localkm.hMf.md5 = str4;
    localkm.hMf.extInfo = str8;
    localkm.hMf.appId = str6;
    localkm.hMf.scene = i;
    localkm.publish();
    paramJSONObject = new g.a();
    paramJSONObject.amR(str2);
    paramJSONObject.amS(str3);
    paramJSONObject.setFileSize(l);
    paramJSONObject.amT(str1);
    paramJSONObject.setFileMD5(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.setPackageName(str7);
    paramJSONObject.nA(true);
    paramJSONObject.JA(Util.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.JE(k);
    paramJSONObject.JB(m);
    paramJSONObject.JC(n);
    paramJSONObject.JD(i1);
    paramJSONObject = paramJSONObject.xoe;
    if (j == 1) {}
    for (l = f.duv().b(paramJSONObject);; l = f.duv().a(paramJSONObject))
    {
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      if (l > 0L) {
        break;
      }
      this.JZj.aJV("fail");
      AppMethodBeat.o(277093);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      this.JZj.bq(paramJSONObject);
      AppMethodBeat.o(277093);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      this.JZj.aJV("exception");
      AppMethodBeat.o(277093);
    }
  }
  
  public final void a(final String paramString, final JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277117);
    paramString = paramJSONObject.optString("task_url");
    long l = paramJSONObject.optLong("task_size");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("LiteAppJsApiAddDownloadTaskStraight", "url is null");
      this.JZj.aJV("uri is null");
      AppMethodBeat.o(277117);
      return;
    }
    final String str1 = paramJSONObject.optString("appid");
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("download_type", 1);
    int k = paramJSONObject.optInt("ssid");
    int m = paramJSONObject.optInt("uiarea");
    int n = paramJSONObject.optInt("notice_id");
    com.tencent.mm.plugin.downloader.e.a.a(9, new b(str1, i, paramJSONObject.optString("extInfo"), m, k, n, j));
    final String str2 = paramJSONObject.optString("currentUrl");
    if (paramJSONObject.optBoolean("use_downloader_widget", false))
    {
      paramString = com.tencent.mm.plugin.downloader_app.a.a.aZ(paramJSONObject);
      o.a(MMApplicationContext.getContext(), paramString, new o.a()
      {
        public final void j(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(277109);
          if (paramAnonymousString != null)
          {
            a.b(a.this).aJV(paramAnonymousString);
            AppMethodBeat.o(277109);
            return;
          }
          a.c(a.this).bq(paramAnonymousJSONObject);
          AppMethodBeat.o(277109);
        }
      });
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(277117);
      return;
    }
    final Context localContext = MMApplicationContext.getContext();
    if (!NetStatusUtil.isNetworkConnected(localContext))
    {
      this.JZj.aJV("fail_network_not_connected");
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(277108);
          Toast.makeText(localContext, localContext.getString(a.b.game_download_network_unavailable), 0).show();
          AppMethodBeat.o(277108);
        }
      });
      Log.i("LiteAppJsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(277117);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.aPU())
    {
      this.JZj.aJV("sdcard_not_ready");
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(277105);
          Toast.makeText(localContext, localContext.getString(a.b.game_download_sdcard_unavailable), 0).show();
          AppMethodBeat.o(277105);
        }
      });
      Log.i("LiteAppJsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(277117);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.plugin.downloader.model.h.lj(l)) && (!com.tencent.mm.plugin.downloader.model.h.li(l)))
    {
      this.JZj.aJV("has_not_enough_space");
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(277103);
          Toast.makeText(localContext, localContext.getString(a.b.game_download_not_enough_space), 0).show();
          AppMethodBeat.o(277103);
        }
      });
      Log.i("LiteAppJsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(277117);
      return;
    }
    if (NetStatusUtil.isWifi(localContext))
    {
      bn(paramJSONObject);
      AppMethodBeat.o(277117);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str1, Integer.valueOf(4), str2, paramString, Integer.valueOf(3) });
    k.a(localContext, localContext.getString(a.b.webview_download_ui_download_not_in_wifi_tips), localContext.getString(a.b.webview_download_ui_download_not_in_wifi_title), localContext.getString(a.b.webview_download_ui_btn_state_to_download), localContext.getString(a.b.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(277107);
        com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str1, Integer.valueOf(5), str2, paramString, Integer.valueOf(3) });
        a.a(a.this, paramJSONObject);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(277107);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(277104);
        com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { str1, Integer.valueOf(6), str2, paramString, Integer.valueOf(3) });
        paramAnonymousDialogInterface.dismiss();
        a.a(a.this).aJV("network_not_wifi");
        AppMethodBeat.o(277104);
      }
    }, a.a.wechat_green);
    AppMethodBeat.o(277117);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.a
 * JD-Core Version:    0.7.0.1
 */