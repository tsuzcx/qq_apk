package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class LoginUI$14
  implements DialogInterface.OnClickListener
{
  LoginUI$14(LoginUI paramLoginUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125041);
    if (LoginUI.h(this.gFf) == null)
    {
      ab.e("MicroMsg.LoginUI", "secimg is null!");
      AppMethodBeat.o(125041);
      return;
    }
    ab.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.i(this.gFf).gwj + " img len" + LoginUI.i(this.gFf).gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
    paramDialogInterface = new s(LoginUI.i(this.gFf).account, LoginUI.i(this.gFf).gwh, LoginUI.i(this.gFf).gEL, LoginUI.h(this.gFf).getSecImgCode(), LoginUI.h(this.gFf).getSecImgSid(), LoginUI.h(this.gFf).getSecImgEncryptKey(), 2, "", false, false);
    com.tencent.mm.kernel.g.Rc().a(paramDialogInterface, 0);
    LoginUI localLoginUI1 = this.gFf;
    LoginUI localLoginUI2 = this.gFf;
    this.gFf.getString(2131297087);
    LoginUI.a(localLoginUI1, h.b(localLoginUI2, this.gFf.getString(2131301149), true, new LoginUI.14.1(this, paramDialogInterface)));
    AppMethodBeat.o(125041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.14
 * JD-Core Version:    0.7.0.1
 */