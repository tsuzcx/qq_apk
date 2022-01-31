package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.widget.PopupWindow;

final class AutoFillListPopupWindowBase$c
  extends DataSetObserver
{
  private AutoFillListPopupWindowBase$c(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final void onChanged()
  {
    if (this.hxk.afe.isShowing()) {
      this.hxk.show();
    }
  }
  
  public final void onInvalidated()
  {
    this.hxk.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.c
 * JD-Core Version:    0.7.0.1
 */