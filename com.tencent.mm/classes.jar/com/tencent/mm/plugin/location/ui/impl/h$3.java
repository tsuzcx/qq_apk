package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$3
  implements View.OnClickListener
{
  h$3(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113697);
    ab.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
    this.ohE.cud = 0;
    this.ohE.bMt();
    this.ohE.bMD();
    AppMethodBeat.o(113697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.3
 * JD-Core Version:    0.7.0.1
 */