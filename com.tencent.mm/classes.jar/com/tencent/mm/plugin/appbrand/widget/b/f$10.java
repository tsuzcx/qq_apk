package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class f$10
  implements View.OnClickListener
{
  public f$10(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134262);
    ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user clicked dialog inside");
    AppMethodBeat.o(134262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f.10
 * JD-Core Version:    0.7.0.1
 */