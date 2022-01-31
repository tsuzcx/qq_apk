package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class RegByMobileSendSmsUI$3
  extends SecurityImage.b
{
  RegByMobileSendSmsUI$3(RegByMobileSendSmsUI paramRegByMobileSendSmsUI, u paramu) {}
  
  public final void apW()
  {
    AppMethodBeat.i(125400);
    this.gIu.hideVKB();
    u localu = new u("", RegByMobileSendSmsUI.g(this.gIu), RegByMobileSendSmsUI.h(this.gIu), 0, "", RegByMobileSendSmsUI.i(this.gIu), "", "", RegByMobileSendSmsUI.j(this.gIu), 1, "", this.gIv.ajG(), RegByMobileSendSmsUI.k(this.gIu).getSecImgCode(), true, RegByMobileSendSmsUI.l(this.gIu));
    localu.uq(RegByMobileSendSmsUI.m(this.gIu));
    localu.ur(RegByMobileSendSmsUI.n(this.gIu));
    localu.lU(1);
    g.Rc().a(localu, 0);
    AppMethodBeat.o(125400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.3
 * JD-Core Version:    0.7.0.1
 */