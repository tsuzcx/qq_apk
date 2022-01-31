package com.tencent.mm.plugin.exdevice.model;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;

final class i$1
  implements DialogInterface.OnCancelListener
{
  i$1(i parami, o paramo, i.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.jvK);
    i.a(this.jvM).dismiss();
    i.b(this.jvM);
    if (this.jvL != null) {
      this.jvL.fB(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i.1
 * JD-Core Version:    0.7.0.1
 */