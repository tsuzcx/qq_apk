package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallTalkUI$2
  implements DialogInterface.OnClickListener
{
  IPCallTalkUI$2(IPCallTalkUI paramIPCallTalkUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22361);
    paramDialogInterface.dismiss();
    this.nWz.finish();
    this.nWz.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    AppMethodBeat.o(22361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.2
 * JD-Core Version:    0.7.0.1
 */