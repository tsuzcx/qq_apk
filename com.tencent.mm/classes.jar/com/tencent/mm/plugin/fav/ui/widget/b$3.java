package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$3
  implements View.OnClickListener
{
  public b$3(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74674);
    if (this.mDY.mDX == null)
    {
      AppMethodBeat.o(74674);
      return;
    }
    this.mDY.mDX.bxs();
    AppMethodBeat.o(74674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b.3
 * JD-Core Version:    0.7.0.1
 */