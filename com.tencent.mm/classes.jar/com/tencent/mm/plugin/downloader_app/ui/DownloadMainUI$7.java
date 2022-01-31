package com.tencent.mm.plugin.downloader_app.ui;

import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.f;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.sdk.platformtools.y;

final class DownloadMainUI$7
  implements Runnable
{
  DownloadMainUI$7(DownloadMainUI paramDownloadMainUI) {}
  
  public final void run()
  {
    if (!DownloadMainUI.f(this.iTt)) {
      com.tencent.mm.ui.widget.snackbar.b.h(this.iTt, this.iTt.getString(b.h.task_already_in_list));
    }
    TaskListView localTaskListView = DownloadMainUI.g(this.iTt);
    j localj = DownloadMainUI.c(this.iTt).Ad(DownloadMainUI.d(this.iTt));
    int i = localTaskListView.iTW.iTQ.indexOf(localj);
    if ((i < 0) || (i >= DownloadMainUI.g(this.iTt).getSize()))
    {
      y.e("MicroMsg.DownloadMainUI", "error position < 0");
      return;
    }
    DownloadMainUI.g(this.iTt).smoothScrollToPosition(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI.7
 * JD-Core Version:    0.7.0.1
 */