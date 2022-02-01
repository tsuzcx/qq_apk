package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public class f
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193028);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      ae.i("LiteAppJsApiInstallDownloadTask", "data is null");
      this.vko.ZC("fail_invalid_data");
      AppMethodBeat.o(193028);
      return;
    }
    paramString = com.tencent.mm.plugin.downloader.model.f.cdA().uj(l);
    if (paramString.status == -1)
    {
      ae.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
      this.vko.ZC("fail");
      AppMethodBeat.o(193028);
      return;
    }
    if (paramString.status != 3)
    {
      ae.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + paramString.status);
      this.vko.ZC("fail");
      AppMethodBeat.o(193028);
      return;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(l);
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
      public final void gn(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(193027);
        if (paramAnonymousBoolean)
        {
          f.a(f.this).cZN();
          AppMethodBeat.o(193027);
          return;
        }
        f.b(f.this).ZC("fail");
        AppMethodBeat.o(193027);
      }
    });
    AppMethodBeat.o(193028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.f
 * JD-Core Version:    0.7.0.1
 */