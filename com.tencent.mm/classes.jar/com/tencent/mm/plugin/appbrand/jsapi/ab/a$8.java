package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ab;

final class a$8
  implements ab
{
  a$8(a parama) {}
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(188540);
    paramBoolean = a.e(this.lvn).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(188540);
    return paramBoolean;
  }
  
  public final void bpf()
  {
    AppMethodBeat.i(188541);
    a.e(this.lvn).fLB();
    AppMethodBeat.o(188541);
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(188542);
    a.e(this.lvn).i(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(188542);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(188543);
    a.e(this.lvn).S(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(188543);
  }
  
  public final boolean x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(188539);
    boolean bool = a.e(this.lvn).ah(paramMotionEvent);
    AppMethodBeat.o(188539);
    return bool;
  }
  
  public final boolean y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(188544);
    boolean bool = a.e(this.lvn).ai(paramMotionEvent);
    AppMethodBeat.o(188544);
    return bool;
  }
  
  public final boolean z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(188545);
    boolean bool = a.e(this.lvn).aj(paramMotionEvent);
    AppMethodBeat.o(188545);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a.8
 * JD-Core Version:    0.7.0.1
 */