package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class DelChatroomMemberUI$4
  implements DialogInterface.OnCancelListener
{
  DelChatroomMemberUI$4(DelChatroomMemberUI paramDelChatroomMemberUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(104087);
    this.efH.cancel();
    AppMethodBeat.o(104087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI.4
 * JD-Core Version:    0.7.0.1
 */