package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.bpd;

final class HoneyPayMainUI$7
  implements View.OnClickListener
{
  HoneyPayMainUI$7(HoneyPayMainUI paramHoneyPayMainUI, bpd parambpd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64776);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    HoneyPayMainUI.a(this.uSW, this.uTa.GSy, this.uTa.oFF);
    a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.7
 * JD-Core Version:    0.7.0.1
 */