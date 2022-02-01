package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class BaseLoginVoiceUI$22
  implements DialogInterface.OnClickListener
{
  BaseLoginVoiceUI$22(BaseLoginVoiceUI paramBaseLoginVoiceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(304973);
    Log.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
    BaseLoginVoiceUI.a(this.pZB);
    AppMethodBeat.o(304973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI.22
 * JD-Core Version:    0.7.0.1
 */