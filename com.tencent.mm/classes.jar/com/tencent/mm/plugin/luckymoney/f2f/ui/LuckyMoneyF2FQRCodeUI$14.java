package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.HorizontalListViewV2.d;
import com.tencent.mm.ui.base.HorizontalListViewV2.d.a;
import java.util.List;

final class LuckyMoneyF2FQRCodeUI$14
  implements HorizontalListViewV2.d
{
  LuckyMoneyF2FQRCodeUI$14(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void a(HorizontalListViewV2.d.a parama)
  {
    if ((parama == HorizontalListViewV2.d.a.uTN) && (LuckyMoneyF2FQRCodeUI.a(this.lOE).size() >= 5) && (LuckyMoneyF2FQRCodeUI.a(this.lOE).size() < LuckyMoneyF2FQRCodeUI.v(this.lOE)) && (LuckyMoneyF2FQRCodeUI.w(this.lOE).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(this.lOE).size() - 1) && (!bk.bl(LuckyMoneyF2FQRCodeUI.u(this.lOE))))
    {
      parama = new w(LuckyMoneyF2FQRCodeUI.u(this.lOE), 5, LuckyMoneyF2FQRCodeUI.a(this.lOE).size(), null, "v1.0");
      this.lOE.l(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.14
 * JD-Core Version:    0.7.0.1
 */