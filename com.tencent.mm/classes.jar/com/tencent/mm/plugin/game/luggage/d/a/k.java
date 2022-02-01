package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public class k
  extends com.tencent.mm.plugin.lite.jsapi.b
{
  private void GH(long paramLong)
  {
    AppMethodBeat.i(186925);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Cw(paramLong);
    if ((locala != null) && (locala.field_fromDownloadApp))
    {
      locala.field_fromDownloadApp = false;
      locala.field_showNotification = true;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    if (f.cBv().Cq(paramLong)) {
      this.yEn.ecz();
    }
    for (;;)
    {
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(186925);
      return;
      this.yEn.aCS("fail");
    }
  }
  
  public final void a(String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186924);
    final long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.e("LiteAppJsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.yEn.aCS("invalid_downloadid");
      AppMethodBeat.o(186924);
      return;
    }
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("uiarea");
    int k = paramJSONObject.optInt("notice_id");
    int m = paramJSONObject.optInt("ssid");
    int n = paramJSONObject.optInt("download_type", 1);
    if (paramJSONObject.optInt("ignoreNetwork", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramString = com.tencent.mm.plugin.downloader.model.d.Cw(l);
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
      boolean bool2 = paramJSONObject.optBoolean("use_downloader_widget", false);
      boolean bool3 = paramJSONObject.optBoolean("download_in_wifi", false);
      paramString = MMApplicationContext.getContext();
      if (!bool2) {
        break;
      }
      o.a(MMApplicationContext.getContext(), l, bool3, bool1, new o.a()
      {
        public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(186923);
          if (paramAnonymousString != null)
          {
            k.b(k.this).aCS(paramAnonymousString);
            AppMethodBeat.o(186923);
            return;
          }
          k.c(k.this).aW(paramAnonymousJSONObject);
          AppMethodBeat.o(186923);
        }
      });
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(186924);
      return;
    }
    if (NetStatusUtil.isWifi(paramString))
    {
      GH(l);
      AppMethodBeat.o(186924);
      return;
    }
    h.a(paramString, paramString.getString(2131768552), paramString.getString(2131768553), paramString.getString(2131768547), paramString.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(186921);
        k.a(k.this, l);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(186921);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(186922);
        paramAnonymousDialogInterface.dismiss();
        k.a(k.this).aCS("fail_network_not_wifi");
        AppMethodBeat.o(186922);
      }
    }, 2131101414);
    AppMethodBeat.o(186924);
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.k
 * JD-Core Version:    0.7.0.1
 */