package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class e$1
  implements View.OnClickListener
{
  e$1(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(131477);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView == this.ngC) {
      e.a(this.ngC);
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(131477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.e.1
 * JD-Core Version:    0.7.0.1
 */