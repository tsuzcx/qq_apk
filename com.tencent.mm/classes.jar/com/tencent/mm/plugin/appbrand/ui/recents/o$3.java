package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.q;
import android.support.v4.view.u;
import android.support.v4.view.w;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ar;
import android.view.View;
import java.util.ArrayList;

final class o$3
  extends w
{
  o$3(o paramo, RecyclerView.v paramv, u paramu) {}
  
  public final void au(View paramView)
  {
    ((RecentsRecyclerView)paramView.getParent()).bZ(paramView);
    this.hjP.y(this.abK);
  }
  
  public final void av(View paramView)
  {
    if (paramView == null) {
      return;
    }
    ((RecentsRecyclerView)paramView.getParent()).ca(paramView);
    this.hjQ.a(null);
    q.d(paramView, 0.0F);
    this.hjP.w(this.abK);
    this.hjP.hjD.remove(this.abK);
    o.a(this.hjP);
  }
  
  public final void aw(View paramView)
  {
    if (paramView == null) {
      return;
    }
    q.d(paramView, 0.0F);
    q.e(paramView, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o.3
 * JD-Core Version:    0.7.0.1
 */