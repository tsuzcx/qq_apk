package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "", "onLoadMoreBegin", "", "onLoadMoreEnd", "className", "", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
{
  public abstract void a(m.a parama);
  
  public abstract void d(RecyclerView paramRecyclerView, int paramInt);
  
  public abstract void dKe();
  
  public abstract void dKf();
  
  public abstract void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.e
 * JD-Core Version:    0.7.0.1
 */