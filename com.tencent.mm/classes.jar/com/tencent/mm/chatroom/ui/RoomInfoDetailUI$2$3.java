package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class RoomInfoDetailUI$2$3
  implements DialogInterface.OnClickListener
{
  RoomInfoDetailUI$2$3(RoomInfoDetailUI.2 param2, ProgressDialog paramProgressDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.doh.show();
    RoomInfoDetailUI.a(this.dqg.dqf, false);
    RoomInfoDetailUI.a(this.dqg.dqf, this.doh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI.2.3
 * JD-Core Version:    0.7.0.1
 */