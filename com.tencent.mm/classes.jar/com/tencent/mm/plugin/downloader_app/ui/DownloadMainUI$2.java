package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.downloader_app.search.DownloadSearchUI;

final class DownloadMainUI$2
  implements MenuItem.OnMenuItemClickListener
{
  DownloadMainUI$2(DownloadMainUI paramDownloadMainUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.iTt.startActivity(new Intent(this.iTt, DownloadSearchUI.class));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.2
 * JD-Core Version:    0.7.0.1
 */