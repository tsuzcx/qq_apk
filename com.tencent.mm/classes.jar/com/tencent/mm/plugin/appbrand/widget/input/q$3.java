package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$3
  implements View.OnLongClickListener
{
  q$3(q paramq) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(123700);
    boolean bool = this.jmB.aOP();
    AppMethodBeat.o(123700);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.q.3
 * JD-Core Version:    0.7.0.1
 */