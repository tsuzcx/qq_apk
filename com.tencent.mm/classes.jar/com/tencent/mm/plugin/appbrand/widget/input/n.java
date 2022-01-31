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
import com.tencent.luggage.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class n
  extends FrameLayout
{
  private static final int VIEW_ID = 2131820573;
  private View jlX;
  private int jlY;
  private final int[] jlZ;
  private a jma;
  private WeakHashMap<View, n.b> jmb;
  private Runnable jmc;
  private final Runnable jmd;
  private final Set<n.a> jme;
  private View mContent;
  private boolean mInLayout;
  
  public n(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(126668);
    this.jlY = -1;
    this.mInLayout = false;
    this.jlZ = new int[2];
    this.jmb = new WeakHashMap();
    this.jmc = new n.1(this);
    this.jmd = new n.2(this);
    this.jme = new HashSet();
    super.setId(VIEW_ID);
    this.mContent = paramView;
    super.addView(paramView);
    AppMethodBeat.o(126668);
  }
  
  public static n cJ(View paramView)
  {
    AppMethodBeat.i(126665);
    paramView = (n)paramView.getRootView().findViewById(VIEW_ID);
    AppMethodBeat.o(126665);
    return paramView;
  }
  
  public static u cL(View paramView)
  {
    AppMethodBeat.i(126681);
    paramView = cJ(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(126681);
      return null;
    }
    if ((paramView.getOnLayoutListener() == null) || (!(paramView.getOnLayoutListener() instanceof u))) {
      paramView.setOnLayoutListener(new u());
    }
    paramView = (u)paramView.getOnLayoutListener();
    AppMethodBeat.o(126681);
    return paramView;
  }
  
  public static n v(Activity paramActivity)
  {
    AppMethodBeat.i(126666);
    paramActivity = (n)paramActivity.findViewById(VIEW_ID);
    AppMethodBeat.o(126666);
    return paramActivity;
  }
  
  public static void w(Activity paramActivity)
  {
    AppMethodBeat.i(126667);
    paramActivity = v(paramActivity);
    if ((paramActivity != null) && (paramActivity.jlX != null))
    {
      paramActivity.jlX.setVisibility(8);
      paramActivity.jlX = null;
    }
    AppMethodBeat.o(126667);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(126673);
    if ((paramView == this.mContent) || (paramView == this.jlX)) {
      super.addView(paramView);
    }
    AppMethodBeat.o(126673);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(126674);
    if ((paramView == this.mContent) || (paramView == this.jlX)) {
      super.addView(paramView, paramInt);
    }
    AppMethodBeat.o(126674);
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126675);
    if ((paramView == this.mContent) || (paramView == this.jlX)) {
      super.addView(paramView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(126675);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(126677);
    if ((paramView == this.mContent) || (paramView == this.jlX)) {
      super.addView(paramView, paramInt, paramLayoutParams);
    }
    AppMethodBeat.o(126677);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(126676);
    if ((paramView == this.mContent) || (paramView == this.jlX)) {
      super.addView(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(126676);
  }
  
  protected final boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    return false;
  }
  
  protected final boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return false;
  }
  
  public final void cK(View paramView)
  {
    AppMethodBeat.i(126679);
    n(paramView, false);
    AppMethodBeat.o(126679);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126671);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.jlX != null) && (this.jlX.isShown()))
      {
        this.jlX.setVisibility(8);
        AppMethodBeat.o(126671);
        return true;
      }
      if (f.av(getContext()))
      {
        AppMethodBeat.o(126671);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(126671);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126672);
    n.b localb = (n.b)this.jmb.get(this.jlX);
    if ((localb != null) && (localb.jmg) && (this.jlX != null) && (this.jlX.isShown()) && (paramMotionEvent.getAction() == 0))
    {
      float f1 = paramMotionEvent.getRawY();
      this.jlX.getLocationOnScreen(this.jlZ);
      float f2 = this.jlZ[1];
      float f3 = this.jlX.getHeight();
      if ((f1 < f2) || (f1 > f3 + f2))
      {
        this.jlX.setVisibility(8);
        AppMethodBeat.o(126672);
        return true;
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(126672);
    return bool;
  }
  
  public final View getCurrentBottomPanel()
  {
    return this.jlX;
  }
  
  public final a getOnLayoutListener()
  {
    return this.jma;
  }
  
  public final void n(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126678);
    if (this.jlX != null)
    {
      this.jlX.setVisibility(8);
      this.jlX = null;
    }
    if (this != paramView.getParent())
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.jlX = paramView;
      Object localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      super.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new n.b((byte)0);
      ((n.b)localObject).jmg = paramBoolean;
      this.jmb.put(paramView, localObject);
    }
    AppMethodBeat.o(126678);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(126680);
    this.mInLayout = true;
    if (t.as(this))
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
        n.b localb;
        if (localView != null)
        {
          i = j;
          i2 = n;
          i1 = k;
          if (localView != this.mContent)
          {
            localb = (n.b)this.jmb.get(localView);
            i = j;
            i2 = n;
            i1 = k;
            if (localb != null)
            {
              i = j;
              if (j == 0)
              {
                i = j;
                if (localb.jmh != 0)
                {
                  i = j;
                  if (localView.getVisibility() == 0)
                  {
                    this.jlX = localView;
                    post(this.jmc);
                    i = 1;
                  }
                }
              }
              if (localb.jmh != 0) {
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
          localb.jmh = localView.getVisibility();
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
        post(this.jmd);
      }
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jma != null) {
      this.jma.cN(this);
    }
    this.mInLayout = false;
    AppMethodBeat.o(126680);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126670);
    if (this.jlY > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.jlY, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(126670);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(156316);
    super.onViewRemoved(paramView);
    this.jmb.remove(paramView);
    AppMethodBeat.o(156316);
  }
  
  public final void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(126669);
    if (paramInt != this.jlY) {}
    for (int i = 1;; i = 0)
    {
      this.jlY = paramInt;
      if (i == 0) {
        break label62;
      }
      if (t.as(this)) {
        break;
      }
      AppMethodBeat.o(126669);
      return;
    }
    if (this.mInLayout)
    {
      AppMethodBeat.o(126669);
      return;
    }
    requestLayout();
    label62:
    AppMethodBeat.o(126669);
  }
  
  public final void setId(int paramInt) {}
  
  public final void setOnLayoutListener(a parama)
  {
    this.jma = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.n
 * JD-Core Version:    0.7.0.1
 */