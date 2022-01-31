package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class LoginHistoryUI$30
  implements n.c
{
  LoginHistoryUI$30(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(124939);
    if (paraml.size() == 0)
    {
      paraml.hx(7002, 2131301129);
      paraml.hx(7003, 2131300744);
      paraml.hx(7004, 2131305945);
      if (!aa.dsD()) {
        paraml.hx(7009, 2131305943);
      }
    }
    AppMethodBeat.o(124939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.30
 * JD-Core Version:    0.7.0.1
 */