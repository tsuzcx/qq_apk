package com.tencent.mm.plugin.downloader_app.ui;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TaskItemView$2
  implements Runnable
{
  TaskItemView$2(TaskItemView paramTaskItemView) {}
  
  public final void run()
  {
    AppMethodBeat.i(136261);
    TaskItemView.i(this.lcM).setVisibility(8);
    TaskItemView.c(this.lcM).setText(this.lcM.getResources().getString(2131304771));
    TaskItemView.c(this.lcM).setVisibility(0);
    AppMethodBeat.o(136261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.2
 * JD-Core Version:    0.7.0.1
 */