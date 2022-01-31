package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class m$2
  implements DialogInterface.OnClickListener
{
  m$2(m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125236);
    ab.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.gGI.gDU.gwj + " img len" + this.gGI.gDU.gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
    paramDialogInterface = new s(this.gGI.gDU.account, this.gGI.gDU.gEK, this.gGI.gDU.gEL, this.gGI.gwg.getSecImgCode(), this.gGI.gwg.getSecImgSid(), this.gGI.gwg.getSecImgEncryptKey(), 1, "", false, true);
    com.tencent.mm.kernel.g.Rc().a(paramDialogInterface, 0);
    MobileVerifyUI localMobileVerifyUI = this.gGI.gGG;
    this.gGI.gGG.getString(2131297087);
    h.b(localMobileVerifyUI, this.gGI.gGG.getString(2131301149), true, new m.2.1(this, paramDialogInterface));
    AppMethodBeat.o(125236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m.2
 * JD-Core Version:    0.7.0.1
 */