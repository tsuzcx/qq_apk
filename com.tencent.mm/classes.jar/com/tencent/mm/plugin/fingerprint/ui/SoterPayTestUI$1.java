package com.tencent.mm.plugin.fingerprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class SoterPayTestUI$1
  implements View.OnClickListener
{
  SoterPayTestUI$1(SoterPayTestUI paramSoterPayTestUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.SoterPayTestUI", "hy: start get challenge");
    g.DQ();
    g.DO().dJT.a(1586, this.kml);
    g.DQ();
    g.DO().dJT.a(new a(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI.1
 * JD-Core Version:    0.7.0.1
 */