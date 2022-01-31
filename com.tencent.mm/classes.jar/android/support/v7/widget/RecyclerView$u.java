package android.support.v7.widget;

import android.os.Build.VERSION;
import android.support.v4.os.f;
import android.support.v4.view.i;
import android.support.v4.view.q;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.ArrayList;

final class RecyclerView$u
  implements Runnable
{
  int aia;
  int aib;
  private boolean aic = false;
  private boolean aid = false;
  OverScroller iY;
  Interpolator mInterpolator = RecyclerView.agI;
  
  RecyclerView$u(RecyclerView paramRecyclerView)
  {
    this.iY = new OverScroller(paramRecyclerView.getContext(), RecyclerView.agI);
  }
  
  final int au(int paramInt1, int paramInt2)
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
        break label139;
      }
    }
    label139:
    for (paramInt1 = this.agK.getWidth();; paramInt1 = this.agK.getHeight())
    {
      int n = paramInt1 / 2;
      float f3 = Math.min(1.0F, paramInt2 * 1.0F / paramInt1);
      float f1 = n;
      float f2 = n;
      f3 = (float)Math.sin((f3 - 0.5F) * 0.4712389F);
      if (m <= 0) {
        break label150;
      }
      paramInt1 = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / m)) * 4;
      return Math.min(paramInt1, 2000);
      i = 0;
      break;
    }
    label150:
    if (i != 0) {}
    for (paramInt2 = j;; paramInt2 = k)
    {
      paramInt1 = (int)((paramInt2 / paramInt1 + 1.0F) * 300.0F);
      break;
    }
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (this.mInterpolator != paramInterpolator)
    {
      this.mInterpolator = paramInterpolator;
      this.iY = new OverScroller(this.agK.getContext(), paramInterpolator);
    }
    this.agK.setScrollState(2);
    this.aib = 0;
    this.aia = 0;
    this.iY.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
    if (Build.VERSION.SDK_INT < 23) {
      this.iY.computeScrollOffset();
    }
    hZ();
  }
  
  final void hZ()
  {
    if (this.aic)
    {
      this.aid = true;
      return;
    }
    this.agK.removeCallbacks(this);
    q.b(this.agK, this);
  }
  
  public final void m(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3, RecyclerView.agI);
  }
  
  public final void run()
  {
    if (this.agK.afG == null)
    {
      stop();
      return;
    }
    this.aid = false;
    this.aic = true;
    this.agK.hn();
    OverScroller localOverScroller = this.iY;
    RecyclerView.r localr = this.agK.afG.agY;
    int i5;
    int i6;
    int i2;
    int i1;
    int i;
    if (localOverScroller.computeScrollOffset())
    {
      int[] arrayOfInt = RecyclerView.a(this.agK);
      i5 = localOverScroller.getCurrX();
      i6 = localOverScroller.getCurrY();
      i2 = i5 - this.aia;
      i1 = i6 - this.aib;
      this.aia = i5;
      this.aib = i6;
      if (!this.agK.a(i2, i1, arrayOfInt, null, 1)) {
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
      if (this.agK.Sw != null)
      {
        this.agK.ho();
        this.agK.hy();
        f.beginSection("RV Scroll");
        this.agK.m(this.agK.agu);
        if (i2 != 0)
        {
          i = this.agK.afG.a(i2, this.agK.afy, this.agK.agu);
          m = i2 - i;
          if (i1 != 0)
          {
            n = this.agK.afG.b(i1, this.agK.afy, this.agK.agu);
            j = i1 - n;
            f.endSection();
            this.agK.hN();
            this.agK.ad(true);
            this.agK.ac(false);
            if ((localr != null) && (!localr.ahB) && (localr.ahC))
            {
              k = this.agK.agu.getItemCount();
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
        if (!this.agK.afI.isEmpty()) {
          this.agK.invalidate();
        }
        if (this.agK.getOverScrollMode() != 2) {
          this.agK.ad(i2, i1);
        }
        int i3;
        if ((!this.agK.a(j, n, m, k, null, 1)) && ((m != 0) || (k != 0)))
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
            if (this.agK.getOverScrollMode() != 2) {
              this.agK.ae(i4, i);
            }
            if (((i4 != 0) || (m == i5) || (localOverScroller.getFinalX() == 0)) && ((i != 0) || (k == i6) || (localOverScroller.getFinalY() == 0))) {
              localOverScroller.abortAnimation();
            }
            if ((j != 0) || (n != 0)) {
              this.agK.ag(j, n);
            }
            if (!RecyclerView.b(this.agK)) {
              this.agK.invalidate();
            }
            if ((i1 != 0) && (this.agK.afG.gP()) && (n == i1))
            {
              i = 1;
              if ((i2 == 0) || (!this.agK.afG.gO()) || (j != i2)) {
                break label801;
              }
              j = 1;
              if (((i2 != 0) || (i1 != 0)) && (j == 0) && (i == 0)) {
                break label806;
              }
              i = 1;
              if ((!localOverScroller.isFinished()) && ((i != 0) || (this.agK.getScrollingChildHelper().au(1)))) {
                break label811;
              }
              this.agK.setScrollState(0);
              if (RecyclerView.access$800()) {
                this.agK.agt.gH();
              }
              this.agK.av(1);
            }
            for (;;)
            {
              if (localr != null)
              {
                if (localr.ahB) {
                  RecyclerView.r.a(localr, 0, 0);
                }
                if (!this.aid) {
                  localr.stop();
                }
              }
              this.aic = false;
              if (!this.aid) {
                break;
              }
              hZ();
              return;
              if (localr.ahA >= k) {
                localr.ahA = (k - 1);
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
              hZ();
              if (this.agK.ags != null) {
                this.agK.ags.b(this.agK, i2, i1);
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
    this.agK.removeCallbacks(this);
    this.iY.abortAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.u
 * JD-Core Version:    0.7.0.1
 */