package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class f$9
  implements View.OnClickListener
{
  public f$9(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134261);
    ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user clicked dialog outside");
    this.jjB.jju = false;
    this.jjB.dismiss();
    AppMethodBeat.o(134261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f.9
 * JD-Core Version:    0.7.0.1
 */