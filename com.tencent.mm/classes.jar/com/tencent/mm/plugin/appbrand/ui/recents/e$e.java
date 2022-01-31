package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

final class e$e
  extends RecyclerView.m
  implements Runnable
{
  private e$e(e parame) {}
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = this.hhH;
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(paramRecyclerView, bool);
      if (paramInt == 0) {
        this.hhH.F(this);
      }
      return;
    }
  }
  
  public final void run()
  {
    if ((e.i(this.hhH) != null) && (e.o(this.hhH) != null) && (e.b(this.hhH) != null) && (e.C(this.hhH) != null))
    {
      int i = e.o(this.hhH).gY();
      int j = e.o(this.hhH).ha();
      while (i <= j)
      {
        RecyclerView.v localv = e.i(this.hhH).bK(i);
        if ((localv instanceof e.d))
        {
          AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = ((e.d)localv).apR();
          if (localAppBrandRecentTaskInfo != null) {
            e.C(this.hhH).b((e.d)localv, localAppBrandRecentTaskInfo.fJk);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.e
 * JD-Core Version:    0.7.0.1
 */