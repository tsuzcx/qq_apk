package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.chatroom.d.v;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.b.p;
import com.tencent.mm.ui.base.h;

final class TransferRoomOwnerUI$1
  implements DialogInterface.OnClickListener
{
  TransferRoomOwnerUI$1(TransferRoomOwnerUI paramTransferRoomOwnerUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13004);
    if (w.zl(this.fUJ.fPi)) {}
    for (paramDialogInterface = new p(this.fUJ.fPi, this.fNr);; paramDialogInterface = new v(this.fUJ.fPi, this.fNr))
    {
      g.ajB().gAO.a(paramDialogInterface, 0);
      paramDialogInterface = this.fUJ;
      TransferRoomOwnerUI localTransferRoomOwnerUI = this.fUJ;
      this.fUJ.getString(2131755906);
      TransferRoomOwnerUI.a(paramDialogInterface, h.b(localTransferRoomOwnerUI, this.fUJ.getString(2131762712), false, null));
      AppMethodBeat.o(13004);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI.1
 * JD-Core Version:    0.7.0.1
 */