package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class d$4
  implements Runnable
{
  d$4(d paramd, RecyclerView paramRecyclerView, int paramInt, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(134213);
    if (this.jiB.jiw)
    {
      d locald = this.jiB;
      RecyclerView localRecyclerView = this.jiz;
      Object localObject1 = this.jiB.jiv;
      int m = this.jiD;
      ab.i("ItemInsertHelper", "alvinluo checkDuplicate position: %d", new Object[] { Integer.valueOf(m) });
      if (localObject1 != null)
      {
        if (locald.jiy != null)
        {
          int i = 0;
          for (int j = -1;; j = k)
          {
            k = j;
            if (i >= locald.jiu.size()) {
              break;
            }
            Object localObject2 = locald.jiu.get(i);
            k = j;
            if (locald.jiy.u(localObject1, localObject2))
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
        if ((k != -1) && (k < locald.jiu.size()))
        {
          ab.i("ItemInsertHelper", "alvinluo checkDuplicate targetPosition: %d", new Object[] { Integer.valueOf(k) });
          locald.jiu.remove(k);
          localRecyclerView.getAdapter().bT(k);
        }
      }
    }
    if (this.jiB.jix != null) {
      this.jiB.jix.b(this.jiB.chT, this.jiB.endPos, this.jiB.jiv, this.jiB.jiw);
    }
    this.bZt.run();
    AppMethodBeat.o(134213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.d.4
 * JD-Core Version:    0.7.0.1
 */