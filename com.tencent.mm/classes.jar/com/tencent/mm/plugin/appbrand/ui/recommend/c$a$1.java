package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.recents.f;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

final class c$a$1
  implements Runnable
{
  c$a$1(c.a parama, int paramInt1, int paramInt2, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    this.hkE.hkA.Wa();
    Object localObject;
    if (this.ewr == 0)
    {
      y.i("MicroMsg.AppBrandRecommendUILogic", "fetch success");
      this.hkE.hkA.hks = this.hkD;
      if (this.hkE.hkA.fKx == 0)
      {
        this.hkE.hkA.hkt.set(true);
        this.hkE.hkA.hkd.clear();
        if ((this.dri != null) && (this.dri.size() > 0)) {
          this.hkE.hkA.hkd.addAll(this.dri);
        }
        this.hkE.hkA.hkr.setData(this.hkE.hkA.hkd);
        int i = this.hkE.hkA.fKx;
        this.hkE.hkA.hkr.agL.notifyChanged();
        localObject = this.hkE.hkA;
        ((c)localObject).fKx += 1;
        if ((i != 0) || (!this.hkE.hkA.aqh()) || (this.dri == null) || (!this.dri.isEmpty())) {
          break label348;
        }
        y.e("MicroMsg.AppBrandRecommendUILogic", "can load more, but return empty data, should be load fail!");
      }
    }
    for (;;)
    {
      localObject = this.hkE.hkA;
      y.i("MicroMsg.AppBrandRecommendUILogic", "onFetchPageFailFromServer, filterType:%d", new Object[] { Integer.valueOf(((c)localObject).getFilterType()) });
      ((c)localObject).Wa();
      ((c)localObject).hhj.dZ(false);
      ((c)localObject).hhs.setLoading(false);
      return;
      if (this.hkE.hkA.fKx <= 0) {
        break;
      }
      if ((this.dri != null) && (this.dri.size() > 0)) {
        this.hkE.hkA.hkd.addAll(this.dri);
      }
      localObject = this.hkE.hkA.hkr;
      LinkedList localLinkedList = this.dri;
      ((b)localObject).hkd.addAll(localLinkedList);
      break;
      label348:
      localObject = this.hkE.hkA;
      y.i("MicroMsg.AppBrandRecommendUILogic", "onFetchPageSuccessFromServer, filterType:%d", new Object[] { Integer.valueOf(((c)localObject).getFilterType()) });
      if (!((c)localObject).aqh())
      {
        ((c)localObject).hhs.setLoading(false);
        if (((c)localObject).hhs.aie != null) {
          ((c)localObject).hhs.aie.post(new c.7((c)localObject));
        }
        y.i("MicroMsg.AppBrandRecommendUILogic", "onFetchPageFinishFromServer  can't fetch more data");
        return;
      }
      if ((((c)localObject).hhs != null) && (((c)localObject).hhs.aie != null) && (((c)localObject).hhs.aie.isShown()))
      {
        ((c)localObject).F(new c.6((c)localObject));
        return;
      }
      y.i("MicroMsg.AppBrandRecommendUILogic", "show loading");
      ((c)localObject).hhj.dZ(true);
      return;
      y.i("MicroMsg.AppBrandRecommendUILogic", "fetch fail");
      if (this.hkE.hkA.fKx == 0) {
        this.hkE.hkA.hkt.set(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c.a.1
 * JD-Core Version:    0.7.0.1
 */