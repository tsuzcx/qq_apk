package com.tencent.mm.plugin.downloader_app.ui;

import android.content.res.Resources;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.f;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.plugin.downloader_app.b.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class DownloadMainUI$8$2
  implements Runnable
{
  DownloadMainUI$8$2(DownloadMainUI.8 param8) {}
  
  public final void run()
  {
    if (!bk.bl(this.iTw.iTv))
    {
      j localj = DownloadMainUI.c(this.iTw.iTt).Ad(this.iTw.iTv);
      if (localj == null) {
        break label86;
      }
      k.Af(this.iTw.iTv);
      l.postDelayed(new DownloadMainUI.8.2.1(this, localj), 200L);
    }
    for (;;)
    {
      DownloadMainUI.a(this.iTw.iTt, DownloadMainUI.c(this.iTw.iTt), true);
      return;
      label86:
      h.b(this.iTw.iTt, "", this.iTw.iTt.getResources().getString(b.h.no_appid_cgi_data), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.8.2
 * JD-Core Version:    0.7.0.1
 */