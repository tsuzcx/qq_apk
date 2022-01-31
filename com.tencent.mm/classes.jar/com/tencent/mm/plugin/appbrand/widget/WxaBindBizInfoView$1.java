package com.tencent.mm.plugin.appbrand.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class WxaBindBizInfoView$1
  implements ViewTreeObserver.OnPreDrawListener
{
  WxaBindBizInfoView$1(WxaBindBizInfoView paramWxaBindBizInfoView) {}
  
  public final boolean onPreDraw()
  {
    this.hor.getViewTreeObserver().removeOnPreDrawListener(this);
    WxaBindBizInfoView.a(this.hor);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView.1
 * JD-Core Version:    0.7.0.1
 */