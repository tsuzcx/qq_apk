package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.chatroom.c.l;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;

final class RoomRightUI$2
  implements DialogInterface.OnClickListener
{
  RoomRightUI$2(RoomRightUI paramRoomRightUI, String paramString) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104206);
    paramDialogInterface = new l(this.ehI);
    RoomRightUI localRoomRightUI1 = this.ehH;
    RoomRightUI localRoomRightUI2 = this.ehH;
    this.ehH.getString(2131297087);
    RoomRightUI.a(localRoomRightUI1, h.b(localRoomRightUI2, "", true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(104205);
        g.RK().eHt.a(paramDialogInterface);
        AppMethodBeat.o(104205);
      }
    }));
    g.RK().eHt.a(paramDialogInterface, 0);
    AppMethodBeat.o(104206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomRightUI.2
 * JD-Core Version:    0.7.0.1
 */