package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class SelectMemberUI$b$1
  implements Runnable
{
  SelectMemberUI$b$1(SelectMemberUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(104413);
    SelectMemberUI.b.a(this.ejO, true);
    long l = System.currentTimeMillis();
    this.ejO.N(this.ejO.ejJ.Kq());
    SelectMemberUI.b.a(this.ejO);
    ab.i("MicroMsg.SelectMemberAdapter", "[load data] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    al.d(new SelectMemberUI.b.1.1(this));
    AppMethodBeat.o(104413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b.1
 * JD-Core Version:    0.7.0.1
 */