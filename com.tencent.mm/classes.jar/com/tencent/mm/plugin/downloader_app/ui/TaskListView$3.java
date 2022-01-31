package com.tencent.mm.plugin.downloader_app.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.d.a;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import java.util.Iterator;

final class TaskListView$3
  implements d.a
{
  TaskListView$3(TaskListView paramTaskListView) {}
  
  public final void gx(boolean paramBoolean)
  {
    AppMethodBeat.i(136293);
    TaskListView localTaskListView = this.ldh;
    Iterator localIterator = localTaskListView.lcX.lcP.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.bjS()) {
        locali.gDG = paramBoolean;
      }
    }
    localTaskListView.lcX.ajb.notifyChanged();
    d.gw(paramBoolean);
    AppMethodBeat.o(136293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.3
 * JD-Core Version:    0.7.0.1
 */