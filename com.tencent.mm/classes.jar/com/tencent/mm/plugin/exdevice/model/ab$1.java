package com.tencent.mm.plugin.exdevice.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.hc;
import com.tencent.mm.model.au;

final class ab$1
  implements DialogInterface.OnCancelListener
{
  ab$1(ab paramab, u paramu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    au.Dk().c(this.jwm);
    if (this.jwn.jwl.bFJ != null)
    {
      this.jwn.jwl.bOX.ret = 1;
      this.jwn.jwl.bFJ.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ab.1
 * JD-Core Version:    0.7.0.1
 */