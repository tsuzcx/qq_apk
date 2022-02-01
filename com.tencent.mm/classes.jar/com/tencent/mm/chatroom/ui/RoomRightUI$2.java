package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.chatroom.d.r;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.ui.base.k;

final class RoomRightUI$2
  implements DialogInterface.OnClickListener
{
  RoomRightUI$2(RoomRightUI paramRoomRightUI, String paramString) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(12754);
    paramDialogInterface = new r(this.lLa);
    RoomRightUI localRoomRightUI1 = this.lKZ;
    RoomRightUI localRoomRightUI2 = this.lKZ;
    this.lKZ.getString(a.i.app_tip);
    RoomRightUI.a(localRoomRightUI1, k.a(localRoomRightUI2, "", true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(12753);
        h.baD().mCm.a(paramDialogInterface);
        AppMethodBeat.o(12753);
      }
    }));
    h.baD().mCm.a(paramDialogInterface, 0);
    AppMethodBeat.o(12754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomRightUI.2
 * JD-Core Version:    0.7.0.1
 */