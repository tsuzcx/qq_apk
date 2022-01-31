package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a;

final class EmailVerifyUI$1
  implements MMAutoSwitchEditTextView.a
{
  EmailVerifyUI$1(EmailVerifyUI paramEmailVerifyUI) {}
  
  public final void xv(String paramString)
  {
    AppMethodBeat.i(124757);
    this.gCQ.enableOptionMenu(true);
    EmailVerifyUI.a(this.gCQ, paramString);
    AppMethodBeat.o(124757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI.1
 * JD-Core Version:    0.7.0.1
 */