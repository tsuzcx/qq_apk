package com.tencent.mm.plugin.appbrand.widget.desktop.a;

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
import com.tencent.mm.plugin.appbrand.widget.desktop.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.List;

public final class d<T extends RecyclerView.v>
  extends b<T>
{
  int chT = 0;
  int endPos = 0;
  View jfC;
  public g jfK = null;
  FrameLayout jis;
  private List jit;
  List jiu;
  Object jiv;
  boolean jiw;
  public a jix;
  d.a jiy;
  public int paddingLeft = 0;
  public int paddingTop = 0;
  
  public d(FrameLayout paramFrameLayout, List paramList1, List paramList2, d.a parama)
  {
    this.jis = paramFrameLayout;
    this.jit = paramList1;
    this.jiy = parama;
    this.jiu = paramList2;
  }
  
  private View f(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(134225);
    paramT.aku.setVisibility(4);
    paramRecyclerView = this.jix.b(paramRecyclerView, paramT);
    paramRecyclerView.setVisibility(0);
    AppMethodBeat.o(134225);
    return paramRecyclerView;
  }
  
  private void n(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(134224);
    if (this.jiw)
    {
      int i = this.jiu.indexOf(this.jiv);
      if (i >= 0)
      {
        this.jiu.remove(i);
        paramRecyclerView.getAdapter().bT(i);
      }
      this.jiw = false;
      if (this.jiy != null) {
        this.jiy.aPp();
      }
    }
    AppMethodBeat.o(134224);
  }
  
  public final boolean O(T paramT)
  {
    AppMethodBeat.i(134215);
    if (this.jix != null)
    {
      boolean bool = this.jix.O(paramT);
      AppMethodBeat.o(134215);
      return bool;
    }
    if (paramT == null)
    {
      AppMethodBeat.o(134215);
      return false;
    }
    AppMethodBeat.o(134215);
    return true;
  }
  
  public final boolean P(T paramT)
  {
    AppMethodBeat.i(134221);
    if (this.jix != null)
    {
      boolean bool = this.jix.P(paramT);
      AppMethodBeat.o(134221);
      return bool;
    }
    AppMethodBeat.o(134221);
    return false;
  }
  
  public final boolean R(T paramT)
  {
    AppMethodBeat.i(134217);
    if (this.jix != null)
    {
      boolean bool = this.jix.a(paramT, this.jiv);
      AppMethodBeat.o(134217);
      return bool;
    }
    AppMethodBeat.o(134217);
    return true;
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.v paramv, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(134219);
    if (this.jix != null) {
      this.jix.cz(this.jfC);
    }
    d.4 local4 = new d.4(this, paramRecyclerView, paramInt, paramRunnable);
    if ((paramv != null) && (this.jfC != null))
    {
      ab.i("ItemInsertHelper", "[finishMove] position:" + paramv.jN() + " dragViewPosition:" + paramInt);
      RecyclerView.v localv = paramRecyclerView.bQ(paramInt);
      float f2 = this.jfC.getTranslationX();
      float f1 = this.jfC.getTranslationY();
      float f3;
      if (!this.jiw)
      {
        f2 = c(paramRecyclerView, paramv);
        f3 = this.jiy.aMW();
        f1 = Q(paramv) + this.jiy.aMX();
        f2 = f3 + f2;
      }
      for (;;)
      {
        paramRunnable = this.jiy.cA(this.jfC);
        paramRecyclerView = paramRunnable;
        if (paramRunnable == null) {
          paramRecyclerView = this.jfC;
        }
        ab.i("ItemInsertHelper", "alvinluo finishMove transX: %f, transY: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
        this.jfC.findViewById(2131823387).setVisibility(4);
        paramRecyclerView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener(null).start();
        this.jfC.animate().translationX(f2).translationY(f1).setDuration(300L).setListener(new d.5(this, paramv, local4, localv)).start();
        AppMethodBeat.o(134219);
        return;
        if ((localv != null) && (paramInt == localv.jN())) {
          break;
        }
        if (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).it() > paramInt) {
          f1 -= paramRecyclerView.getHeight();
        } else {
          f1 = paramRecyclerView.getHeight() + f1;
        }
      }
      float f4;
      if (this.jiw)
      {
        f2 = c(paramRecyclerView, localv) + this.jiy.aMW();
        f3 = Q(localv);
        f4 = this.jiy.aMX();
        if (this.jfK != null) {
          break label441;
        }
        f1 = 0.0F;
      }
      for (;;)
      {
        f3 = f4 + f3 + f1;
        ab.i("ItemInsertHelper", "alvinluo finishMove computeMoveExtraY %f", new Object[] { Float.valueOf(f1) });
        f1 = f3;
        break;
        label441:
        paramInt = this.jfK.computeVerticalScrollOffset();
        int i = paramRecyclerView.computeVerticalScrollExtent();
        int j = this.jfK.computeVerticalScrollRange();
        int k = j - paramRecyclerView.getMeasuredHeight() - paramInt;
        ab.i("ItemInsertHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramRecyclerView.getMeasuredHeight()), Integer.valueOf((int)(paramRecyclerView.getResources().getDimension(2131428643) * 1.0F)), Integer.valueOf(k) });
        if (k > paramRecyclerView.getResources().getDimension(2131428643) * 1.0F) {
          f1 = 0.0F;
        } else {
          f1 = paramRecyclerView.getResources().getDimension(2131428643) * 1.0F - k;
        }
      }
    }
    ab.e("ItemInsertHelper", "alvinluo finishMove viewHolder is null");
    AppMethodBeat.o(134219);
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(134220);
    if (paramView == null)
    {
      AppMethodBeat.o(134220);
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() - paramFloat1);
    paramView.setTranslationY(paramView.getTranslationY() - paramFloat2);
    if (this.jix != null) {
      this.jix.a(paramv, paramView, this.jiv, paramInt);
    }
    AppMethodBeat.o(134220);
  }
  
  public final boolean a(final RecyclerView paramRecyclerView, T paramT1, T paramT2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(134218);
    ab.i("ItemInsertHelper", "alvinluo ItemInsertHelper onMoved isHasInserted: " + this.jiw + ", from: " + paramInt1 + ", to: " + paramInt2);
    if (!this.jiw)
    {
      this.jiu.add(paramInt2, this.jiv);
      paramRecyclerView.post(new d.1(this, paramRecyclerView, paramInt2));
      this.jiw = true;
      if (this.jiy != null) {
        this.jiy.aPo();
      }
    }
    for (;;)
    {
      this.endPos = paramInt2;
      if (this.jiy != null) {
        this.jiy.e(this.jiv, paramInt2);
      }
      AppMethodBeat.o(134218);
      return true;
      int i;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1;
        while (i < paramInt2)
        {
          Collections.swap(this.jiu, i, i + 1);
          i += 1;
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(134211);
              paramRecyclerView.getAdapter().ao(paramInt1, paramInt2);
              AppMethodBeat.o(134211);
            }
          });
        }
      }
      else if (paramInt1 > paramInt2)
      {
        i = paramInt1;
        while (i > paramInt2)
        {
          Collections.swap(this.jiu, i, i - 1);
          i -= 1;
        }
        if (paramRecyclerView != null) {
          paramRecyclerView.post(new d.3(this, paramRecyclerView, paramInt1, paramInt2));
        }
      }
    }
  }
  
  public final View d(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(134216);
    this.jfC = f(paramRecyclerView, paramT);
    if (this.jfC != null)
    {
      FrameLayout localFrameLayout = this.jis;
      paramRecyclerView = f(paramRecyclerView, paramT);
      this.jfC = paramRecyclerView;
      localFrameLayout.addView(paramRecyclerView);
      if ((paramT.jN() < 0) && (this.jfC != null))
      {
        this.jis.removeView(this.jfC);
        this.jfC = null;
        AppMethodBeat.o(134216);
        return null;
      }
      this.jiw = false;
      if (paramT.jN() < this.jit.size())
      {
        this.jiv = this.jiy.bo(this.jit.get(paramT.jN()));
        this.chT = paramT.jN();
        paramRecyclerView = this.jfC;
        AppMethodBeat.o(134216);
        return paramRecyclerView;
      }
    }
    AppMethodBeat.o(134216);
    return null;
  }
  
  public final void e(RecyclerView paramRecyclerView, T paramT)
  {
    AppMethodBeat.i(134222);
    int i = paramT.jN();
    ab.i("ItemInsertHelper", "[onDelete] position:".concat(String.valueOf(i)));
    if ((i >= 0) && (i < this.jit.size())) {
      this.jit.remove(i);
    }
    n(paramRecyclerView);
    if (this.jix != null)
    {
      if ((this.jiv instanceof AppBrandDesktopView.c)) {
        ((AppBrandDesktopView.c)this.jiv).position = paramT.jN();
      }
      this.jix.bn(this.jiv);
    }
    AppMethodBeat.o(134222);
  }
  
  public final void m(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(134223);
    ab.i("ItemInsertHelper", "alvinluo onCancel");
    n(paramRecyclerView);
    AppMethodBeat.o(134223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.d
 * JD-Core Version:    0.7.0.1
 */