package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.j;

final class w$6
  extends j
{
  w$6(w paramw) {}
  
  public final void onHideCustomView()
  {
    try
    {
      if (w.b(this.gVh) != null) {
        w.b(this.gVh).amQ();
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + localException.getMessage());
    }
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    try
    {
      if (w.b(this.gVh) != null)
      {
        w.b(this.gVh).z(paramView, 90);
        w.b(this.gVh).gSu = paramCustomViewCallback;
      }
      return;
    }
    catch (Exception paramView)
    {
      y.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w.6
 * JD-Core Version:    0.7.0.1
 */