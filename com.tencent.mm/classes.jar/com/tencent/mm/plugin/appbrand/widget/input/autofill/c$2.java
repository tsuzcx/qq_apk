package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.widget.PopupWindow;

final class c$2
  extends DataSetObserver
{
  c$2(c paramc) {}
  
  public final void onChanged()
  {
    if (!this.hxb.hwL.afe.isShowing()) {
      return;
    }
    this.hxb.mZ(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c.2
 * JD-Core Version:    0.7.0.1
 */