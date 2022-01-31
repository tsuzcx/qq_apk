package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class MobileVerifyUI$8$1
  implements n.c
{
  MobileVerifyUI$8$1(MobileVerifyUI.8 param8) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(125273);
    paraml.e(0, this.gHu.gHp.getString(2131301601));
    if (b.tK(this.gHu.gHp.czF)) {
      paraml.e(1, this.gHu.gHp.getString(2131297625));
    }
    if ((MobileVerifyUI.f(this.gHu.gHp) == 2) && (this.gHu.gHp.gHk)) {
      paraml.e(2, this.gHu.gHp.getString(2131302428));
    }
    AppMethodBeat.o(125273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.8.1
 * JD-Core Version:    0.7.0.1
 */