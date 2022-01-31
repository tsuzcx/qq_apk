package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelfriend.a;

final class o$13
  implements DialogInterface.OnClickListener
{
  o$13(o paramo, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mm.kernel.g.Dk().a(701, this.fpr);
    this.fpr.foc = new g(new o.13.1(this), ((a)this.bEe).getUsername(), ((a)this.bEe).NI(), this.fpr.fpj.bSe);
    this.fpr.foc.a(this.fpr.fpj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.13
 * JD-Core Version:    0.7.0.1
 */