package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import java.util.HashSet;
import java.util.Iterator;

final class b$1
  implements DialogInterface.OnCancelListener
{
  b$1(b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(16778);
    if ((this.gLb.gKM != null) && (this.gLb.gKK.isEmpty()))
    {
      this.gLb.gKM.dismiss();
      paramDialogInterface = this.gLb.gKL.iterator();
      while (paramDialogInterface.hasNext())
      {
        m localm = (m)paramDialogInterface.next();
        aw.Rc().a(localm);
      }
      this.gLb.gKL.clear();
    }
    AppMethodBeat.o(16778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b.1
 * JD-Core Version:    0.7.0.1
 */