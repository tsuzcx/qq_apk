package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoadMoreRecyclerView$2
  extends RecyclerView.c
{
  LoadMoreRecyclerView$2(LoadMoreRecyclerView paramLoadMoreRecyclerView, LinearLayoutManager paramLinearLayoutManager) {}
  
  public final void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77480);
    super.at(paramInt1, paramInt2);
    if ((this.jws.jwp) && (this.jwr.iv() == this.jws.jwt.getItemCount() - 1) && (LoadMoreRecyclerView.a(this.jws) != null)) {
      LoadMoreRecyclerView.a(this.jws).aNj();
    }
    AppMethodBeat.o(77480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.2
 * JD-Core Version:    0.7.0.1
 */