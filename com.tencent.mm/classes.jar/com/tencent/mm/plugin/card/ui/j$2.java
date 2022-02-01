package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.o;

final class j$2
  implements View.OnClickListener
{
  j$2(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113549);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/card/ui/CardPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((this.oQc.jwx != null) && (this.oQc.jwx.isShowing())) {
      this.oQc.jwx.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/card/ui/CardPopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(113549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j.2
 * JD-Core Version:    0.7.0.1
 */