package com.tencent.mm.particles;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import java.util.Iterator;
import java.util.List;

public class ConfettiView
  extends View
  implements View.OnLayoutChangeListener
{
  private boolean ipY;
  private b ipZ;
  List<b> ipo;
  boolean terminated;
  
  public ConfettiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ConfettiView cT(Context paramContext)
  {
    AppMethodBeat.i(151362);
    ConfettiView localConfettiView = new ConfettiView(paramContext, null);
    localConfettiView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (Build.VERSION.SDK_INT >= 21) {
      localConfettiView.setElevation(paramContext.getResources().getDimensionPixelOffset(2131166072));
    }
    AppMethodBeat.o(151362);
    return localConfettiView;
  }
  
  public final void aMv()
  {
    AppMethodBeat.i(151363);
    if (!this.terminated)
    {
      this.terminated = true;
      getParent().requestLayout();
    }
    AppMethodBeat.o(151363);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(151364);
    super.onAttachedToWindow();
    ViewGroup localViewGroup = (ViewGroup)getParent();
    localViewGroup.removeOnLayoutChangeListener(this);
    localViewGroup.addOnLayoutChangeListener(this);
    if (this.ipo == null) {
      aMv();
    }
    AppMethodBeat.o(151364);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(151366);
    super.onDraw(paramCanvas);
    if (!this.terminated)
    {
      paramCanvas.save();
      Iterator localIterator = this.ipo.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.iqv)
        {
          float f1 = localb.iqw;
          float f2 = localb.iqy;
          float f3 = localb.iqx;
          localb.a(paramCanvas, f2 + f1, localb.iqz + f3, localb.iqt, localb.iqq);
        }
        else if ((localb.iqu) && (!localb.terminated))
        {
          localb.a(paramCanvas, localb.iqr, localb.iqs, localb.iqt, localb.iqq);
        }
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(151366);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(151365);
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
    AppMethodBeat.o(151365);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(151367);
    if (this.ipY) {}
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if ((i == 0) && (!super.onTouchEvent(paramMotionEvent))) {
        break label459;
      }
      AppMethodBeat.o(151367);
      return true;
      Object localObject = this.ipo.iterator();
      label261:
      label265:
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label267;
        }
        b localb = (b)((Iterator)localObject).next();
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if ((localb.iqr <= f1) && (f1 <= localb.iqr + localb.getWidth()) && (localb.iqs <= f2) && (f2 <= localb.iqs + localb.getHeight()))
        {
          i = 1;
          label171:
          if (i == 0) {
            break label261;
          }
          localb.iqv = true;
          localb.iqw = f1;
          localb.iqx = f2;
          localb.iqy = (localb.iqr - f1);
          localb.iqz = (localb.iqs - f2);
          localb.mq = VelocityTracker.obtain();
          localb.mq.addMovement(paramMotionEvent);
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label265;
          }
          this.ipZ = localb;
          i = 1;
          break;
          i = 0;
          break label171;
        }
      }
      label267:
      i = 0;
      continue;
      if (this.ipZ == null) {
        break;
      }
      localObject = this.ipZ;
      ((b)localObject).iqw = paramMotionEvent.getX();
      ((b)localObject).iqx = paramMotionEvent.getY();
      ((b)localObject).mq.addMovement(paramMotionEvent);
      i = 1;
      continue;
      if (this.ipZ == null) {
        break;
      }
      localObject = this.ipZ;
      ((b)localObject).mq.addMovement(paramMotionEvent);
      ((b)localObject).mq.computeCurrentVelocity(1);
      ((b)localObject).iqf = -1L;
      ((b)localObject).iqg = (paramMotionEvent.getX() + ((b)localObject).iqy);
      ((b)localObject).iqh = (paramMotionEvent.getY() + ((b)localObject).iqz);
      ((b)localObject).iqi = ((b)localObject).mq.getXVelocity();
      ((b)localObject).iqj = ((b)localObject).mq.getYVelocity();
      ((b)localObject).iqm = ((b)localObject).iqt;
      ((b)localObject).mq.recycle();
      ((b)localObject).j(((b)localObject).ipv);
      ((b)localObject).iqv = false;
      this.ipZ = null;
      i = 1;
    }
    label459:
    AppMethodBeat.o(151367);
    return false;
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.ipY = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.ConfettiView
 * JD-Core Version:    0.7.0.1
 */