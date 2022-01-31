package com.tencent.mm.plugin.clean.ui.fileindexui;

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
    AppMethodBeat.i(18739);
    if (a.a(this.kHG).contains(Integer.valueOf(this.lU))) {
      a.a(this.kHG).remove(Integer.valueOf(this.lU));
    }
    for (;;)
    {
      this.kHG.notifyDataSetChanged();
      a.b(this.kHG).a(a.a(this.kHG));
      AppMethodBeat.o(18739);
      return;
      a.a(this.kHG).add(Integer.valueOf(this.lU));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.a.1
 * JD-Core Version:    0.7.0.1
 */