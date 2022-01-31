package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$1
  implements View.OnClickListener
{
  public b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74672);
    if (this.mDY.mDX == null)
    {
      AppMethodBeat.o(74672);
      return;
    }
    this.mDY.mDX.bxJ();
    AppMethodBeat.o(74672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b.1
 * JD-Core Version:    0.7.0.1
 */