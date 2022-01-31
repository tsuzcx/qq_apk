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
  List<b> ggW;
  private boolean ghG;
  private b ghH;
  boolean terminated;
  
  public ConfettiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ConfettiView cn(Context paramContext)
  {
    AppMethodBeat.i(151587);
    ConfettiView localConfettiView = new ConfettiView(paramContext, null);
    localConfettiView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (Build.VERSION.SDK_INT >= 21) {
      localConfettiView.setElevation(paramContext.getResources().getDimensionPixelOffset(2131428259));
    }
    AppMethodBeat.o(151587);
    return localConfettiView;
  }
  
  public final void anW()
  {
    AppMethodBeat.i(151588);
    if (!this.terminated)
    {
      this.terminated = true;
      getParent().requestLayout();
    }
    AppMethodBeat.o(151588);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(151589);
    super.onAttachedToWindow();
    ViewGroup localViewGroup = (ViewGroup)getParent();
    localViewGroup.removeOnLayoutChangeListener(this);
    localViewGroup.addOnLayoutChangeListener(this);
    if (this.ggW == null) {
      anW();
    }
    AppMethodBeat.o(151589);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(151591);
    super.onDraw(paramCanvas);
    if (!this.terminated)
    {
      paramCanvas.save();
      Iterator localIterator = this.ggW.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.gid)
        {
          float f1 = localb.gif;
          float f2 = localb.gih;
          float f3 = localb.gig;
          localb.a(paramCanvas, f2 + f1, localb.gii + f3, localb.gib, localb.ghY);
        }
        else if ((localb.gic) && (!localb.terminated))
        {
          localb.a(paramCanvas, localb.ghZ, localb.gia, localb.gib, localb.ghY);
        }
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(151591);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(151590);
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
    AppMethodBeat.o(151590);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(151592);
    if (this.ghG) {}
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
      AppMethodBeat.o(151592);
      return true;
      Object localObject = this.ggW.iterator();
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
        if ((localb.ghZ <= f1) && (f1 <= localb.ghZ + localb.getWidth()) && (localb.gia <= f2) && (f2 <= localb.gia + localb.getHeight()))
        {
          i = 1;
          label171:
          if (i == 0) {
            break label261;
          }
          localb.gid = true;
          localb.gif = f1;
          localb.gig = f2;
          localb.gih = (localb.ghZ - f1);
          localb.gii = (localb.gia - f2);
          localb.gie = VelocityTracker.obtain();
          localb.gie.addMovement(paramMotionEvent);
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label265;
          }
          this.ghH = localb;
          i = 1;
          break;
          i = 0;
          break label171;
        }
      }
      label267:
      i = 0;
      continue;
      if (this.ghH == null) {
        break;
      }
      localObject = this.ghH;
      ((b)localObject).gif = paramMotionEvent.getX();
      ((b)localObject).gig = paramMotionEvent.getY();
      ((b)localObject).gie.addMovement(paramMotionEvent);
      i = 1;
      continue;
      if (this.ghH == null) {
        break;
      }
      localObject = this.ghH;
      ((b)localObject).gie.addMovement(paramMotionEvent);
      ((b)localObject).gie.computeCurrentVelocity(1);
      ((b)localObject).ghN = -1L;
      ((b)localObject).ghO = (paramMotionEvent.getX() + ((b)localObject).gih);
      ((b)localObject).ghP = (paramMotionEvent.getY() + ((b)localObject).gii);
      ((b)localObject).ghQ = ((b)localObject).gie.getXVelocity();
      ((b)localObject).ghR = ((b)localObject).gie.getYVelocity();
      ((b)localObject).ghU = ((b)localObject).gib;
      ((b)localObject).gie.recycle();
      ((b)localObject).j(((b)localObject).ghd);
      ((b)localObject).gid = false;
      this.ghH = null;
      i = 1;
    }
    label459:
    AppMethodBeat.o(151592);
    return false;
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.ghG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.ConfettiView
 * JD-Core Version:    0.7.0.1
 */