package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w$2
  implements View.OnClickListener
{
  w$2(w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(123768);
    if (paramView.isSelected())
    {
      w.aRn().o(this.jnq);
      paramView.setSelected(false);
      AppMethodBeat.o(123768);
      return;
    }
    w.aRn().p(this.jnq);
    paramView.setSelected(true);
    AppMethodBeat.o(123768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w.2
 * JD-Core Version:    0.7.0.1
 */