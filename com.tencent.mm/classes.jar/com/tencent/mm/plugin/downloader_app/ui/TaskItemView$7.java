package com.tencent.mm.plugin.downloader_app.ui;

import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

final class TaskItemView$7
  implements Runnable
{
  TaskItemView$7(TaskItemView paramTaskItemView) {}
  
  public final void run()
  {
    TaskItemView.j(this.iTP).setVisibility(0);
    TaskItemView.i(this.iTP).setIndeterminate(true);
    TaskItemView.c(this.iTP).setVisibility(8);
    TaskItemView.d(this.iTP).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.7
 * JD-Core Version:    0.7.0.1
 */