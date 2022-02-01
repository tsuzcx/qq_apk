package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.af;
import kotlin.Metadata;
import kotlin.g.b.ae;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$mWebViewCallbackClient$1", "Lcom/tencent/xweb/WebViewCallbackClient;", "mWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "getMWebView", "()Lcom/tencent/mm/ui/widget/MMWebView;", "computeScroll", "", "view", "Landroid/view/View;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "invalidate", "onContentHeightChanged", "height", "", "onInterceptTouchEvent", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "onScrollChanged", "l", "t", "oldl", "oldt", "onTouchEvent", "event", "overScrollBy", "deltaX", "deltaY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$f
  implements af
{
  f$f(f paramf) {}
  
  private final MMWebView cyc()
  {
    AppMethodBeat.i(327498);
    MMWebView localMMWebView = (MMWebView)new a(this.sMY).get();
    AppMethodBeat.o(327498);
    return localMMWebView;
  }
  
  public final void Bv(int paramInt) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(327512);
    s.u(paramView, "view");
    cyc().jEW();
    AppMethodBeat.o(327512);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327533);
    s.u(paramMotionEvent, "ev");
    s.u(paramView, "view");
    boolean bool = cyc().ay(paramMotionEvent);
    AppMethodBeat.o(327533);
    return bool;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327537);
    s.u(paramMotionEvent, "ev");
    s.u(paramView, "view");
    boolean bool = cyc().az(paramMotionEvent);
    AppMethodBeat.o(327537);
    return bool;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(327519);
    s.u(paramView, "view");
    cyc().i(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(327519);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(327524);
    s.u(paramView, "view");
    cyc().ag(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(327524);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327501);
    s.u(paramMotionEvent, "event");
    s.u(paramView, "view");
    boolean bool = cyc().ax(paramMotionEvent);
    AppMethodBeat.o(327501);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(327506);
    s.u(paramView, "view");
    paramBoolean = cyc().b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(327506);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.f.f
 * JD-Core Version:    0.7.0.1
 */