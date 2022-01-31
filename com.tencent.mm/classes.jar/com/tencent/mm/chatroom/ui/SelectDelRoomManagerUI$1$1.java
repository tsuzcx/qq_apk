package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;

final class SelectDelRoomManagerUI$1$1
  implements DialogInterface.OnClickListener
{
  SelectDelRoomManagerUI$1$1(SelectDelRoomManagerUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Select_Contact", bk.c(SelectDelRoomManagerUI.b(this.drS.drR), ","));
    this.drS.drR.setResult(-1, paramDialogInterface);
    this.drS.drR.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelRoomManagerUI.1.1
 * JD-Core Version:    0.7.0.1
 */