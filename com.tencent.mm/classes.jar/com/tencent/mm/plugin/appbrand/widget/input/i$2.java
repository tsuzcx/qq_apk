package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$2
  implements View.OnClickListener
{
  i$2(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141602);
    if (this.jlw.jll == null)
    {
      AppMethodBeat.o(141602);
      return;
    }
    if (this.jlw.jll.hasFocus())
    {
      i.d(this.jlw);
      AppMethodBeat.o(141602);
      return;
    }
    if (this.jlw.jll == paramView) {
      i.e(this.jlw);
    }
    AppMethodBeat.o(141602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.2
 * JD-Core Version:    0.7.0.1
 */