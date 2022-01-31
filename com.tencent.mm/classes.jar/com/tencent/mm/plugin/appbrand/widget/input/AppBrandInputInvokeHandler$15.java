package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.page.q;
import java.lang.ref.WeakReference;

final class AppBrandInputInvokeHandler$15
  implements View.OnClickListener
{
  AppBrandInputInvokeHandler$15(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  public final void onClick(View paramView)
  {
    if (AppBrandInputInvokeHandler.access$200(this.htr) == null) {
      return;
    }
    if (AppBrandInputInvokeHandler.access$200(this.htr).hasFocus())
    {
      AppBrandInputInvokeHandler.access$800(this.htr);
      return;
    }
    if (this.htr.mPageRef == null) {}
    for (q localq = null;; localq = (q)this.htr.mPageRef.get())
    {
      if (localq != null) {
        h.arM().f(localq.gTF);
      }
      if ((AppBrandInputInvokeHandler.access$200(this.htr) == null) || (paramView != AppBrandInputInvokeHandler.access$200(this.htr))) {
        break;
      }
      AppBrandInputInvokeHandler.access$200(this.htr).setFocusable(true);
      AppBrandInputInvokeHandler.access$200(this.htr).setFocusableInTouchMode(true);
      AppBrandInputInvokeHandler.access$300(this.htr).hvc = AppBrandInputInvokeHandler.access$200(this.htr);
      AppBrandInputInvokeHandler.access$200(this.htr).requestFocus();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.15
 * JD-Core Version:    0.7.0.1
 */