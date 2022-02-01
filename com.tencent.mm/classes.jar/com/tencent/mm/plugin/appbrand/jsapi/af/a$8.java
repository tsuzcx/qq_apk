package com.tencent.mm.plugin.appbrand.jsapi.af;

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
  
  public final boolean B(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(227009);
    boolean bool = a.e(this.mGZ).am(paramMotionEvent);
    AppMethodBeat.o(227009);
    return bool;
  }
  
  public final boolean C(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(227014);
    boolean bool = a.e(this.mGZ).an(paramMotionEvent);
    AppMethodBeat.o(227014);
    return bool;
  }
  
  public final boolean D(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(227015);
    boolean bool = a.e(this.mGZ).ao(paramMotionEvent);
    AppMethodBeat.o(227015);
    return bool;
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(227010);
    paramBoolean = a.e(this.mGZ).c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(227010);
    return paramBoolean;
  }
  
  public final void bLv()
  {
    AppMethodBeat.i(227011);
    a.e(this.mGZ).gYY();
    AppMethodBeat.o(227011);
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(227012);
    a.e(this.mGZ).h(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(227012);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(227013);
    a.e(this.mGZ).R(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(227013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.a.8
 * JD-Core Version:    0.7.0.1
 */