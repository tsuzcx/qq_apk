package com.tencent.mm.plugin.downloader_app.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;

final class TaskItemView$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TaskItemView$3(TaskItemView paramTaskItemView) {}
  
  public final void onGlobalLayout()
  {
    if (TaskItemView.e(this.iTP).getLineCount() <= 2)
    {
      TaskItemView.f(this.iTP).setVisibility(8);
      TaskItemView.e(this.iTP).setVisibility(8);
      return;
    }
    if (TaskItemView.g(this.iTP))
    {
      TaskItemView.f(this.iTP).setVisibility(8);
      TaskItemView.e(this.iTP).setVisibility(0);
      return;
    }
    TaskItemView.f(this.iTP).setVisibility(0);
    TaskItemView.e(this.iTP).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.3
 * JD-Core Version:    0.7.0.1
 */