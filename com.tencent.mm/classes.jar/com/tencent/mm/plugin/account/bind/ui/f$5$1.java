package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;

final class f$5$1
  implements DialogInterface.OnCancelListener
{
  f$5$1(f.5 param5, ab paramab) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.feG.feE.onDetach();
    g.Dk().c(this.feF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f.5.1
 * JD-Core Version:    0.7.0.1
 */