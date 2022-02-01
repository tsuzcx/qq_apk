package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.if;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  private void ax(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211628);
    if localif = new if();
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
    localif.duL.url = str2;
    localif.duL.md5 = str4;
    localif.duL.extInfo = str8;
    localif.duL.appId = str6;
    localif.duL.scene = i;
    com.tencent.mm.sdk.b.a.IbL.l(localif);
    paramJSONObject = new g.a();
    paramJSONObject.aak(str2);
    paramJSONObject.aal(str3);
    paramJSONObject.ui(l);
    paramJSONObject.aam(str1);
    paramJSONObject.aan(str4);
    paramJSONObject.setAppId(str6);
    paramJSONObject.ft(str7);
    paramJSONObject.jQ(true);
    paramJSONObject.Bp(bt.getInt(str5, 1));
    paramJSONObject.setScene(i);
    paramJSONObject.Bt(k);
    paramJSONObject.Bq(m);
    paramJSONObject.Br(n);
    paramJSONObject.Bs(i1);
    paramJSONObject = paramJSONObject.pmN;
    if (j == 1) {}
    for (l = f.ccl().b(paramJSONObject);; l = f.ccl().a(paramJSONObject))
    {
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      if (l > 0L) {
        break;
      }
      this.uYz.YL("fail");
      AppMethodBeat.o(211628);
      return;
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("download_id", l);
      this.uYz.aA(paramJSONObject);
      AppMethodBeat.o(211628);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      this.uYz.YL("exception");
      AppMethodBeat.o(211628);
    }
  }
  
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(final String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211627);
    paramString = paramJSONObject.optString("task_url");
    long l = paramJSONObject.optLong("task_size");
    if (bt.isNullOrNil(paramString))
    {
      ad.e("LiteAppJsApiAddDownloadTaskStraight", "url is null");
      this.uYz.YL("uri is null");
      AppMethodBeat.o(211627);
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
      o.a(aj.getContext(), paramString, new o.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(211626);
          if (paramAnonymousString != null)
          {
            a.b(a.this).YL(paramAnonymousString);
            AppMethodBeat.o(211626);
            return;
          }
          a.c(a.this).aA(paramAnonymousJSONObject);
          AppMethodBeat.o(211626);
        }
      });
      d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
      AppMethodBeat.o(211627);
      return;
    }
    final Context localContext = aj.getContext();
    if (!ay.isNetworkConnected(localContext))
    {
      this.uYz.YL("fail_network_not_connected");
      com.tencent.e.h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211621);
          Toast.makeText(localContext, localContext.getString(2131759864), 0).show();
          AppMethodBeat.o(211621);
        }
      });
      ad.i("LiteAppJsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(211627);
      return;
    }
    if (!e.abf())
    {
      this.uYz.YL("sdcard_not_ready");
      com.tencent.e.h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211622);
          Toast.makeText(localContext, localContext.getString(2131759868), 0).show();
          AppMethodBeat.o(211622);
        }
      });
      ad.i("LiteAppJsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(211627);
      return;
    }
    if ((l > 0L) && (!com.tencent.mm.plugin.downloader.model.h.uk(l)) && (!com.tencent.mm.plugin.downloader.model.h.uj(l)))
    {
      this.uYz.YL("has_not_enough_space");
      com.tencent.e.h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211623);
          Toast.makeText(localContext, localContext.getString(2131759865), 0).show();
          AppMethodBeat.o(211623);
        }
      });
      ad.i("LiteAppJsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(211627);
      return;
    }
    if (ay.isWifi(localContext))
    {
      ax(paramJSONObject);
      AppMethodBeat.o(211627);
      return;
    }
    g.yhR.f(14217, new Object[] { str1, Integer.valueOf(4), str2, paramString, Integer.valueOf(3) });
    com.tencent.mm.ui.base.h.a(localContext, localContext.getString(2131766086), localContext.getString(2131766087), localContext.getString(2131766081), localContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(211624);
        g.yhR.f(14217, new Object[] { str1, Integer.valueOf(5), str2, paramString, Integer.valueOf(3) });
        a.a(a.this, paramJSONObject);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(211624);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(211625);
        g.yhR.f(14217, new Object[] { str1, Integer.valueOf(6), str2, paramString, Integer.valueOf(3) });
        paramAnonymousDialogInterface.dismiss();
        a.a(a.this).YL("network_not_wifi");
        AppMethodBeat.o(211625);
      }
    }, 2131101171);
    AppMethodBeat.o(211627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.a
 * JD-Core Version:    0.7.0.1
 */