package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.af;

final class a$8
  implements af
{
  a$8(a parama) {}
  
  public final void Bv(int paramInt) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(327447);
    a.b(this.sLn).jEW();
    AppMethodBeat.o(327447);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327461);
    boolean bool = a.b(this.sLn).ay(paramMotionEvent);
    AppMethodBeat.o(327461);
    return bool;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327464);
    boolean bool = a.b(this.sLn).az(paramMotionEvent);
    AppMethodBeat.o(327464);
    return bool;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(327453);
    a.b(this.sLn).i(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(327453);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(327458);
    a.b(this.sLn).ag(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(327458);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327439);
    boolean bool = a.b(this.sLn).ax(paramMotionEvent);
    AppMethodBeat.o(327439);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(327443);
    paramBoolean = a.b(this.sLn).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(327443);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.8
 * JD-Core Version:    0.7.0.1
 */