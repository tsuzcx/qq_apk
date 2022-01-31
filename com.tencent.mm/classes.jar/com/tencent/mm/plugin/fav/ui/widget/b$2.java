package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$2
  implements View.OnClickListener
{
  public b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74673);
    if (this.mDY.mDX == null)
    {
      AppMethodBeat.o(74673);
      return;
    }
    this.mDY.mDX.bxK();
    AppMethodBeat.o(74673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b.2
 * JD-Core Version:    0.7.0.1
 */