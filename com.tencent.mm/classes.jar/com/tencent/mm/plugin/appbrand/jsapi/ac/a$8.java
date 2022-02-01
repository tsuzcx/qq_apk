package com.tencent.mm.plugin.appbrand.jsapi.ac;

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
    AppMethodBeat.i(222699);
    paramBoolean = a.e(this.lzL).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(222699);
    return paramBoolean;
  }
  
  public final void bpP()
  {
    AppMethodBeat.i(222700);
    a.e(this.lzL).fPV();
    AppMethodBeat.o(222700);
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(222701);
    a.e(this.lzL).i(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(222701);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(222702);
    a.e(this.lzL).S(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(222702);
  }
  
  public final boolean x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(222698);
    boolean bool = a.e(this.lzL).af(paramMotionEvent);
    AppMethodBeat.o(222698);
    return bool;
  }
  
  public final boolean y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(222703);
    boolean bool = a.e(this.lzL).ag(paramMotionEvent);
    AppMethodBeat.o(222703);
    return bool;
  }
  
  public final boolean z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(222704);
    boolean bool = a.e(this.lzL).ah(paramMotionEvent);
    AppMethodBeat.o(222704);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.a.8
 * JD-Core Version:    0.7.0.1
 */