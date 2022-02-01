package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

final class CollectMainUI$6
  implements View.OnClickListener
{
  CollectMainUI$6(CollectMainUI paramCollectMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213196);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!Util.isNullOrNil(CollectMainUI.v(this.qBM))) {
      f.p(MMApplicationContext.getContext(), CollectMainUI.v(this.qBM), true);
    }
    a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.6
 * JD-Core Version:    0.7.0.1
 */