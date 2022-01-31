package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(42188);
    if ((parama == HorizontalListViewV2.d.a.zin) && (LuckyMoneyF2FQRCodeUI.a(this.olY).size() >= 5) && (LuckyMoneyF2FQRCodeUI.a(this.olY).size() < LuckyMoneyF2FQRCodeUI.v(this.olY)) && (LuckyMoneyF2FQRCodeUI.w(this.olY).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(this.olY).size() - 1) && (!bo.isNullOrNil(LuckyMoneyF2FQRCodeUI.u(this.olY))))
    {
      parama = new af(LuckyMoneyF2FQRCodeUI.u(this.olY), 5, LuckyMoneyF2FQRCodeUI.a(this.olY).size(), null, "v1.0");
      this.olY.doSceneProgress(parama);
    }
    AppMethodBeat.o(42188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.14
 * JD-Core Version:    0.7.0.1
 */