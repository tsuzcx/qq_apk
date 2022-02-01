package com.tencent.liteapp.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaLiteAppUI$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  WxaLiteAppUI$2(WxaLiteAppUI paramWxaLiteAppUI) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(197753);
    this.crE.mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    WxaLiteAppUI.a(this.crE);
    AppMethodBeat.o(197753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteapp.ui.WxaLiteAppUI.2
 * JD-Core Version:    0.7.0.1
 */