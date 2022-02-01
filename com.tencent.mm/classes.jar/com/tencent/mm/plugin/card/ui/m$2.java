package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

final class m$2
  implements View.OnClickListener
{
  m$2(m paramm, com.tencent.mm.plugin.card.model.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113611);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/card/ui/CellAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (((CheckBox)paramView).isChecked()) {}
    for (this.oQK.dLH = true;; this.oQK.dLH = false)
    {
      a.a(this, "com/tencent/mm/plugin/card/ui/CellAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113611);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m.2
 * JD-Core Version:    0.7.0.1
 */