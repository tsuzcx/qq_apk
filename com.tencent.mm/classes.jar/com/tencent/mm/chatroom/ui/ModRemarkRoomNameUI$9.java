package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.c.a;

final class ModRemarkRoomNameUI$9
  implements DialogInterface.OnClickListener
{
  ModRemarkRoomNameUI$9(ModRemarkRoomNameUI paramModRemarkRoomNameUI, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(194172);
    this.gxG.a(this.gxD.getContext(), this.gxD.getString(2131755998), this.gxD.getString(2131757854), false, false, null);
    AppMethodBeat.o(194172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.9
 * JD-Core Version:    0.7.0.1
 */