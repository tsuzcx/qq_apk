package com.tencent.liteapp.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.core.g.w;
import com.tencent.liteapp.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class a
  extends FrameLayout
{
  private static final int cpM = a.d.app_brand_ui_root;
  private View GR;
  private View cpN;
  private int cpO;
  private final int[] cpP;
  private c cpQ;
  private WeakHashMap<View, b> cpR;
  private Runnable cpS;
  private final Runnable cpT;
  private final Set<a> cpU;
  private boolean mInLayout;
  
  public a(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(258793);
    this.cpO = -1;
    this.mInLayout = false;
    this.cpP = new int[2];
    this.cpR = new WeakHashMap();
    this.cpS = new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(258785);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(258785);
          return;
        }
        com.tencent.liteapp.b.b.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", new Object[] { a.a(a.this).getClass().getSimpleName() });
        while (i < a.this.getChildCount())
        {
          View localView = a.this.getChildAt(i);
          if ((localView != null) && (localView != a.b(a.this)) && (localView != a.a(a.this))) {
            a.cq(localView);
          }
          i += 1;
        }
        AppMethodBeat.o(258785);
      }
    };
    this.cpT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258786);
        com.tencent.liteapp.b.b.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", new Object[] { Integer.valueOf(a.c(a.this).size()) });
        if (a.c(a.this).size() <= 0)
        {
          AppMethodBeat.o(258786);
          return;
        }
        a.a[] arrayOfa = new a.a[a.c(a.this).size()];
        a.c(a.this).toArray(arrayOfa);
        AppMethodBeat.o(258786);
      }
    };
    this.cpU = new HashSet();
    super.setId(cpM);
    this.GR = paramView;
    AppMethodBeat.o(258793);
  }
  
  public static b cp(View paramView)
  {
    AppMethodBeat.i(258813);
    paramView = (a)paramView.getRootView().findViewById(cpM);
    if (paramView == null)
    {
      AppMethodBeat.o(258813);
      return null;
    }
    if ((paramView.getOnLayoutListener() == null) || (!(paramView.getOnLayoutListener() instanceof b))) {
      paramView.setOnLayoutListener(new b());
    }
    paramView = (b)paramView.getOnLayoutListener();
    AppMethodBeat.o(258813);
    return paramView;
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(258801);
    if ((paramView == this.GR) || (paramView == this.cpN)) {
      super.addView(paramView);
    }
    AppMethodBeat.o(258801);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(258802);
    if ((paramView == this.GR) || (paramView == this.cpN)) {
      super.addView(paramView, paramInt);
    }
    AppMethodBeat.o(258802);
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258804);
    if ((paramView == this.GR) || (paramView == this.cpN)) {
      super.addView(paramView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(258804);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(258808);
    if ((paramView == this.GR) || (paramView == this.cpN)) {
      super.addView(paramView, paramInt, paramLayoutParams);
    }
    AppMethodBeat.o(258808);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(258805);
    if ((paramView == this.GR) || (paramView == this.cpN)) {
      super.addView(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(258805);
  }
  
  protected final boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    return false;
  }
  
  protected final boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(258800);
    b localb = (b)this.cpR.get(this.cpN);
    if ((localb != null) && (localb.cpW) && (this.cpN != null) && (this.cpN.isShown()) && (paramMotionEvent.getAction() == 0))
    {
      float f1 = paramMotionEvent.getRawY();
      this.cpN.getLocationOnScreen(this.cpP);
      float f2 = this.cpP[1];
      float f3 = this.cpN.getHeight();
      if ((f1 < f2) || (f1 > f3 + f2))
      {
        this.cpN.setVisibility(8);
        AppMethodBeat.o(258800);
        return true;
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(258800);
    return bool;
  }
  
  public final View getCurrentBottomPanel()
  {
    return this.cpN;
  }
  
  public final c getOnLayoutListener()
  {
    return this.cpQ;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(258810);
    this.mInLayout = true;
    if (w.ah(this))
    {
      int m = 0;
      int j = 0;
      int n = 1;
      int k = 0;
      if (m < getChildCount())
      {
        View localView = getChildAt(m);
        int i = j;
        int i2 = n;
        int i1 = k;
        b localb;
        if (localView != null)
        {
          i = j;
          i2 = n;
          i1 = k;
          if (localView != this.GR)
          {
            localb = (b)this.cpR.get(localView);
            i = j;
            i2 = n;
            i1 = k;
            if (localb != null)
            {
              i = j;
              if (j == 0)
              {
                i = j;
                if (localb.cpX != 0)
                {
                  i = j;
                  if (localView.getVisibility() == 0)
                  {
                    this.cpN = localView;
                    post(this.cpS);
                    i = 1;
                  }
                }
              }
              if (localb.cpX != 0) {
                break label233;
              }
              j = 1;
              label177:
              if (localView.getVisibility() == 0) {
                break label239;
              }
            }
          }
        }
        label233:
        label239:
        for (i1 = 1;; i1 = 0)
        {
          i2 = n & i1;
          localb.cpX = localView.getVisibility();
          i1 = j | k;
          m += 1;
          j = i;
          n = i2;
          k = i1;
          break;
          j = 0;
          break label177;
        }
      }
      if ((j != 0) || ((k != 0) && (n != 0))) {
        post(this.cpT);
      }
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.cpQ != null) {
      this.cpQ.cr(this);
    }
    this.mInLayout = false;
    AppMethodBeat.o(258810);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258798);
    if (this.cpO > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.cpO, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(258798);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(258809);
    super.onViewRemoved(paramView);
    this.cpR.remove(paramView);
    AppMethodBeat.o(258809);
  }
  
  public final void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(258795);
    if (paramInt != this.cpO) {}
    for (int i = 1;; i = 0)
    {
      this.cpO = paramInt;
      if (i == 0) {
        break label59;
      }
      if (w.ah(this)) {
        break;
      }
      AppMethodBeat.o(258795);
      return;
    }
    if (this.mInLayout)
    {
      AppMethodBeat.o(258795);
      return;
    }
    requestLayout();
    label59:
    AppMethodBeat.o(258795);
  }
  
  public final void setId(int paramInt) {}
  
  public final void setOnLayoutListener(c paramc)
  {
    this.cpQ = paramc;
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    boolean cpW;
    int cpX = 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteapp.d.a
 * JD-Core Version:    0.7.0.1
 */