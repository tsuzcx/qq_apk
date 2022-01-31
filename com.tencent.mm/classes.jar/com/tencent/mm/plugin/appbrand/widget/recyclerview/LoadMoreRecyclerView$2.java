package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;

final class LoadMoreRecyclerView$2
  extends RecyclerView.c
{
  LoadMoreRecyclerView$2(LoadMoreRecyclerView paramLoadMoreRecyclerView, LinearLayoutManager paramLinearLayoutManager) {}
  
  public final void an(int paramInt1, int paramInt2)
  {
    super.an(paramInt1, paramInt2);
    if ((this.hDS.hDP) && (this.hDR.ha() == this.hDS.hDT.getItemCount() - 1) && (LoadMoreRecyclerView.a(this.hDS) != null))
    {
      LoadMoreRecyclerView.a locala = LoadMoreRecyclerView.a(this.hDS);
      RecyclerView.a locala1 = this.hDS.hDT.Sw;
      locala.apj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.2
 * JD-Core Version:    0.7.0.1
 */