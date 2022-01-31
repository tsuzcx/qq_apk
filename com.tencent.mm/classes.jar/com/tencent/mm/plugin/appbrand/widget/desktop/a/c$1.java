package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class c$1
  implements Runnable
{
  c$1(c paramc, RecyclerView paramRecyclerView, int paramInt, Runnable paramRunnable) {}
  
  public final void run()
  {
    if (this.hsf.hsa)
    {
      c localc = this.hsf;
      RecyclerView localRecyclerView = this.hsd;
      Object localObject1 = this.hsf.hrZ;
      int m = this.hse;
      y.i("ItemInsertHelper", "alvinluo checkDuplicate position: %d", new Object[] { Integer.valueOf(m) });
      if (localObject1 != null)
      {
        if (localc.hsc != null)
        {
          int i = 0;
          for (int j = -1;; j = k)
          {
            k = j;
            if (i >= localc.hrY.size()) {
              break;
            }
            Object localObject2 = localc.hrY.get(i);
            k = j;
            if (localc.hsc.k(localObject1, localObject2))
            {
              k = j;
              if (i != m) {
                k = i;
              }
            }
            i += 1;
          }
        }
        int k = -1;
        if ((k != -1) && (k < localc.hrY.size()))
        {
          y.i("ItemInsertHelper", "alvinluo checkDuplicate targetPosition: %d", new Object[] { Integer.valueOf(k) });
          localc.hrY.remove(k);
          localRecyclerView.getAdapter().bN(k);
        }
      }
    }
    if (this.hsf.hsb != null) {
      this.hsf.hsb.c(this.hsf.hrZ, this.hsf.hsa);
    }
    this.bxs.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.c.1
 * JD-Core Version:    0.7.0.1
 */