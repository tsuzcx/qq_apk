package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.w;

final class BindGoogleContactUI$4
  implements DialogInterface.OnClickListener
{
  BindGoogleContactUI$4(BindGoogleContactUI paramBindGoogleContactUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13351);
    BindGoogleContactUI.a(this.gsF, this.gsG, w.gxN);
    AppMethodBeat.o(13351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.4
 * JD-Core Version:    0.7.0.1
 */