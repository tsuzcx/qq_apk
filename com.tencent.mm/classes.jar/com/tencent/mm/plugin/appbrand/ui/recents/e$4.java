package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

final class e$4
  implements Runnable
{
  e$4(e parame) {}
  
  public final void run()
  {
    if (e.i(this.hhH).computeVerticalScrollOffset() == 0) {
      e.i(this.hhH).scrollBy(0, e.p(this.hhH).getTop());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.4
 * JD-Core Version:    0.7.0.1
 */