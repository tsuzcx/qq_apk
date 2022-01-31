package com.tencent.mm.plugin.downloader_app.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DownloadMainUI$1
  implements MenuItem.OnMenuItemClickListener
{
  DownloadMainUI$1(DownloadMainUI paramDownloadMainUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(136224);
    this.lci.finish();
    AppMethodBeat.o(136224);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.1
 * JD-Core Version:    0.7.0.1
 */