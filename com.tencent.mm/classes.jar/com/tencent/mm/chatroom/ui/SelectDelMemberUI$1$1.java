package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class SelectDelMemberUI$1$1
  implements DialogInterface.OnClickListener
{
  SelectDelMemberUI$1$1(SelectDelMemberUI.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104386);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Select_Contact", bo.d(SelectDelMemberUI.a(this.ejx.ejw), ","));
    this.ejx.ejw.setResult(-1, paramDialogInterface);
    this.ejx.ejw.finish();
    AppMethodBeat.o(104386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDelMemberUI.1.1
 * JD-Core Version:    0.7.0.1
 */