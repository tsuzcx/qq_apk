package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.t;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class n
  extends FrameLayout
{
  private static final int VIEW_ID = 2131296838;
  private int lzd;
  private View mContent;
  private View mDM;
  private final int[] mDN;
  private a mDO;
  private WeakHashMap<View, b> mDP;
  private Runnable mDQ;
  private final Runnable mDR;
  private final Set<a> mDS;
  private boolean mInLayout;
  
  public n(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(137948);
    this.lzd = -1;
    this.mInLayout = false;
    this.mDN = new int[2];
    this.mDP = new WeakHashMap();
    this.mDQ = new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(137943);
        if (n.a(n.this) == null)
        {
          AppMethodBeat.o(137943);
          return;
        }
        ac.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", new Object[] { n.a(n.this).getClass().getSimpleName() });
        while (i < n.this.getChildCount())
        {
          View localView = n.this.getChildAt(i);
          if ((localView != null) && (localView != n.b(n.this)) && (localView != n.a(n.this))) {
            n.de(localView);
          }
          i += 1;
        }
        AppMethodBeat.o(137943);
      }
    };
    this.mDR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137944);
        ac.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", new Object[] { Integer.valueOf(n.c(n.this).size()) });
        if (n.c(n.this).size() <= 0)
        {
          AppMethodBeat.o(137944);
          return;
        }
        n.a[] arrayOfa = new n.a[n.c(n.this).size()];
        n.c(n.this).toArray(arrayOfa);
        AppMethodBeat.o(137944);
      }
    };
    this.mDS = new HashSet();
    super.setId(VIEW_ID);
    this.mContent = paramView;
    AppMethodBeat.o(137948);
  }
  
  public static n H(Activity paramActivity)
  {
    AppMethodBeat.i(137946);
    paramActivity = (n)paramActivity.findViewById(VIEW_ID);
    AppMethodBeat.o(137946);
    return paramActivity;
  }
  
  public static void I(Activity paramActivity)
  {
    AppMethodBeat.i(137947);
    paramActivity = H(paramActivity);
    if (paramActivity != null) {
      paramActivity.bAl();
    }
    AppMethodBeat.o(137947);
  }
  
  public static n db(View paramView)
  {
    AppMethodBeat.i(137945);
    paramView = (n)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(137945);
    return paramView;
  }
  
  public static u dd(View paramView)
  {
    AppMethodBeat.i(137962);
    paramView = db(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(137962);
      return null;
    }
    if ((paramView.getOnLayoutListener() == null) || (!(paramView.getOnLayoutListener() instanceof u))) {
      paramView.setOnLayoutListener(new u());
    }
    paramView = (u)paramView.getOnLayoutListener();
    AppMethodBeat.o(137962);
    return paramView;
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(137953);
    if ((paramView == this.mContent) || (paramView == this.mDM)) {
      super.addView(paramView);
    }
    AppMethodBeat.o(137953);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(137954);
    if ((paramView == this.mContent) || (paramView == this.mDM)) {
      super.addView(paramView, paramInt);
    }
    AppMethodBeat.o(137954);
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137955);
    if ((paramView == this.mContent) || (paramView == this.mDM)) {
      super.addView(paramView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137955);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137957);
    if ((paramView == this.mContent) || (paramView == this.mDM)) {
      super.addView(paramView, paramInt, paramLayoutParams);
    }
    AppMethodBeat.o(137957);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137956);
    if ((paramView == this.mContent) || (paramView == this.mDM)) {
      super.addView(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(137956);
  }
  
  protected final boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    return false;
  }
  
  protected final boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return false;
  }
  
  public final void bAl()
  {
    AppMethodBeat.i(206842);
    if (this.mDM != null)
    {
      this.mDM.setVisibility(8);
      this.mDM = null;
    }
    AppMethodBeat.o(206842);
  }
  
  public final boolean d(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(183769);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.mDM != null) && (this.mDM.isShown()))
      {
        this.mDM.setVisibility(8);
        AppMethodBeat.o(183769);
        return true;
      }
      if (f.aC(getContext()))
      {
        AppMethodBeat.o(183769);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(183769);
    return bool;
  }
  
  public final void dc(View paramView)
  {
    AppMethodBeat.i(137960);
    n(paramView, false);
    AppMethodBeat.o(137960);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137952);
    b localb = (b)this.mDP.get(this.mDM);
    if ((localb != null) && (localb.mDU) && (this.mDM != null) && (this.mDM.isShown()) && (paramMotionEvent.getAction() == 0))
    {
      float f1 = paramMotionEvent.getRawY();
      this.mDM.getLocationOnScreen(this.mDN);
      float f2 = this.mDN[1];
      float f3 = this.mDM.getHeight();
      if ((f1 < f2) || (f1 > f3 + f2))
      {
        this.mDM.setVisibility(8);
        AppMethodBeat.o(137952);
        return true;
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(137952);
    return bool;
  }
  
  public final View getCurrentBottomPanel()
  {
    return this.mDM;
  }
  
  public final a getOnLayoutListener()
  {
    return this.mDO;
  }
  
  public final void n(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(137959);
    if (this.mDM != null)
    {
      this.mDM.setVisibility(8);
      this.mDM = null;
    }
    if (this != paramView.getParent())
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.mDM = paramView;
      Object localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      super.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new b((byte)0);
      ((b)localObject).mDU = paramBoolean;
      this.mDP.put(paramView, localObject);
    }
    AppMethodBeat.o(137959);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(137961);
    this.mInLayout = true;
    if (t.ay(this))
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
            localb = (b)this.mDP.get(localView);
            i = j;
            i2 = n;
            i1 = k;
            if (localb != null)
            {
              i = j;
              if (j == 0)
              {
                i = j;
                if (localb.mDV != 0)
                {
                  i = j;
                  if (localView.getVisibility() == 0)
                  {
                    this.mDM = localView;
                    post(this.mDQ);
                    i = 1;
                  }
                }
              }
              if (localb.mDV != 0) {
                break label234;
              }
              j = 1;
              label178:
              if (localView.getVisibility() == 0) {
                break label240;
              }
            }
          }
        }
        label234:
        label240:
        for (i1 = 1;; i1 = 0)
        {
          i2 = n & i1;
          localb.mDV = localView.getVisibility();
          i1 = j | k;
          m += 1;
          j = i;
          n = i2;
          k = i1;
          break;
          j = 0;
          break label178;
        }
      }
      if ((j != 0) || ((k != 0) && (n != 0))) {
        post(this.mDR);
      }
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mDO != null) {
      this.mDO.df(this);
    }
    this.mInLayout = false;
    AppMethodBeat.o(137961);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137950);
    if (this.lzd > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.lzd, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(137950);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(137958);
    super.onViewRemoved(paramView);
    this.mDP.remove(paramView);
    AppMethodBeat.o(137958);
  }
  
  public final void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(137949);
    if (paramInt != this.lzd) {}
    for (int i = 1;; i = 0)
    {
      this.lzd = paramInt;
      if (i == 0) {
        break label62;
      }
      if (t.ay(this)) {
        break;
      }
      AppMethodBeat.o(137949);
      return;
    }
    if (this.mInLayout)
    {
      AppMethodBeat.o(137949);
      return;
    }
    requestLayout();
    label62:
    AppMethodBeat.o(137949);
  }
  
  public final void setId(int paramInt) {}
  
  public final void setOnLayoutListener(a parama)
  {
    this.mDO = parama;
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    boolean mDU;
    int mDV = 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.n
 * JD-Core Version:    0.7.0.1
 */