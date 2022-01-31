package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class MobileLoginOrForceReg$2
  implements DialogInterface.OnClickListener
{
  MobileLoginOrForceReg$2(MobileLoginOrForceReg paramMobileLoginOrForceReg, String paramString1, String paramString2, m paramm, Boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125205);
    paramDialogInterface = new u("", this.gGx, this.gGy, 0, "", MobileLoginOrForceReg.e(this.gGw), "", "", MobileLoginOrForceReg.h(this.gGw), MobileLoginOrForceReg.t(this.gGw), "", ((u)this.ckS).ajG(), MobileLoginOrForceReg.r(this.gGw).getSecImgCode(), true, this.gGz.booleanValue());
    paramDialogInterface.uq(MobileLoginOrForceReg.i(this.gGw));
    paramDialogInterface.ur(MobileLoginOrForceReg.j(this.gGw));
    paramDialogInterface.lU(MobileLoginOrForceReg.m(this.gGw));
    g.Rc().a(paramDialogInterface, 0);
    MobileLoginOrForceReg localMobileLoginOrForceReg = this.gGw;
    AppCompatActivity localAppCompatActivity = this.gGw.getContext();
    this.gGw.getString(2131297087);
    localMobileLoginOrForceReg.eeN = h.b(localAppCompatActivity, this.gGw.getString(2131302482), true, new MobileLoginOrForceReg.2.1(this, paramDialogInterface));
    AppMethodBeat.o(125205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.2
 * JD-Core Version:    0.7.0.1
 */