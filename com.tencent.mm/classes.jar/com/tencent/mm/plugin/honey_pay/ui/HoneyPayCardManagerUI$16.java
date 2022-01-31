package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.wallet_core.c.p.a;

final class HoneyPayCardManagerUI$16
  implements p.a
{
  HoneyPayCardManagerUI$16(HoneyPayCardManagerUI paramHoneyPayCardManagerUI) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41805);
    HoneyPayCardManagerUI.a(this.nIw, HoneyPayCardManagerUI.b(this.nIw));
    if (HoneyPayCardManagerUI.c(this.nIw) != null) {
      HoneyPayCardManagerUI.a(this.nIw, HoneyPayCardManagerUI.QN(HoneyPayCardManagerUI.c(this.nIw).xAC));
    }
    HoneyPayCardManagerUI.d(this.nIw);
    AppMethodBeat.o(41805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.16
 * JD-Core Version:    0.7.0.1
 */