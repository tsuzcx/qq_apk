package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TaskManagerHeaderView$1
  implements View.OnClickListener
{
  TaskManagerHeaderView$1(TaskManagerHeaderView paramTaskManagerHeaderView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136314);
    if ((this.ldi.getContext() instanceof DownloadMainUI)) {
      ((DownloadMainUI)this.ldi.getContext()).lca.bka();
    }
    AppMethodBeat.o(136314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView.1
 * JD-Core Version:    0.7.0.1
 */