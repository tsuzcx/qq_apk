package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class FavSearchActionView$2
  implements View.OnClickListener
{
  FavSearchActionView$2(FavSearchActionView paramFavSearchActionView) {}
  
  public final void onClick(View paramView)
  {
    if (FavSearchActionView.d(this.kjG) == null) {
      return;
    }
    paramView = FavSearchActionView.a(this.kjG);
    Iterator localIterator = paramView.sXo.iterator();
    while (localIterator.hasNext())
    {
      MMTagPanel.d locald = (MMTagPanel.d)localIterator.next();
      paramView.removeView(locald.uYz);
      paramView.a(locald);
    }
    paramView.sXo.clear();
    paramView.cBd();
    FavSearchActionView.a(this.kjG).cAZ();
    FavSearchActionView.f(this.kjG).clear();
    FavSearchActionView.b(this.kjG).clear();
    FavSearchActionView.d(this.kjG).a(FavSearchActionView.e(this.kjG), FavSearchActionView.f(this.kjG), FavSearchActionView.b(this.kjG), true);
    FavSearchActionView.c(this.kjG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.2
 * JD-Core Version:    0.7.0.1
 */