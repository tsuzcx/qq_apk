package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.plugin.downloader_app.a.c;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends bn
{
  public final void a(final Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(8823);
    try
    {
      paramString = new JSONObject(paramString);
      str1 = paramString.optString("task_url");
      l = paramString.optLong("task_size");
      if (bs.isNullOrNil(str1))
      {
        ac.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
        parama.f("fail", null);
        AppMethodBeat.o(8823);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ac.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + paramContext.getMessage());
      parama.f("fail", null);
      AppMethodBeat.o(8823);
      return;
    }
    com.tencent.mm.plugin.downloader.f.a.a(9, new b(paramString.optString("appid"), 1000, -1L, ""));
    if (!ax.isNetworkConnected(paramContext))
    {
      parama.f("fail_network_not_connected", null);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(8819);
          Toast.makeText(paramContext, paramContext.getString(2131759864), 0).show();
          AppMethodBeat.o(8819);
        }
      });
      ac.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(8823);
      return;
    }
    if (!e.YD())
    {
      parama.f("sdcard_not_ready", null);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(8820);
          Toast.makeText(paramContext, paramContext.getString(2131759868), 0).show();
          AppMethodBeat.o(8820);
        }
      });
      ac.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(8823);
      return;
    }
    if ((l > 0L) && (!h.sm(l)) && (!h.sl(l)))
    {
      parama.f("has_not_enough_space", null);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(8821);
          Toast.makeText(paramContext, paramContext.getString(2131759865), 0).show();
          AppMethodBeat.o(8821);
        }
      });
      ac.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(8823);
      return;
    }
    String str1 = paramString.optString("task_name");
    String str2 = paramString.optString("task_url");
    String str3 = paramString.optString("alternative_url");
    long l = paramString.optLong("task_size");
    String str4 = paramString.optString("file_md5");
    String str5 = paramString.optString("extInfo");
    String str6 = paramString.optString("appid");
    String str7 = paramString.optString("package_name");
    int i = paramString.optInt("downloader_type", 1);
    paramString = new com.tencent.mm.plugin.downloader_app.a.a();
    paramString.appName = str1;
    paramString.downloadUrl = str2;
    paramString.oKQ = str3;
    paramString.oKS = l;
    paramString.lpa = str4;
    paramString.extInfo = str5;
    paramString.appId = str6;
    paramString.packageName = str7;
    paramString.diX = i;
    c.a(paramContext, paramString, new a.b()
    {
      public final void a(com.tencent.mm.plugin.downloader_app.api.a.a paramAnonymousa, long paramAnonymousLong)
      {
        AppMethodBeat.i(8822);
        if (paramAnonymousLong < 0L)
        {
          parama.f("fail", null);
          AppMethodBeat.o(8822);
          return;
        }
        if (paramAnonymousa == com.tencent.mm.plugin.downloader_app.api.a.a.oKo) {
          try
          {
            paramAnonymousa = new JSONObject();
            paramAnonymousa.put("download_id", paramAnonymousLong);
            parama.f(null, paramAnonymousa);
            AppMethodBeat.o(8822);
            return;
          }
          catch (JSONException paramAnonymousa)
          {
            parama.f(null, null);
            AppMethodBeat.o(8822);
            return;
          }
        }
        if (paramAnonymousa == com.tencent.mm.plugin.downloader_app.api.a.a.oKp)
        {
          parama.f("fail", null);
          AppMethodBeat.o(8822);
          return;
        }
        if (paramAnonymousa == com.tencent.mm.plugin.downloader_app.api.a.a.oKq) {
          try
          {
            paramAnonymousa = new JSONObject();
            paramAnonymousa.put("download_id", paramAnonymousLong);
            parama.f("wait_for_wifi", paramAnonymousa);
            AppMethodBeat.o(8822);
            return;
          }
          catch (JSONException paramAnonymousa)
          {
            parama.f(null, null);
          }
        }
        AppMethodBeat.o(8822);
      }
    });
    AppMethodBeat.o(8823);
  }
  
  public final void b(com.tencent.luggage.d.a.a parama) {}
  
  public final int bYk()
  {
    return 1;
  }
  
  public final String name()
  {
    return "addDownloadTaskStraight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.a
 * JD-Core Version:    0.7.0.1
 */