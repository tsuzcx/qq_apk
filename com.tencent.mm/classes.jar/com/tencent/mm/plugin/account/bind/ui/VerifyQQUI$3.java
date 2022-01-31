package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class VerifyQQUI$3
  implements DialogInterface.OnClickListener
{
  VerifyQQUI$3(VerifyQQUI paramVerifyQQUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13780);
    paramDialogInterface = new b(VerifyQQUI.c(this.gwA), VerifyQQUI.d(this.gwA), VerifyQQUI.e(this.gwA).getSecImgSid(), VerifyQQUI.e(this.gwA).getSecImgCode(), VerifyQQUI.e(this.gwA).getSecImgEncryptKey(), VerifyQQUI.f(this.gwA), VerifyQQUI.g(this.gwA), true);
    g.Rc().a(paramDialogInterface, 0);
    VerifyQQUI localVerifyQQUI = this.gwA;
    AppCompatActivity localAppCompatActivity = this.gwA.getContext();
    this.gwA.getString(2131297652);
    VerifyQQUI.a(localVerifyQQUI, h.b(localAppCompatActivity, this.gwA.getString(2131297643), true, new VerifyQQUI.3.1(this, paramDialogInterface)));
    AppMethodBeat.o(13780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.3
 * JD-Core Version:    0.7.0.1
 */