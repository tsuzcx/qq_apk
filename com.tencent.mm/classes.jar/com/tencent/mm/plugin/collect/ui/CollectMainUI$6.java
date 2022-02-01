package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;

final class CollectMainUI$6
  implements View.OnClickListener
{
  CollectMainUI$6(CollectMainUI paramCollectMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(277523);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (!Util.isNullOrNil(CollectMainUI.v(this.uaM))) {
      g.p(MMApplicationContext.getContext(), CollectMainUI.v(this.uaM), true);
    }
    a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.6
 * JD-Core Version:    0.7.0.1
 */