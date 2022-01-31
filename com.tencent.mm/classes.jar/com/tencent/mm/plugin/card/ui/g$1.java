package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88545);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.kwv;
    if (((Boolean)paramView.kwt.get(i)).booleanValue()) {
      paramView.kwt.set(i, Boolean.FALSE);
    }
    for (;;)
    {
      paramView.notifyDataSetChanged();
      AppMethodBeat.o(88545);
      return;
      paramView.kwt.set(i, Boolean.TRUE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g.1
 * JD-Core Version:    0.7.0.1
 */