package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class i$19
  implements View.OnClickListener
{
  public i$19(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49883);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user clicked dialog outside");
    this.uCF.uCN = false;
    this.uCF.dismiss();
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.19
 * JD-Core Version:    0.7.0.1
 */