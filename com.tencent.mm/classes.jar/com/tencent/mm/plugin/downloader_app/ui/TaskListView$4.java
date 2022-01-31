package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.d.b;
import com.tencent.mm.ui.base.h;

final class TaskListView$4
  implements d.b
{
  TaskListView$4(TaskListView paramTaskListView) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(136294);
    TaskListView localTaskListView = this.ldh;
    h.d(localTaskListView.getContext(), localTaskListView.getContext().getString(2131298952), "", localTaskListView.getContext().getString(2131304263), localTaskListView.getContext().getString(2131304262), new TaskListView.10(localTaskListView), new TaskListView.2(localTaskListView));
    AppMethodBeat.o(136294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.4
 * JD-Core Version:    0.7.0.1
 */