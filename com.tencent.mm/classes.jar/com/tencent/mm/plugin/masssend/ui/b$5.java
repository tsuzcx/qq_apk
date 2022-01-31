package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.masssend.a.f;

final class b$5
  implements DialogInterface.OnCancelListener
{
  b$5(b paramb, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.mbc);
    if (this.mbb.tipDialog != null)
    {
      this.mbb.tipDialog.dismiss();
      this.mbb.tipDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.b.5
 * JD-Core Version:    0.7.0.1
 */