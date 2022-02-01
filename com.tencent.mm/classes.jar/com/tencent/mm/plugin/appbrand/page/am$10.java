package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ab;

final class am$10
  implements ab
{
  am$10(am paramam) {}
  
  public final boolean B(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(227339);
    boolean bool = this.nsp.am(paramMotionEvent);
    AppMethodBeat.o(227339);
    return bool;
  }
  
  public final boolean C(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(227343);
    boolean bool = this.nsp.an(paramMotionEvent);
    AppMethodBeat.o(227343);
    return bool;
  }
  
  public final boolean D(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(227344);
    boolean bool = this.nsp.ao(paramMotionEvent);
    AppMethodBeat.o(227344);
    return bool;
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(227340);
    paramBoolean = this.nsp.c(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(227340);
    return paramBoolean;
  }
  
  public final void bLv()
  {
    AppMethodBeat.i(227341);
    this.nsp.gYY();
    AppMethodBeat.o(227341);
  }
  
  @TargetApi(9)
  public final void d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(227342);
    this.nsp.h(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(227342);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(47943);
    if (am.f(this.nsp) != null) {
      am.f(this.nsp).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
    am.d(this.nsp);
    this.nsp.R(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(47943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am.10
 * JD-Core Version:    0.7.0.1
 */