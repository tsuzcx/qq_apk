package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelfriend.a;

final class o$15
  implements DialogInterface.OnClickListener
{
  o$15(o paramo, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mm.kernel.g.Dk().a(701, this.fpr);
    this.fpr.foc = new g(new g.a()
    {
      public final void a(ProgressDialog paramAnonymousProgressDialog)
      {
        o.15.this.fpr.fpj.dnm = paramAnonymousProgressDialog;
      }
    }, ((a)this.bEe).getUsername(), ((a)this.bEe).NI(), this.fpr.fpj.bSe);
    this.fpr.foc.a(this.fpr.fpj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.15
 * JD-Core Version:    0.7.0.1
 */