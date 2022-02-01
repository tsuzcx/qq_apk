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
  List<b> iLE;
  private boolean iMo;
  private b iMp;
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
  
  public final void aQh()
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
    if (this.iLE == null) {
      aQh();
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
      Iterator localIterator = this.iLE.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.iML)
        {
          float f1 = localb.iMM;
          float f2 = localb.iMO;
          float f3 = localb.iMN;
          localb.a(paramCanvas, f2 + f1, localb.iMP + f3, localb.iMJ, localb.iMG);
        }
        else if ((localb.iMK) && (!localb.terminated))
        {
          localb.a(paramCanvas, localb.iMH, localb.iMI, localb.iMJ, localb.iMG);
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
    if (this.iMo) {}
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
      Object localObject = this.iLE.iterator();
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
        if ((localb.iMH <= f1) && (f1 <= localb.iMH + localb.getWidth()) && (localb.iMI <= f2) && (f2 <= localb.iMI + localb.getHeight()))
        {
          i = 1;
          label171:
          if (i == 0) {
            break label261;
          }
          localb.iML = true;
          localb.iMM = f1;
          localb.iMN = f2;
          localb.iMO = (localb.iMH - f1);
          localb.iMP = (localb.iMI - f2);
          localb.oj = VelocityTracker.obtain();
          localb.oj.addMovement(paramMotionEvent);
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label265;
          }
          this.iMp = localb;
          i = 1;
          break;
          i = 0;
          break label171;
        }
      }
      label267:
      i = 0;
      continue;
      if (this.iMp == null) {
        break;
      }
      localObject = this.iMp;
      ((b)localObject).iMM = paramMotionEvent.getX();
      ((b)localObject).iMN = paramMotionEvent.getY();
      ((b)localObject).oj.addMovement(paramMotionEvent);
      i = 1;
      continue;
      if (this.iMp == null) {
        break;
      }
      localObject = this.iMp;
      ((b)localObject).oj.addMovement(paramMotionEvent);
      ((b)localObject).oj.computeCurrentVelocity(1);
      ((b)localObject).iMv = -1L;
      ((b)localObject).iMw = (paramMotionEvent.getX() + ((b)localObject).iMO);
      ((b)localObject).iMx = (paramMotionEvent.getY() + ((b)localObject).iMP);
      ((b)localObject).iMy = ((b)localObject).oj.getXVelocity();
      ((b)localObject).iMz = ((b)localObject).oj.getYVelocity();
      ((b)localObject).iMC = ((b)localObject).iMJ;
      ((b)localObject).oj.recycle();
      ((b)localObject).j(((b)localObject).iLL);
      ((b)localObject).iML = false;
      this.iMp = null;
      i = 1;
    }
    label459:
    AppMethodBeat.o(151367);
    return false;
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.iMo = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.particles.ConfettiView
 * JD-Core Version:    0.7.0.1
 */