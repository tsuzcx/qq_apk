package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$6
  implements View.OnClickListener
{
  c$6(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74549);
    this.mCh.mBW.wc(((Integer)paramView.getTag()).intValue());
    AppMethodBeat.o(74549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c.6
 * JD-Core Version:    0.7.0.1
 */