package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$1
  implements View.OnClickListener
{
  n$1(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(54331);
    a locala = (a)paramView.getTag();
    if (locala == null)
    {
      AppMethodBeat.o(54331);
      return;
    }
    locala.a(paramView, locala);
    AppMethodBeat.o(54331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.n.1
 * JD-Core Version:    0.7.0.1
 */