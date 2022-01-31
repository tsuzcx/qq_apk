package com.tencent.mm.chatroom.ui;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class SelectMemberUI$b$1
  implements Runnable
{
  SelectMemberUI$b$1(SelectMemberUI.b paramb) {}
  
  public final void run()
  {
    SelectMemberUI.b.a(this.dsg, true);
    long l = System.currentTimeMillis();
    this.dsg.G(this.dsg.dsb.xY());
    SelectMemberUI.b.a(this.dsg);
    y.i("MicroMsg.SelectMemberAdapter", "[load data] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    ai.d(new SelectMemberUI.b.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b.1
 * JD-Core Version:    0.7.0.1
 */