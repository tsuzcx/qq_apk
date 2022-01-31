package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;

final class c$a
  implements View.OnClickListener
{
  c$a(c paramc, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    paramView = c.a(this.hgw);
    if (paramView != null) {
      paramView.removeItem(this.hgx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.c.a
 * JD-Core Version:    0.7.0.1
 */