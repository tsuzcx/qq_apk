package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.recents.f;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

final class c$7
  implements Runnable
{
  c$7(c paramc) {}
  
  public final void run()
  {
    if ((this.hkA.hhs.aie == null) || (this.hkA.hhs.aie.getHeight() <= 0) || (this.hkA.hhj == null)) {
      return;
    }
    this.hkA.hhj.scrollBy(0, this.hkA.hhs.aie.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c.7
 * JD-Core Version:    0.7.0.1
 */