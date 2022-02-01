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
  List<b> iIL;
  private boolean iJv;
  private b iJw;
  boolean terminated;
  
  public ConfettiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ConfettiView cR(Context paramContext)
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
  
  public final void aPI()
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
    if (this.iIL == null) {
      aPI();
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
      Iterator localIterator = this.iIL.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.iJS)
        {
          float f1 = localb.iJT;
          float f2 = localb.iJV;
          float f3 = localb.iJU;
          localb.a(paramCanvas, f2 + f1, localb.iJW + f3, localb.iJQ, localb.iJN);
        }
        else if ((localb.iJR) && (!localb.terminated))
        {
          localb.a(paramCanvas, localb.iJO, localb.iJP, localb.iJQ, localb.iJN);
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
    if (this.iJv) {}
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
      Object localObject = this.iIL.iterator();
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
        if ((localb.iJO <= f1) && (f1 <= localb.iJO + localb.getWidth()) && (localb.iJP <= f2) && (f2 <= localb.iJP + localb.getHeight()))
        {
          i = 1;
          label171:
          if (i == 0) {
            break label261;
          }
          localb.iJS = true;
          localb.iJT = f1;
          localb.iJU = f2;
          localb.iJV = (localb.iJO - f1);
          localb.iJW = (localb.iJP - f2);
          localb.oj = VelocityTracker.obtain();
          localb.oj.addMovement(paramMotionEvent);
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label265;
          }
          this.iJw = localb;
          i = 1;
          break;
          i = 0;
          break label171;
        }
      }
      label267:
      i = 0;
      continue;
      if (this.iJw == null) {
        break;
      }
      localObject = this.iJw;
      ((b)localObject).iJT = paramMotionEvent.getX();
      ((b)localObject).iJU = paramMotionEvent.getY();
      ((b)localObject).oj.addMovement(paramMotionEvent);
      i = 1;
      continue;
      if (this.iJw == null) {
        break;
      }
      localObject = this.iJw;
      ((b)localObject).oj.addMovement(paramMotionEvent);
      ((b)localObject).oj.computeCurrentVelocity(1);
      ((b)localObject).iJC = -1L;
      ((b)localObject).iJD = (paramMotionEvent.getX() + ((b)localObject).iJV);
      ((b)localObject).iJE = (paramMotionEvent.getY() + ((b)localObject).iJW);
      ((b)localObject).iJF = ((b)localObject).oj.getXVelocity();
      ((b)localObject).iJG = ((b)localObject).oj.getYVelocity();
      ((b)localObject).iJJ = ((b)localObject).iJQ;
      ((b)localObject).oj.recycle();
      ((b)localObject).j(((b)localObject).iIS);
      ((b)localObject).iJS = false;
      this.iJw = null;
      i = 1;
    }
    label459:
    AppMethodBeat.o(151367);
    return false;
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.iJv = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.particles.ConfettiView
 * JD-Core Version:    0.7.0.1
 */