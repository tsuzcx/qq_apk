package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.v;

final class a$4
  implements v
{
  a$4(a parama) {}
  
  public final boolean A(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155911);
    boolean bool = a.c(this.igQ).V(paramMotionEvent);
    AppMethodBeat.o(155911);
    return bool;
  }
  
  public final boolean B(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155915);
    boolean bool = a.c(this.igQ).W(paramMotionEvent);
    AppMethodBeat.o(155915);
    return bool;
  }
  
  public final boolean C(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155916);
    boolean bool = a.c(this.igQ).X(paramMotionEvent);
    AppMethodBeat.o(155916);
    return bool;
  }
  
  public final void aGl()
  {
    AppMethodBeat.i(155913);
    a.c(this.igQ).dON();
    AppMethodBeat.o(155913);
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(155912);
    paramBoolean = a.c(this.igQ).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(155912);
    return paramBoolean;
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(155914);
    a.c(this.igQ).e(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(155914);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(131644);
    a.c(this.igQ).M(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(131644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.4
 * JD-Core Version:    0.7.0.1
 */