package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class RegSetInfoUI$10
  implements DialogInterface.OnClickListener
{
  RegSetInfoUI$10(RegSetInfoUI paramRegSetInfoUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125516);
    paramDialogInterface = RegSetInfoUI.a(this.gJQ).getText().toString().trim();
    Object localObject = RegSetInfoUI.b(this.gJQ).getText().toString().trim();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      h.h(this.gJQ, 2131304491, 2131302443);
      AppMethodBeat.o(125516);
      return;
    }
    paramInt = RegSetInfoUI.e(this.gJQ);
    g.Rc().a(126, this.gJQ);
    paramDialogInterface = new u("", RegSetInfoUI.y(this.gJQ), (String)localObject, RegSetInfoUI.z(this.gJQ), RegSetInfoUI.A(this.gJQ), RegSetInfoUI.B(this.gJQ), "", "", RegSetInfoUI.g(this.gJQ), paramInt, paramDialogInterface, ((u)this.ckS).ajG(), RegSetInfoUI.C(this.gJQ).getSecImgCode(), RegSetInfoUI.D(this.gJQ), RegSetInfoUI.j(this.gJQ));
    paramDialogInterface.uq(RegSetInfoUI.E(this.gJQ));
    paramDialogInterface.ur(RegSetInfoUI.F(this.gJQ));
    paramDialogInterface.lU(RegSetInfoUI.G(this.gJQ));
    g.Rc().a(paramDialogInterface, 0);
    localObject = this.gJQ;
    RegSetInfoUI localRegSetInfoUI = this.gJQ;
    this.gJQ.getString(2131297087);
    RegSetInfoUI.a((RegSetInfoUI)localObject, h.b(localRegSetInfoUI, this.gJQ.getString(2131302482), true, new RegSetInfoUI.10.1(this, paramDialogInterface)));
    AppMethodBeat.o(125516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.10
 * JD-Core Version:    0.7.0.1
 */