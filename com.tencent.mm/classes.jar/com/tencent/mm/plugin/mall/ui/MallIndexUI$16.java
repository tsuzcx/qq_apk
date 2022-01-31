package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class MallIndexUI$16
  implements Runnable
{
  MallIndexUI$16(MallIndexUI paramMallIndexUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(43221);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG)) {
      e.a(this.oAt.ozv, this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
    }
    AppMethodBeat.o(43221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.16
 * JD-Core Version:    0.7.0.1
 */