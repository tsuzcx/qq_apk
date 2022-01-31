package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class BindMContactIntroUI$23$1
  implements n.c
{
  BindMContactIntroUI$23$1(BindMContactIntroUI.23 param23) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(13431);
    paraml.setHeaderTitle(2131297585);
    if ((this.gtA.gtz & 0x2) != 0) {
      paraml.hx(0, 2131297604);
    }
    if ((this.gtA.gtz & 0x1) != 0) {
      paraml.hx(1, 2131297564);
    }
    AppMethodBeat.o(13431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.23.1
 * JD-Core Version:    0.7.0.1
 */