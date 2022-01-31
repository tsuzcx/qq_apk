package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class MassSendMsgUI$8$1
  implements DialogInterface.OnClickListener
{
  MassSendMsgUI$8$1(MassSendMsgUI.8 param8, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("CropImage_OutputPath", this.gBs);
    MassSendMsgUI.a(this.mbN.mbI, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.8.1
 * JD-Core Version:    0.7.0.1
 */