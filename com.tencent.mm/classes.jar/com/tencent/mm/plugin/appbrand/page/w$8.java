package com.tencent.mm.plugin.appbrand.page;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.o;
import com.tencent.xweb.x5.a.a.a.a.b;

final class w$8
  extends b
{
  w$8(w paramw) {}
  
  public final void computeScroll(View paramView)
  {
    w.d(this.gVh).alk();
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return w.d(this.gVh).w(paramMotionEvent);
  }
  
  public final void hasDiscardCurrentPage(boolean paramBoolean)
  {
    w.a(this.gVh, paramBoolean);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return w.d(this.gVh).x(paramMotionEvent);
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    if ((bk.bl(paramString)) || (paramBundle == null)) {
      return null;
    }
    y.i("MicroMsg.AppBrandWebView", "method = %s", new Object[] { paramString });
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    w.d(this.gVh).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    w.d(this.gVh).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public final boolean onShowLongClickPopupMenu()
  {
    return WebView.getUsingTbsCoreVersion(this.gVh.getContext()) < 43011;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return w.d(this.gVh).v(paramMotionEvent);
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return w.d(this.gVh).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public final boolean shouldDiscardCurrentPage()
  {
    boolean bool2 = w.e(this.gVh).anq();
    if ((bool2) && (!w.f(this.gVh))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      y.i("MicroMsg.AppBrandWebView", "shouldTrimCurrentPage: %b", new Object[] { Boolean.valueOf(bool1) });
      if ((!bool2) || (w.f(this.gVh))) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w.8
 * JD-Core Version:    0.7.0.1
 */