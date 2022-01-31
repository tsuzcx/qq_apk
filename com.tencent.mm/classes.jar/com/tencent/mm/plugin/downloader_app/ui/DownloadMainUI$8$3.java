package com.tencent.mm.plugin.downloader_app.ui;

import com.tencent.mm.plugin.downloader_app.b.f;
import com.tencent.mm.plugin.downloader_app.detail.d;
import com.tencent.mm.sdk.platformtools.bk;

final class DownloadMainUI$8$3
  implements Runnable
{
  DownloadMainUI$8$3(DownloadMainUI.8 param8) {}
  
  public final void run()
  {
    String str = DownloadMainUI.c(this.iTw.iTt).iSn;
    if (!bk.bl(str)) {
      d.zV(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.8.3
 * JD-Core Version:    0.7.0.1
 */