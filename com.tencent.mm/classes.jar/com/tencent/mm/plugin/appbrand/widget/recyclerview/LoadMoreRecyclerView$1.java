package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoadMoreRecyclerView$1
  extends RecyclerView.m
{
  int jwq = 0;
  
  LoadMoreRecyclerView$1(LoadMoreRecyclerView paramLoadMoreRecyclerView, LinearLayoutManager paramLinearLayoutManager) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77479);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    this.jwq = this.jwr.iv();
    AppMethodBeat.o(77479);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(77478);
    super.c(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.jws.jwp) && (this.jwq == this.jws.jwt.getItemCount() - 1) && (LoadMoreRecyclerView.a(this.jws) != null)) {
      LoadMoreRecyclerView.a(this.jws).aNj();
    }
    AppMethodBeat.o(77478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */