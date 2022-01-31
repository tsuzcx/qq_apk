package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaScrollView$1
  extends ScrollView
{
  WxaScrollView$1(WxaScrollView paramWxaScrollView, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(126321);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (WxaScrollView.a(this.hLv) != null) {
      WxaScrollView.a(this.hLv).q(this.hLv, paramInt1, paramInt2);
    }
    AppMethodBeat.o(126321);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126322);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(126322);
      return bool;
    } while (WxaScrollView.b(this.hLv));
    d.e("MicroMsg.WxaScrollView", "can not move");
    AppMethodBeat.o(126322);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView.1
 * JD-Core Version:    0.7.0.1
 */