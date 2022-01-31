package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class LoginHistoryUI$19
  implements n.c
{
  LoginHistoryUI$19(LoginHistoryUI paramLoginHistoryUI, List paramList) {}
  
  public final void a(l paraml)
  {
    if (paraml.size() == 0)
    {
      Iterator localIterator = this.fng.iterator();
      while (localIterator.hasNext()) {
        paraml.i((m)localIterator.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.19
 * JD-Core Version:    0.7.0.1
 */