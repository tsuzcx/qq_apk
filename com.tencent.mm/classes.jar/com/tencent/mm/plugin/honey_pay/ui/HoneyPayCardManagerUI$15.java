package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.wallet_core.c.p.a;

final class HoneyPayCardManagerUI$15
  implements p.a
{
  HoneyPayCardManagerUI$15(HoneyPayCardManagerUI paramHoneyPayCardManagerUI) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41804);
    HoneyPayCardManagerUI.a(this.nIw, HoneyPayCardManagerUI.b(this.nIw));
    if (HoneyPayCardManagerUI.c(this.nIw) != null) {
      HoneyPayCardManagerUI.a(this.nIw, HoneyPayCardManagerUI.QN(HoneyPayCardManagerUI.c(this.nIw).xAC));
    }
    HoneyPayCardManagerUI.d(this.nIw);
    AppMethodBeat.o(41804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.15
 * JD-Core Version:    0.7.0.1
 */