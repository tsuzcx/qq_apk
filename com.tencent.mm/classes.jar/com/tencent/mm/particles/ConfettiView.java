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
  List<b> jIs;
  private boolean jJc;
  private b jJd;
  boolean terminated;
  
  public ConfettiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ConfettiView jdMethod_do(Context paramContext)
  {
    AppMethodBeat.i(151362);
    ConfettiView localConfettiView = new ConfettiView(paramContext, null);
    localConfettiView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (Build.VERSION.SDK_INT >= 21) {
      localConfettiView.setElevation(paramContext.getResources().getDimensionPixelOffset(2131166112));
    }
    AppMethodBeat.o(151362);
    return localConfettiView;
  }
  
  public final void bkK()
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
    if (this.jIs == null) {
      bkK();
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
      Iterator localIterator = this.jIs.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.jJz)
        {
          float f1 = localb.jJA;
          float f2 = localb.jJC;
          float f3 = localb.jJB;
          localb.a(paramCanvas, f2 + f1, localb.jJD + f3, localb.jJx, localb.jJu);
        }
        else if ((localb.jJy) && (!localb.terminated))
        {
          localb.a(paramCanvas, localb.jJv, localb.jJw, localb.jJx, localb.jJu);
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
    if (this.jJc) {}
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
      Object localObject = this.jIs.iterator();
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
        if ((localb.jJv <= f1) && (f1 <= localb.jJv + localb.getWidth()) && (localb.jJw <= f2) && (f2 <= localb.jJw + localb.getHeight()))
        {
          i = 1;
          label171:
          if (i == 0) {
            break label261;
          }
          localb.jJz = true;
          localb.jJA = f1;
          localb.jJB = f2;
          localb.jJC = (localb.jJv - f1);
          localb.jJD = (localb.jJw - f2);
          localb.ol = VelocityTracker.obtain();
          localb.ol.addMovement(paramMotionEvent);
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label265;
          }
          this.jJd = localb;
          i = 1;
          break;
          i = 0;
          break label171;
        }
      }
      label267:
      i = 0;
      continue;
      if (this.jJd == null) {
        break;
      }
      localObject = this.jJd;
      ((b)localObject).jJA = paramMotionEvent.getX();
      ((b)localObject).jJB = paramMotionEvent.getY();
      ((b)localObject).ol.addMovement(paramMotionEvent);
      i = 1;
      continue;
      if (this.jJd == null) {
        break;
      }
      localObject = this.jJd;
      ((b)localObject).ol.addMovement(paramMotionEvent);
      ((b)localObject).ol.computeCurrentVelocity(1);
      ((b)localObject).jJj = -1L;
      ((b)localObject).jJk = (paramMotionEvent.getX() + ((b)localObject).jJC);
      ((b)localObject).jJl = (paramMotionEvent.getY() + ((b)localObject).jJD);
      ((b)localObject).jJm = ((b)localObject).ol.getXVelocity();
      ((b)localObject).jJn = ((b)localObject).ol.getYVelocity();
      ((b)localObject).jJq = ((b)localObject).jJx;
      ((b)localObject).ol.recycle();
      ((b)localObject).k(((b)localObject).jIz);
      ((b)localObject).jJz = false;
      this.jJd = null;
      i = 1;
    }
    label459:
    AppMethodBeat.o(151367);
    return false;
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.jJc = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.ConfettiView
 * JD-Core Version:    0.7.0.1
 */