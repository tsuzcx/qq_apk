package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class RegByMobileSendSmsUI$16
  implements DialogInterface.OnClickListener
{
  RegByMobileSendSmsUI$16(RegByMobileSendSmsUI paramRegByMobileSendSmsUI, u paramu) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125412);
    paramDialogInterface = new u("", RegByMobileSendSmsUI.g(this.gIu), RegByMobileSendSmsUI.h(this.gIu), 0, "", RegByMobileSendSmsUI.i(this.gIu), "", "", RegByMobileSendSmsUI.j(this.gIu), 1, "", this.gIv.ajG(), RegByMobileSendSmsUI.k(this.gIu).getSecImgCode(), true, RegByMobileSendSmsUI.l(this.gIu));
    paramDialogInterface.uq(RegByMobileSendSmsUI.m(this.gIu));
    paramDialogInterface.ur(RegByMobileSendSmsUI.n(this.gIu));
    paramDialogInterface.lU(1);
    g.Rc().a(paramDialogInterface, 0);
    RegByMobileSendSmsUI localRegByMobileSendSmsUI = this.gIu;
    AppCompatActivity localAppCompatActivity = this.gIu.getContext();
    this.gIu.getString(2131297087);
    RegByMobileSendSmsUI.a(localRegByMobileSendSmsUI, h.b(localAppCompatActivity, this.gIu.getString(2131302482), true, new RegByMobileSendSmsUI.16.1(this, paramDialogInterface)));
    AppMethodBeat.o(125412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.16
 * JD-Core Version:    0.7.0.1
 */