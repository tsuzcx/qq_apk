package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;

final class SelectDelMemberUI$1$1
  implements DialogInterface.OnClickListener
{
  SelectDelMemberUI$1$1(SelectDelMemberUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Select_Contact", bk.c(SelectDelMemberUI.a(this.drP.drO), ","));
    this.drP.drO.setResult(-1, paramDialogInterface);
    this.drP.drO.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelMemberUI.1.1
 * JD-Core Version:    0.7.0.1
 */