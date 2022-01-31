package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class IPCallTalkUI$3
  implements DialogInterface.OnClickListener
{
  IPCallTalkUI$3(IPCallTalkUI paramIPCallTalkUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.lzn.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.3
 * JD-Core Version:    0.7.0.1
 */