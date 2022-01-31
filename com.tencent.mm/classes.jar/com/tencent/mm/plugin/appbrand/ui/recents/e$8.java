package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

final class e$8
  implements Runnable
{
  e$8(e parame) {}
  
  public final void run()
  {
    if ((e.n(this.hhH).aie == null) || (e.n(this.hhH).aie.getHeight() <= 0) || (e.i(this.hhH) == null)) {
      return;
    }
    e.i(this.hhH).scrollBy(0, e.n(this.hhH).aie.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.8
 * JD-Core Version:    0.7.0.1
 */