package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import java.util.Map;

final class LuckyMoneyF2FQRCodeUI$1
  implements bx.a
{
  LuckyMoneyF2FQRCodeUI$1(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void a(e.a parama)
  {
    parama = bn.s(aa.a(parama.dBs.svH), "sysmsg");
    if (parama != null)
    {
      String str1 = (String)parama.get(".sysmsg.sendId");
      String str2 = (String)parama.get(".sysmsg.username");
      String str3 = (String)parama.get(".sysmsg.amount");
      String str4 = (String)parama.get(".sysmsg.receiveId");
      if (bk.getInt((String)parama.get(".sysmsg.islucky"), 0) > 0) {
        LuckyMoneyF2FQRCodeUI.a(this.lOE, str2);
      }
      if (!bk.H(new String[] { str1, str2, str3 })) {
        this.lOE.runOnUiThread(new LuckyMoneyF2FQRCodeUI.1.1(this, str4, str2, str3));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.1
 * JD-Core Version:    0.7.0.1
 */