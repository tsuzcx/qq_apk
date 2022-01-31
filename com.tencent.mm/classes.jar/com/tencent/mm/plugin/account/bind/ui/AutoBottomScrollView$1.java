package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AutoBottomScrollView$1
  implements Runnable
{
  AutoBottomScrollView$1(AutoBottomScrollView paramAutoBottomScrollView) {}
  
  public final void run()
  {
    AppMethodBeat.i(13330);
    this.gsj.smoothScrollTo(0, this.gsj.getBottom());
    AppMethodBeat.o(13330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.AutoBottomScrollView.1
 * JD-Core Version:    0.7.0.1
 */