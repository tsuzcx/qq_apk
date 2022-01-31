package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.k;

final class ReceiveTemplateMsgMgrUI$3
  implements Runnable
{
  ReceiveTemplateMsgMgrUI$3(ReceiveTemplateMsgMgrUI paramReceiveTemplateMsgMgrUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(14023);
    if (ReceiveTemplateMsgMgrUI.a(this.jUK))
    {
      ReceiveTemplateMsgMgrUI.b(this.jUK);
      k localk = new k(ReceiveTemplateMsgMgrUI.c(this.jUK), ReceiveTemplateMsgMgrUI.aWC());
      g.Rc().a(localk, 0);
    }
    AppMethodBeat.o(14023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI.3
 * JD-Core Version:    0.7.0.1
 */