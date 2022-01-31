package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class SelectDelRoomManagerUI$1$1
  implements DialogInterface.OnClickListener
{
  SelectDelRoomManagerUI$1$1(SelectDelRoomManagerUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104396);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Select_Contact", bo.d(SelectDelRoomManagerUI.b(this.ejA.ejz), ","));
    this.ejA.ejz.setResult(-1, paramDialogInterface);
    this.ejA.ejz.finish();
    AppMethodBeat.o(104396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI.1.1
 * JD-Core Version:    0.7.0.1
 */