package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class LoginHistoryUI$34
  implements n.c
{
  LoginHistoryUI$34(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(128116);
    if (paraml.size() == 0)
    {
      paraml.jw(7002, 2131760759);
      paraml.jw(7003, 2131760345);
      paraml.jw(7004, 2131766192);
      if (!ab.eUL()) {
        paraml.jw(7009, 2131766189);
      }
    }
    AppMethodBeat.o(128116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.34
 * JD-Core Version:    0.7.0.1
 */