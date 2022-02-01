package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.o;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;

final class RoomRightUI$2
  implements DialogInterface.OnClickListener
{
  RoomRightUI$2(RoomRightUI paramRoomRightUI, String paramString) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(12754);
    paramDialogInterface = new o(this.fTw);
    RoomRightUI localRoomRightUI1 = this.fTv;
    RoomRightUI localRoomRightUI2 = this.fTv;
    this.fTv.getString(2131755906);
    RoomRightUI.a(localRoomRightUI1, h.b(localRoomRightUI2, "", true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(12753);
        g.ajQ().gDv.a(paramDialogInterface);
        AppMethodBeat.o(12753);
      }
    }));
    g.ajQ().gDv.a(paramDialogInterface, 0);
    AppMethodBeat.o(12754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomRightUI.2
 * JD-Core Version:    0.7.0.1
 */