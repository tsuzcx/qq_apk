package android.support.v7.widget.a;

import android.graphics.Rect;
import android.support.v4.view.q;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    int k = 0;
    a locala;
    long l2;
    long l1;
    Object localObject;
    int j;
    int i;
    label149:
    int m;
    label206:
    RecyclerView localRecyclerView;
    if (this.aoa.anE != null)
    {
      locala = this.aoa;
      if (locala.anE == null) {
        break label550;
      }
      l2 = System.currentTimeMillis();
      if (locala.anZ != -9223372036854775808L) {
        break label409;
      }
      l1 = 0L;
      localObject = locala.acI.getLayoutManager();
      if (locala.hc == null) {
        locala.hc = new Rect();
      }
      ((RecyclerView.i)localObject).g(locala.anE.aie, locala.hc);
      if (!((RecyclerView.i)localObject).gO()) {
        break label479;
      }
      j = (int)(locala.anL + locala.anJ);
      i = j - locala.hc.left - locala.acI.getPaddingLeft();
      if ((locala.anJ >= 0.0F) || (i >= 0)) {
        break label422;
      }
      if (!((RecyclerView.i)localObject).gP()) {
        break label545;
      }
      m = (int)(locala.anM + locala.anK);
      j = m - locala.hc.top - locala.acI.getPaddingTop();
      if ((locala.anK >= 0.0F) || (j >= 0)) {
        break label484;
      }
      if (i == 0) {
        break label566;
      }
      localObject = locala.anN;
      localRecyclerView = locala.acI;
      m = locala.anE.aie.getWidth();
      locala.acI.getWidth();
      i = ((a.a)localObject).a(localRecyclerView, m, i, l1);
    }
    label409:
    label422:
    label550:
    label566:
    for (;;)
    {
      if (j != 0)
      {
        localObject = locala.anN;
        localRecyclerView = locala.acI;
        m = locala.anE.aie.getHeight();
        locala.acI.getHeight();
        j = ((a.a)localObject).a(localRecyclerView, m, j, l1);
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (locala.anZ == -9223372036854775808L) {
            locala.anZ = l2;
          }
          locala.acI.scrollBy(i, j);
        }
        for (i = 1;; i = k)
        {
          if (i != 0)
          {
            if (this.aoa.anE != null) {
              this.aoa.G(this.aoa.anE);
            }
            this.aoa.acI.removeCallbacks(this.aoa.anR);
            q.b(this.aoa.acI, this);
          }
          return;
          l1 = l2 - locala.anZ;
          break;
          if (locala.anJ > 0.0F)
          {
            j = j + locala.anE.aie.getWidth() + locala.hc.right - (locala.acI.getWidth() - locala.acI.getPaddingRight());
            i = j;
            if (j > 0) {
              break label149;
            }
          }
          label479:
          i = 0;
          break label149;
          label484:
          if (locala.anK > 0.0F)
          {
            m = m + locala.anE.aie.getHeight() + locala.hc.bottom - (locala.acI.getHeight() - locala.acI.getPaddingBottom());
            j = m;
            if (m > 0) {
              break label206;
            }
          }
          j = 0;
          break label206;
          locala.anZ = -9223372036854775808L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.a.a.1
 * JD-Core Version:    0.7.0.1
 */