package com.tencent.mm.plugin.downloader_app.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.d.a;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;
import java.util.Iterator;

final class TaskListView$2
  implements d.a
{
  TaskListView$2(TaskListView paramTaskListView) {}
  
  public final void eU(boolean paramBoolean)
  {
    TaskListView localTaskListView = this.iUe;
    Iterator localIterator = localTaskListView.iTW.iTQ.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.aGp()) {
        localj.fmm = paramBoolean;
      }
    }
    localTaskListView.iTW.agL.notifyChanged();
    d.eT(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.2
 * JD-Core Version:    0.7.0.1
 */