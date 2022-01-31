package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74676);
    if ((c.a(this.mEg) == 1) || (c.a(this.mEg) == 3))
    {
      ab.i("MicroMsg.FavHeaderView", "click clear fav item");
      if (c.b(this.mEg) != null) {
        c.b(this.mEg).bxI();
      }
    }
    AppMethodBeat.o(74676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c.1
 * JD-Core Version:    0.7.0.1
 */