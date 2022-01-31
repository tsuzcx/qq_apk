package com.tencent.mm.plugin.downloader_app.ui;

import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TaskItemView$10
  implements Runnable
{
  TaskItemView$10(TaskItemView paramTaskItemView) {}
  
  public final void run()
  {
    AppMethodBeat.i(136271);
    TaskItemView.i(this.lcM).setVisibility(0);
    TaskItemView.h(this.lcM).setIndeterminate(true);
    TaskItemView.j(this.lcM).setVisibility(8);
    TaskItemView.c(this.lcM).setVisibility(8);
    AppMethodBeat.o(136271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.10
 * JD-Core Version:    0.7.0.1
 */