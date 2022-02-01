package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class LoginHistoryUI$23
  implements n.c
{
  LoginHistoryUI$23(LoginHistoryUI paramLoginHistoryUI, List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(128105);
    if (paraml.size() == 0)
    {
      Iterator localIterator = this.iSl.iterator();
      while (localIterator.hasNext()) {
        paraml.g((m)localIterator.next());
      }
    }
    AppMethodBeat.o(128105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.23
 * JD-Core Version:    0.7.0.1
 */