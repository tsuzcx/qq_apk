package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ab;

final class a$9
  extends com.tencent.xweb.x5.export.external.extension.proxy.a
{
  a$9(a parama) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(227022);
    a.i(this.mGZ).bLv();
    AppMethodBeat.o(227022);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(227018);
    boolean bool = a.i(this.mGZ).C(paramMotionEvent);
    AppMethodBeat.o(227018);
    return bool;
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(227017);
    boolean bool = a.i(this.mGZ).D(paramMotionEvent);
    AppMethodBeat.o(227017);
    return bool;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(227023);
    if ((Util.isNullOrNil(paramString)) || (paramBundle == null))
    {
      AppMethodBeat.o(227023);
      return null;
    }
    Log.i("MicroMsg.AppBrandHTMLWebView", "method = %s", new Object[] { paramString });
    if ("onJavascriptCloseWindow".equals(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(227023);
      return paramString;
    }
    AppMethodBeat.o(227023);
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(227021);
    a.i(this.mGZ).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(227021);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(227020);
    a.i(this.mGZ).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(227020);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(227016);
    boolean bool = a.i(this.mGZ).B(paramMotionEvent);
    AppMethodBeat.o(227016);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(227019);
    paramBoolean = a.i(this.mGZ).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(227019);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.a.9
 * JD-Core Version:    0.7.0.1
 */