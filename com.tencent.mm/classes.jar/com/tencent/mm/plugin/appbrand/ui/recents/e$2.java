package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

final class e$2
  extends LinearLayoutManager
{
  e$2(e parame)
  {
    super(1);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new p(this.hhH.getActivity(), e.o(this.hhH));
    paramRecyclerView.ahA = paramInt;
    a(paramRecyclerView);
  }
  
  public final boolean gM()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.2
 * JD-Core Version:    0.7.0.1
 */