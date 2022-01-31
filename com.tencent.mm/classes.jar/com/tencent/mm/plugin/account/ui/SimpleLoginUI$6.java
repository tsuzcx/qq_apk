package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class SimpleLoginUI$6
  implements DialogInterface.OnClickListener
{
  SimpleLoginUI$6(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125602);
    ab.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(this.gKt).gwj + " img len" + SimpleLoginUI.g(this.gKt).gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
    paramDialogInterface = new s(SimpleLoginUI.g(this.gKt).account, SimpleLoginUI.g(this.gKt).gwh, SimpleLoginUI.g(this.gKt).gEL, SimpleLoginUI.h(this.gKt).getSecImgCode(), SimpleLoginUI.h(this.gKt).getSecImgSid(), SimpleLoginUI.h(this.gKt).getSecImgEncryptKey(), 0, "", false, false);
    com.tencent.mm.kernel.g.Rc().a(paramDialogInterface, 0);
    SimpleLoginUI localSimpleLoginUI1 = this.gKt;
    SimpleLoginUI localSimpleLoginUI2 = this.gKt;
    this.gKt.getString(2131297087);
    SimpleLoginUI.a(localSimpleLoginUI1, h.b(localSimpleLoginUI2, this.gKt.getString(2131301149), true, new SimpleLoginUI.6.1(this, paramDialogInterface)));
    AppMethodBeat.o(125602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.6
 * JD-Core Version:    0.7.0.1
 */