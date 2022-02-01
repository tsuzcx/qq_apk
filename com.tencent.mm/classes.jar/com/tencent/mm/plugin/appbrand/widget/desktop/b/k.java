package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Collections;
import java.util.List;

public final class k<T extends RecyclerView.w>
  extends i<T>
{
  int cUq = 0;
  int endPos = 0;
  FrameLayout mqR;
  View mxK;
  public com.tencent.mm.plugin.appbrand.widget.desktop.g mxS = null;
  private List mzM;
  List mzN;
  Object mzO;
  boolean mzP;
  public g mzQ;
  a mzR;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public k(FrameLayout paramFrameLayout, List paramList1, List paramList2, a parama)
  {
    this.mqR = paramFrameLayout;
    this.mzM = paramList1;
    this.mzR = parama;
    this.mzN = paramList2;
  }
  
  private View i(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49836);
    paramT.asD.setVisibility(4);
    paramRecyclerView = this.mzQ.e(paramRecyclerView, paramT);
    paramRecyclerView.setVisibility(0);
    AppMethodBeat.o(49836);
    return paramRecyclerView;
  }
  
  private void n(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49835);
    if (this.mzP)
    {
      int i = this.mzN.indexOf(this.mzO);
      if (i >= 0)
      {
        this.mzN.remove(i);
        paramRecyclerView.getAdapter().cl(i);
      }
      this.mzP = false;
      if (this.mzR != null) {
        this.mzR.byO();
      }
    }
    AppMethodBeat.o(49835);
  }
  
  private float o(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49837);
    if (this.mxS == null)
    {
      AppMethodBeat.o(49837);
      return 0.0F;
    }
    int i = this.mxS.computeVerticalScrollOffset();
    int j = paramRecyclerView.computeVerticalScrollExtent();
    int k = this.mxS.computeVerticalScrollRange();
    int m = k - paramRecyclerView.getMeasuredHeight() - i;
    ac.i("ItemInsertHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramRecyclerView.getMeasuredHeight()), Integer.valueOf((int)(paramRecyclerView.getResources().getDimension(2131166753) * 1.0F)), Integer.valueOf(m) });
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
    if (this.mzQ != null)
    {
      boolean bool = this.mzQ.O(paramT);
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
    if (this.mzQ != null)
    {
      boolean bool = this.mzQ.P(paramT);
      AppMethodBeat.o(49832);
      return bool;
    }
    AppMethodBeat.o(49832);
    return false;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(49828);
    if (this.mzQ != null)
    {
      boolean bool = this.mzQ.a(paramT, this.mzO);
      AppMethodBeat.o(49828);
      return bool;
    }
    AppMethodBeat.o(49828);
    return true;
  }
  
  public final void a(final RecyclerView paramRecyclerView, final RecyclerView.w paramw, final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49830);
    if (this.mzQ != null) {
      this.mzQ.cN(this.mxK);
    }
    final Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49824);
        if (k.this.mzP)
        {
          k localk = k.this;
          RecyclerView localRecyclerView = paramRecyclerView;
          Object localObject1 = k.this.mzO;
          int m = paramInt;
          ac.i("ItemInsertHelper", "alvinluo checkDuplicate position: %d", new Object[] { Integer.valueOf(m) });
          if (localObject1 != null)
          {
            if (localk.mzR != null)
            {
              int i = 0;
              for (int j = -1;; j = k)
              {
                k = j;
                if (i >= localk.mzN.size()) {
                  break;
                }
                Object localObject2 = localk.mzN.get(i);
                k = j;
                if (localk.mzR.C(localObject1, localObject2))
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
            if ((k != -1) && (k < localk.mzN.size()))
            {
              ac.i("ItemInsertHelper", "alvinluo checkDuplicate targetPosition: %d", new Object[] { Integer.valueOf(k) });
              localk.mzN.remove(k);
              localRecyclerView.getAdapter().cl(k);
            }
          }
        }
        if (k.this.mzQ != null) {
          k.this.mzQ.b(k.this.cUq, k.this.endPos, k.this.mzO, k.this.mzP);
        }
        paramRunnable.run();
        AppMethodBeat.o(49824);
      }
    };
    final RecyclerView.w localw;
    float f2;
    float f1;
    float f3;
    if ((paramw != null) && (this.mxK != null))
    {
      ac.i("ItemInsertHelper", "[finishMove] position:" + paramw.lv() + " dragViewPosition:" + paramInt);
      localw = paramRecyclerView.ci(paramInt);
      f2 = this.mxK.getTranslationX();
      f1 = this.mxK.getTranslationY();
      if (!this.mzP)
      {
        f2 = f(paramRecyclerView, paramw);
        f3 = this.mzR.bwh();
        f1 = Q(paramw) + this.mzR.bwi() + o(paramRecyclerView);
        f2 = f3 + f2;
      }
    }
    for (;;)
    {
      paramRunnable = this.mzR.cO(this.mxK);
      paramRecyclerView = paramRunnable;
      if (paramRunnable == null) {
        paramRecyclerView = this.mxK;
      }
      ac.i("ItemInsertHelper", "alvinluo finishMove transX: %f, transY: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
      this.mxK.findViewById(2131305201).setVisibility(4);
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.mxK.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49825);
          k.this.mqR.removeView(k.this.mxK);
          if (!k.this.mzP)
          {
            paramw.asD.setVisibility(0);
            local4.run();
            AppMethodBeat.o(49825);
            return;
          }
          if ((localw != null) && (localw.asD != null)) {
            localw.asD.setVisibility(0);
          }
          if (paramw != null)
          {
            paramw.asD.setVisibility(0);
            paramw.asD.setScaleX(0.0F);
            paramw.asD.setScaleY(0.0F);
            paramw.asD.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(300L).setListener(null).start();
          }
          local4.run();
          k.this.mxK.setScaleX(1.0F);
          k.this.mxK.setScaleY(1.0F);
          AppMethodBeat.o(49825);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      AppMethodBeat.o(49830);
      return;
      if ((localw == null) || (paramInt != localw.lv()))
      {
        if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).jW() > paramInt) {
          f1 -= paramRecyclerView.getHeight();
        } else {
          f1 = paramRecyclerView.getHeight() + f1;
        }
      }
      else if (this.mzP)
      {
        f2 = f(paramRecyclerView, localw);
        f3 = this.mzR.bwh();
        f1 = Q(localw);
        float f5 = this.mzR.bwi();
        float f4 = o(paramRecyclerView);
        f1 = f1 + f5 + f4;
        ac.i("ItemInsertHelper", "alvinluo finishMove computeMoveExtraY %f", new Object[] { Float.valueOf(f4) });
        f2 = f3 + f2;
        continue;
        ac.e("ItemInsertHelper", "alvinluo finishMove viewHolder is null");
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
    if (this.mzQ != null) {
      this.mzQ.a(paramw, paramView, this.mzO, paramInt);
    }
    AppMethodBeat.o(49831);
  }
  
  public final boolean a(final RecyclerView paramRecyclerView, T paramT1, T paramT2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(49829);
    ac.i("ItemInsertHelper", "alvinluo ItemInsertHelper onMoved isHasInserted: " + this.mzP + ", from: " + paramInt1 + ", to: " + paramInt2);
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(49829);
      return false;
    }
    if (!this.mzP)
    {
      this.mzN.add(paramInt2, this.mzO);
      paramRecyclerView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49821);
          paramRecyclerView.getAdapter().ck(paramInt2);
          AppMethodBeat.o(49821);
        }
      });
      this.mzP = true;
      if (this.mzR != null) {
        this.mzR.byN();
      }
    }
    for (;;)
    {
      this.endPos = paramInt2;
      if (this.mzR != null) {
        this.mzR.g(this.mzO, paramInt2);
      }
      AppMethodBeat.o(49829);
      return true;
      if ((paramInt1 < 0) || (paramInt1 >= this.mzN.size()) || (paramInt2 < 0) || (paramInt2 >= this.mzN.size()))
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
          Collections.swap(this.mzN, i, i + 1);
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
          Collections.swap(this.mzN, i, i - 1);
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
    this.mxK = i(paramRecyclerView, paramT);
    if (this.mxK != null)
    {
      FrameLayout localFrameLayout = this.mqR;
      paramRecyclerView = i(paramRecyclerView, paramT);
      this.mxK = paramRecyclerView;
      localFrameLayout.addView(paramRecyclerView);
      if ((paramT.lv() < 0) && (this.mxK != null))
      {
        this.mqR.removeView(this.mxK);
        this.mxK = null;
        AppMethodBeat.o(49827);
        return null;
      }
      this.mzP = false;
      if (paramT.lv() < this.mzM.size())
      {
        this.mzO = this.mzR.cA(this.mzM.get(paramT.lv()));
        this.cUq = paramT.lv();
        paramRecyclerView = this.mxK;
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
    int i = paramT.lv();
    ac.i("ItemInsertHelper", "[onDelete] position:".concat(String.valueOf(i)));
    if ((i >= 0) && (i < this.mzM.size())) {
      this.mzM.remove(i);
    }
    n(paramRecyclerView);
    if (this.mzQ != null)
    {
      if ((this.mzO instanceof AppBrandDesktopView.c)) {
        ((AppBrandDesktopView.c)this.mzO).position = paramT.lv();
      }
      this.mzQ.cz(this.mzO);
    }
    AppMethodBeat.o(49833);
  }
  
  public final void m(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49834);
    ac.i("ItemInsertHelper", "alvinluo onCancel");
    n(paramRecyclerView);
    AppMethodBeat.o(49834);
  }
  
  public static abstract interface a
    extends m
  {
    public abstract boolean C(Object paramObject1, Object paramObject2);
    
    public abstract void byN();
    
    public abstract void byO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.k
 * JD-Core Version:    0.7.0.1
 */