package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class LuckyMoneyNewYearReceiveUI$6
  implements a.a
{
  LuckyMoneyNewYearReceiveUI$6(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI, ag paramag) {}
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + paramInt1 + ";errCode=" + paramInt2 + ";errMsg=" + paramString + ";hadAgree = " + paramBoolean);
    if (paramInt1 == 1) {
      this.lWq.finish();
    }
    do
    {
      return true;
      if (paramInt1 == 2)
      {
        LuckyMoneyNewYearReceiveUI.a(this.lWq, this.lWu.msgType, this.lWu.bvj, this.lWu.lMg, this.lWu.ceb, this.lWu.lRM);
        return true;
      }
    } while ((paramInt1 != 0) || (!paramBoolean));
    LuckyMoneyNewYearReceiveUI.a(this.lWq, this.lWu.msgType, this.lWu.bvj, this.lWu.lMg, this.lWu.ceb, this.lWu.lRM);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.6
 * JD-Core Version:    0.7.0.1
 */