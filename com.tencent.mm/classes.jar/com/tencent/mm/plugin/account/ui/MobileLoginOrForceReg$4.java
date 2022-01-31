package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class MobileLoginOrForceReg$4
  extends SecurityImage.b
{
  MobileLoginOrForceReg$4(MobileLoginOrForceReg paramMobileLoginOrForceReg, String paramString1, String paramString2, m paramm, Boolean paramBoolean) {}
  
  public final void apW()
  {
    AppMethodBeat.i(125207);
    this.gGw.hideVKB();
    u localu = new u("", this.gGx, this.gGy, 0, "", MobileLoginOrForceReg.e(this.gGw), "", "", MobileLoginOrForceReg.h(this.gGw), MobileLoginOrForceReg.t(this.gGw), "", ((u)this.ckS).ajG(), "", true, this.gGz.booleanValue());
    localu.uq(MobileLoginOrForceReg.i(this.gGw));
    localu.ur(MobileLoginOrForceReg.j(this.gGw));
    localu.lU(MobileLoginOrForceReg.m(this.gGw));
    g.Rc().a(localu, 0);
    AppMethodBeat.o(125207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.4
 * JD-Core Version:    0.7.0.1
 */