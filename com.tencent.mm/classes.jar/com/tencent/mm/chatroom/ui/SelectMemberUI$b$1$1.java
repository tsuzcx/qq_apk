package com.tencent.mm.chatroom.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectMemberUI$b$1$1
  implements Runnable
{
  SelectMemberUI$b$1$1(SelectMemberUI.b.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(104412);
    SelectMemberUI.b.a(this.ejP.ejO, false);
    SelectMemberUI.c(this.ejP.ejO.ejJ).setVisibility(8);
    this.ejP.ejO.notifyDataSetChanged();
    AppMethodBeat.o(104412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.b.1.1
 * JD-Core Version:    0.7.0.1
 */