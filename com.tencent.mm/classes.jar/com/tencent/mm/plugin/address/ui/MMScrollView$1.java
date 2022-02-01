package com.tencent.mm.plugin.address.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;

final class MMScrollView$1
  implements Runnable
{
  MMScrollView$1(MMScrollView paramMMScrollView, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(20952);
    this.jak.scrollTo(0, this.val$view.getTop() - a.fromDPToPix(this.jak.getContext(), 10));
    AppMethodBeat.o(20952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.MMScrollView.1
 * JD-Core Version:    0.7.0.1
 */