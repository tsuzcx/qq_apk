package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.base.b;

final class BindMContactUI$6
  implements Runnable
{
  BindMContactUI$6(BindMContactUI paramBindMContactUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(13466);
    String str = this.gtN.getString(2131306170, new Object[] { aa.dsG() });
    a.b(this.gtN, str, 30765, true);
    b.ih(this.gtN);
    AppMethodBeat.o(13466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI.6
 * JD-Core Version:    0.7.0.1
 */