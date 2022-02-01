package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.aed;

final class CollectMainUI$16
  implements View.OnClickListener
{
  CollectMainUI$16(CollectMainUI paramCollectMainUI, aed paramaed) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(271269);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    CollectMainUI.d(this.uaM, 3);
    CollectMainUI.a(this.uaM, this.uaR.SqM);
    a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(271269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.16
 * JD-Core Version:    0.7.0.1
 */