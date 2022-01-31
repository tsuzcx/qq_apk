package com.tencent.mm.plugin.downloader_app.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class TaskListView$7
  implements MRecyclerView.a
{
  TaskListView$7(TaskListView paramTaskListView) {}
  
  public final void B(View paramView, int paramInt)
  {
    y.d("MicroMsg.TaskListView", "onItemClick");
    paramView = ((ViewGroup)paramView).getChildAt(0);
    Object localObject = TaskListView.b(this.iUe).iTQ;
    if ((!(paramView instanceof TaskItemView)) || (paramInt < 0) || (paramInt >= ((h)localObject).size())) {}
    do
    {
      return;
      localObject = (j)((h)localObject).get(paramInt);
      if (!TaskListView.a(this.iUe))
      {
        if (!((j)localObject).fmm) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.setSelected(bool);
          return;
        }
      }
    } while (bk.bl(((j)localObject).jumpUrl));
    paramView = new Bundle();
    paramView.putString("rawUrl", ((j)localObject).jumpUrl);
    ((a)g.r(a.class)).e(this.iUe.getContext(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.7
 * JD-Core Version:    0.7.0.1
 */