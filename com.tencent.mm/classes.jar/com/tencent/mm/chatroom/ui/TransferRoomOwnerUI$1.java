package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.ui.base.h;

final class TransferRoomOwnerUI$1
  implements DialogInterface.OnClickListener
{
  TransferRoomOwnerUI$1(TransferRoomOwnerUI paramTransferRoomOwnerUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104462);
    if (t.nK(this.elf.egF)) {}
    for (paramDialogInterface = new com.tencent.mm.openim.b.p(this.elf.egF, this.efI);; paramDialogInterface = new com.tencent.mm.chatroom.c.p(this.elf.egF, this.efI))
    {
      g.RK().eHt.a(paramDialogInterface, 0);
      paramDialogInterface = this.elf;
      TransferRoomOwnerUI localTransferRoomOwnerUI = this.elf;
      this.elf.getString(2131297087);
      TransferRoomOwnerUI.a(paramDialogInterface, h.b(localTransferRoomOwnerUI, this.elf.getString(2131302800), false, null));
      AppMethodBeat.o(104462);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI.1
 * JD-Core Version:    0.7.0.1
 */