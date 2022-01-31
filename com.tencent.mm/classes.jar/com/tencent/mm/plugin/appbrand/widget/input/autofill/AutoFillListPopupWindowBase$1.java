package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;

final class AutoFillListPopupWindowBase$1
  implements Runnable
{
  AutoFillListPopupWindowBase$1(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final void run()
  {
    View localView = this.hxk.aeU;
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.hxk.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.1
 * JD-Core Version:    0.7.0.1
 */