package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

final class GroupToolsManagereUI$7
  implements DialogInterface.OnCancelListener
{
  GroupToolsManagereUI$7(GroupToolsManagereUI paramGroupToolsManagereUI, q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(182174);
    Log.i("MicroMsg.roomtools.GroupToolsManagereUI", "dialog onCancel scene:%s", new Object[] { Integer.valueOf(this.dAK.getType()) });
    g.azz().a(this.dAK);
    AppMethodBeat.o(182174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.GroupToolsManagereUI.7
 * JD-Core Version:    0.7.0.1
 */