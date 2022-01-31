package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.c.bjt;

final class c$d
  extends RecyclerView.m
  implements Runnable
{
  private c$d(c paramc) {}
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = this.hkA;
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerView.hhw = bool;
      this.hkA.hky = true;
      if (paramInt == 0) {
        this.hkA.F(this);
      }
      return;
    }
  }
  
  public final void run()
  {
    if ((this.hkA.hhj != null) && (this.hkA.hkq != null) && (this.hkA.hkr != null))
    {
      int i = this.hkA.hkq.gY();
      int j = this.hkA.hkq.ha();
      while (i <= j)
      {
        Object localObject = this.hkA.hhj.bK(i);
        int k = this.hkA.hhj.N((RecyclerView.v)localObject);
        if ((localObject instanceof b.b))
        {
          b localb = this.hkA.hkr;
          localObject = (b.b)localObject;
          boolean bool = this.hkA.hhw;
          bjt localbjt = localb.mu(k);
          if (localbjt != null) {
            localb.a(b.b.d((b.b)localObject), localbjt, bool);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c.d
 * JD-Core Version:    0.7.0.1
 */