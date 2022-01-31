package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class f$1
  implements DialogInterface.OnCancelListener
{
  public f$1(f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(134253);
    ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user cancel evaluate dialog");
    this.jjB.jju = false;
    AppMethodBeat.o(134253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f.1
 * JD-Core Version:    0.7.0.1
 */