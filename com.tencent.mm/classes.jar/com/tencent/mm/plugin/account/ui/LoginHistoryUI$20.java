package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.g;
import java.util.Iterator;
import java.util.List;

final class LoginHistoryUI$20
  implements u.g
{
  LoginHistoryUI$20(LoginHistoryUI paramLoginHistoryUI, List paramList) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(305194);
    if (params.size() == 0)
    {
      Iterator localIterator = this.pZG.iterator();
      while (localIterator.hasNext()) {
        params.j((t)localIterator.next());
      }
    }
    AppMethodBeat.o(305194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.20
 * JD-Core Version:    0.7.0.1
 */