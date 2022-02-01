package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class i$1
  implements DialogInterface.OnCancelListener
{
  public i$1(i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(49865);
    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user cancel evaluate dialog");
    this.uCF.uCN = false;
    AppMethodBeat.o(49865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.1
 * JD-Core Version:    0.7.0.1
 */