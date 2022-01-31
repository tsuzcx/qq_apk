package com.tencent.mm.plugin.downloader_app.ui;

import android.widget.ProgressBar;

final class TaskItemView$6
  implements Runnable
{
  TaskItemView$6(TaskItemView paramTaskItemView, int paramInt) {}
  
  public final void run()
  {
    TaskItemView.i(this.iTP).setSecondaryProgress(100);
    TaskItemView.i(this.iTP).setProgress(this.fyT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.6
 * JD-Core Version:    0.7.0.1
 */