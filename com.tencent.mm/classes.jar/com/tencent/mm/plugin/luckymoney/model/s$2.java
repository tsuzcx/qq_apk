package com.tencent.mm.plugin.luckymoney.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import java.util.HashSet;
import java.util.Iterator;

final class s$2
  implements DialogInterface.OnCancelListener
{
  s$2(s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42340);
    if ((this.oov.tipDialog != null) && (this.oov.gKK.isEmpty()))
    {
      this.oov.tipDialog.dismiss();
      paramDialogInterface = this.oov.gKL.iterator();
      while (paramDialogInterface.hasNext())
      {
        m localm = (m)paramDialogInterface.next();
        g.RM();
        g.RK().eHt.a(localm);
      }
      this.oov.gKL.clear();
    }
    AppMethodBeat.o(42340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s.2
 * JD-Core Version:    0.7.0.1
 */