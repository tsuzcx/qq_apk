package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class j$4
  implements View.OnClickListener
{
  j$4(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(56150);
    ad.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
    this.sWY.diY = 0;
    this.sWY.cKy();
    this.sWY.cKJ();
    AppMethodBeat.o(56150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.4
 * JD-Core Version:    0.7.0.1
 */