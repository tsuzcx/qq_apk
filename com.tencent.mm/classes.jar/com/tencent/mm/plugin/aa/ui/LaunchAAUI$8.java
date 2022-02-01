package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.widget.a.e;

final class LaunchAAUI$8
  implements q.f
{
  LaunchAAUI$8(LaunchAAUI paramLaunchAAUI, e parame, View paramView) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(213850);
    paramo.clear();
    this.jaP.setFooterView(null);
    this.jaP.setFooterView(this.mPk);
    AppMethodBeat.o(213850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.8
 * JD-Core Version:    0.7.0.1
 */