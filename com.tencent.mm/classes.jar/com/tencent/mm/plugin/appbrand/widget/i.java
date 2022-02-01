package com.tencent.mm.plugin.appbrand.widget;

import android.view.MotionEvent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "", "animateContainer", "", "type", "Lcom/tencent/mm/plugin/appbrand/widget/ContainerAnimateType;", "getCurrentStatus", "Lcom/tencent/mm/plugin/appbrand/widget/ViewStatus;", "handleInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "handleTouchEvent", "onInterceptTapToFullScreen", "onLayout", "left", "", "top", "right", "bottom", "setDefaultViewHeight", "height", "luggage-wxa-app_release"})
public abstract interface i
{
  public abstract void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void Dw(int paramInt);
  
  public abstract boolean I(MotionEvent paramMotionEvent);
  
  public abstract boolean J(MotionEvent paramMotionEvent);
  
  public abstract void a(f paramf);
  
  public abstract p cmX();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i
 * JD-Core Version:    0.7.0.1
 */