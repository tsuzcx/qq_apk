package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.List;

public final class k<T extends RecyclerView.w>
  extends i<T>
{
  FrameLayout cuk;
  int dfG = 0;
  int endPos = 0;
  public h mYA = null;
  View mYs;
  private List nau;
  List nav;
  Object naw;
  boolean nax;
  public g nay;
  a naz;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public k(FrameLayout paramFrameLayout, List paramList1, List paramList2, a parama)
  {
    this.cuk = paramFrameLayout;
    this.nau = paramList1;
    this.naz = parama;
    this.nav = paramList2;
  }
  
  private View i(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49836);
    paramT.auu.setVisibility(4);
    paramRecyclerView = this.nay.e(paramRecyclerView, paramT);
    paramRecyclerView.setVisibility(0);
    AppMethodBeat.o(49836);
    return paramRecyclerView;
  }
  
  private void n(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49835);
    if (this.nax)
    {
      int i = this.nav.indexOf(this.naw);
      if (i >= 0)
      {
        this.nav.remove(i);
        paramRecyclerView.getAdapter().cl(i);
      }
      this.nax = false;
      if (this.naz != null) {
        this.naz.bCR();
      }
    }
    AppMethodBeat.o(49835);
  }
  
  private float o(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49837);
    if (this.mYA == null)
    {
      AppMethodBeat.o(49837);
      return 0.0F;
    }
    int i = this.mYA.computeVerticalScrollOffset();
    int j = paramRecyclerView.computeVerticalScrollExtent();
    int k = this.mYA.computeVerticalScrollRange();
    int m = k - paramRecyclerView.getMeasuredHeight() - i;
    ad.i("ItemInsertHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramRecyclerView.getMeasuredHeight()), Integer.valueOf((int)(paramRecyclerView.getResources().getDimension(2131166753) * 1.0F)), Integer.valueOf(m) });
    if (m > paramRecyclerView.getResources().getDimension(2131166753) * 1.0F)
    {
      AppMethodBeat.o(49837);
      return 0.0F;
    }
    float f1 = paramRecyclerView.getResources().getDimension(2131166753);
    float f2 = m;
    AppMethodBeat.o(49837);
    return f1 * 1.0F - f2;
  }
  
  public final boolean O(T paramT)
  {
    AppMethodBeat.i(49826);
    if (this.nay != null)
    {
      boolean bool = this.nay.O(paramT);
      AppMethodBeat.o(49826);
      return bool;
    }
    if (paramT == null)
    {
      AppMethodBeat.o(49826);
      return false;
    }
    AppMethodBeat.o(49826);
    return true;
  }
  
  public final boolean P(T paramT)
  {
    AppMethodBeat.i(49832);
    if (this.nay != null)
    {
      boolean bool = this.nay.P(paramT);
      AppMethodBeat.o(49832);
      return bool;
    }
    AppMethodBeat.o(49832);
    return false;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(49828);
    if (this.nay != null)
    {
      boolean bool = this.nay.a(paramT, this.naw);
      AppMethodBeat.o(49828);
      return bool;
    }
    AppMethodBeat.o(49828);
    return true;
  }
  
  public final void a(final RecyclerView paramRecyclerView, RecyclerView.w paramw, final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49830);
    if (this.nay != null) {
      this.nay.cP(this.mYs);
    }
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49824);
        if (k.this.nax)
        {
          k localk = k.this;
          RecyclerView localRecyclerView = paramRecyclerView;
          Object localObject1 = k.this.naw;
          int m = paramInt;
          ad.i("ItemInsertHelper", "alvinluo checkDuplicate position: %d", new Object[] { Integer.valueOf(m) });
          if (localObject1 != null)
          {
            if (localk.naz != null)
            {
              int i = 0;
              for (int j = -1;; j = k)
              {
                k = j;
                if (i >= localk.nav.size()) {
                  break;
                }
                Object localObject2 = localk.nav.get(i);
                k = j;
                if (localk.naz.E(localObject1, localObject2))
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
            if ((k != -1) && (k < localk.nav.size()))
            {
              ad.i("ItemInsertHelper", "alvinluo checkDuplicate targetPosition: %d", new Object[] { Integer.valueOf(k) });
              localk.nav.remove(k);
              localRecyclerView.getAdapter().cl(k);
            }
          }
        }
        if (k.this.nay != null) {
          k.this.nay.b(k.this.dfG, k.this.endPos, k.this.naw, k.this.nax);
        }
        paramRunnable.run();
        AppMethodBeat.o(49824);
      }
    };
    RecyclerView.w localw;
    float f2;
    float f1;
    float f3;
    if ((paramw != null) && (this.mYs != null))
    {
      ad.i("ItemInsertHelper", "[finishMove] position:" + paramw.lN() + " dragViewPosition:" + paramInt);
      localw = paramRecyclerView.ci(paramInt);
      f2 = this.mYs.getTranslationX();
      f1 = this.mYs.getTranslationY();
      if (!this.nax)
      {
        f2 = f(paramRecyclerView, paramw);
        f3 = this.naz.bAn();
        f1 = Q(paramw) + this.naz.bAo() + o(paramRecyclerView);
        f2 = f3 + f2;
      }
    }
    for (;;)
    {
      paramRunnable = this.naz.cQ(this.mYs);
      paramRecyclerView = paramRunnable;
      if (paramRunnable == null) {
        paramRecyclerView = this.mYs;
      }
      ad.i("ItemInsertHelper", "alvinluo finishMove transX: %f, transY: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
      this.mYs.findViewById(2131305201).setVisibility(4);
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.mYs.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new k.5(this, paramw, local4, localw)).start();
      AppMethodBeat.o(49830);
      return;
      if ((localw == null) || (paramInt != localw.lN()))
      {
        if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).km() > paramInt) {
          f1 -= paramRecyclerView.getHeight();
        } else {
          f1 = paramRecyclerView.getHeight() + f1;
        }
      }
      else if (this.nax)
      {
        f2 = f(paramRecyclerView, localw);
        f3 = this.naz.bAn();
        f1 = Q(localw);
        float f5 = this.naz.bAo();
        float f4 = o(paramRecyclerView);
        f1 = f1 + f5 + f4;
        ad.i("ItemInsertHelper", "alvinluo finishMove computeMoveExtraY %f", new Object[] { Float.valueOf(f4) });
        f2 = f3 + f2;
        continue;
        ad.e("ItemInsertHelper", "alvinluo finishMove viewHolder is null");
        AppMethodBeat.o(49830);
        return;
      }
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(49831);
    if (paramView == null)
    {
      AppMethodBeat.o(49831);
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
    paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
    if (this.nay != null) {
      this.nay.a(paramw, paramView, this.naw, paramInt);
    }
    AppMethodBeat.o(49831);
  }
  
  public final boolean a(final RecyclerView paramRecyclerView, T paramT1, T paramT2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(49829);
    ad.i("ItemInsertHelper", "alvinluo ItemInsertHelper onMoved isHasInserted: " + this.nax + ", from: " + paramInt1 + ", to: " + paramInt2);
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(49829);
      return false;
    }
    if (!this.nax)
    {
      this.nav.add(paramInt2, this.naw);
      paramRecyclerView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49821);
          paramRecyclerView.getAdapter().ck(paramInt2);
          AppMethodBeat.o(49821);
        }
      });
      this.nax = true;
      if (this.naz != null) {
        this.naz.bCQ();
      }
    }
    for (;;)
    {
      this.endPos = paramInt2;
      if (this.naz != null) {
        this.naz.h(this.naw, paramInt2);
      }
      AppMethodBeat.o(49829);
      return true;
      if ((paramInt1 < 0) || (paramInt1 >= this.nav.size()) || (paramInt2 < 0) || (paramInt2 >= this.nav.size()))
      {
        AppMethodBeat.o(49829);
        return false;
      }
      int i;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1;
        while (i < paramInt2)
        {
          Collections.swap(this.nav, i, i + 1);
          i += 1;
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49822);
              paramRecyclerView.getAdapter().aq(paramInt1, paramInt2);
              AppMethodBeat.o(49822);
            }
          });
        }
      }
      else if (paramInt1 > paramInt2)
      {
        i = paramInt1;
        while (i > paramInt2)
        {
          Collections.swap(this.nav, i, i - 1);
          i -= 1;
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49823);
              paramRecyclerView.getAdapter().aq(paramInt1, paramInt2);
              AppMethodBeat.o(49823);
            }
          });
        }
      }
    }
  }
  
  public final View g(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49827);
    this.mYs = i(paramRecyclerView, paramT);
    if (this.mYs != null)
    {
      FrameLayout localFrameLayout = this.cuk;
      paramRecyclerView = i(paramRecyclerView, paramT);
      this.mYs = paramRecyclerView;
      localFrameLayout.addView(paramRecyclerView);
      if ((paramT.lN() < 0) && (this.mYs != null))
      {
        this.cuk.removeView(this.mYs);
        this.mYs = null;
        AppMethodBeat.o(49827);
        return null;
      }
      this.nax = false;
      if (paramT.lN() < this.nau.size())
      {
        this.naw = this.naz.cC(this.nau.get(paramT.lN()));
        this.dfG = paramT.lN();
        paramRecyclerView = this.mYs;
        AppMethodBeat.o(49827);
        return paramRecyclerView;
      }
    }
    AppMethodBeat.o(49827);
    return null;
  }
  
  public final void h(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49833);
    int i = paramT.lN();
    ad.i("ItemInsertHelper", "[onDelete] position:".concat(String.valueOf(i)));
    if ((i >= 0) && (i < this.nau.size())) {
      this.nau.remove(i);
    }
    n(paramRecyclerView);
    if (this.nay != null)
    {
      if ((this.naw instanceof AppBrandDesktopView.c)) {
        ((AppBrandDesktopView.c)this.naw).position = paramT.lN();
      }
      this.nay.cB(this.naw);
    }
    AppMethodBeat.o(49833);
  }
  
  public final void m(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49834);
    ad.i("ItemInsertHelper", "alvinluo onCancel");
    n(paramRecyclerView);
    AppMethodBeat.o(49834);
  }
  
  public static abstract interface a
    extends m
  {
    public abstract boolean E(Object paramObject1, Object paramObject2);
    
    public abstract void bCQ();
    
    public abstract void bCR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.k
 * JD-Core Version:    0.7.0.1
 */