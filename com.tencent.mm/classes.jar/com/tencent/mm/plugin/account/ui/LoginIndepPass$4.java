package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class LoginIndepPass$4
  implements DialogInterface.OnClickListener
{
  LoginIndepPass$4(LoginIndepPass paramLoginIndepPass) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(124972);
    ab.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(this.gEE).gwj + " img len" + LoginIndepPass.e(this.gEE).gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
    paramDialogInterface = new s(LoginIndepPass.e(this.gEE).account, LoginIndepPass.e(this.gEE).gwh, LoginIndepPass.e(this.gEE).gEL, LoginIndepPass.f(this.gEE).getSecImgCode(), LoginIndepPass.f(this.gEE).getSecImgSid(), LoginIndepPass.f(this.gEE).getSecImgEncryptKey(), 1, "", false, false);
    com.tencent.mm.kernel.g.Rc().a(paramDialogInterface, 0);
    LoginIndepPass localLoginIndepPass1 = this.gEE;
    LoginIndepPass localLoginIndepPass2 = this.gEE;
    this.gEE.getString(2131297087);
    LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, this.gEE.getString(2131301149), true, new LoginIndepPass.4.1(this, paramDialogInterface)));
    AppMethodBeat.o(124972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.4
 * JD-Core Version:    0.7.0.1
 */