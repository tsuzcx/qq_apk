package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.q;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.c.a.a.c;
import com.tencent.luggage.j.e;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class m
  extends FrameLayout
{
  private static final int gdr = a.c.app_brand_ui_root;
  private View htQ;
  private View htR;
  private int htS = -1;
  private final int[] htT = new int[2];
  private a htU;
  private WeakHashMap<View, m.b> htV = new WeakHashMap();
  private Runnable htW = new m.1(this);
  private final Runnable htX = new m.2(this);
  public final Set<m.a> htY = new HashSet();
  private boolean mInLayout = false;
  
  public m(Context paramContext, View paramView)
  {
    super(paramContext);
    super.setId(gdr);
    this.htR = paramView;
    super.addView(paramView);
  }
  
  public static m ch(View paramView)
  {
    return (m)paramView.getRootView().findViewById(gdr);
  }
  
  public static m t(Activity paramActivity)
  {
    return (m)paramActivity.findViewById(gdr);
  }
  
  public static void u(Activity paramActivity)
  {
    paramActivity = t(paramActivity);
    if ((paramActivity != null) && (paramActivity.htQ != null))
    {
      paramActivity.htQ.setVisibility(8);
      paramActivity.htQ = null;
    }
  }
  
  public final void addView(View paramView)
  {
    if ((paramView == this.htR) || (paramView == this.htQ)) {
      super.addView(paramView);
    }
  }
  
  public final void addView(View paramView, int paramInt)
  {
    if ((paramView == this.htR) || (paramView == this.htQ)) {
      super.addView(paramView, paramInt);
    }
  }
  
  public final void addView(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView == this.htR) || (paramView == this.htQ)) {
      super.addView(paramView, paramInt1, paramInt2);
    }
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView == this.htR) || (paramView == this.htQ)) {
      super.addView(paramView, paramInt, paramLayoutParams);
    }
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView == this.htR) || (paramView == this.htQ)) {
      super.addView(paramView, paramLayoutParams);
    }
  }
  
  protected final boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    return false;
  }
  
  protected final boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return false;
  }
  
  public final void ci(View paramView)
  {
    i(paramView, false);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.htQ != null) && (this.htQ.isShown())) {
        this.htQ.setVisibility(8);
      }
      while (e.af(getContext())) {
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    m.b localb = (m.b)this.htV.get(this.htQ);
    if ((localb != null) && (localb.hua) && (this.htQ != null) && (this.htQ.isShown()) && (paramMotionEvent.getAction() == 0))
    {
      float f1 = paramMotionEvent.getRawY();
      this.htQ.getLocationOnScreen(this.htT);
      float f2 = this.htT[1];
      float f3 = this.htQ.getHeight();
      if ((f1 < f2) || (f1 > f3 + f2))
      {
        this.htQ.setVisibility(8);
        return true;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final View getCurrentBottomPanel()
  {
    return this.htQ;
  }
  
  public final a getOnLayoutListener()
  {
    return this.htU;
  }
  
  public final void i(View paramView, boolean paramBoolean)
  {
    if (this.htQ != null)
    {
      this.htQ.setVisibility(8);
      this.htQ = null;
    }
    if (this != paramView.getParent())
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.htQ = paramView;
      Object localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      super.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new m.b((byte)0);
      ((m.b)localObject).hua = paramBoolean;
      this.htV.put(paramView, localObject);
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    if (q.al(this))
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
        m.b localb;
        if (localView != null)
        {
          i = j;
          i2 = n;
          i1 = k;
          if (localView != this.htR)
          {
            localb = (m.b)this.htV.get(localView);
            i = j;
            i2 = n;
            i1 = k;
            if (localb != null)
            {
              i = j;
              if (j == 0)
              {
                i = j;
                if (localb.hub != 0)
                {
                  i = j;
                  if (localView.getVisibility() == 0)
                  {
                    this.htQ = localView;
                    post(this.htW);
                    i = 1;
                  }
                }
              }
              if (localb.hub != 0) {
                break label228;
              }
              j = 1;
              label172:
              if (localView.getVisibility() == 0) {
                break label234;
              }
            }
          }
        }
        label228:
        label234:
        for (i1 = 1;; i1 = 0)
        {
          i2 = n & i1;
          localb.hub = localView.getVisibility();
          i1 = j | k;
          m += 1;
          j = i;
          n = i2;
          k = i1;
          break;
          j = 0;
          break label172;
        }
      }
      if ((j != 0) || ((k != 0) && (n != 0))) {
        post(this.htX);
      }
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.htU != null) {
      this.htU.ck(this);
    }
    this.mInLayout = false;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.htS > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.htS, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setForceHeight(int paramInt)
  {
    int i;
    if (paramInt != this.htS)
    {
      i = 1;
      this.htS = paramInt;
      if ((i != 0) && (q.al(this))) {
        break label32;
      }
    }
    label32:
    while (this.mInLayout)
    {
      return;
      i = 0;
      break;
    }
    requestLayout();
  }
  
  public final void setId(int paramInt) {}
  
  public final void setOnLayoutListener(a parama)
  {
    this.htU = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.m
 * JD-Core Version:    0.7.0.1
 */