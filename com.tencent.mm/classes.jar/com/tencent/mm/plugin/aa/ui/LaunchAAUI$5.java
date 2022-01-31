package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class LaunchAAUI$5
  implements View.OnClickListener
{
  LaunchAAUI$5(LaunchAAUI paramLaunchAAUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40827);
    this.grm.hideTenpayKB();
    this.grm.hideVKB();
    LaunchAAUI.a(this.grm, this.grn);
    AppMethodBeat.o(40827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.5
 * JD-Core Version:    0.7.0.1
 */