package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.af;

final class a$9
  extends com.tencent.xweb.x5.export.external.extension.proxy.a
{
  a$9(a parama) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(327469);
    a.i(this.sLn).computeScroll(paramView);
    AppMethodBeat.o(327469);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327459);
    boolean bool = a.i(this.sLn).dispatchTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(327459);
    return bool;
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327452);
    boolean bool = a.i(this.sLn).onInterceptTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(327452);
    return bool;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(327475);
    if ((Util.isNullOrNil(paramString)) || (paramBundle == null))
    {
      AppMethodBeat.o(327475);
      return null;
    }
    Log.i("MicroMsg.AppBrandHTMLWebView", "method = %s", new Object[] { paramString });
    if ("onJavascriptCloseWindow".equals(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(327475);
      return paramString;
    }
    AppMethodBeat.o(327475);
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(327467);
    a.i(this.sLn).onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    AppMethodBeat.o(327467);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(327465);
    a.i(this.sLn).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(327465);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(327446);
    boolean bool = a.i(this.sLn).onTouchEvent(paramMotionEvent, paramView);
    AppMethodBeat.o(327446);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(327462);
    paramBoolean = a.i(this.sLn).overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    AppMethodBeat.o(327462);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.9
 * JD-Core Version:    0.7.0.1
 */