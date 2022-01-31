package com.tencent.mm.plugin.honey_pay.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayMainUI$5
  implements Runnable
{
  HoneyPayMainUI$5(HoneyPayMainUI paramHoneyPayMainUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(41885);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG))
    {
      ab.i(this.nJe.TAG, "show notice banner");
      e.a((TextView)this.nJe.findViewById(2131821672), this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
    }
    AppMethodBeat.o(41885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.5
 * JD-Core Version:    0.7.0.1
 */