package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  private void ax(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193017);
    ig localig = new ig();
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
    localig.dvQ.url = str2;
    localig.dvQ.md5 = str4;
    localig.dvQ.extInfo = str8;
    localig.dvQ.appId = str6;
    localig.dvQ.scene = i;
    com.tencent.mm.sdk.b.a.IvT.l(localig);
    paramJSONObject = new g.a();
    paramJSONObject.abb(str2);
    paramJSONObject.abc(str3);
    paramJSONObject.uz(l);
    paramJSONObject.abd(str1);
    paramJSONObject.abe(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.fz(str7);
    paramJSONObject.jP(true);
    paramJSONObject.BB(bu.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.BF(k);
    paramJSONObject.BC(m);
    paramJSONObject.BD(n);
    paramJSONObject.BE(i1);
    paramJSONObject = paramJSONObject.ptu;
    if (j == 1) {}
    for (l = f.cdA().b(paramJSONObject);; l = f.cdA().a(paramJSONObject))
    {
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      if (l > 0L) {
        break;
      }
      this.vko.ZC("fail");
      AppMethodBeat.o(193017);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      this.vko.aA(paramJSONObject);
      AppMethodBeat.o(193017);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      this.vko.ZC("exception");
      AppMethodBeat.o(193017);
    }
  }
  
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(final String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193016);
    paramString = paramJSONObject.optString("task_url");
    long l = paramJSONObject.optLong("task_size");
    if (bu.isNullOrNil(paramString))
    {
      ae.e("LiteAppJsApiAddDownloadTaskStraight", "url is null");
      this.vko.ZC("uri is null");
      AppMethodBeat.o(193016);
      return;
    }
    final String str1 = paramJSONObject.optString("appid");
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("download_type", 1);
    int k = paramJSONObject.optInt("ssid");
    int m = paramJSONObject.optInt("uiarea");
    int n = paramJSONObject.optInt("notice_id");
    com.tencent.mm.plugin.downloader.f.a.a(9, new b(str1, i, paramJSONObject.optString("extInfo"), m, k, n, j));
    final String str2 = paramJSONObject.optString("currentUrl");
    if (paramJSONObject.optBoolean("use_downloader_widget", false))
    {
      paramString = com.tencent.mm.plugin.downloader_app.a.a.ar(paramJSONObject);
      o.a(ak.getContext(), paramString, new o.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(193015);
          if (paramAnonymousString != null)
          {
            a.b(a.this).ZC(paramAnonymousString);
            AppMethodBeat.o(193015);
            return;
          }
          a.c(a.this).aA(paramAnonymousJSONObject);
          AppMethodBeat.o(193015);
        }
      });
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(193016);
      return;
    }
    final Context localContext = ak.getContext();
    if (!az.isNetworkConnected(localContext))
    {
      this.vko.ZC("fail_network_not_connected");
      com.tencent.e.h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193010);
          Toast.makeText(localContext, localContext.getString(2131759864), 0).show();
          AppMethodBeat.o(193010);
        }
      });
      ae.i("LiteAppJsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(193016);
      return;
    }
    if (!e.abo())
    {
      this.vko.ZC("sdcard_not_ready");
      com.tencent.e.h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193011);
          Toast.makeText(localContext, localContext.getString(2131759868), 0).show();
          AppMethodBeat.o(193011);
        }
      });
      ae.i("LiteAppJsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(193016);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.plugin.downloader.model.h.uB(l)) && (!com.tencent.mm.plugin.downloader.model.h.uA(l)))
    {
      this.vko.ZC("has_not_enough_space");
      com.tencent.e.h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193012);
          Toast.makeText(localContext, localContext.getString(2131759865), 0).show();
          AppMethodBeat.o(193012);
        }
      });
      ae.i("LiteAppJsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(193016);
      return;
    }
    if (az.isWifi(localContext))
    {
      ax(paramJSONObject);
      AppMethodBeat.o(193016);
      return;
    }
    g.yxI.f(14217, new Object[] { str1, Integer.valueOf(4), str2, paramString, Integer.valueOf(3) });
    com.tencent.mm.ui.base.h.a(localContext, localContext.getString(2131766086), localContext.getString(2131766087), localContext.getString(2131766081), localContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(193013);
        g.yxI.f(14217, new Object[] { str1, Integer.valueOf(5), str2, paramString, Integer.valueOf(3) });
        a.a(a.this, paramJSONObject);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(193013);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(193014);
        g.yxI.f(14217, new Object[] { str1, Integer.valueOf(6), str2, paramString, Integer.valueOf(3) });
        paramAnonymousDialogInterface.dismiss();
        a.a(a.this).ZC("network_not_wifi");
        AppMethodBeat.o(193014);
      }
    }, 2131101171);
    AppMethodBeat.o(193016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.a
 * JD-Core Version:    0.7.0.1
 */