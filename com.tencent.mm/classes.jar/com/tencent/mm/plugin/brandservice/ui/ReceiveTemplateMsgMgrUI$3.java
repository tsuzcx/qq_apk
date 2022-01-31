package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.k;

final class ReceiveTemplateMsgMgrUI$3
  implements Runnable
{
  ReceiveTemplateMsgMgrUI$3(ReceiveTemplateMsgMgrUI paramReceiveTemplateMsgMgrUI) {}
  
  public final void run()
  {
    if (ReceiveTemplateMsgMgrUI.a(this.idW))
    {
      ReceiveTemplateMsgMgrUI.b(this.idW);
      k localk = new k(ReceiveTemplateMsgMgrUI.c(this.idW), ReceiveTemplateMsgMgrUI.axF());
      g.Dk().a(localk, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI.3
 * JD-Core Version:    0.7.0.1
 */