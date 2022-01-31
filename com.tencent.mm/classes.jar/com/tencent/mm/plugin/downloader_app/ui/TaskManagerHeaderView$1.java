package com.tencent.mm.plugin.downloader_app.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;
import java.util.Iterator;

final class TaskManagerHeaderView$1
  implements View.OnClickListener
{
  TaskManagerHeaderView$1(TaskManagerHeaderView paramTaskManagerHeaderView) {}
  
  public final void onClick(View paramView)
  {
    if ((this.iUf.getContext() instanceof DownloadMainUI))
    {
      paramView = ((DownloadMainUI)this.iUf.getContext()).iTl;
      if (paramView.iTX != null) {
        paramView.iTX.eZ(false);
      }
      localObject = paramView.iTW.iTQ;
      if (((h)localObject).size() <= 3) {
        ((DownloadMainUI)paramView.getContext()).eY(true);
      }
    }
    else
    {
      return;
    }
    Object localObject = ((h)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      j localj = (j)((Iterator)localObject).next();
      localj.ilB = false;
      localj.fmm = false;
    }
    paramView.iTW.agL.notifyChanged();
    paramView.iUd = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView.1
 * JD-Core Version:    0.7.0.1
 */