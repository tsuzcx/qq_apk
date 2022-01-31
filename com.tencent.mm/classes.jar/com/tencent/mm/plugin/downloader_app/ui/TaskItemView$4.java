package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

final class TaskItemView$4
  implements View.OnClickListener
{
  TaskItemView$4(TaskItemView paramTaskItemView) {}
  
  public final void onClick(View paramView)
  {
    TaskItemView.a(this.iTP, false);
    TaskItemView.h(this.iTP).setMaxLines(2);
    TaskItemView.f(this.iTP).setVisibility(8);
    TaskItemView.e(this.iTP).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.4
 * JD-Core Version:    0.7.0.1
 */