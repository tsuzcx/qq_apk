package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class f$20
  implements View.OnClickListener
{
  public f$20(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49884);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "user clicked dialog inside");
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.20
 * JD-Core Version:    0.7.0.1
 */