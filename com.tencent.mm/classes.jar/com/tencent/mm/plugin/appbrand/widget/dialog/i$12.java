package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fsp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class i$12
  implements DialogInterface.OnDismissListener
{
  public i$12(i parami, Runnable paramRunnable) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(49876);
    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user dismiss evaluate dialog");
    if (!this.uCF.uCN)
    {
      paramDialogInterface = this.uCF;
      fsp localfsp = new fsp();
      localfsp.username = paramDialogInterface.userName;
      localfsp.abRe = 4;
      Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "reportSkipEvaluate, userName:%s", new Object[] { paramDialogInterface.userName });
      paramDialogInterface.a(localfsp);
    }
    paramDialogInterface = this.val$runnable;
    if (paramDialogInterface != null) {
      MMHandlerThread.postToMainThreadDelayed(paramDialogInterface, 100L);
    }
    AppMethodBeat.o(49876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.12
 * JD-Core Version:    0.7.0.1
 */