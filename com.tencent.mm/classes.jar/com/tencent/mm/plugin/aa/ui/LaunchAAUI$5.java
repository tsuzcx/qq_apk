package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.e;

final class LaunchAAUI$5
  implements n.c
{
  LaunchAAUI$5(LaunchAAUI paramLaunchAAUI, e parame, View paramView) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(63632);
    paraml.clear();
    this.iEb.setFooterView(null);
    this.iEb.setFooterView(this.iEc);
    AppMethodBeat.o(63632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.5
 * JD-Core Version:    0.7.0.1
 */