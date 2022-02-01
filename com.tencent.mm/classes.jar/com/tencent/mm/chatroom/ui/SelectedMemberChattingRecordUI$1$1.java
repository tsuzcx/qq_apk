package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class SelectedMemberChattingRecordUI$1$1
  implements Runnable
{
  SelectedMemberChattingRecordUI$1$1(SelectedMemberChattingRecordUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(224391);
    try
    {
      this.jsf.fVP.initView();
      AppMethodBeat.o(224391);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.SelectedMemberChattingRecordUI", "initView failed, exception : " + localThrowable.getMessage());
      AppMethodBeat.o(224391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.1.1
 * JD-Core Version:    0.7.0.1
 */