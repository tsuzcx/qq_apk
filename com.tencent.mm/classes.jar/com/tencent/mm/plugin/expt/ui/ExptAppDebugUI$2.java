package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;

final class ExptAppDebugUI$2
  implements View.OnClickListener
{
  ExptAppDebugUI$2(ExptAppDebugUI paramExptAppDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(220651);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = ExptAppDebugUI.a(this.sLJ).getText().toString().trim();
    ExptAppDebugUI.a(this.sLJ, Util.getInt(paramView, 0));
    a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(220651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.2
 * JD-Core Version:    0.7.0.1
 */