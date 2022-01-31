package com.tencent.mm.plugin.ipcall.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class IPCallDynamicTextView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  IPCallDynamicTextView$2(IPCallDynamicTextView paramIPCallDynamicTextView) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(22143);
    if (IPCallDynamicTextView.b(this.nTh) != IPCallDynamicTextView.c(this.nTh)) {
      IPCallDynamicTextView.e(this.nTh).sendEmptyMessage(1);
    }
    AppMethodBeat.o(22143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallDynamicTextView.2
 * JD-Core Version:    0.7.0.1
 */