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
import com.tencent.mm.plugin.comm.c.c;
import java.util.Iterator;
import java.util.List;

public class ConfettiView
  extends View
  implements View.OnLayoutChangeListener
{
  private boolean mAh;
  private b mAi;
  List<b> mzx;
  boolean terminated;
  
  public ConfettiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ConfettiView dl(Context paramContext)
  {
    AppMethodBeat.i(151362);
    ConfettiView localConfettiView = new ConfettiView(paramContext, null);
    localConfettiView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (Build.VERSION.SDK_INT >= 21) {
      localConfettiView.setElevation(paramContext.getResources().getDimensionPixelOffset(c.c.confetti_default_elevation));
    }
    AppMethodBeat.o(151362);
    return localConfettiView;
  }
  
  public final void buy()
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
    if (this.mzx == null) {
      buy();
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
      Iterator localIterator = this.mzx.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.mAE)
        {
          float f1 = localb.mAF;
          float f2 = localb.mAH;
          float f3 = localb.mAG;
          localb.a(paramCanvas, f2 + f1, localb.mAI + f3, localb.mAC, localb.mAz);
        }
        else if ((localb.mAD) && (!localb.terminated))
        {
          localb.a(paramCanvas, localb.mAA, localb.mAB, localb.mAC, localb.mAz);
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
    if (this.mAh) {}
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
      Object localObject = this.mzx.iterator();
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
        if ((localb.mAA <= f1) && (f1 <= localb.mAA + localb.getWidth()) && (localb.mAB <= f2) && (f2 <= localb.mAB + localb.getHeight()))
        {
          i = 1;
          label171:
          if (i == 0) {
            break label261;
          }
          localb.mAE = true;
          localb.mAF = f1;
          localb.mAG = f2;
          localb.mAH = (localb.mAA - f1);
          localb.mAI = (localb.mAB - f2);
          localb.bvI = VelocityTracker.obtain();
          localb.bvI.addMovement(paramMotionEvent);
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label265;
          }
          this.mAi = localb;
          i = 1;
          break;
          i = 0;
          break label171;
        }
      }
      label267:
      i = 0;
      continue;
      if (this.mAi == null) {
        break;
      }
      localObject = this.mAi;
      ((b)localObject).mAF = paramMotionEvent.getX();
      ((b)localObject).mAG = paramMotionEvent.getY();
      ((b)localObject).bvI.addMovement(paramMotionEvent);
      i = 1;
      continue;
      if (this.mAi == null) {
        break;
      }
      localObject = this.mAi;
      ((b)localObject).bvI.addMovement(paramMotionEvent);
      ((b)localObject).bvI.computeCurrentVelocity(1);
      ((b)localObject).mAo = -1L;
      ((b)localObject).mAp = (paramMotionEvent.getX() + ((b)localObject).mAH);
      ((b)localObject).mAq = (paramMotionEvent.getY() + ((b)localObject).mAI);
      ((b)localObject).mAr = ((b)localObject).bvI.getXVelocity();
      ((b)localObject).mAs = ((b)localObject).bvI.getYVelocity();
      ((b)localObject).mAv = ((b)localObject).mAC;
      ((b)localObject).bvI.recycle();
      ((b)localObject).p(((b)localObject).mzE);
      ((b)localObject).mAE = false;
      this.mAi = null;
      i = 1;
    }
    label459:
    AppMethodBeat.o(151367);
    return false;
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.mAh = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.particles.ConfettiView
 * JD-Core Version:    0.7.0.1
 */