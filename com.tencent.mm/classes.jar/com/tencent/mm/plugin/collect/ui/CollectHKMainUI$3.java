package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.collect.model.n;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class CollectHKMainUI$3
  implements View.OnClickListener
{
  CollectHKMainUI$3(CollectHKMainUI paramCollectHKMainUI, n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64106);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!bt.isNullOrNil(this.pew.iTI)) {
      e.o(this.pey.getContext(), this.pew.iTI, true);
    }
    a.a(this, "com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectHKMainUI.3
 * JD-Core Version:    0.7.0.1
 */