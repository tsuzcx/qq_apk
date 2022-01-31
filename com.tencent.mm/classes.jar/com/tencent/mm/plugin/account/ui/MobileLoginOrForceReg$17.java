package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class MobileLoginOrForceReg$17
  implements DialogInterface.OnClickListener
{
  MobileLoginOrForceReg$17(MobileLoginOrForceReg paramMobileLoginOrForceReg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125219);
    ab.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.q(this.gGw).gwj + " img len" + MobileLoginOrForceReg.q(this.gGw).gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
    paramDialogInterface = new s(MobileLoginOrForceReg.q(this.gGw).account, MobileLoginOrForceReg.q(this.gGw).gEK, MobileLoginOrForceReg.q(this.gGw).gEL, MobileLoginOrForceReg.r(this.gGw).getSecImgCode(), MobileLoginOrForceReg.r(this.gGw).getSecImgSid(), MobileLoginOrForceReg.r(this.gGw).getSecImgEncryptKey(), 1, "", false, true);
    com.tencent.mm.kernel.g.Rc().a(paramDialogInterface, 0);
    MobileLoginOrForceReg localMobileLoginOrForceReg = this.gGw;
    this.gGw.getString(2131297087);
    h.b(localMobileLoginOrForceReg, this.gGw.getString(2131301149), true, new MobileLoginOrForceReg.17.1(this, paramDialogInterface));
    AppMethodBeat.o(125219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.17
 * JD-Core Version:    0.7.0.1
 */