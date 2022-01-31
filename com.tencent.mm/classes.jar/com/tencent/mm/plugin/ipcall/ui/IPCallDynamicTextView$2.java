package com.tencent.mm.plugin.ipcall.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.sdk.platformtools.ah;

final class IPCallDynamicTextView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  IPCallDynamicTextView$2(IPCallDynamicTextView paramIPCallDynamicTextView) {}
  
  public final void onGlobalLayout()
  {
    if (IPCallDynamicTextView.b(this.lvS) != IPCallDynamicTextView.c(this.lvS)) {
      IPCallDynamicTextView.e(this.lvS).sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView.2
 * JD-Core Version:    0.7.0.1
 */