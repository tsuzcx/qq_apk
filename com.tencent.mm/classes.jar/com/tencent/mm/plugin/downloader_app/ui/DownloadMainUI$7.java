package com.tencent.mm.plugin.downloader_app.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.f;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.sdk.platformtools.ab;

final class DownloadMainUI$7
  implements Runnable
{
  DownloadMainUI$7(DownloadMainUI paramDownloadMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(136232);
    if (!DownloadMainUI.e(this.lci)) {
      com.tencent.mm.ui.widget.snackbar.b.l(this.lci, this.lci.getString(2131304261));
    }
    TaskListView localTaskListView = DownloadMainUI.g(this.lci);
    i locali = DownloadMainUI.c(this.lci).Kb(DownloadMainUI.d(this.lci));
    int i = localTaskListView.lcX.lcP.indexOf(locali);
    if ((i < 0) || (i >= DownloadMainUI.g(this.lci).getSize()))
    {
      ab.e("MicroMsg.DownloadMainUI", "error position < 0");
      AppMethodBeat.o(136232);
      return;
    }
    DownloadMainUI.g(this.lci).smoothScrollToPosition(i);
    AppMethodBeat.o(136232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.7
 * JD-Core Version:    0.7.0.1
 */