package com.tencent.mm.plugin.appbrand.page;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.x5.export.external.extension.proxy.a;

final class am$2
  extends a
{
  am$2(am paramam) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(227317);
    am.g(this.nsp).bLv();
    AppMethodBeat.o(227317);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(227313);
    boolean bool = am.g(this.nsp).C(paramMotionEvent);
    AppMethodBeat.o(227313);
    return bool;
  }
  
  public final void hasDiscardCurrentPage(boolean paramBoolean)
  {
    AppMethodBeat.i(227321);
    am.a(this.nsp, paramBoolean);
    if ((paramBoolean) && ((am.h(this.nsp) instanceof ar))) {
      am.h(this.nsp);
    }
    AppMethodBeat.o(227321);
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(227312);
    boolean bool = am.g(this.nsp).D(paramMotionEvent);
    AppMethodBeat.o(227312);
    return bool;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(227319);
    if ((Util.isNullOrNil(paramString)) || (paramBundle == null))
    {
      AppMethodBeat.o(227319);
      return null;
    }
    Log.i("MicroMsg.AppBrandWebView", "onMiscCallBack method = %s", new Object[] { paramString });
    if ("onJavascriptCloseWindow".equals(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(227319);
      return paramString;
    }
    AppMethodBeat.o(227319);
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(227316);
    am.g(this.nsp).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(227316);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(227315);
    am.g(this.nsp).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(227315);
  }
  
  public final boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(227318);
    if (WebView.getUsingTbsCoreVersion(this.nsp.getContext()) >= 43011)
    {
      AppMethodBeat.o(227318);
      return false;
    }
    AppMethodBeat.o(227318);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(227311);
    boolean bool = am.g(this.nsp).B(paramMotionEvent);
    AppMethodBeat.o(227311);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(227314);
    paramBoolean = am.g(this.nsp).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(227314);
    return paramBoolean;
  }
  
  public final boolean shouldDiscardCurrentPage()
  {
    AppMethodBeat.i(227320);
    if (am.h(this.nsp) == null)
    {
      AppMethodBeat.o(227320);
      return false;
    }
    boolean bool2 = am.h(this.nsp).bSa();
    if ((bool2) && (!am.i(this.nsp))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.AppBrandWebView", "shouldTrimCurrentPage: %b", new Object[] { Boolean.valueOf(bool1) });
      if ((!bool2) || (am.i(this.nsp))) {
        break;
      }
      AppMethodBeat.o(227320);
      return true;
    }
    AppMethodBeat.o(227320);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am.2
 * JD-Core Version:    0.7.0.1
 */