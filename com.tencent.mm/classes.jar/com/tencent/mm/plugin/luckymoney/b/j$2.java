package com.tencent.mm.plugin.luckymoney.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import java.util.HashSet;
import java.util.Iterator;

final class j$2
  implements DialogInterface.OnCancelListener
{
  j$2(j paramj) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((this.lQF.tipDialog != null) && (this.lQF.fti.isEmpty()))
    {
      this.lQF.tipDialog.dismiss();
      paramDialogInterface = this.lQF.ftj.iterator();
      while (paramDialogInterface.hasNext())
      {
        m localm = (m)paramDialogInterface.next();
        g.DQ();
        g.DO().dJT.c(localm);
      }
      this.lQF.ftj.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.j.2
 * JD-Core Version:    0.7.0.1
 */