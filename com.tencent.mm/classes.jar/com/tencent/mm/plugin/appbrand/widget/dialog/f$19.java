package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class f$19
  implements View.OnClickListener
{
  public f$19(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49883);
    ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user clicked dialog outside");
    this.lYV.KCV = false;
    this.lYV.dismiss();
    AppMethodBeat.o(49883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.19
 * JD-Core Version:    0.7.0.1
 */