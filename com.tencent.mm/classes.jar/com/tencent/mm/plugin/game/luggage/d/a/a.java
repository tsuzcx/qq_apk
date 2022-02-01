package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.modelstat.d;
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
  private void aT(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186897);
    iv localiv = new iv();
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
    localiv.dNx.url = str2;
    localiv.dNx.md5 = str4;
    localiv.dNx.extInfo = str8;
    localiv.dNx.appId = str6;
    localiv.dNx.scene = i;
    EventCenter.instance.publish(localiv);
    paramJSONObject = new g.a();
    paramJSONObject.alj(str2);
    paramJSONObject.alk(str3);
    paramJSONObject.setFileSize(l);
    paramJSONObject.all(str1);
    paramJSONObject.setFileMD5(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.gm(str7);
    paramJSONObject.kS(true);
    paramJSONObject.Fl(Util.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.Fp(k);
    paramJSONObject.Fm(m);
    paramJSONObject.Fn(n);
    paramJSONObject.Fo(i1);
    paramJSONObject = paramJSONObject.qIY;
    if (j == 1) {}
    for (l = f.cBv().b(paramJSONObject);; l = f.cBv().a(paramJSONObject))
    {
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      if (l > 0L) {
        break;
      }
      this.yEn.aCS("fail");
      AppMethodBeat.o(186897);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      this.yEn.aW(paramJSONObject);
      AppMethodBeat.o(186897);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      this.yEn.aCS("exception");
      AppMethodBeat.o(186897);
    }
  }
  
  public final void a(final String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186896);
    paramString = paramJSONObject.optString("task_url");
    long l = paramJSONObject.optLong("task_size");
    if (Util.isNullOrNil(paramString))
    {
      Log.e("LiteAppJsApiAddDownloadTaskStraight", "url is null");
      this.yEn.aCS("uri is null");
      AppMethodBeat.o(186896);
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
      paramString = com.tencent.mm.plugin.downloader_app.a.a.aK(paramJSONObject);
      o.a(MMApplicationContext.getContext(), paramString, new o.a()
      {
        public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(186895);
          if (paramAnonymousString != null)
          {
            a.b(a.this).aCS(paramAnonymousString);
            AppMethodBeat.o(186895);
            return;
          }
          a.c(a.this).aW(paramAnonymousJSONObject);
          AppMethodBeat.o(186895);
        }
      });
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(186896);
      return;
    }
    final Context localContext = MMApplicationContext.getContext();
    if (!NetStatusUtil.isNetworkConnected(localContext))
    {
      this.yEn.aCS("fail_network_not_connected");
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186890);
          Toast.makeText(localContext, localContext.getString(2131761199), 0).show();
          AppMethodBeat.o(186890);
        }
      });
      Log.i("LiteAppJsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(186896);
      return;
    }
    if (!e.apn())
    {
      this.yEn.aCS("sdcard_not_ready");
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186891);
          Toast.makeText(localContext, localContext.getString(2131761203), 0).show();
          AppMethodBeat.o(186891);
        }
      });
      Log.i("LiteAppJsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(186896);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.plugin.downloader.model.h.CF(l)) && (!com.tencent.mm.plugin.downloader.model.h.CE(l)))
    {
      this.yEn.aCS("has_not_enough_space");
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186892);
          Toast.makeText(localContext, localContext.getString(2131761200), 0).show();
          AppMethodBeat.o(186892);
        }
      });
      Log.i("LiteAppJsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(186896);
      return;
    }
    if (NetStatusUtil.isWifi(localContext))
    {
      aT(paramJSONObject);
      AppMethodBeat.o(186896);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { str1, Integer.valueOf(4), str2, paramString, Integer.valueOf(3) });
    com.tencent.mm.ui.base.h.a(localContext, localContext.getString(2131768552), localContext.getString(2131768553), localContext.getString(2131768547), localContext.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(186893);
        com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { str1, Integer.valueOf(5), str2, paramString, Integer.valueOf(3) });
        a.a(a.this, paramJSONObject);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(186893);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(186894);
        com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { str1, Integer.valueOf(6), str2, paramString, Integer.valueOf(3) });
        paramAnonymousDialogInterface.dismiss();
        a.a(a.this).aCS("network_not_wifi");
        AppMethodBeat.o(186894);
      }
    }, 2131101414);
    AppMethodBeat.o(186896);
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.a
 * JD-Core Version:    0.7.0.1
 */