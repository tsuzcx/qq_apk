package com.tencent.mm.plugin.finder.webview.ad;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.af;
import com.tencent.xweb.ao;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper$callbackListener$1", "Lcom/tencent/xweb/WebViewCallbackClient;", "computeScroll", "", "view", "Landroid/view/View;", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "invalidate", "onContentHeightChanged", "height", "", "onInterceptTouchEvent", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "webContentView", "onScrollChanged", "l", "t", "oldl", "oldt", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$c
  implements af
{
  d$c(d paramd) {}
  
  public final void Bv(int paramInt) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(334646);
    paramView = d.b(this.GZj);
    if (paramView != null) {
      paramView.jEW();
    }
    AppMethodBeat.o(334646);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(334641);
    do
    {
      Log.i("Finder.DialogScrollViewHelper", s.X("dispatchTouchEvent: event:", paramMotionEvent));
    } while ((d.b(this.GZj) != null) && (ao.kgm()));
    AppMethodBeat.o(334641);
    return false;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(334666);
    Log.i("Finder.DialogScrollViewHelper", s.X("onInterceptTouchEvent: event:", paramMotionEvent));
    paramView = d.b(this.GZj);
    if ((paramView != null) && (ao.kgm()))
    {
      boolean bool = paramView.az(paramMotionEvent);
      AppMethodBeat.o(334666);
      return bool;
    }
    AppMethodBeat.o(334666);
    return false;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(334656);
    Log.i("Finder.DialogScrollViewHelper", "onOverScrolled: scrollX:" + paramInt1 + " scrollY:" + paramInt2 + " clampedX:" + paramBoolean1 + " clampedY:" + paramBoolean2);
    paramView = d.b(this.GZj);
    if (paramView != null)
    {
      d locald = this.GZj;
      paramView.i(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      if ((paramBoolean2) && (paramInt2 < 200))
      {
        d.d(locald).setAllowVerticalIntercept(true);
        AppMethodBeat.o(334656);
        return;
      }
      if ((paramBoolean1) && (paramInt1 < 100)) {
        d.d(locald).setAllowHorizontalIntercept(true);
      }
    }
    AppMethodBeat.o(334656);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(334676);
    Log.i("Finder.DialogScrollViewHelper", "onScrollChanged l:" + paramInt1 + ", t:" + paramInt2 + "  oldl:" + paramInt3 + " oldt:" + paramInt4);
    paramView = d.b(this.GZj);
    if ((paramView != null) && (ao.kgm())) {
      paramView.ag(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(334676);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(334625);
    s.u(paramMotionEvent, "event");
    Log.i("Finder.DialogScrollViewHelper", "onTouchEvent event:" + paramMotionEvent + " view:" + paramView);
    paramView = d.b(this.GZj);
    if (paramView != null)
    {
      d locald = this.GZj;
      if (ao.kgm())
      {
        if (paramMotionEvent.getAction() == 2) {
          paramView.requestDisallowInterceptTouchEvent(d.c(locald));
        }
        boolean bool = paramView.ax(paramMotionEvent);
        AppMethodBeat.o(334625);
        return bool;
      }
    }
    AppMethodBeat.o(334625);
    return false;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(334633);
    Log.i("Finder.DialogScrollViewHelper", "overScrollBy: deltaX：" + paramInt1 + " deltaY：" + paramInt2 + " scrollX：" + paramInt3 + " scrollY:" + paramInt4 + "  scrollRangeX:" + paramInt5 + " scrollRangeY:" + paramInt6 + " maxOverScrollX:" + paramInt7 + " maxOverScrollY:" + paramInt8 + " isTouchEvent:" + paramBoolean);
    paramView = d.b(this.GZj);
    if (paramView != null)
    {
      paramBoolean = paramView.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      AppMethodBeat.o(334633);
      return paramBoolean;
    }
    AppMethodBeat.o(334633);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.d.c
 * JD-Core Version:    0.7.0.1
 */