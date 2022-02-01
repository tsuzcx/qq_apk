package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.v;

final class j$2
  implements View.OnClickListener
{
  j$2(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113549);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/card/ui/CardPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((this.wEi.qjH != null) && (this.wEi.qjH.isShowing())) {
      this.wEi.qjH.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/card/ui/CardPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(113549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j.2
 * JD-Core Version:    0.7.0.1
 */