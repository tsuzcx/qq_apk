package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.d.b;
import com.tencent.mm.ui.base.h;

final class TaskListView$3
  implements d.b
{
  TaskListView$3(TaskListView paramTaskListView) {}
  
  public final void onClick()
  {
    TaskListView localTaskListView = this.iUe;
    h.a(localTaskListView.getContext(), localTaskListView.getContext().getString(b.h.delete_task_tips), "", localTaskListView.getContext().getString(b.h.task_delete), localTaskListView.getContext().getString(b.h.task_cancel), new TaskListView.8(localTaskListView), new TaskListView.9(localTaskListView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.3
 * JD-Core Version:    0.7.0.1
 */