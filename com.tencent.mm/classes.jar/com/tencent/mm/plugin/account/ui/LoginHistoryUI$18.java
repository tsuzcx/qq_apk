package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class LoginHistoryUI$18
  implements n.c
{
  LoginHistoryUI$18(LoginHistoryUI paramLoginHistoryUI, List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(152547);
    if (paraml.size() == 0)
    {
      Iterator localIterator = this.gEz.iterator();
      while (localIterator.hasNext()) {
        paraml.f((m)localIterator.next());
      }
    }
    AppMethodBeat.o(152547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.18
 * JD-Core Version:    0.7.0.1
 */