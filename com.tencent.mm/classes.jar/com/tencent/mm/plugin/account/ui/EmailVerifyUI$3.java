package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;

final class EmailVerifyUI$3
  implements View.OnClickListener
{
  EmailVerifyUI$3(EmailVerifyUI paramEmailVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(124761);
    paramView = new StringBuilder();
    g.RJ();
    paramView = paramView.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R500_250,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R500_250") + ",3");
    h.a(this.gCQ, 2131302395, 2131302385, 2131297018, 2131296888, new EmailVerifyUI.3.1(this), null);
    AppMethodBeat.o(124761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI.3
 * JD-Core Version:    0.7.0.1
 */