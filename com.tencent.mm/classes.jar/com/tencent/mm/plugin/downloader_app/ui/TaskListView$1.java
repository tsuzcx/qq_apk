package com.tencent.mm.plugin.downloader_app.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.b.d.d;

final class TaskListView$1
  implements d.d
{
  TaskListView$1(TaskListView paramTaskListView) {}
  
  public final void H(int paramInt, long paramLong)
  {
    AppMethodBeat.i(136292);
    a locala = d.iJ(paramLong);
    if (locala != null) {
      TaskListView.a(this.ldh, paramInt, locala.field_appId);
    }
    AppMethodBeat.o(136292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.1
 * JD-Core Version:    0.7.0.1
 */