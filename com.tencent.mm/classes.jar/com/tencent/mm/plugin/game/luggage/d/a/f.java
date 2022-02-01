package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class f
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(277078);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.i("LiteAppJsApiInstallDownloadTask", "data is null");
      this.JZj.aJV("fail_invalid_data");
      AppMethodBeat.o(277078);
      return;
    }
    paramString = com.tencent.mm.plugin.downloader.model.f.duv().kS(l);
    if (paramString.status == -1)
    {
      Log.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
      this.JZj.aJV("fail");
      AppMethodBeat.o(277078);
      return;
    }
    if (paramString.status != 3)
    {
      Log.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + paramString.status);
      this.JZj.aJV("fail");
      AppMethodBeat.o(277078);
      return;
    }
    com.tencent.mm.plugin.downloader.f.a locala = d.la(l);
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
    com.tencent.mm.plugin.downloader.h.a.a(paramString.id, false, new com.tencent.mm.pluginsdk.permission.a()
    {
      public final void iZ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(277083);
        if (paramAnonymousBoolean)
        {
          f.a(f.this).fTW();
          AppMethodBeat.o(277083);
          return;
        }
        f.b(f.this).aJV("fail");
        AppMethodBeat.o(277083);
      }
    });
    AppMethodBeat.o(277078);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.f
 * JD-Core Version:    0.7.0.1
 */