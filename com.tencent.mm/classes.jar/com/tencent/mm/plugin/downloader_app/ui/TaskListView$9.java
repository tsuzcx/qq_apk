package com.tencent.mm.plugin.downloader_app.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.plugin.downloader_app.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class TaskListView$9
  implements MRecyclerView.a
{
  TaskListView$9(TaskListView paramTaskListView) {}
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(136299);
    ab.d("MicroMsg.TaskListView", "onItemClick");
    paramView = ((ViewGroup)paramView).getChildAt(0);
    Object localObject = TaskListView.b(this.ldh).lcP;
    if ((paramInt < 0) || (paramInt >= ((h)localObject).size()))
    {
      AppMethodBeat.o(136299);
      return;
    }
    localObject = (i)((h)localObject).get(paramInt);
    if (((i)localObject).type == 7)
    {
      paramView = TaskListView.b(this.ldh);
      if (paramView.lcU != true)
      {
        paramView.lcU = true;
        paramView.ajb.notifyChanged();
      }
      a.a(10, 1004, 101, 2, "", "", "");
      AppMethodBeat.o(136299);
      return;
    }
    if (!TaskListView.a(this.ldh))
    {
      if (!((i)localObject).gDG) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setSelected(bool);
        AppMethodBeat.o(136299);
        return;
      }
    }
    if (bo.isNullOrNil(((i)localObject).jumpUrl))
    {
      AppMethodBeat.o(136299);
      return;
    }
    paramView = new Bundle();
    paramView.putString("rawUrl", ((i)localObject).jumpUrl);
    ((d)g.E(d.class)).g(this.ldh.getContext(), paramView);
    a.a(10, a.uc(((i)localObject).type), ((i)localObject).position, 40, ((i)localObject).appId, "", "");
    AppMethodBeat.o(136299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.9
 * JD-Core Version:    0.7.0.1
 */