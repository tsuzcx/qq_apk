package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.report.service.h;

final class g$7
  implements View.OnClickListener
{
  g$7(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155626);
    this.ohw.ohh.bLG();
    this.ohw.ohj.oez = true;
    this.ohw.ohj.a(this.ohw.ofo.ocA);
    this.ohw.ohj.iT(false);
    h.qsU.e(10997, new Object[] { "6", "", Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(155626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.7
 * JD-Core Version:    0.7.0.1
 */