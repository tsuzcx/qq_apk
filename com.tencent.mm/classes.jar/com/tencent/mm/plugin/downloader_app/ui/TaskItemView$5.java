package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

final class TaskItemView$5
  implements View.OnClickListener
{
  TaskItemView$5(TaskItemView paramTaskItemView) {}
  
  public final void onClick(View paramView)
  {
    TaskItemView.a(this.iTP, true);
    TaskItemView.h(this.iTP).setMaxLines(2147483647);
    TaskItemView.f(this.iTP).setVisibility(0);
    TaskItemView.e(this.iTP).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.5
 * JD-Core Version:    0.7.0.1
 */