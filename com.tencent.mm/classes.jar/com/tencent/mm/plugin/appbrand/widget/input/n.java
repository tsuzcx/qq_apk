package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.g.z;
import androidx.fragment.app.FragmentActivity;
import com.tencent.luggage.b.a.a.e;
import com.tencent.luggage.l.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

public final class n
  extends FrameLayout
{
  private static final int ehD = a.e.app_brand_ui_root;
  private View bmR;
  private View ehE;
  private int ehF;
  private final int[] ehG;
  private WeakHashMap<View, b> ehI;
  private Runnable ehJ;
  private final Runnable ehK;
  private final Set<a> ehL;
  private boolean mInLayout;
  private ap uGx;
  private a uGy;
  
  public n(Context paramContext, View paramView)
  {
    super(paramContext.getApplicationContext());
    AppMethodBeat.i(137948);
    this.ehF = -1;
    this.mInLayout = false;
    this.ehG = new int[2];
    this.ehI = new WeakHashMap();
    this.ehJ = new Runnable()
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
        Log.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", new Object[] { n.a(n.this).getClass().getSimpleName() });
        while (i < n.this.getChildCount())
        {
          View localView = n.this.getChildAt(i);
          if ((localView != null) && (localView != n.b(n.this)) && (localView != n.a(n.this))) {
            n.eg(localView);
          }
          i += 1;
        }
        AppMethodBeat.o(137943);
      }
    };
    this.ehK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137944);
        Log.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", new Object[] { Integer.valueOf(n.c(n.this).size()) });
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
    this.ehL = new HashSet();
    super.setId(ehD);
    this.bmR = paramView;
    paramContext = AndroidContextUtil.castActivityOrNull(paramContext);
    if ((paramContext instanceof FragmentActivity)) {
      this.uGx = new ap(paramContext);
    }
    AppMethodBeat.o(137948);
  }
  
  public static n Q(Activity paramActivity)
  {
    AppMethodBeat.i(137946);
    paramActivity = (n)paramActivity.findViewById(ehD);
    AppMethodBeat.o(137946);
    return paramActivity;
  }
  
  public static void R(Activity paramActivity)
  {
    AppMethodBeat.i(137947);
    paramActivity = Q(paramActivity);
    if (paramActivity != null) {
      paramActivity.cRg();
    }
    AppMethodBeat.o(137947);
  }
  
  public static n ed(View paramView)
  {
    AppMethodBeat.i(137945);
    paramView = (n)paramView.getRootView().findViewById(ehD);
    AppMethodBeat.o(137945);
    return paramView;
  }
  
  public static u ef(View paramView)
  {
    AppMethodBeat.i(137962);
    paramView = ed(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(137962);
      return null;
    }
    if ((paramView.getOnLayoutListener() == null) || (!(paramView.getOnLayoutListener() instanceof u)))
    {
      u localu = new u();
      paramView.setOnLayoutListener(localu);
      if (paramView.uGx != null)
      {
        ap localap = paramView.uGx;
        localu.uGZ = localap;
        localap.uJd = new u.3(localu);
      }
    }
    paramView = (u)paramView.getOnLayoutListener();
    AppMethodBeat.o(137962);
    return paramView;
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(137953);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
      super.addView(paramView);
    }
    AppMethodBeat.o(137953);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(137954);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
      super.addView(paramView, paramInt);
    }
    AppMethodBeat.o(137954);
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137955);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
      super.addView(paramView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137955);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137957);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
      super.addView(paramView, paramInt, paramLayoutParams);
    }
    AppMethodBeat.o(137957);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137956);
    if ((paramView == this.bmR) || (paramView == this.ehE)) {
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
  
  public final void cRg()
  {
    AppMethodBeat.i(324561);
    if (this.ehE != null)
    {
      this.ehE.setVisibility(8);
      this.ehE = null;
    }
    AppMethodBeat.o(324561);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137952);
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
        AppMethodBeat.o(137952);
        return true;
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(137952);
    return bool;
  }
  
  public final void ee(View paramView)
  {
    AppMethodBeat.i(137960);
    n(paramView, false);
    AppMethodBeat.o(137960);
  }
  
  public final View getCurrentBottomPanel()
  {
    return this.ehE;
  }
  
  public final a getOnLayoutListener()
  {
    return this.uGy;
  }
  
  public final boolean j(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(183769);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.ehE != null) && (this.ehE.isShown()))
      {
        this.ehE.setVisibility(8);
        AppMethodBeat.o(183769);
        return true;
      }
      if (f.bv(getContext()))
      {
        AppMethodBeat.o(183769);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(183769);
    return bool;
  }
  
  public final void n(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(137959);
    if (this.ehE != null)
    {
      this.ehE.setVisibility(8);
      this.ehE = null;
    }
    if (this != paramView.getParent())
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.ehE = paramView;
      Object localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      super.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new b((byte)0);
      ((b)localObject).ehN = paramBoolean;
      this.ehI.put(paramView, localObject);
    }
    AppMethodBeat.o(137959);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(324576);
    super.onDetachedFromWindow();
    if (this.uGy != null) {
      this.uGy.onDestroy();
    }
    this.uGy = null;
    removeAllViews();
    AppMethodBeat.o(324576);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(137961);
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
          localb.ehO = localView.getVisibility();
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
        post(this.ehK);
      }
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.uGy != null) {
      this.uGy.cN(this);
    }
    this.mInLayout = false;
    AppMethodBeat.o(137961);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137950);
    if (this.ehF > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.ehF, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(137950);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(137958);
    super.onViewRemoved(paramView);
    this.ehI.remove(paramView);
    AppMethodBeat.o(137958);
  }
  
  public final void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(137949);
    if (paramInt != this.ehF) {}
    for (int i = 1;; i = 0)
    {
      this.ehF = paramInt;
      if (i == 0) {
        break label62;
      }
      if (z.au(this)) {
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
    this.uGy = parama;
  }
  
  public static abstract interface a {}
  
  static final class b
  {
    boolean ehN;
    int ehO = 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.n
 * JD-Core Version:    0.7.0.1
 */