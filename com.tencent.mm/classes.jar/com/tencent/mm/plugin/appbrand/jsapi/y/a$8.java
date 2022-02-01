package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.ab;

final class a$8
  extends com.tencent.xweb.x5.export.external.extension.proxy.a
{
  a$8(a parama) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(186786);
    a.h(this.kYl).blu();
    AppMethodBeat.o(186786);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(186782);
    boolean bool = a.h(this.kYl).A(paramMotionEvent);
    AppMethodBeat.o(186782);
    return bool;
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(186781);
    boolean bool = a.h(this.kYl).B(paramMotionEvent);
    AppMethodBeat.o(186781);
    return bool;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(186787);
    if ((bs.isNullOrNil(paramString)) || (paramBundle == null))
    {
      AppMethodBeat.o(186787);
      return null;
    }
    ac.i("MicroMsg.AppBrandHTMLWebView", "method = %s", new Object[] { paramString });
    if ("onJavascriptCloseWindow".equals(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(186787);
      return paramString;
    }
    AppMethodBeat.o(186787);
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(186785);
    a.h(this.kYl).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(186785);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(186784);
    a.h(this.kYl).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(186784);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(186780);
    boolean bool = a.h(this.kYl).z(paramMotionEvent);
    AppMethodBeat.o(186780);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(186783);
    paramBoolean = a.h(this.kYl).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(186783);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a.8
 * JD-Core Version:    0.7.0.1
 */