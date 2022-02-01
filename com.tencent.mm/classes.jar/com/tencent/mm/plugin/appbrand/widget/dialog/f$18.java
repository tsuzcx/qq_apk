package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class f$18
  implements View.OnClickListener
{
  public f$18(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49882);
    ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user clicked dialog close button");
    this.lYV.KCV = false;
    this.lYV.dismiss();
    AppMethodBeat.o(49882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.18
 * JD-Core Version:    0.7.0.1
 */