package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.luggage.j.c;

final class WxaScrollView$1
  extends ScrollView
{
  WxaScrollView$1(WxaScrollView paramWxaScrollView, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (WxaScrollView.a(this.gqB) != null) {
      WxaScrollView.a(this.gqB).i(this.gqB, paramInt1, paramInt2);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return super.onTouchEvent(paramMotionEvent);
    } while (WxaScrollView.b(this.gqB));
    c.e("MicroMsg.WxaScrollView", "can not move");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView.1
 * JD-Core Version:    0.7.0.1
 */