package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.xweb.o;
import com.tencent.xweb.x5.a.a.a.a.b;

final class a$3
  extends b
{
  a$3(a parama) {}
  
  public final void computeScroll(View paramView)
  {
    a.c(this.gGj).alk();
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return a.c(this.gGj).w(paramMotionEvent);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return a.c(this.gGj).x(paramMotionEvent);
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    a.c(this.gGj).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    a.c(this.gGj).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return a.c(this.gGj).v(paramMotionEvent);
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return a.c(this.gGj).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.3
 * JD-Core Version:    0.7.0.1
 */