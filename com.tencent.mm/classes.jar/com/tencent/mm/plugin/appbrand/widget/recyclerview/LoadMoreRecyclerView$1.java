package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;

final class LoadMoreRecyclerView$1
  extends RecyclerView.m
{
  int hDQ = 0;
  
  LoadMoreRecyclerView$1(LoadMoreRecyclerView paramLoadMoreRecyclerView, LinearLayoutManager paramLinearLayoutManager) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.hDQ = this.hDR.ha();
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.hDS.hDP) && (this.hDQ == this.hDS.hDT.getItemCount() - 1) && (LoadMoreRecyclerView.a(this.hDS) != null))
    {
      paramRecyclerView = LoadMoreRecyclerView.a(this.hDS);
      RecyclerView.a locala = this.hDS.hDT.Sw;
      paramRecyclerView.apj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */