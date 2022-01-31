package com.tencent.mm.plugin.collect.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class CollectMainUI$2
  implements Runnable
{
  CollectMainUI$2(CollectMainUI paramCollectMainUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(41253);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG))
    {
      e.a((TextView)this.kSz.findViewById(2131821672), this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
      AppMethodBeat.o(41253);
      return;
    }
    ab.i("MicroMsg.CollectMainUI", "no bulletin data");
    AppMethodBeat.o(41253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.2
 * JD-Core Version:    0.7.0.1
 */