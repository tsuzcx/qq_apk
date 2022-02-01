package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class f
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211639);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      ad.i("LiteAppJsApiInstallDownloadTask", "data is null");
      this.uYz.YL("fail_invalid_data");
      AppMethodBeat.o(211639);
      return;
    }
    paramString = com.tencent.mm.plugin.downloader.model.f.ccl().tS(l);
    if (paramString.status == -1)
    {
      ad.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
      this.uYz.YL("fail");
      AppMethodBeat.o(211639);
      return;
    }
    if (paramString.status != 3)
    {
      ad.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + paramString.status);
      this.uYz.YL("fail");
      AppMethodBeat.o(211639);
      return;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(l);
    if (locala != null)
    {
      int i = paramJSONObject.optInt("scene");
      int j = paramJSONObject.optInt("uiarea");
      int k = paramJSONObject.optInt("notice_id");
      int m = paramJSONObject.optInt("ssid");
      locala.field_scene = i;
      locala.field_uiarea = j;
      locala.field_noticeId = k;
      locala.field_ssid = m;
      d.e(locala);
    }
    com.tencent.mm.plugin.downloader.i.a.a(paramString.id, false, new com.tencent.mm.pluginsdk.permission.a()
    {
      public final void gp(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(211638);
        if (paramAnonymousBoolean)
        {
          f.a(f.this).cXe();
          AppMethodBeat.o(211638);
          return;
        }
        f.b(f.this).YL("fail");
        AppMethodBeat.o(211638);
      }
    });
    AppMethodBeat.o(211639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.f
 * JD-Core Version:    0.7.0.1
 */