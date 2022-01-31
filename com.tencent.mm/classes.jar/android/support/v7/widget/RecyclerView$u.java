package android.support.v7.widget;

import android.os.Build.VERSION;
import android.support.v4.os.e;
import android.support.v4.view.l;
import android.support.v4.view.t;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.ArrayList;

final class RecyclerView$u
  implements Runnable
{
  int akq;
  int akr;
  private boolean aks = false;
  private boolean akt = false;
  OverScroller jR;
  Interpolator mInterpolator = RecyclerView.aiY;
  
  RecyclerView$u(RecyclerView paramRecyclerView)
  {
    this.jR = new OverScroller(paramRecyclerView.getContext(), RecyclerView.aiY);
  }
  
  private int aD(int paramInt1, int paramInt2)
  {
    int j = Math.abs(paramInt1);
    int k = Math.abs(paramInt2);
    int i;
    int m;
    if (j > k)
    {
      i = 1;
      m = (int)Math.sqrt(0.0D);
      paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (i == 0) {
        break label131;
      }
    }
    label131:
    for (paramInt1 = this.aja.getWidth();; paramInt1 = this.aja.getHeight())
    {
      int n = paramInt1 / 2;
      float f3 = Math.min(1.0F, paramInt2 * 1.0F / paramInt1);
      float f1 = n;
      float f2 = n;
      f3 = distanceInfluenceForSnapDuration(f3);
      if (m <= 0) {
        break label142;
      }
      paramInt1 = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / m)) * 4;
      return Math.min(paramInt1, 2000);
      i = 0;
      break;
    }
    label142:
    if (i != 0) {}
    for (paramInt2 = j;; paramInt2 = k)
    {
      paramInt1 = (int)((paramInt2 / paramInt1 + 1.0F) * 300.0F);
      break;
    }
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  public final void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    int i = aD(paramInt1, paramInt2);
    Interpolator localInterpolator = paramInterpolator;
    if (paramInterpolator == null) {
      localInterpolator = RecyclerView.aiY;
    }
    b(paramInt1, paramInt2, i, localInterpolator);
  }
  
  final void aC(int paramInt1, int paramInt2)
  {
    m(paramInt1, paramInt2, aD(paramInt1, paramInt2));
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (this.mInterpolator != paramInterpolator)
    {
      this.mInterpolator = paramInterpolator;
      this.jR = new OverScroller(this.aja.getContext(), paramInterpolator);
    }
    this.aja.setScrollState(2);
    this.akr = 0;
    this.akq = 0;
    this.jR.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
    if (Build.VERSION.SDK_INT < 23) {
      this.jR.computeScrollOffset();
    }
    jI();
  }
  
  final void jI()
  {
    if (this.aks)
    {
      this.akt = true;
      return;
    }
    this.aja.removeCallbacks(this);
    t.b(this.aja, this);
  }
  
  public final void m(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3, RecyclerView.aiY);
  }
  
  public final void run()
  {
    if (this.aja.ahW == null)
    {
      stop();
      return;
    }
    this.akt = false;
    this.aks = true;
    this.aja.iO();
    OverScroller localOverScroller = this.jR;
    RecyclerView.r localr = this.aja.ahW.ajo;
    int i5;
    int i6;
    int i2;
    int i1;
    int i;
    if (localOverScroller.computeScrollOffset())
    {
      int[] arrayOfInt = RecyclerView.b(this.aja);
      i5 = localOverScroller.getCurrX();
      i6 = localOverScroller.getCurrY();
      i2 = i5 - this.akq;
      i1 = i6 - this.akr;
      this.akq = i5;
      this.akr = i6;
      if (!this.aja.a(i2, i1, arrayOfInt, null, 1)) {
        break label886;
      }
      i = arrayOfInt[0];
      i1 -= arrayOfInt[1];
      i2 -= i;
    }
    label230:
    label623:
    label886:
    for (;;)
    {
      int m;
      int n;
      int j;
      int k;
      if (this.aja.Tg != null)
      {
        this.aja.iP();
        this.aja.ja();
        e.beginSection("RV Scroll");
        this.aja.m(this.aja.aiK);
        if (i2 != 0)
        {
          i = this.aja.ahW.a(i2, this.aja.ahO, this.aja.aiK);
          m = i2 - i;
          if (i1 != 0)
          {
            n = this.aja.ahW.b(i1, this.aja.ahO, this.aja.aiK);
            j = i1 - n;
            e.endSection();
            this.aja.jt();
            this.aja.am(true);
            this.aja.al(false);
            if ((localr != null) && (!localr.ajR) && (localr.ajS))
            {
              k = this.aja.aiK.getItemCount();
              if (k == 0)
              {
                localr.stop();
                k = j;
                j = i;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (!this.aja.ahY.isEmpty()) {
          this.aja.invalidate();
        }
        if (this.aja.getOverScrollMode() != 2) {
          this.aja.ah(i2, i1);
        }
        int i3;
        if ((!this.aja.a(j, n, m, k, null, 1)) && ((m != 0) || (k != 0)))
        {
          i3 = (int)localOverScroller.getCurrVelocity();
          if (m == i5) {
            break label851;
          }
          if (m >= 0) {
            break label768;
          }
          i = -i3;
        }
        for (int i4 = i;; i4 = 0)
        {
          if (k != i6) {
            if (k < 0) {
              i = -i3;
            }
          }
          for (;;)
          {
            if (this.aja.getOverScrollMode() != 2) {
              this.aja.ai(i4, i);
            }
            if (((i4 != 0) || (m == i5) || (localOverScroller.getFinalX() == 0)) && ((i != 0) || (k == i6) || (localOverScroller.getFinalY() == 0))) {
              localOverScroller.abortAnimation();
            }
            if ((j != 0) || (n != 0)) {
              this.aja.am(j, n);
            }
            if (!RecyclerView.c(this.aja)) {
              this.aja.invalidate();
            }
            if ((i1 != 0) && (this.aja.ahW.ik()) && (n == i1))
            {
              i = 1;
              if ((i2 == 0) || (!this.aja.ahW.ij()) || (j != i2)) {
                break label801;
              }
              j = 1;
              if (((i2 != 0) || (i1 != 0)) && (j == 0) && (i == 0)) {
                break label806;
              }
              i = 1;
              if ((!localOverScroller.isFinished()) && ((i != 0) || (this.aja.getScrollingChildHelper().au(1)))) {
                break label811;
              }
              this.aja.setScrollState(0);
              if (RecyclerView.access$800()) {
                this.aja.aiJ.hI();
              }
              this.aja.av(1);
            }
            for (;;)
            {
              if (localr != null)
              {
                if (localr.ajR) {
                  RecyclerView.r.a(localr, 0, 0);
                }
                if (!this.akt) {
                  localr.stop();
                }
              }
              this.aks = false;
              if (!this.akt) {
                break;
              }
              jI();
              return;
              if (localr.ajQ >= k) {
                localr.ajQ = (k - 1);
              }
              RecyclerView.r.a(localr, i2 - m, i1 - j);
              k = j;
              j = i;
              break label340;
              if (m > 0)
              {
                i = i3;
                break label433;
              }
              i = 0;
              break label433;
              i = i3;
              if (k > 0) {
                break label450;
              }
              i = 0;
              break label450;
              i = 0;
              break label577;
              j = 0;
              break label603;
              i = 0;
              break label623;
              jI();
              if (this.aja.aiI != null) {
                this.aja.aiI.b(this.aja, i2, i1);
              }
            }
            i = 0;
          }
        }
        j = 0;
        n = 0;
        break label269;
        m = 0;
        i = 0;
        break label230;
        k = 0;
        m = 0;
        n = 0;
        j = 0;
      }
    }
  }
  
  public final void stop()
  {
    this.aja.removeCallbacks(this);
    this.jR.abortAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.u
 * JD-Core Version:    0.7.0.1
 */