package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.sdk.platformtools.ah;

final class AppBrandInputInvokeHandler$5
  implements View.OnKeyListener
{
  AppBrandInputInvokeHandler$5(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = this.htr;
    if (67 == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      AppBrandInputInvokeHandler.access$602(paramView, bool);
      if (!AppBrandInputInvokeHandler.access$600(this.htr)) {
        break;
      }
      AppBrandInputInvokeHandler.access$1300(this.htr).removeCallbacks(AppBrandInputInvokeHandler.access$1200(this.htr));
      AppBrandInputInvokeHandler.access$1300(this.htr).postDelayed(AppBrandInputInvokeHandler.access$1200(this.htr), 1000L);
      return false;
    }
    AppBrandInputInvokeHandler.access$1200(this.htr).run();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.5
 * JD-Core Version:    0.7.0.1
 */