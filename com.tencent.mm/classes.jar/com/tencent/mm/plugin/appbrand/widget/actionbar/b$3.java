package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements View.OnLongClickListener
{
  b$3(b paramb, View.OnLongClickListener paramOnLongClickListener) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(141714);
    if (this.jbt != null)
    {
      boolean bool = this.jbt.onLongClick(paramView);
      AppMethodBeat.o(141714);
      return bool;
    }
    AppMethodBeat.o(141714);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.3
 * JD-Core Version:    0.7.0.1
 */