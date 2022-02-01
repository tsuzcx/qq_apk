package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.protocal.protobuf.cvz;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity.a;

public final class d
  implements a, MMActivity.a
{
  private String appId;
  c vwO;
  cwa vwP;
  boolean vwQ;
  final int vwR;
  
  public d()
  {
    AppMethodBeat.i(64978);
    this.appId = null;
    this.vwR = (hashCode() & 0xFFFF);
    AppMethodBeat.o(64978);
  }
  
  private void a(cvz paramcvz)
  {
    AppMethodBeat.i(64982);
    ae.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
    if (this.vwQ)
    {
      ae.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
      AppMethodBeat.o(64982);
      return;
    }
    this.vwQ = true;
    new e(paramcvz).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(64982);
  }
  
  final void az(Intent paramIntent)
  {
    AppMethodBeat.i(64983);
    this.vwQ = false;
    if (this.vwO == null)
    {
      AppMethodBeat.o(64983);
      return;
    }
    this.vwO.f(0, paramIntent);
    AppMethodBeat.o(64983);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64984);
    ae.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + paramInt1 + "], resultCode = [" + paramInt2 + "], data = [" + paramIntent + "]");
    if (paramInt1 == this.vwR)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        this.vwO.a(b.class, paramIntent, new d.a()
        {
          public final void g(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(64977);
            paramAnonymousIntent = new Intent().putExtra("sendId", d.this.vwP.HsF);
            if (paramAnonymousInt == -1) {
              paramAnonymousIntent.putExtra("result_share_msg", true);
            }
            for (;;)
            {
              d locald = d.this;
              locald.vwQ = false;
              if (locald.vwO != null) {
                locald.vwO.f(-1, paramAnonymousIntent);
              }
              AppMethodBeat.o(64977);
              return;
              paramAnonymousIntent.putExtra("result_share_msg", false);
            }
          }
        });
        AppMethodBeat.o(64984);
        return;
      }
      ae.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
      az(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
    }
    AppMethodBeat.o(64984);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64980);
    ae.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.vwO == null)
    {
      AppMethodBeat.o(64980);
      return;
    }
    cvz localcvz = new cvz();
    localcvz.dwb = this.appId;
    localcvz.vvv = 1;
    localcvz.FIh = paramInt2;
    localcvz.HsL = paramInt1;
    localcvz.vvw = paramString;
    localcvz.HGM = paramInt3;
    a(localcvz);
    AppMethodBeat.o(64980);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64981);
    ae.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.vwO == null)
    {
      AppMethodBeat.o(64981);
      return;
    }
    cvz localcvz = new cvz();
    localcvz.dwb = this.appId;
    localcvz.vvv = 0;
    localcvz.FIh = paramInt2;
    localcvz.HGL = paramInt1;
    localcvz.vvw = paramString;
    localcvz.HGM = paramInt3;
    a(localcvz);
    AppMethodBeat.o(64981);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64979);
    ae.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
    this.vwO = null;
    AppMethodBeat.o(64979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d
 * JD-Core Version:    0.7.0.1
 */