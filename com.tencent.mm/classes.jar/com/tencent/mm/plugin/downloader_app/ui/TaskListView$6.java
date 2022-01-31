package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;
import java.util.Iterator;

final class TaskListView$6
  implements MRecyclerView.b
{
  TaskListView$6(TaskListView paramTaskListView) {}
  
  public final boolean cx(View paramView)
  {
    if (!TaskListView.a(this.iUe)) {
      return false;
    }
    if ((((ViewGroup)paramView).getChildAt(0) instanceof TaskItemView))
    {
      Object localObject = TaskListView.b(this.iUe).iTQ;
      if (localObject != null)
      {
        localObject = ((h)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((j)((Iterator)localObject).next()).ilB = true;
        }
        ((TaskItemView)((ViewGroup)paramView).getChildAt(0)).setSelected(true);
        TaskListView.c(this.iUe);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.6
 * JD-Core Version:    0.7.0.1
 */