package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.luggage.c.a.a.b;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;

public final class AppBrandMultiOptionsPicker
  extends FrameLayout
  implements b<int[]>
{
  private boolean afR;
  private final Drawable hzU;
  public LinearLayout hzV;
  private boolean hzW;
  private d hzX;
  public final YANumberPicker.b hzY = new AppBrandMultiOptionsPicker.1(this);
  
  @Keep
  public AppBrandMultiOptionsPicker(Context paramContext)
  {
    super(paramContext);
    this.hzU = paramContext.getResources().getDrawable(a.b.app_brand_multi_options_picker_column_divider);
    this.hzV = new LinearLayout(paramContext);
    this.hzV.setPadding(a.fromDPToPix(paramContext, 2), 0, a.fromDPToPix(paramContext, 2), 0);
    this.hzV.setOrientation(0);
    addView(this.hzV, new FrameLayout.LayoutParams(-1, -1, 17));
    this.hzV.setDividerDrawable(this.hzU);
    this.hzV.setShowDividers(2);
  }
  
  public final void a(d paramd)
  {
    this.hzX = paramd;
  }
  
  public final void ajP()
  {
    int j = getPickersCount();
    int i = 0;
    while (i < j)
    {
      c localc = nb(i);
      if (localc != null) {
        localc.asY();
      }
      i += 1;
    }
  }
  
  public final void ajQ()
  {
    this.hzX = null;
  }
  
  public final void b(d paramd)
  {
    this.hzX = paramd;
  }
  
  public final int getPickersCount()
  {
    if (this.hzV == null) {
      return 0;
    }
    return this.hzV.getChildCount();
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final c nb(int paramInt)
  {
    if (paramInt < 0) {}
    while (this.hzV == null) {
      return null;
    }
    return (c)this.hzV.getChildAt(paramInt);
  }
  
  public final void nc(int paramInt)
  {
    if (paramInt <= 0) {}
    for (;;)
    {
      return;
      int i = getPickersCount() - 1;
      while (paramInt > 0)
      {
        this.hzV.removeViewAt(i);
        i -= 1;
        paramInt -= 1;
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.afR) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.afR) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final void requestLayout()
  {
    if (this.afR)
    {
      this.hzW = true;
      return;
    }
    super.requestLayout();
  }
  
  public final void setLayoutFrozen(boolean paramBoolean)
  {
    if (this.afR != paramBoolean)
    {
      this.afR = paramBoolean;
      if (!paramBoolean) {
        break label36;
      }
      l = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    }
    label36:
    while (!this.hzW)
    {
      long l;
      return;
    }
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker
 * JD-Core Version:    0.7.0.1
 */