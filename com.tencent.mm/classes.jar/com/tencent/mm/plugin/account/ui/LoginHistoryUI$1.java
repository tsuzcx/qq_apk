package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mq;
import com.tencent.mm.sdk.event.IListener;

final class LoginHistoryUI$1
  extends IListener<mq>
{
  LoginHistoryUI$1(LoginHistoryUI paramLoginHistoryUI)
  {
    AppMethodBeat.i(161701);
    this.__eventId = mq.class.getName().hashCode();
    AppMethodBeat.o(161701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.1
 * JD-Core Version:    0.7.0.1
 */