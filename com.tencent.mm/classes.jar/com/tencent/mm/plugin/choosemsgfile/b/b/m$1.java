package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$1
  implements View.OnClickListener
{
  m$1(m paramm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(54327);
    a locala = (a)paramView.getTag();
    if (locala == null)
    {
      AppMethodBeat.o(54327);
      return;
    }
    locala.a(paramView, locala);
    AppMethodBeat.o(54327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.m.1
 * JD-Core Version:    0.7.0.1
 */