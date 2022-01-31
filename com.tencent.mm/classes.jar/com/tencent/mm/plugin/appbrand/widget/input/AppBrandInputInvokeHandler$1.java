package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import java.lang.ref.WeakReference;

final class AppBrandInputInvokeHandler$1
  implements View.OnFocusChangeListener
{
  AppBrandInputInvokeHandler$1(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      n.b((q)this.htr.mPageRef.get(), this.htr);
    }
    AppBrandInputInvokeHandler.access$000(this.htr, paramBoolean);
    if ((paramBoolean) && ((!AppBrandInputInvokeHandler.access$100(this.htr).hyu) || (l.bW(AppBrandInputInvokeHandler.access$200(this.htr))))) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (AppBrandInputInvokeHandler.access$200(this.htr) != null) && (AppBrandInputInvokeHandler.access$300(this.htr) != null))
      {
        AppBrandInputInvokeHandler.access$200(this.htr).requestFocus();
        AppBrandInputInvokeHandler.access$300(this.htr).show();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.1
 * JD-Core Version:    0.7.0.1
 */