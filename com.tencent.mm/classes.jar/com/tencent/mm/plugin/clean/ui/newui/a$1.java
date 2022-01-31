package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18840);
    if (a.a(this.kJc).contains(Integer.valueOf(this.lU))) {
      a.a(this.kJc).remove(Integer.valueOf(this.lU));
    }
    for (;;)
    {
      this.kJc.notifyDataSetChanged();
      a.b(this.kJc).a(a.a(this.kJc));
      AppMethodBeat.o(18840);
      return;
      a.a(this.kJc).add(Integer.valueOf(this.lU));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.a.1
 * JD-Core Version:    0.7.0.1
 */