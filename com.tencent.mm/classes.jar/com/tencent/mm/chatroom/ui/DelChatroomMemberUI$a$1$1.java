package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.storage.ad;

final class DelChatroomMemberUI$a$1$1
  implements DialogInterface.OnClickListener
{
  DelChatroomMemberUI$a$1$1(DelChatroomMemberUI.a.1 param1, ad paramad) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104088);
    DelChatroomMemberUI.a(this.egp.egn.egi, this.ego.field_username);
    AppMethodBeat.o(104088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a.1.1
 * JD-Core Version:    0.7.0.1
 */