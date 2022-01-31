package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class AppBrandInputInvokeHandler$4
  implements v.e
{
  AppBrandInputInvokeHandler$4(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  public final void kT(int paramInt)
  {
    y.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 2)
    {
      if ((paramInt == 0) && (AppBrandInputInvokeHandler.access$200(this.htr) != null)) {
        AppBrandInputInvokeHandler.access$200(this.htr).requestFocus();
      }
      AppBrandInputInvokeHandler.access$1100(this.htr);
      if ((this.htr.mPageRef != null) && (this.htr.mPageRef.get() != null)) {
        n.a((q)this.htr.mPageRef.get(), AppBrandInputInvokeHandler.access$200(this.htr));
      }
      return;
    }
    AppBrandInputInvokeHandler.access$902(this.htr, AppBrandInputInvokeHandler.c.htt);
    AppBrandInputInvokeHandler.access$1000(this.htr);
    AppBrandInputInvokeHandler.access$902(this.htr, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.4
 * JD-Core Version:    0.7.0.1
 */