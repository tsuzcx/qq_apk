package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ab;

final class a$7
  implements ab
{
  a$7(a parama) {}
  
  public final boolean A(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186778);
    boolean bool = a.d(this.kYl).ag(paramMotionEvent);
    AppMethodBeat.o(186778);
    return bool;
  }
  
  public final boolean B(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186779);
    boolean bool = a.d(this.kYl).ah(paramMotionEvent);
    AppMethodBeat.o(186779);
    return bool;
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(186775);
    paramBoolean = a.d(this.kYl).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(186775);
    return paramBoolean;
  }
  
  public final void blu()
  {
    AppMethodBeat.i(186776);
    a.d(this.kYl).fuO();
    AppMethodBeat.o(186776);
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186777);
    a.d(this.kYl).g(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(186777);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(180288);
    a.d(this.kYl).S(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(180288);
  }
  
  public final boolean z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186774);
    boolean bool = a.d(this.kYl).af(paramMotionEvent);
    AppMethodBeat.o(186774);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a.7
 * JD-Core Version:    0.7.0.1
 */