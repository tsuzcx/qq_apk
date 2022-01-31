package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.appbrand.ui.recents.p;

final class c$1
  extends LinearLayoutManager
{
  c$1(c paramc)
  {
    super(1);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new p(this.hkA.bMV, this.hkA.hkq);
    paramRecyclerView.ahA = paramInt;
    a(paramRecyclerView);
  }
  
  public final boolean gM()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c.1
 * JD-Core Version:    0.7.0.1
 */