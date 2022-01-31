package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.ivr;
    if (((Boolean)paramView.ivp.get(i)).booleanValue()) {
      paramView.ivp.set(i, Boolean.valueOf(false));
    }
    for (;;)
    {
      paramView.notifyDataSetChanged();
      return;
      paramView.ivp.set(i, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.g.1
 * JD-Core Version:    0.7.0.1
 */