package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;

final class BindGoogleContactUI$5
  implements DialogInterface.OnClickListener
{
  BindGoogleContactUI$5(BindGoogleContactUI paramBindGoogleContactUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13352);
    g.RL().Ru().set(208905, Boolean.TRUE);
    this.gsF.finish();
    AppMethodBeat.o(13352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.5
 * JD-Core Version:    0.7.0.1
 */