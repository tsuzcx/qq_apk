package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.List;

public final class d<T extends RecyclerView.v>
  extends b<T>
{
  int bNu = 0;
  FrameLayout cIL;
  int endPos = 0;
  View ooN;
  public com.tencent.mm.plugin.appbrand.widget.desktop.f ooV = null;
  Object opA;
  boolean opB;
  public a opC;
  a opD;
  private List opy;
  List opz;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public d(FrameLayout paramFrameLayout, List paramList1, List paramList2, a parama)
  {
    this.cIL = paramFrameLayout;
    this.opy = paramList1;
    this.opD = parama;
    this.opz = paramList2;
  }
  
  private View i(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49836);
    paramT.aus.setVisibility(4);
    paramRecyclerView = this.opC.Q(paramT);
    paramRecyclerView.setVisibility(0);
    AppMethodBeat.o(49836);
    return paramRecyclerView;
  }
  
  private void i(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49835);
    if (this.opB)
    {
      int i = this.opz.indexOf(this.opA);
      if (i >= 0)
      {
        this.opz.remove(i);
        paramRecyclerView.getAdapter().ck(i);
      }
      this.opB = false;
      if (this.opD != null) {
        this.opD.cap();
      }
    }
    AppMethodBeat.o(49835);
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(49826);
    if (this.opC != null)
    {
      boolean bool = this.opC.R(paramT);
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
  
  public final boolean S(T paramT)
  {
    AppMethodBeat.i(49832);
    if (this.opC != null)
    {
      boolean bool = this.opC.S(paramT);
      AppMethodBeat.o(49832);
      return bool;
    }
    AppMethodBeat.o(49832);
    return false;
  }
  
  public final boolean T(T paramT)
  {
    AppMethodBeat.i(49828);
    if (this.opC != null)
    {
      boolean bool = this.opC.c(paramT, this.opA);
      AppMethodBeat.o(49828);
      return bool;
    }
    AppMethodBeat.o(49828);
    return true;
  }
  
  public final void a(final RecyclerView paramRecyclerView, RecyclerView.v paramv, final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(49830);
    if (this.opC != null) {
      this.opC.cR(this.ooN);
    }
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49824);
        if (d.this.opB)
        {
          d locald = d.this;
          RecyclerView localRecyclerView = paramRecyclerView;
          Object localObject1 = d.this.opA;
          int m = paramInt;
          Log.i("ItemInsertHelper", "alvinluo checkDuplicate position: %d", new Object[] { Integer.valueOf(m) });
          if (localObject1 != null)
          {
            if (locald.opD != null)
            {
              int i = 0;
              for (int j = -1;; j = k)
              {
                k = j;
                if (i >= locald.opz.size()) {
                  break;
                }
                Object localObject2 = locald.opz.get(i);
                k = j;
                if (locald.opD.K(localObject1, localObject2))
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
            if ((k != -1) && (k < locald.opz.size()))
            {
              Log.i("ItemInsertHelper", "alvinluo checkDuplicate targetPosition: %d", new Object[] { Integer.valueOf(k) });
              locald.opz.remove(k);
              localRecyclerView.getAdapter().ck(k);
            }
          }
        }
        if (d.this.opC != null) {
          d.this.opC.b(d.this.bNu, d.this.endPos, d.this.opA, d.this.opB);
        }
        paramRunnable.run();
        AppMethodBeat.o(49824);
      }
    };
    RecyclerView.v localv;
    float f2;
    float f1;
    float f3;
    if ((paramv != null) && (this.ooN != null))
    {
      Log.i("ItemInsertHelper", "[finishMove] position:" + paramv.lR() + " dragViewPosition:" + paramInt);
      localv = paramRecyclerView.ch(paramInt);
      f2 = this.ooN.getTranslationX();
      f1 = this.ooN.getTranslationY();
      if (!this.opB)
      {
        f2 = f(paramRecyclerView, paramv);
        f3 = this.opD.cam();
        f1 = e(paramRecyclerView, paramv) + this.opD.can();
        f2 = f3 + f2;
      }
    }
    for (;;)
    {
      paramRunnable = this.opD.cQ(this.ooN);
      paramRecyclerView = paramRunnable;
      if (paramRunnable == null) {
        paramRecyclerView = this.ooN;
      }
      Log.i("ItemInsertHelper", "alvinluo finishMove transX: %f, transY: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
      this.ooN.findViewById(2131308398).setVisibility(4);
      paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
      this.ooN.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new d.5(this, paramv, local4, localv)).start();
      AppMethodBeat.o(49830);
      return;
      if ((localv == null) || (paramInt != localv.lR()))
      {
        if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).ks() > paramInt) {
          f1 -= paramRecyclerView.getHeight();
        } else {
          f1 = paramRecyclerView.getHeight() + f1;
        }
      }
      else if (this.opB)
      {
        f2 = f(paramRecyclerView, localv);
        f3 = this.opD.cam();
        f1 = e(paramRecyclerView, localv) + this.opD.can();
        f2 = f3 + f2;
        continue;
        Log.e("ItemInsertHelper", "alvinluo finishMove viewHolder is null");
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
    if (this.opC != null) {
      this.opC.a(paramv, paramView, this.opA, paramInt);
    }
    AppMethodBeat.o(49831);
  }
  
  public final boolean a(final RecyclerView paramRecyclerView, T paramT1, T paramT2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(49829);
    Log.i("ItemInsertHelper", "alvinluo ItemInsertHelper onMoved isHasInserted: " + this.opB + ", from: " + paramInt1 + ", to: " + paramInt2);
    if (paramInt2 < 0)
    {
      AppMethodBeat.o(49829);
      return false;
    }
    if (!this.opB)
    {
      this.opz.add(paramInt2, this.opA);
      paramRecyclerView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49821);
          paramRecyclerView.getAdapter().cj(paramInt2);
          AppMethodBeat.o(49821);
        }
      });
      this.opB = true;
      if (this.opD != null) {
        this.opD.cao();
      }
    }
    for (;;)
    {
      this.endPos = paramInt2;
      if (this.opD != null) {
        this.opD.i(this.opA, paramInt2);
      }
      AppMethodBeat.o(49829);
      return true;
      if ((paramInt1 < 0) || (paramInt1 >= this.opz.size()) || (paramInt2 < 0) || (paramInt2 >= this.opz.size()))
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
          Collections.swap(this.opz, i, i + 1);
          i += 1;
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49822);
              paramRecyclerView.getAdapter().ar(paramInt1, paramInt2);
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
          Collections.swap(this.opz, i, i - 1);
          i -= 1;
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49823);
              paramRecyclerView.getAdapter().ar(paramInt1, paramInt2);
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
    this.ooN = i(paramRecyclerView, paramT);
    if (this.ooN != null)
    {
      FrameLayout localFrameLayout = this.cIL;
      paramRecyclerView = i(paramRecyclerView, paramT);
      this.ooN = paramRecyclerView;
      localFrameLayout.addView(paramRecyclerView);
      if ((paramT.lR() < 0) && (this.ooN != null))
      {
        this.cIL.removeView(this.ooN);
        this.ooN = null;
        AppMethodBeat.o(49827);
        return null;
      }
      this.opB = false;
      if (paramT.lR() < this.opy.size())
      {
        this.opA = this.opD.cS(this.opy.get(paramT.lR()));
        this.bNu = paramT.lR();
        paramRecyclerView = this.ooN;
        AppMethodBeat.o(49827);
        return paramRecyclerView;
      }
    }
    AppMethodBeat.o(49827);
    return null;
  }
  
  public final void h(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(49834);
    Log.i("ItemInsertHelper", "alvinluo onCancel");
    i(paramRecyclerView);
    AppMethodBeat.o(49834);
  }
  
  public final void h(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(49833);
    int i = paramT.lR();
    Log.i("ItemInsertHelper", "[onDelete] position:".concat(String.valueOf(i)));
    if ((i >= 0) && (i < this.opy.size())) {
      this.opy.remove(i);
    }
    i(paramRecyclerView);
    if (this.opC != null)
    {
      if ((this.opA instanceof AppBrandDesktopView.c)) {
        ((AppBrandDesktopView.c)this.opA).position = paramT.lR();
      }
      this.opC.cT(this.opA);
    }
    AppMethodBeat.o(49833);
  }
  
  public static abstract interface a
    extends f
  {
    public abstract boolean K(Object paramObject1, Object paramObject2);
    
    public abstract void cao();
    
    public abstract void cap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.d
 * JD-Core Version:    0.7.0.1
 */