package com.tencent.mm.plugin.luckymoney.sns;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$1
  extends g
{
  a$1(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      y.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.bC(this.gfb, this.gfb.getString(a.i.lucky_money_open_sns_pay_success));
        a.tn(121);
        a.a(this.lTu).putBoolean("is_open_sns_pay", true);
        this.lTu.a(this.gfb, 0, a.b(this.lTu));
        return true;
      }
      h.bC(this.gfb, this.gfb.getString(a.i.lucky_money_open_sns_pay_failed));
      a.tn(122);
      this.lTu.b(this.gfb, 0);
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (String)paramVarArgs[0];
    this.wBd.a(new com.tencent.mm.plugin.luckymoney.sns.a.a(1, paramVarArgs, ""), true, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.a.1
 * JD-Core Version:    0.7.0.1
 */