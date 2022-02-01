package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.af;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$proxyWebViewClientExtension$1", "Lcom/tencent/xweb/x5/export/external/extension/proxy/ProxyWebViewClientExtension;", "computeScroll", "", "view", "Landroid/view/View;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "invalidate", "onInterceptTouchEvent", "onMiscCallBack", "", "method", "", "bundle", "Landroid/os/Bundle;", "onOverScrolled", "scrollX", "", "scrollY", "clampedX", "clampedY", "onScrollChanged", "l", "t", "oldl", "oldt", "onTouchEvent", "event", "overScrollBy", "deltaX", "deltaY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$g
  extends a
{
  f$g(f paramf) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(327539);
    s.u(paramView, "view");
    f.g(this.sMY).computeScroll(paramView);
    AppMethodBeat.o(327539);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327518);
    s.u(paramMotionEvent, "ev");
    s.u(paramView, "view");
    boolean bool = f.g(this.sMY).dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(327518);
    return bool;
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(327542);
    f.g(this.sMY);
    AppMethodBeat.o(327542);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327511);
    s.u(paramMotionEvent, "ev");
    s.u(paramView, "view");
    boolean bool = f.g(this.sMY).onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(327511);
    return bool;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(327547);
    if ((Util.isNullOrNil(paramString)) || (paramBundle == null))
    {
      AppMethodBeat.o(327547);
      return null;
    }
    Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "method = %s", new Object[] { paramString });
    if (s.p("onJavascriptCloseWindow", paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(327547);
      return paramString;
    }
    AppMethodBeat.o(327547);
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(327534);
    s.u(paramView, "view");
    f.g(this.sMY).onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(327534);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(327530);
    s.u(paramView, "view");
    f.g(this.sMY).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(327530);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327505);
    s.u(paramMotionEvent, "event");
    s.u(paramView, "view");
    boolean bool = f.g(this.sMY).onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(327505);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(327523);
    s.u(paramView, "view");
    paramBoolean = f.g(this.sMY).overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(327523);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.f.g
 * JD-Core Version:    0.7.0.1
 */