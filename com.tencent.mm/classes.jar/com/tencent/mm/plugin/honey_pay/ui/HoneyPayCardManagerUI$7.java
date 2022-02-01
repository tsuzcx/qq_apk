package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class HoneyPayCardManagerUI$7
  implements View.OnClickListener
{
  HoneyPayCardManagerUI$7(HoneyPayCardManagerUI paramHoneyPayCardManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64690);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.ykR.finish();
    a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.7
 * JD-Core Version:    0.7.0.1
 */