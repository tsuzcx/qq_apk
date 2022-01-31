package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class RegSetInfoUI$17
  extends SecurityImage.b
{
  RegSetInfoUI$17(RegSetInfoUI paramRegSetInfoUI, m paramm) {}
  
  public final void apW()
  {
    AppMethodBeat.i(125524);
    this.gJQ.hideVKB();
    int i = RegSetInfoUI.e(this.gJQ);
    Object localObject = RegSetInfoUI.f(this.gJQ);
    g.Rc().a(429, this.gJQ);
    localObject = new ad((String)localObject, RegSetInfoUI.g(this.gJQ), i, "", "", ((ad)this.ckS).ajG(), "");
    g.Rc().a((m)localObject, 0);
    AppMethodBeat.o(125524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.17
 * JD-Core Version:    0.7.0.1
 */