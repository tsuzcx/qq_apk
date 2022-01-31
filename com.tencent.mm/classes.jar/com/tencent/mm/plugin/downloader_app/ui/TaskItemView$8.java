package com.tencent.mm.plugin.downloader_app.ui;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.downloader_app.b.h;

final class TaskItemView$8
  implements Runnable
{
  TaskItemView$8(TaskItemView paramTaskItemView) {}
  
  public final void run()
  {
    TaskItemView.j(this.iTP).setVisibility(8);
    TaskItemView.d(this.iTP).setText(this.iTP.getResources().getString(b.h.wait_for_wifi));
    TaskItemView.d(this.iTP).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.8
 * JD-Core Version:    0.7.0.1
 */