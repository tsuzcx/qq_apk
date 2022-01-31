package com.tencent.mm.plugin.fts.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class FTSMainUI$7
  implements DialogInterface.OnCancelListener
{
  FTSMainUI$7(FTSMainUI paramFTSMainUI, com.tencent.mm.plugin.messenger.a.f paramf, com.tencent.mm.ah.f paramf1) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.Dk().c(this.hZc);
    g.Dk().b(106, this.kAJ);
    FTSMainUI.q(this.kCm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.7
 * JD-Core Version:    0.7.0.1
 */