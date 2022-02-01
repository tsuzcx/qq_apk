package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.aa;

final class a$8
  extends com.tencent.xweb.x5.export.external.extension.proxy.a
{
  a$8(a parama) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(195964);
    a.h(this.kwX).beA();
    AppMethodBeat.o(195964);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(195960);
    boolean bool = a.h(this.kwX).C(paramMotionEvent);
    AppMethodBeat.o(195960);
    return bool;
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(195959);
    boolean bool = a.h(this.kwX).D(paramMotionEvent);
    AppMethodBeat.o(195959);
    return bool;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(195965);
    if ((bt.isNullOrNil(paramString)) || (paramBundle == null))
    {
      AppMethodBeat.o(195965);
      return null;
    }
    ad.i("MicroMsg.AppBrandHTMLWebView", "method = %s", new Object[] { paramString });
    if ("onJavascriptCloseWindow".equals(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(195965);
      return paramString;
    }
    AppMethodBeat.o(195965);
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(195963);
    a.h(this.kwX).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(195963);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(195962);
    a.h(this.kwX).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(195962);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(195958);
    boolean bool = a.h(this.kwX).B(paramMotionEvent);
    AppMethodBeat.o(195958);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(195961);
    paramBoolean = a.h(this.kwX).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(195961);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a.8
 * JD-Core Version:    0.7.0.1
 */