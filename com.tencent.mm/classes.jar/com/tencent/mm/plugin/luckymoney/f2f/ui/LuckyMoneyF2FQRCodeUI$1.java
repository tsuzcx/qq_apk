package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class LuckyMoneyF2FQRCodeUI$1
  implements bz.a
{
  LuckyMoneyF2FQRCodeUI$1(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(42170);
    parama = br.F(aa.a(parama.eyJ.woR), "sysmsg");
    if (parama != null)
    {
      String str1 = (String)parama.get(".sysmsg.sendId");
      String str2 = (String)parama.get(".sysmsg.username");
      String str3 = (String)parama.get(".sysmsg.amount");
      String str4 = (String)parama.get(".sysmsg.receiveId");
      if (bo.getInt((String)parama.get(".sysmsg.islucky"), 0) > 0) {
        LuckyMoneyF2FQRCodeUI.a(this.olY, str2);
      }
      if (!bo.Q(new String[] { str1, str2, str3 })) {
        this.olY.runOnUiThread(new LuckyMoneyF2FQRCodeUI.1.1(this, str4, str2, str3));
      }
    }
    AppMethodBeat.o(42170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.1
 * JD-Core Version:    0.7.0.1
 */