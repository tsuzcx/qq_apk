package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.a.f.c;

final class BindMobilePolicyUI$2
  implements f.c
{
  BindMobilePolicyUI$2(BindMobilePolicyUI paramBindMobilePolicyUI) {}
  
  public final void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(242191);
    if (!paramBoolean)
    {
      paramString = new c(3, (String)h.aHG().aHp().b(274436, null));
      h.aGY().a(paramString, 0);
      BindMobilePolicyUI.a(this.mSF);
    }
    AppMethodBeat.o(242191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobilePolicyUI.2
 * JD-Core Version:    0.7.0.1
 */