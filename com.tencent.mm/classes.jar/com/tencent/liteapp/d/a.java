package com.tencent.liteapp.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.core.g.z;
import com.tencent.liteapp.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public final class a
  extends FrameLayout
{
  private static final int ehD = a.d.app_brand_ui_root;
  private View bmR;
  private View ehE;
  private int ehF;
  private final int[] ehG;
  private d ehH;
  private WeakHashMap<View, b> ehI;
  private Runnable ehJ;
  private final Runnable ehK;
  private final Set<a> ehL;
  private boolean mInLayout;
  
  public a(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(219063);
    this.ehF = -1;
    this.mInLayout = false;
    this.ehG = new int[2];
    this.ehI = new WeakHashMap();
    this.ehJ = new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(219061);
        if (a.a(a.this) == null)
        {
          AppMethodBeat.o(219061);
          return;
        }
        com.tencent.liteapp.b.b.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", new Object[] { a.a(a.this).getClass().getSimpleName() });
        while (i < a.this.getChildCount())
        {
          View localView = a.this.getChildAt(i);
          if ((localView != null) && (localView != a.b(a.this)) && (localView != a.a(a.this))) {
            a.cM(localView);
          }
          i += 1;
        }
        AppMethodBeat.o(219061);
      }
    };
    this.ehK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219059);
        com.tencent.liteapp.b.b.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", new Object[] { Integer.valueOf(a.c(a.this).size()) });
        if (a.c(a.this).size() <= 0)
        {
          AppMethodBeat.o(219059);
          return;
        }
        a.a[] arrayOfa = new a.a[a.c(a.this).size()];
        a.c(a.this).toArray(arrayOfa);
        AppMethodBeat.o(219059);
      }
    };
    this.ehL = new HashSet();
    super.setId(ehD);
    this.bmR = paramView;
    AppMethodBeat.o(219063);
  }
  
  public static b cL(View paramView)
  {
    AppMethodBeat.i(219067);
    paramView = (a)paramView.getRootView().findViewById(ehD);
    if (paramView == null)
    {
      AppMethodBeat.o(219067);
      return null;
    }
    if ((paramView.getOnLayoutListener() == null) || (!(paramView.getOnLayoutListener() instanceof b))) {
      paramView.setOnLayoutListener(new b());
    }
    paramView = (b)paramView.getOnLayoutListener();
    AppMethodBeat.o(219067);
    return paramView;
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(219138);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
      super.addView(paramView);
    }
    AppMethodBeat.o(219138);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(219143);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
      super.addView(paramView, paramInt);
    }
    AppMethodBeat.o(219143);
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219152);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
      super.addView(paramView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(219152);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(219165);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
      super.addView(paramView, paramInt, paramLayoutParams);
    }
    AppMethodBeat.o(219165);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(219160);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
      super.addView(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(219160);
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
    AppMethodBeat.i(219124);
    b localb = (b)this.ehI.get(this.ehE);
    if ((localb != null) && (localb.ehN) && (this.ehE != null) && (this.ehE.isShown()) && (paramMotionEvent.getAction() == 0))
    {
      float f1 = paramMotionEvent.getRawY();
      this.ehE.getLocationOnScreen(this.ehG);
      float f2 = this.ehG[1];
      float f3 = this.ehE.getHeight();
      if ((f1 < f2) || (f1 > f3 + f2))
      {
        this.ehE.setVisibility(8);
        AppMethodBeat.o(219124);
        return true;
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(219124);
    return bool;
  }
  
  public final View getCurrentBottomPanel()
  {
    return this.ehE;
  }
  
  public final d getOnLayoutListener()
  {
    return this.ehH;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(219189);
    this.mInLayout = true;
    if (z.au(this))
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
          if (localView != this.bmR)
          {
            localb = (b)this.ehI.get(localView);
            i = j;
            i2 = n;
            i1 = k;
            if (localb != null)
            {
              i = j;
              if (j == 0)
              {
                i = j;
                if (localb.ehO != 0)
                {
                  i = j;
                  if (localView.getVisibility() == 0)
                  {
                    this.ehE = localView;
                    post(this.ehJ);
                    i = 1;
                  }
                }
              }
              if (localb.ehO != 0) {
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
          localb.ehO = localView.getVisibility();
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
        post(this.ehK);
      }
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ehH != null) {
      this.ehH.cN(this);
    }
    this.mInLayout = false;
    AppMethodBeat.o(219189);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219114);
    if (this.ehF > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.ehF, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(219114);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(219173);
    super.onViewRemoved(paramView);
    this.ehI.remove(paramView);
    AppMethodBeat.o(219173);
  }
  
  public final void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(219107);
    if (paramInt != this.ehF) {}
    for (int i = 1;; i = 0)
    {
      this.ehF = paramInt;
      if (i == 0) {
        break label59;
      }
      if (z.au(this)) {
        break;
      }
      AppMethodBeat.o(219107);
      return;
    }
    if (this.mInLayout)
    {
      AppMethodBeat.o(219107);
      return;
    }
    requestLayout();
    label59:
    AppMethodBeat.o(219107);
  }
  
  public final void setId(int paramInt) {}
  
  public final void setOnLayoutListener(d paramd)
  {
    this.ehH = paramd;
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    boolean ehN;
    int ehO = 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteapp.d.a
 * JD-Core Version:    0.7.0.1
 */