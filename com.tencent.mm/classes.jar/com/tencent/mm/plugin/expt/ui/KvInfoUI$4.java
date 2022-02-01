package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class KvInfoUI$4
  implements View.OnClickListener
{
  KvInfoUI$4(KvInfoUI paramKvInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(299596);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/expt/ui/KvInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = KvInfoUI.a(this.zNZ).getText().toString().trim();
    KvInfoUI.a(this.zNZ, paramView);
    a.a(this, "com/tencent/mm/plugin/expt/ui/KvInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.KvInfoUI.4
 * JD-Core Version:    0.7.0.1
 */