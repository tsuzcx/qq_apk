package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class CollectBillListUI$5
  implements View.OnClickListener
{
  CollectBillListUI$5(CollectBillListUI paramCollectBillListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64051);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/collect/ui/CollectBillListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    CollectBillListUI.d(this.qzO).dismiss();
    a.a(this, "com/tencent/mm/plugin/collect/ui/CollectBillListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillListUI.5
 * JD-Core Version:    0.7.0.1
 */