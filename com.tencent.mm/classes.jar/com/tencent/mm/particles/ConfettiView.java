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
  private boolean pwR;
  private b pwS;
  List<b> pwh;
  boolean terminated;
  
  public ConfettiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ConfettiView ed(Context paramContext)
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
  
  public final void bSJ()
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
    if (this.pwh == null) {
      bSJ();
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
      Iterator localIterator = this.pwh.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.pxo)
        {
          float f1 = localb.pxp;
          float f2 = localb.pxr;
          float f3 = localb.pxq;
          localb.a(paramCanvas, f2 + f1, localb.pxs + f3, localb.pxm, localb.pxj);
        }
        else if ((localb.pxn) && (!localb.terminated))
        {
          localb.a(paramCanvas, localb.pxk, localb.pxl, localb.pxm, localb.pxj);
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
    if (this.pwR) {}
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
      Object localObject = this.pwh.iterator();
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
        if ((localb.pxk <= f1) && (f1 <= localb.pxk + localb.getWidth()) && (localb.pxl <= f2) && (f2 <= localb.pxl + localb.getHeight()))
        {
          i = 1;
          label171:
          if (i == 0) {
            break label261;
          }
          localb.pxo = true;
          localb.pxp = f1;
          localb.pxq = f2;
          localb.pxr = (localb.pxk - f1);
          localb.pxs = (localb.pxl - f2);
          localb.doL = VelocityTracker.obtain();
          localb.doL.addMovement(paramMotionEvent);
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label265;
          }
          this.pwS = localb;
          i = 1;
          break;
          i = 0;
          break label171;
        }
      }
      label267:
      i = 0;
      continue;
      if (this.pwS == null) {
        break;
      }
      localObject = this.pwS;
      ((b)localObject).pxp = paramMotionEvent.getX();
      ((b)localObject).pxq = paramMotionEvent.getY();
      ((b)localObject).doL.addMovement(paramMotionEvent);
      i = 1;
      continue;
      if (this.pwS == null) {
        break;
      }
      localObject = this.pwS;
      ((b)localObject).doL.addMovement(paramMotionEvent);
      ((b)localObject).doL.computeCurrentVelocity(1);
      ((b)localObject).pwY = -1L;
      ((b)localObject).pwZ = (paramMotionEvent.getX() + ((b)localObject).pxr);
      ((b)localObject).pxa = (paramMotionEvent.getY() + ((b)localObject).pxs);
      ((b)localObject).pxb = ((b)localObject).doL.getXVelocity();
      ((b)localObject).pxc = ((b)localObject).doL.getYVelocity();
      ((b)localObject).pxf = ((b)localObject).pxm;
      ((b)localObject).doL.recycle();
      ((b)localObject).u(((b)localObject).pwo);
      ((b)localObject).pxo = false;
      this.pwS = null;
      i = 1;
    }
    label459:
    AppMethodBeat.o(151367);
    return false;
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.pwR = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.particles.ConfettiView
 * JD-Core Version:    0.7.0.1
 */