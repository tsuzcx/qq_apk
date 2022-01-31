package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class f$5
  implements DialogInterface.OnDismissListener
{
  public f$5(f paramf, Runnable paramRunnable) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(134257);
    ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user dismiss evaluate dialog");
    if (!this.jjB.jju)
    {
      paramDialogInterface = this.jjB;
      cnl localcnl = new cnl();
      localcnl.username = paramDialogInterface.userName;
      localcnl.xWx = 4;
      ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "reportSkipEvaluate, userName:%s", new Object[] { paramDialogInterface.userName });
      paramDialogInterface.a(localcnl);
    }
    paramDialogInterface = this.val$runnable;
    if (paramDialogInterface != null) {
      al.p(paramDialogInterface, 100L);
    }
    AppMethodBeat.o(134257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f.5
 * JD-Core Version:    0.7.0.1
 */