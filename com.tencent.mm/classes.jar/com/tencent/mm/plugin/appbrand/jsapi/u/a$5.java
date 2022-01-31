package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.v;
import com.tencent.xweb.x5.a.a.a.a.b;

final class a$5
  extends b
{
  a$5(a parama) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(155923);
    a.d(this.igQ).aGl();
    AppMethodBeat.o(155923);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(155919);
    boolean bool = a.d(this.igQ).B(paramMotionEvent);
    AppMethodBeat.o(155919);
    return bool;
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(155918);
    boolean bool = a.d(this.igQ).C(paramMotionEvent);
    AppMethodBeat.o(155918);
    return bool;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(155922);
    a.d(this.igQ).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(155922);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(155921);
    a.d(this.igQ).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(155921);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(155917);
    boolean bool = a.d(this.igQ).A(paramMotionEvent);
    AppMethodBeat.o(155917);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(155920);
    paramBoolean = a.d(this.igQ).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(155920);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.5
 * JD-Core Version:    0.7.0.1
 */