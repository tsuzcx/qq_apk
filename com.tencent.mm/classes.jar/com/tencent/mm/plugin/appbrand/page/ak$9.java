package com.tencent.mm.plugin.appbrand.page;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.x5.export.external.extension.proxy.a;

final class ak$9
  extends a
{
  ak$9(ak paramak) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(47945);
    ak.f(this.lDY).blu();
    AppMethodBeat.o(47945);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(47941);
    boolean bool = ak.f(this.lDY).A(paramMotionEvent);
    AppMethodBeat.o(47941);
    return bool;
  }
  
  public final void hasDiscardCurrentPage(boolean paramBoolean)
  {
    AppMethodBeat.i(47949);
    ak.a(this.lDY, paramBoolean);
    if ((paramBoolean) && ((ak.g(this.lDY) instanceof ap))) {
      ak.g(this.lDY);
    }
    AppMethodBeat.o(47949);
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(47940);
    boolean bool = ak.f(this.lDY).B(paramMotionEvent);
    AppMethodBeat.o(47940);
    return bool;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(47947);
    if ((bs.isNullOrNil(paramString)) || (paramBundle == null))
    {
      AppMethodBeat.o(47947);
      return null;
    }
    ac.i("MicroMsg.AppBrandWebView", "onMiscCallBack method = %s", new Object[] { paramString });
    if ("onJavascriptCloseWindow".equals(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(47947);
      return paramString;
    }
    AppMethodBeat.o(47947);
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(47944);
    ak.f(this.lDY).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(47944);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(47943);
    ak.f(this.lDY).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(47943);
  }
  
  public final boolean onShowLongClickPopupMenu()
  {
    AppMethodBeat.i(47946);
    if (WebView.getUsingTbsCoreVersion(this.lDY.getContext()) >= 43011)
    {
      AppMethodBeat.o(47946);
      return false;
    }
    AppMethodBeat.o(47946);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(47939);
    boolean bool = ak.f(this.lDY).z(paramMotionEvent);
    AppMethodBeat.o(47939);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(47942);
    paramBoolean = ak.f(this.lDY).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(47942);
    return paramBoolean;
  }
  
  public final boolean shouldDiscardCurrentPage()
  {
    AppMethodBeat.i(47948);
    if (ak.g(this.lDY) == null)
    {
      AppMethodBeat.o(47948);
      return false;
    }
    boolean bool2 = ak.g(this.lDY).brj();
    if ((bool2) && (!ak.h(this.lDY))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.AppBrandWebView", "shouldTrimCurrentPage: %b", new Object[] { Boolean.valueOf(bool1) });
      if ((!bool2) || (ak.h(this.lDY))) {
        break;
      }
      AppMethodBeat.o(47948);
      return true;
    }
    AppMethodBeat.o(47948);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ak.9
 * JD-Core Version:    0.7.0.1
 */