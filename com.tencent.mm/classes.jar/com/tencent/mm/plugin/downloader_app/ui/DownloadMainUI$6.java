package com.tencent.mm.plugin.downloader_app.ui;

import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.j;

final class DownloadMainUI$6
  implements Runnable
{
  DownloadMainUI$6(DownloadMainUI paramDownloadMainUI, a parama, j paramj) {}
  
  public final void run()
  {
    if (this.iOZ != null)
    {
      if (this.iOZ.field_status != 1)
      {
        if (this.iOZ.field_status == 2) {
          c.a(this.iTt, this.iOZ, null);
        }
      }
      else {
        return;
      }
      c.a(this.iTt, this.iRY);
      return;
    }
    c.a(this.iTt, this.iRY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.6
 * JD-Core Version:    0.7.0.1
 */