package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.d.v;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.b.p;
import com.tencent.mm.ui.base.h;

final class TransferRoomOwnerUI$1
  implements DialogInterface.OnClickListener
{
  TransferRoomOwnerUI$1(TransferRoomOwnerUI paramTransferRoomOwnerUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13004);
    if (ab.Iy(this.gBV.gwx)) {}
    for (paramDialogInterface = new p(this.gBV.gwx, this.gtu);; paramDialogInterface = new v(this.gBV.gwx, this.gtu))
    {
      g.aAg().hqi.a(paramDialogInterface, 0);
      paramDialogInterface = this.gBV;
      TransferRoomOwnerUI localTransferRoomOwnerUI = this.gBV;
      this.gBV.getString(2131755998);
      TransferRoomOwnerUI.a(paramDialogInterface, h.a(localTransferRoomOwnerUI, this.gBV.getString(2131764795), false, null));
      AppMethodBeat.o(13004);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI.1
 * JD-Core Version:    0.7.0.1
 */