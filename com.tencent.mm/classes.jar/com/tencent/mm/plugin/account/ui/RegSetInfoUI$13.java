package com.tencent.mm.plugin.account.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class RegSetInfoUI$13
  extends SecurityImage.b
{
  RegSetInfoUI$13(RegSetInfoUI paramRegSetInfoUI, m paramm) {}
  
  public final void apW()
  {
    AppMethodBeat.i(125519);
    this.gJQ.hideVKB();
    Object localObject = RegSetInfoUI.a(this.gJQ).getText().toString().trim();
    String str = RegSetInfoUI.b(this.gJQ).getText().toString().trim();
    int i = RegSetInfoUI.e(this.gJQ);
    g.Rc().a(126, this.gJQ);
    localObject = new u("", RegSetInfoUI.y(this.gJQ), str, RegSetInfoUI.z(this.gJQ), RegSetInfoUI.A(this.gJQ), RegSetInfoUI.B(this.gJQ), "", "", RegSetInfoUI.g(this.gJQ), i, (String)localObject, ((u)this.ckS).ajG(), "", RegSetInfoUI.D(this.gJQ), RegSetInfoUI.j(this.gJQ));
    ((u)localObject).uq(RegSetInfoUI.E(this.gJQ));
    ((u)localObject).ur(RegSetInfoUI.F(this.gJQ));
    ((u)localObject).lU(RegSetInfoUI.G(this.gJQ));
    g.Rc().a((m)localObject, 0);
    AppMethodBeat.o(125519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.13
 * JD-Core Version:    0.7.0.1
 */