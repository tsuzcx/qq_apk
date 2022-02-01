package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;
import com.tencent.mm.roomsdk.a.c.d;

final class DelChatroomMemberUI$5
  implements DialogInterface.OnCancelListener
{
  DelChatroomMemberUI$5(DelChatroomMemberUI paramDelChatroomMemberUI, d paramd) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(194117);
    if (this.gvo != null) {
      this.gvo.cancel();
    }
    if (DelChatroomMemberUI.j(this.gvj) != null) {
      DelChatroomMemberUI.j(this.gvj).cancel();
    }
    AppMethodBeat.o(194117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI.5
 * JD-Core Version:    0.7.0.1
 */