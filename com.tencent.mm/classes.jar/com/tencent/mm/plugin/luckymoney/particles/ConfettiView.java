package com.tencent.mm.plugin.luckymoney.particles;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import java.util.Iterator;
import java.util.List;

public class ConfettiView
  extends View
  implements View.OnLayoutChangeListener
{
  private boolean lSR;
  private b lSS;
  List<b> lSh;
  boolean terminated;
  
  public ConfettiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ConfettiView dJ(Context paramContext)
  {
    ConfettiView localConfettiView = new ConfettiView(paramContext, null);
    localConfettiView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (Build.VERSION.SDK_INT >= 21) {
      localConfettiView.setElevation(paramContext.getResources().getDimensionPixelOffset(a.d.confetti_default_elevation));
    }
    return localConfettiView;
  }
  
  public final void bfS()
  {
    if (!this.terminated)
    {
      this.terminated = true;
      getParent().requestLayout();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewGroup localViewGroup = (ViewGroup)getParent();
    localViewGroup.removeOnLayoutChangeListener(this);
    localViewGroup.addOnLayoutChangeListener(this);
    if (this.lSh == null) {
      bfS();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.terminated)
    {
      paramCanvas.save();
      Iterator localIterator = this.lSh.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.lTo) {
          localb.a(paramCanvas, localb.lTq + localb.lTs, localb.lTr + localb.lTt, localb.lTm);
        } else if ((localb.lTn) && (!localb.terminated)) {
          localb.a(paramCanvas, localb.lTk, localb.lTl, localb.lTm);
        }
      }
      paramCanvas.restore();
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.terminated)
    {
      paramView = getParent();
      if ((paramView != null) && ((paramView instanceof ViewGroup)))
      {
        paramView = (ViewGroup)paramView;
        paramView.removeViewInLayout(this);
        paramView.removeOnLayoutChangeListener(this);
        paramView.invalidate();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.lSR) {}
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if ((i == 0) && (!super.onTouchEvent(paramMotionEvent))) {
        break label446;
      }
      return true;
      Object localObject = this.lSh.iterator();
      label158:
      label248:
      label252:
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label254;
        }
        b localb = (b)((Iterator)localObject).next();
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if ((localb.lTk <= f1) && (f1 <= localb.lTk + localb.getWidth()) && (localb.lTl <= f2) && (f2 <= localb.lTl + localb.getHeight()))
        {
          i = 1;
          if (i == 0) {
            break label248;
          }
          localb.lTo = true;
          localb.lTq = f1;
          localb.lTr = f2;
          localb.lTs = (localb.lTk - f1);
          localb.lTt = (localb.lTl - f2);
          localb.lTp = VelocityTracker.obtain();
          localb.lTp.addMovement(paramMotionEvent);
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label252;
          }
          this.lSS = localb;
          i = 1;
          break;
          i = 0;
          break label158;
        }
      }
      label254:
      i = 0;
      continue;
      if (this.lSS == null) {
        break;
      }
      localObject = this.lSS;
      ((b)localObject).lTq = paramMotionEvent.getX();
      ((b)localObject).lTr = paramMotionEvent.getY();
      ((b)localObject).lTp.addMovement(paramMotionEvent);
      i = 1;
      continue;
      if (this.lSS == null) {
        break;
      }
      localObject = this.lSS;
      ((b)localObject).lTp.addMovement(paramMotionEvent);
      ((b)localObject).lTp.computeCurrentVelocity(1);
      ((b)localObject).lSY = -1L;
      ((b)localObject).lSZ = (paramMotionEvent.getX() + ((b)localObject).lTs);
      ((b)localObject).lTa = (paramMotionEvent.getY() + ((b)localObject).lTt);
      ((b)localObject).lTb = ((b)localObject).lTp.getXVelocity();
      ((b)localObject).lTc = ((b)localObject).lTp.getYVelocity();
      ((b)localObject).lTf = ((b)localObject).lTm;
      ((b)localObject).lTp.recycle();
      ((b)localObject).i(((b)localObject).lSo);
      ((b)localObject).lTo = false;
      this.lSS = null;
      i = 1;
    }
    label446:
    return false;
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.lSR = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.particles.ConfettiView
 * JD-Core Version:    0.7.0.1
 */