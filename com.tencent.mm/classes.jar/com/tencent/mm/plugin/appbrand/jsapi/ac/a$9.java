package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.ab;

final class a$9
  extends com.tencent.xweb.x5.export.external.extension.proxy.a
{
  a$9(a parama) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(222711);
    a.i(this.lzL).bpP();
    AppMethodBeat.o(222711);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(222707);
    boolean bool = a.i(this.lzL).y(paramMotionEvent);
    AppMethodBeat.o(222707);
    return bool;
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(222706);
    boolean bool = a.i(this.lzL).z(paramMotionEvent);
    AppMethodBeat.o(222706);
    return bool;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(222712);
    if ((bu.isNullOrNil(paramString)) || (paramBundle == null))
    {
      AppMethodBeat.o(222712);
      return null;
    }
    ae.i("MicroMsg.AppBrandHTMLWebView", "method = %s", new Object[] { paramString });
    if ("onJavascriptCloseWindow".equals(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(222712);
      return paramString;
    }
    AppMethodBeat.o(222712);
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(222710);
    a.i(this.lzL).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(222710);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(222709);
    a.i(this.lzL).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(222709);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(222705);
    boolean bool = a.i(this.lzL).x(paramMotionEvent);
    AppMethodBeat.o(222705);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(222708);
    paramBoolean = a.i(this.lzL).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(222708);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.a.9
 * JD-Core Version:    0.7.0.1
 */