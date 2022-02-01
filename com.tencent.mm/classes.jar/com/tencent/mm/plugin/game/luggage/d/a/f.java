package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class f
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186908);
    long l = paramJSONObject.optLong("download_id");
    if (l <= 0L)
    {
      Log.i("LiteAppJsApiInstallDownloadTask", "data is null");
      this.yEn.aCS("fail_invalid_data");
      AppMethodBeat.o(186908);
      return;
    }
    paramString = com.tencent.mm.plugin.downloader.model.f.cBv().Co(l);
    if (paramString.status == -1)
    {
      Log.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
      this.yEn.aCS("fail");
      AppMethodBeat.o(186908);
      return;
    }
    if (paramString.status != 3)
    {
      Log.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + paramString.status);
      this.yEn.aCS("fail");
      AppMethodBeat.o(186908);
      return;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(l);
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
      public final void hk(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(186907);
        if (paramAnonymousBoolean)
        {
          f.a(f.this).ecz();
          AppMethodBeat.o(186907);
          return;
        }
        f.b(f.this).aCS("fail");
        AppMethodBeat.o(186907);
      }
    });
    AppMethodBeat.o(186908);
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.f
 * JD-Core Version:    0.7.0.1
 */