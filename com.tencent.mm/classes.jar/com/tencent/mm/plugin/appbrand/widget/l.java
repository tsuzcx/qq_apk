package com.tencent.mm.plugin.appbrand.widget;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "", "animateContainer", "", "type", "Lcom/tencent/mm/plugin/appbrand/widget/ContainerAnimateType;", "getCurrentStatus", "Lcom/tencent/mm/plugin/appbrand/widget/ViewStatus;", "handleInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "handleTouchEvent", "onInterceptTapToFullScreen", "onLayout", "left", "", "top", "right", "bottom", "setDefaultViewHeight", "height", "setGestureConfig", "canGesture", "forbidSlidingUpGesture", "setWxaHalfScreenEmptyAreaClickHandler", "handler", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenEmptyAreaClickHandler;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface l
{
  public abstract void DV(int paramInt);
  
  public abstract void G(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void I(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean K(MotionEvent paramMotionEvent);
  
  public abstract boolean L(MotionEvent paramMotionEvent);
  
  public abstract void a(g paramg);
  
  public abstract void a(k paramk);
  
  public abstract s cOP();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.l
 * JD-Core Version:    0.7.0.1
 */