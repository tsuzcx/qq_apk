package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MassSendMsgUI$9$1
  implements DialogInterface.OnClickListener
{
  MassSendMsgUI$9$1(MassSendMsgUI.9 param9, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(22832);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("CropImage_OutputPath", this.hZn);
    MassSendMsgUI.a(this.oCp.oCj, paramDialogInterface);
    AppMethodBeat.o(22832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.9.1
 * JD-Core Version:    0.7.0.1
 */