package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.protocal.protobuf.ers;
import com.tencent.mm.protocal.protobuf.ert;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;

public final class d
  implements a, MMActivity.a
{
  private c KnI;
  private ert KnJ;
  private boolean KnK;
  private final int KnL;
  private String appId;
  
  public d()
  {
    AppMethodBeat.i(64978);
    this.appId = null;
    this.KnL = (hashCode() & 0xFFFF);
    AppMethodBeat.o(64978);
  }
  
  private void a(ers paramers)
  {
    AppMethodBeat.i(64982);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
    if (this.KnK)
    {
      Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
      AppMethodBeat.o(64982);
      return;
    }
    this.KnK = true;
    new e(paramers).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(64982);
  }
  
  private void aZ(Intent paramIntent)
  {
    AppMethodBeat.i(64983);
    this.KnK = false;
    if (this.KnI == null)
    {
      AppMethodBeat.o(64983);
      return;
    }
    this.KnI.i(0, paramIntent);
    AppMethodBeat.o(64983);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64980);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.KnI == null)
    {
      AppMethodBeat.o(64980);
      return;
    }
    ers localers = new ers();
    localers.appid = this.appId;
    localers.Kmp = 1;
    localers.YzO = paramInt2;
    localers.Oll = paramInt1;
    localers.Kmq = paramString;
    localers.abvr = paramInt3;
    a(localers);
    AppMethodBeat.o(64980);
  }
  
  public final void f(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64981);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.KnI == null)
    {
      AppMethodBeat.o(64981);
      return;
    }
    ers localers = new ers();
    localers.appid = this.appId;
    localers.Kmp = 0;
    localers.YzO = paramInt2;
    localers.abvq = paramInt1;
    localers.Kmq = paramString;
    localers.abvr = paramInt3;
    a(localers);
    AppMethodBeat.o(64981);
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64984);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + paramInt1 + "], resultCode = [" + paramInt2 + "], data = [" + paramIntent + "]");
    if (paramInt1 == this.KnL)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        this.KnI.a(b.class, paramIntent, new d.a()
        {
          public final void j(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(64977);
            paramAnonymousIntent = new Intent().putExtra("sendId", d.a(d.this).abdB);
            if (paramAnonymousInt == -1) {
              paramAnonymousIntent.putExtra("result_share_msg", true);
            }
            for (;;)
            {
              d.b(d.this, paramAnonymousIntent);
              AppMethodBeat.o(64977);
              return;
              paramAnonymousIntent.putExtra("result_share_msg", false);
            }
          }
        });
        AppMethodBeat.o(64984);
        return;
      }
      Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
      aZ(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
    }
    AppMethodBeat.o(64984);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64979);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
    this.KnI = null;
    AppMethodBeat.o(64979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d
 * JD-Core Version:    0.7.0.1
 */