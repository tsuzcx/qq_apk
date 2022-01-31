package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class RegSetInfoUI$17
  extends SecurityImage.b
{
  RegSetInfoUI$17(RegSetInfoUI paramRegSetInfoUI, m paramm) {}
  
  public final void Ws()
  {
    this.fso.XM();
    int i = RegSetInfoUI.e(this.fso);
    Object localObject = RegSetInfoUI.f(this.fso);
    g.Dk().a(429, this.fso);
    localObject = new ad((String)localObject, RegSetInfoUI.g(this.fso), i, "", "", ((ad)this.bEe).Qz(), "");
    g.Dk().a((m)localObject, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.17
 * JD-Core Version:    0.7.0.1
 */