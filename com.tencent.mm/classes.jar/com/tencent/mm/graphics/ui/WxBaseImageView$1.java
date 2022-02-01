package com.tencent.mm.graphics.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.b.d;

final class WxBaseImageView$1
  implements View.OnAttachStateChangeListener
{
  WxBaseImageView$1(WxBaseImageView paramWxBaseImageView) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(136221);
    d.gbh.aeu();
    WxBaseImageView.a(this.gbN);
    AppMethodBeat.o(136221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView.1
 * JD-Core Version:    0.7.0.1
 */