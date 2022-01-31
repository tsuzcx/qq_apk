package android.support.v7.widget.a;

import android.graphics.Rect;
import android.support.v4.view.t;
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
    if (this.aqr.apV != null)
    {
      locala = this.aqr;
      if (locala.apV == null) {
        break label550;
      }
      l2 = System.currentTimeMillis();
      if (locala.aqq != -9223372036854775808L) {
        break label409;
      }
      l1 = 0L;
      localObject = locala.adt.getLayoutManager();
      if (locala.hV == null) {
        locala.hV = new Rect();
      }
      ((RecyclerView.i)localObject).g(locala.apV.aku, locala.hV);
      if (!((RecyclerView.i)localObject).ij()) {
        break label479;
      }
      j = (int)(locala.aqc + locala.aqa);
      i = j - locala.hV.left - locala.adt.getPaddingLeft();
      if ((locala.aqa >= 0.0F) || (i >= 0)) {
        break label422;
      }
      if (!((RecyclerView.i)localObject).ik()) {
        break label545;
      }
      m = (int)(locala.aqd + locala.aqb);
      j = m - locala.hV.top - locala.adt.getPaddingTop();
      if ((locala.aqb >= 0.0F) || (j >= 0)) {
        break label484;
      }
      if (i == 0) {
        break label566;
      }
      localObject = locala.aqe;
      localRecyclerView = locala.adt;
      m = locala.apV.aku.getWidth();
      locala.adt.getWidth();
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
        localObject = locala.aqe;
        localRecyclerView = locala.adt;
        m = locala.apV.aku.getHeight();
        locala.adt.getHeight();
        j = ((a.a)localObject).a(localRecyclerView, m, j, l1);
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (locala.aqq == -9223372036854775808L) {
            locala.aqq = l2;
          }
          locala.adt.scrollBy(i, j);
        }
        for (i = 1;; i = k)
        {
          if (i != 0)
          {
            if (this.aqr.apV != null) {
              this.aqr.M(this.aqr.apV);
            }
            this.aqr.adt.removeCallbacks(this.aqr.aqi);
            t.b(this.aqr.adt, this);
          }
          return;
          l1 = l2 - locala.aqq;
          break;
          if (locala.aqa > 0.0F)
          {
            j = j + locala.apV.aku.getWidth() + locala.hV.right - (locala.adt.getWidth() - locala.adt.getPaddingRight());
            i = j;
            if (j > 0) {
              break label149;
            }
          }
          label479:
          i = 0;
          break label149;
          label484:
          if (locala.aqb > 0.0F)
          {
            m = m + locala.apV.aku.getHeight() + locala.hV.bottom - (locala.adt.getHeight() - locala.adt.getPaddingBottom());
            j = m;
            if (m > 0) {
              break label206;
            }
          }
          j = 0;
          break label206;
          locala.aqq = -9223372036854775808L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.a.a.1
 * JD-Core Version:    0.7.0.1
 */