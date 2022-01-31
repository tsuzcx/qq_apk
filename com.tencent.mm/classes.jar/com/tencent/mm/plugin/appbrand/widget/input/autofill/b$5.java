package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.Filter.FilterListener;
import android.widget.PopupWindow;

final class b$5
  implements Filter.FilterListener
{
  b$5(b paramb) {}
  
  public final void onFilterComplete(int paramInt)
  {
    if (paramInt <= 0) {
      this.hwT.hwL.dismiss();
    }
    while (!this.hwT.hwL.afe.isShowing()) {
      return;
    }
    this.hwT.hwL.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.b.5
 * JD-Core Version:    0.7.0.1
 */