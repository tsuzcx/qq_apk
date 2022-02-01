package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class CollectMainUI$6
  implements View.OnClickListener
{
  CollectMainUI$6(CollectMainUI paramCollectMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(198953);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (!bt.isNullOrNil(CollectMainUI.v(this.pfO))) {
      e.o(aj.getContext(), CollectMainUI.v(this.pfO), true);
    }
    a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(198953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.6
 * JD-Core Version:    0.7.0.1
 */