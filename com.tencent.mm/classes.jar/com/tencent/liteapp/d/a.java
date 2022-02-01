package com.tencent.liteapp.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class a
  extends FrameLayout
{
  private static final int VIEW_ID = 2131296930;
  private View crH;
  private int crI;
  private final int[] crJ;
  private c crK;
  private WeakHashMap<View, b> crL;
  private Runnable crM;
  private final Runnable crN;
  private final Set<a> crO;
  private View mContent;
  private boolean mInLayout;
  
  public a(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(197784);
    this.crI = -1;
    this.mInLayout = false;
    this.crJ = new int[2];
    this.crL = new WeakHashMap();
    this.crM = new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(197782);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(197782);
          return;
        }
        com.tencent.liteapp.b.b.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", new Object[] { a.a(a.this).getClass().getSimpleName() });
        while (i < a.this.getChildCount())
        {
          View localView = a.this.getChildAt(i);
          if ((localView != null) && (localView != a.b(a.this)) && (localView != a.a(a.this))) {
            a.bY(localView);
          }
          i += 1;
        }
        AppMethodBeat.o(197782);
      }
    };
    this.crN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197783);
        com.tencent.liteapp.b.b.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", new Object[] { Integer.valueOf(a.c(a.this).size()) });
        if (a.c(a.this).size() <= 0)
        {
          AppMethodBeat.o(197783);
          return;
        }
        a.a[] arrayOfa = new a.a[a.c(a.this).size()];
        a.c(a.this).toArray(arrayOfa);
        AppMethodBeat.o(197783);
      }
    };
    this.crO = new HashSet();
    super.setId(VIEW_ID);
    this.mContent = paramView;
    AppMethodBeat.o(197784);
  }
  
  public static b bX(View paramView)
  {
    AppMethodBeat.i(197795);
    paramView = (a)paramView.getRootView().findViewById(VIEW_ID);
    if (paramView == null)
    {
      AppMethodBeat.o(197795);
      return null;
    }
    if ((paramView.getOnLayoutListener() == null) || (!(paramView.getOnLayoutListener() instanceof b))) {
      paramView.setOnLayoutListener(new b());
    }
    paramView = (b)paramView.getOnLayoutListener();
    AppMethodBeat.o(197795);
    return paramView;
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(197788);
    if ((paramView == this.mContent) || (paramView == this.crH)) {
      super.addView(paramView);
    }
    AppMethodBeat.o(197788);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(197789);
    if ((paramView == this.mContent) || (paramView == this.crH)) {
      super.addView(paramView, paramInt);
    }
    AppMethodBeat.o(197789);
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197790);
    if ((paramView == this.mContent) || (paramView == this.crH)) {
      super.addView(paramView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(197790);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(197792);
    if ((paramView == this.mContent) || (paramView == this.crH)) {
      super.addView(paramView, paramInt, paramLayoutParams);
    }
    AppMethodBeat.o(197792);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(197791);
    if ((paramView == this.mContent) || (paramView == this.crH)) {
      super.addView(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(197791);
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
    AppMethodBeat.i(197787);
    b localb = (b)this.crL.get(this.crH);
    if ((localb != null) && (localb.crQ) && (this.crH != null) && (this.crH.isShown()) && (paramMotionEvent.getAction() == 0))
    {
      float f1 = paramMotionEvent.getRawY();
      this.crH.getLocationOnScreen(this.crJ);
      float f2 = this.crJ[1];
      float f3 = this.crH.getHeight();
      if ((f1 < f2) || (f1 > f3 + f2))
      {
        this.crH.setVisibility(8);
        AppMethodBeat.o(197787);
        return true;
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(197787);
    return bool;
  }
  
  public final View getCurrentBottomPanel()
  {
    return this.crH;
  }
  
  public final c getOnLayoutListener()
  {
    return this.crK;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(197794);
    this.mInLayout = true;
    if (u.az(this))
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
          if (localView != this.mContent)
          {
            localb = (b)this.crL.get(localView);
            i = j;
            i2 = n;
            i1 = k;
            if (localb != null)
            {
              i = j;
              if (j == 0)
              {
                i = j;
                if (localb.crR != 0)
                {
                  i = j;
                  if (localView.getVisibility() == 0)
                  {
                    this.crH = localView;
                    post(this.crM);
                    i = 1;
                  }
                }
              }
              if (localb.crR != 0) {
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
          localb.crR = localView.getVisibility();
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
        post(this.crN);
      }
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.crK != null) {
      this.crK.bZ(this);
    }
    this.mInLayout = false;
    AppMethodBeat.o(197794);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197786);
    if (this.crI > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.crI, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(197786);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(197793);
    super.onViewRemoved(paramView);
    this.crL.remove(paramView);
    AppMethodBeat.o(197793);
  }
  
  public final void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(197785);
    if (paramInt != this.crI) {}
    for (int i = 1;; i = 0)
    {
      this.crI = paramInt;
      if (i == 0) {
        break label59;
      }
      if (u.az(this)) {
        break;
      }
      AppMethodBeat.o(197785);
      return;
    }
    if (this.mInLayout)
    {
      AppMethodBeat.o(197785);
      return;
    }
    requestLayout();
    label59:
    AppMethodBeat.o(197785);
  }
  
  public final void setId(int paramInt) {}
  
  public final void setOnLayoutListener(c paramc)
  {
    this.crK = paramc;
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    boolean crQ;
    int crR = 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteapp.d.a
 * JD-Core Version:    0.7.0.1
 */