package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;

final class WelcomeSelectView$1
  implements Runnable
{
  WelcomeSelectView$1(WelcomeSelectView paramWelcomeSelectView) {}
  
  public final void run()
  {
    AppMethodBeat.i(125660);
    g.Rc().a(new bk(new WelcomeSelectView.1.1(this), "launch normal"), 0);
    AppMethodBeat.o(125660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView.1
 * JD-Core Version:    0.7.0.1
 */