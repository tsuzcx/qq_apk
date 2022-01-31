package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class c$5$1
  implements Runnable
{
  c$5$1(c.5 param5, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    if (this.hkB != null)
    {
      this.hkC.hkA.hkr.setData(this.hkB);
      this.hkC.hkA.hkr.agL.notifyChanged();
    }
    for (;;)
    {
      c localc = this.hkC.hkA;
      y.i("MicroMsg.AppBrandRecommendUILogic", "onFetchPageFinishFromDB, filterType:%d", new Object[] { Integer.valueOf(localc.getFilterType()) });
      localc.Wa();
      localc.hhj.dZ(true);
      return;
      y.e("MicroMsg.AppBrandRecommendUILogic", "load empty data from db");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c.5.1
 * JD-Core Version:    0.7.0.1
 */