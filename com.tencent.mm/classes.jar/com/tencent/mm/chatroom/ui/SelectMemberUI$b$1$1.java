package com.tencent.mm.chatroom.ui;

import android.view.View;

final class SelectMemberUI$b$1$1
  implements Runnable
{
  SelectMemberUI$b$1$1(SelectMemberUI.b.1 param1) {}
  
  public final void run()
  {
    SelectMemberUI.b.a(this.dsh.dsg, false);
    SelectMemberUI.c(this.dsh.dsg.dsb).setVisibility(8);
    this.dsh.dsg.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b.1.1
 * JD-Core Version:    0.7.0.1
 */