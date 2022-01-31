package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;

final class RoomInfoDetailUI$2$2
  implements DialogInterface.OnClickListener
{
  RoomInfoDetailUI$2$2(RoomInfoDetailUI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104187);
    RoomInfoDetailUI.a(this.ehE.ehD, true);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Chat_User", RoomInfoDetailUI.b(this.ehE.ehD).field_username);
    paramDialogInterface.addFlags(67108864);
    d.f(this.ehE.ehD, ".ui.chatting.ChattingUI", paramDialogInterface);
    AppMethodBeat.o(104187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI.2.2
 * JD-Core Version:    0.7.0.1
 */