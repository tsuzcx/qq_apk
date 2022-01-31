package com.tencent.mm.plugin.downloader_app.detail.a;

import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.downloader_app.b.c.a;
import com.tencent.mm.plugin.downloader_app.b.c.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import org.json.JSONException;
import org.json.JSONObject;

final class a$4
  implements c.b
{
  a$4(a parama, String paramString, aw.a parama1) {}
  
  public final void a(c.a parama, long paramLong)
  {
    b.dCw.a(this.val$appId, 10000, 9, paramLong, "", null);
    if (paramLong < 0L) {
      this.iRM.e("fail", null);
    }
    do
    {
      return;
      if (parama == c.a.iRZ) {
        try
        {
          parama = new JSONObject();
          parama.put("download_id", paramLong);
          this.iRM.e(null, parama);
          return;
        }
        catch (JSONException parama)
        {
          this.iRM.e(null, null);
          return;
        }
      }
      if (parama == c.a.iSa)
      {
        this.iRM.e("fail", null);
        return;
      }
    } while (parama != c.a.iSb);
    try
    {
      parama = new JSONObject();
      parama.put("download_id", paramLong);
      this.iRM.e("wait_for_wifi", parama);
      return;
    }
    catch (JSONException parama)
    {
      this.iRM.e(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.a.4
 * JD-Core Version:    0.7.0.1
 */