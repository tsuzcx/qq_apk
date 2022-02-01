package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.gnm;

public final class i$3
  implements View.OnClickListener
{
  public i$3(i parami, w paramw, gnm paramgnm, Runnable paramRunnable) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49867);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    i.a(this.uCF, this.qrd, this.uEQ);
    this.uCF.dismiss();
    this.uCH.run();
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.3
 * JD-Core Version:    0.7.0.1
 */