package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import java.util.Iterator;

final class TaskListView$8
  implements MRecyclerView.b
{
  TaskListView$8(TaskListView paramTaskListView) {}
  
  public final boolean O(View paramView, int paramInt)
  {
    AppMethodBeat.i(136298);
    if (!TaskListView.a(this.ldh))
    {
      AppMethodBeat.o(136298);
      return false;
    }
    if ((((ViewGroup)paramView).getChildAt(0) instanceof TaskItemView))
    {
      Object localObject = TaskListView.b(this.ldh).lcP;
      if (localObject != null)
      {
        localObject = ((h)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i)((Iterator)localObject).next()).kmz = true;
        }
        ((TaskItemView)((ViewGroup)paramView).getChildAt(0)).setSelected(true);
        TaskListView.c(this.ldh);
      }
    }
    AppMethodBeat.o(136298);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.8
 * JD-Core Version:    0.7.0.1
 */