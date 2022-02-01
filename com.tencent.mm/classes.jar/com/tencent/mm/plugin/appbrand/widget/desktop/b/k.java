package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.List;

public final class k<T extends RecyclerView.v>
  extends i<T>
{
  int cWU = 0;
  int endPos = 0;
  FrameLayout lOR;
  View lVI;
  public com.tencent.mm.plugin.appbrand.widget.desktop.g lVQ = null;
  private List lXK;
  List lXL;
  Object lXM;
  boolean lXN;
  public g lXO;
  a lXP;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public k(FrameLayout paramFrameLayout, List paramList1, List paramList2, a parama)
  {
    this.lOR = paramFrameLayout;
    this.lXK = paramList1;
    this.lXP = parama;
    this.lXL = paramList2;
  }
  
  private View i(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49836);
    paramT.arI.setVisibility(4);
    paramRecyclerView = this.lXO.e(paramRecyclerView, paramT);
    paramRecyclerView.setVisibility(0);
    AppMethodBeat.o(49836);
    return paramRecyclerView;
  }
  
  private void n(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49835);
    if (this.lXN)
    {
      int i = this.lXL.indexOf(this.lXM);
      if (i >= 0)
      {
        this.lXL.remove(i);
        paramRecyclerView.getAdapter().cm(i);
      }
      this.lXN = false;
      if (this.lXP != null) {
        this.lXP.brO();
      }
    }
    AppMethodBeat.o(49835);
  }
  
  private float o(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49837);
    if (this.lVQ == null)
    {
      AppMethodBeat.o(49837);
      return 0.0F;
    }
    int i = this.lVQ.computeVerticalScrollOffset();
    int j = paramRecyclerView.computeVerticalScrollExtent();
    int k = this.lVQ.computeVerticalScrollRange();
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
    if (this.lXO != null)
    {
      boolean bool = this.lXO.O(paramT);
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
    if (this.lXO != null)
    {
      boolean bool = this.lXO.P(paramT);
      AppMethodBeat.o(49832);
      return bool;
    }
    AppMethodBeat.o(49832);
    return false;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(49828);
    if (this.lXO != null)
    {
      boolean bool = this.lXO.a(paramT, this.lXM);
      AppMethodBeat.o(49828);
      return bool;
    }
    AppMethodBeat.o(49828);
    return true;
  }
  
  public final void a(final RecyclerView paramRecyclerView, RecyclerView.v paramv, final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49830);
    if (this.lXO != null) {
      this.lXO.cL(this.lVI);
    }
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49824);
        if (k.this.lXN)
        {
          k localk = k.this;
          RecyclerView localRecyclerView = paramRecyclerView;
          Object localObject1 = k.this.lXM;
          int m = paramInt;
          ad.i("ItemInsertHelper", "alvinluo checkDuplicate position: %d", new Object[] { Integer.valueOf(m) });
          if (localObject1 != null)
          {
            if (localk.lXP != null)
            {
              int i = 0;
              for (int j = -1;; j = k)
              {
                k = j;
                if (i >= localk.lXL.size()) {
                  break;
                }
                Object localObject2 = localk.lXL.get(i);
                k = j;
                if (localk.lXP.C(localObject1, localObject2))
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
            if ((k != -1) && (k < localk.lXL.size()))
            {
              ad.i("ItemInsertHelper", "alvinluo checkDuplicate targetPosition: %d", new Object[] { Integer.valueOf(k) });
              localk.lXL.remove(k);
              localRecyclerView.getAdapter().cm(k);
            }
          }
        }
        if (k.this.lXO != null) {
          k.this.lXO.b(k.this.cWU, k.this.endPos, k.this.lXM, k.this.lXN);
        }
        paramRunnable.run();
        AppMethodBeat.o(49824);
      }
    };
    RecyclerView.v localv;
    float f2;
    float f1;
    float f3;
    if ((paramv != null) && (this.lVI != null))
    {
      ad.i("ItemInsertHelper", "[finishMove] position:" + paramv.ln() + " dragViewPosition:" + paramInt);
      localv = paramRecyclerView.cj(paramInt);
      f2 = this.lVI.getTranslationX();
      f1 = this.lVI.getTranslationY();
      if (!this.lXN)
      {
        f2 = f(paramRecyclerView, paramv);
        f3 = this.lXP.bpm();
        f1 = Q(paramv) + this.lXP.bpn() + o(paramRecyclerView);
        f2 = f3 + f2;
      }
    }
    for (;;)
    {
      paramRunnable = this.lXP.cM(this.lVI);
      paramRecyclerView = paramRunnable;
      if (paramRunnable == null) {
        paramRecyclerView = this.lVI;
      }
      ad.i("ItemInsertHelper", "alvinluo finishMove transX: %f, transY: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
      this.lVI.findViewById(2131305201).setVisibility(4);
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.lVI.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new k.5(this, paramv, local4, localv)).start();
      AppMethodBeat.o(49830);
      return;
      if ((localv == null) || (paramInt != localv.ln()))
      {
        if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).jO() > paramInt) {
          f1 -= paramRecyclerView.getHeight();
        } else {
          f1 = paramRecyclerView.getHeight() + f1;
        }
      }
      else if (this.lXN)
      {
        f2 = f(paramRecyclerView, localv);
        f3 = this.lXP.bpm();
        f1 = Q(localv);
        float f5 = this.lXP.bpn();
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
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(49831);
    if (paramView == null)
    {
      AppMethodBeat.o(49831);
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
    paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
    if (this.lXO != null) {
      this.lXO.a(paramv, paramView, this.lXM, paramInt);
    }
    AppMethodBeat.o(49831);
  }
  
  public final boolean a(final RecyclerView paramRecyclerView, T paramT1, T paramT2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(49829);
    ad.i("ItemInsertHelper", "alvinluo ItemInsertHelper onMoved isHasInserted: " + this.lXN + ", from: " + paramInt1 + ", to: " + paramInt2);
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(49829);
      return false;
    }
    if (!this.lXN)
    {
      this.lXL.add(paramInt2, this.lXM);
      paramRecyclerView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49821);
          paramRecyclerView.getAdapter().cl(paramInt2);
          AppMethodBeat.o(49821);
        }
      });
      this.lXN = true;
      if (this.lXP != null) {
        this.lXP.brN();
      }
    }
    for (;;)
    {
      this.endPos = paramInt2;
      if (this.lXP != null) {
        this.lXP.g(this.lXM, paramInt2);
      }
      AppMethodBeat.o(49829);
      return true;
      if ((paramInt1 < 0) || (paramInt1 >= this.lXL.size()) || (paramInt2 < 0) || (paramInt2 >= this.lXL.size()))
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
          Collections.swap(this.lXL, i, i + 1);
          i += 1;
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49822);
              paramRecyclerView.getAdapter().ap(paramInt1, paramInt2);
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
          Collections.swap(this.lXL, i, i - 1);
          i -= 1;
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49823);
              paramRecyclerView.getAdapter().ap(paramInt1, paramInt2);
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
    this.lVI = i(paramRecyclerView, paramT);
    if (this.lVI != null)
    {
      FrameLayout localFrameLayout = this.lOR;
      paramRecyclerView = i(paramRecyclerView, paramT);
      this.lVI = paramRecyclerView;
      localFrameLayout.addView(paramRecyclerView);
      if ((paramT.ln() < 0) && (this.lVI != null))
      {
        this.lOR.removeView(this.lVI);
        this.lVI = null;
        AppMethodBeat.o(49827);
        return null;
      }
      this.lXN = false;
      if (paramT.ln() < this.lXK.size())
      {
        this.lXM = this.lXP.cB(this.lXK.get(paramT.ln()));
        this.cWU = paramT.ln();
        paramRecyclerView = this.lVI;
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
    int i = paramT.ln();
    ad.i("ItemInsertHelper", "[onDelete] position:".concat(String.valueOf(i)));
    if ((i >= 0) && (i < this.lXK.size())) {
      this.lXK.remove(i);
    }
    n(paramRecyclerView);
    if (this.lXO != null)
    {
      if ((this.lXM instanceof AppBrandDesktopView.c)) {
        ((AppBrandDesktopView.c)this.lXM).position = paramT.ln();
      }
      this.lXO.cA(this.lXM);
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
    public abstract boolean C(Object paramObject1, Object paramObject2);
    
    public abstract void brN();
    
    public abstract void brO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.k
 * JD-Core Version:    0.7.0.1
 */