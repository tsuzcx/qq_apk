package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.aa;

final class a$7
  implements aa
{
  a$7(a parama) {}
  
  public final boolean B(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195952);
    boolean bool = a.d(this.kwX).af(paramMotionEvent);
    AppMethodBeat.o(195952);
    return bool;
  }
  
  public final boolean C(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195956);
    boolean bool = a.d(this.kwX).ag(paramMotionEvent);
    AppMethodBeat.o(195956);
    return bool;
  }
  
  public final boolean D(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(195957);
    boolean bool = a.d(this.kwX).ah(paramMotionEvent);
    AppMethodBeat.o(195957);
    return bool;
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(195953);
    paramBoolean = a.d(this.kwX).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(195953);
    return paramBoolean;
  }
  
  public final void beA()
  {
    AppMethodBeat.i(195954);
    a.d(this.kwX).feT();
    AppMethodBeat.o(195954);
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195955);
    a.d(this.kwX).g(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(195955);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(180288);
    a.d(this.kwX).Q(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(180288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a.7
 * JD-Core Version:    0.7.0.1
 */