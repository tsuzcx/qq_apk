package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class SelectDateUI$1
  implements Runnable
{
  SelectDateUI$1(SelectDateUI paramSelectDateUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104380);
    SelectDateUI.a(this.eju);
    SelectDateUI.f(this.eju).post(new SelectDateUI.1.1(this));
    AppMethodBeat.o(104380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDateUI.1
 * JD-Core Version:    0.7.0.1
 */