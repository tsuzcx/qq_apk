package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public class k
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  private void xD(long paramLong)
  {
    AppMethodBeat.i(211656);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ua(paramLong);
    if ((locala != null) && (locala.field_fromDownloadApp))
    {
      locala.field_fromDownloadApp = false;
      locala.field_showNotification = true;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    if (f.ccl().tU(paramLong)) {
      this.uYz.cXe();
    }
    for (;;)
    {
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(211656);
      return;
      this.uYz.YL("fail");
    }
  }
  
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(String paramString, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211655);
    final long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      ad.e("LiteAppJsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(l)));
      this.uYz.YL("invalid_downloadid");
      AppMethodBeat.o(211655);
      return;
    }
    int i = paramJSONObject.optInt("scene", 1000);
    int j = paramJSONObject.optInt("uiarea");
    int k = paramJSONObject.optInt("notice_id");
    int m = paramJSONObject.optInt("ssid");
    int n = paramJSONObject.optInt("download_type", 1);
    paramString = com.tencent.mm.plugin.downloader.model.d.ua(l);
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
      localb.msQ = 0L;
      com.tencent.mm.plugin.downloader.f.a.a(10, localb);
    }
    boolean bool1 = paramJSONObject.optBoolean("use_downloader_widget", false);
    boolean bool2 = paramJSONObject.optBoolean("download_in_wifi", false);
    paramString = aj.getContext();
    if (bool1)
    {
      o.a(aj.getContext(), l, bool2, new o.a()
      {
        public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(211654);
          if (paramAnonymousString != null)
          {
            k.b(k.this).YL(paramAnonymousString);
            AppMethodBeat.o(211654);
            return;
          }
          k.c(k.this).aA(paramAnonymousJSONObject);
          AppMethodBeat.o(211654);
        }
      });
      com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
      AppMethodBeat.o(211655);
      return;
    }
    if (ay.isWifi(paramString))
    {
      xD(l);
      AppMethodBeat.o(211655);
      return;
    }
    h.a(paramString, paramString.getString(2131766086), paramString.getString(2131766087), paramString.getString(2131766081), paramString.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(211652);
        k.a(k.this, l);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(211652);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(211653);
        paramAnonymousDialogInterface.dismiss();
        k.a(k.this).YL("fail_network_not_wifi");
        AppMethodBeat.o(211653);
      }
    }, 2131101171);
    AppMethodBeat.o(211655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.k
 * JD-Core Version:    0.7.0.1
 */