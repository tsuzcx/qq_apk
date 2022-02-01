package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.ab;

final class a$9
  extends com.tencent.xweb.x5.export.external.extension.proxy.a
{
  a$9(a parama) {}
  
  public final void computeScroll(View paramView)
  {
    AppMethodBeat.i(188552);
    a.i(this.lvn).bpf();
    AppMethodBeat.o(188552);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(188548);
    boolean bool = a.i(this.lvn).y(paramMotionEvent);
    AppMethodBeat.o(188548);
    return bool;
  }
  
  public final void invalidate() {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(188547);
    boolean bool = a.i(this.lvn).z(paramMotionEvent);
    AppMethodBeat.o(188547);
    return bool;
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(188553);
    if ((bt.isNullOrNil(paramString)) || (paramBundle == null))
    {
      AppMethodBeat.o(188553);
      return null;
    }
    ad.i("MicroMsg.AppBrandHTMLWebView", "method = %s", new Object[] { paramString });
    if ("onJavascriptCloseWindow".equals(paramString))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(188553);
      return paramString;
    }
    AppMethodBeat.o(188553);
    return null;
  }
  
  public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(188551);
    a.i(this.lvn).d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(188551);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(188550);
    a.i(this.lvn).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(188550);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(188546);
    boolean bool = a.i(this.lvn).x(paramMotionEvent);
    AppMethodBeat.o(188546);
    return bool;
  }
  
  public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(188549);
    paramBoolean = a.i(this.lvn).b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(188549);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a.9
 * JD-Core Version:    0.7.0.1
 */