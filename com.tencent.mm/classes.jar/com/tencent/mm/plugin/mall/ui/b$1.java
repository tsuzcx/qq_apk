package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43135);
    paramView = this.oyC;
    if (!b.a(this.oyC)) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(paramView, bool);
      b.b(this.oyC);
      this.oyC.notifyDataSetChanged();
      AppMethodBeat.o(43135);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b.1
 * JD-Core Version:    0.7.0.1
 */