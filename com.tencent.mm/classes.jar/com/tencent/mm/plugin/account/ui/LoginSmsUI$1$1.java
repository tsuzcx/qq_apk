package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class LoginSmsUI$1$1
  implements DialogInterface.OnClickListener
{
  LoginSmsUI$1$1(LoginSmsUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125013);
    this.gER.gEQ.gEj.dDR();
    LoginSmsUI.a(this.gER.gEQ, this.gER.gEQ.gDW);
    AppMethodBeat.o(125013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI.1.1
 * JD-Core Version:    0.7.0.1
 */