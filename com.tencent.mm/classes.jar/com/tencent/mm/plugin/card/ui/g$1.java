package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113472);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/card/ui/CardListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.wCS;
    if (((Boolean)paramView.wCQ.get(i)).booleanValue()) {
      paramView.wCQ.set(i, Boolean.FALSE);
    }
    for (;;)
    {
      paramView.notifyDataSetChanged();
      a.a(this, "com/tencent/mm/plugin/card/ui/CardListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113472);
      return;
      paramView.wCQ.set(i, Boolean.TRUE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g.1
 * JD-Core Version:    0.7.0.1
 */