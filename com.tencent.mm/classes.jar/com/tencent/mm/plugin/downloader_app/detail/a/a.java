package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends bh
{
  public final void a(final Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(136068);
    try
    {
      paramString = new JSONObject(paramString);
      str1 = paramString.optString("task_url");
      l = paramString.optLong("task_size");
      if (bo.isNullOrNil(str1))
      {
        ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
        parama.c("fail", null);
        AppMethodBeat.o(136068);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + paramContext.getMessage());
      parama.c("fail", null);
      AppMethodBeat.o(136068);
      return;
    }
    com.tencent.mm.plugin.downloader.f.a.a(9, new b(paramString.optString("appid"), 1000, -1L, ""));
    if (!at.isNetworkConnected(paramContext))
    {
      parama.c("fail_network_not_connected", null);
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136064);
          Toast.makeText(paramContext, paramContext.getString(2131300360), 0).show();
          AppMethodBeat.o(136064);
        }
      });
      ab.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
      AppMethodBeat.o(136068);
      return;
    }
    if (!f.Mi())
    {
      parama.c("sdcard_not_ready", null);
      al.d(new a.2(this, paramContext));
      ab.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
      AppMethodBeat.o(136068);
      return;
    }
    if ((l > 0L) && (!f.gc(l)) && (!h.iS(l)))
    {
      parama.c("has_not_enough_space", null);
      al.d(new a.3(this, paramContext));
      ab.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(l)));
      AppMethodBeat.o(136068);
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
    paramString = new com.tencent.mm.plugin.downloader_app.b.a();
    paramString.appName = str1;
    paramString.downloadUrl = str2;
    paramString.laB = str3;
    paramString.laC = l;
    paramString.laD = str4;
    paramString.extInfo = str5;
    paramString.appId = str6;
    paramString.packageName = str7;
    paramString.cvQ = i;
    c.a(paramContext, paramString, new a.4(this, parama));
    AppMethodBeat.o(136068);
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "addDownloadTaskStraight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.a
 * JD-Core Version:    0.7.0.1
 */