package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;

final class m$2$1
  implements DialogInterface.OnCancelListener
{
  m$2$1(m.2 param2, q paramq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.Dk().c(this.fmo);
    g.Dk().b(701, this.fpm.fpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m.2.1
 * JD-Core Version:    0.7.0.1
 */