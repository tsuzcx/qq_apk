package com.tencent.mm.plugin.fingerprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class SoterPayTestUI$1
  implements View.OnClickListener
{
  SoterPayTestUI$1(SoterPayTestUI paramSoterPayTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41662);
    ab.i("MicroMsg.SoterPayTestUI", "hy: start get challenge");
    g.RM();
    g.RK().eHt.a(1586, this.mHb);
    g.RM();
    g.RK().eHt.a(new a(0), 0);
    AppMethodBeat.o(41662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI.1
 * JD-Core Version:    0.7.0.1
 */