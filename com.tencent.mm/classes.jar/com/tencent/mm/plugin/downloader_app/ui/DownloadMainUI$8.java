package com.tencent.mm.plugin.downloader_app.ui;

import android.content.res.Resources;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.g;
import com.tencent.mm.plugin.downloader_app.b.g.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class DownloadMainUI$8
  implements g.a
{
  DownloadMainUI$8(DownloadMainUI paramDownloadMainUI, String paramString) {}
  
  public final void eR(boolean paramBoolean)
  {
    l.m(new DownloadMainUI.8.1(this));
    if (paramBoolean)
    {
      DownloadMainUI.a(this.iTt, g.aGn());
      ai.d(new DownloadMainUI.8.2(this));
      l.e(new DownloadMainUI.8.3(this), 200L);
    }
    while (bk.bl(this.iTv)) {
      return;
    }
    h.b(this.iTt, "", this.iTt.getResources().getString(b.h.cgi_connect_fail), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.8
 * JD-Core Version:    0.7.0.1
 */