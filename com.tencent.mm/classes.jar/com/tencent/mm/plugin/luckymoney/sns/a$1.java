package com.tencent.mm.plugin.luckymoney.sns;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42489);
    if ((paramm instanceof com.tencent.mm.plugin.luckymoney.sns.a.a))
    {
      ab.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.bO(this.hwZ, this.hwZ.getString(2131301278));
        a.yr(121);
        a.a(this.oqB).putBoolean("is_open_sns_pay", true);
        this.oqB.a(this.hwZ, 0, a.b(this.oqB));
      }
      for (;;)
      {
        AppMethodBeat.o(42489);
        return true;
        h.bO(this.hwZ, this.hwZ.getString(2131301277));
        a.yr(122);
        this.oqB.e(this.hwZ, 0);
      }
    }
    AppMethodBeat.o(42489);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(42490);
    paramVarArgs = (String)paramVarArgs[0];
    this.AXB.a(new com.tencent.mm.plugin.luckymoney.sns.a.a(1, paramVarArgs, ""), true, 1);
    AppMethodBeat.o(42490);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.a.1
 * JD-Core Version:    0.7.0.1
 */