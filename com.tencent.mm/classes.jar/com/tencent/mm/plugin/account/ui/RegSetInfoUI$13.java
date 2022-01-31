package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class RegSetInfoUI$13
  extends SecurityImage.b
{
  RegSetInfoUI$13(RegSetInfoUI paramRegSetInfoUI, m paramm) {}
  
  public final void Ws()
  {
    this.fso.XM();
    Object localObject = RegSetInfoUI.a(this.fso).getText().toString().trim();
    String str = RegSetInfoUI.b(this.fso).getText().toString().trim();
    int i = RegSetInfoUI.e(this.fso);
    g.Dk().a(126, this.fso);
    localObject = new s("", RegSetInfoUI.y(this.fso), str, RegSetInfoUI.z(this.fso), RegSetInfoUI.A(this.fso), RegSetInfoUI.B(this.fso), "", "", RegSetInfoUI.g(this.fso), i, (String)localObject, ((s)this.bEe).Qz(), "", RegSetInfoUI.D(this.fso), RegSetInfoUI.j(this.fso));
    ((s)localObject).ne(RegSetInfoUI.E(this.fso));
    ((s)localObject).jc(RegSetInfoUI.F(this.fso));
    g.Dk().a((m)localObject, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.13
 * JD-Core Version:    0.7.0.1
 */