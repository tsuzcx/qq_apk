package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.a;
import java.util.List;

final class RecentAppBrandView$a
  extends RecyclerView.a<e>
{
  RecentAppBrandView$a(RecentAppBrandView paramRecentAppBrandView) {}
  
  public final int getItemCount()
  {
    return Math.min(4, RecentAppBrandView.b(this.hrd).size());
  }
  
  public final int getItemViewType(int paramInt)
  {
    return RecentAppBrandView.a(this.hrd, paramInt).type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView.a
 * JD-Core Version:    0.7.0.1
 */