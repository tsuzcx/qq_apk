package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

final class GroupToolsManagereUI$7
  implements DialogInterface.OnCancelListener
{
  GroupToolsManagereUI$7(GroupToolsManagereUI paramGroupToolsManagereUI, p paramp) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(182174);
    Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "dialog onCancel scene:%s", new Object[] { Integer.valueOf(this.hxO.getType()) });
    h.aZW().a(this.hxO);
    AppMethodBeat.o(182174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.7
 * JD-Core Version:    0.7.0.1
 */