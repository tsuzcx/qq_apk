package com.tencent.mm.plugin.downloader_app.detail.a;

import com.tencent.mm.plugin.downloader_app.b.c.a;
import com.tencent.mm.plugin.downloader_app.b.c.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;

final class f$1
  implements c.b
{
  f$1(f paramf, aw.a parama) {}
  
  public final void a(c.a parama, long paramLong)
  {
    if (parama == c.a.iRZ) {
      this.iRM.e(null, null);
    }
    do
    {
      return;
      if (parama == c.a.iSa)
      {
        this.iRM.e("fail", null);
        return;
      }
    } while (parama != c.a.iSb);
    this.iRM.e("wait_for_wifi", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.f.1
 * JD-Core Version:    0.7.0.1
 */