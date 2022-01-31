package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import java.util.HashSet;
import java.util.Iterator;

final class b$1
  implements DialogInterface.OnCancelListener
{
  b$1(b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((this.ftz.ftk != null) && (this.ftz.fti.isEmpty()))
    {
      this.ftz.ftk.dismiss();
      paramDialogInterface = this.ftz.ftj.iterator();
      while (paramDialogInterface.hasNext())
      {
        m localm = (m)paramDialogInterface.next();
        au.Dk().c(localm);
      }
      this.ftz.ftj.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b.1
 * JD-Core Version:    0.7.0.1
 */