package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.e;

final class LaunchAAUI$8
  implements o.f
{
  LaunchAAUI$8(LaunchAAUI paramLaunchAAUI, e parame, View paramView) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(213027);
    paramm.clear();
    this.gwC.setFooterView(null);
    this.gwC.setFooterView(this.jXU);
    AppMethodBeat.o(213027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.8
 * JD-Core Version:    0.7.0.1
 */