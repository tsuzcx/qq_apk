package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity.a;

public final class d
  implements a, MMActivity.a
{
  private String appId;
  c sZL;
  cku sZM;
  boolean sZN;
  final int sZO;
  
  public d()
  {
    AppMethodBeat.i(64978);
    this.appId = null;
    this.sZO = (hashCode() & 0xFFFF);
    AppMethodBeat.o(64978);
  }
  
  private void a(ckt paramckt)
  {
    AppMethodBeat.i(64982);
    ad.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
    if (this.sZN)
    {
      ad.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
      AppMethodBeat.o(64982);
      return;
    }
    this.sZN = true;
    new e(paramckt).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(64982);
  }
  
  final void as(Intent paramIntent)
  {
    AppMethodBeat.i(64983);
    this.sZN = false;
    if (this.sZL == null)
    {
      AppMethodBeat.o(64983);
      return;
    }
    this.sZL.e(0, paramIntent);
    AppMethodBeat.o(64983);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64984);
    ad.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + paramInt1 + "], resultCode = [" + paramInt2 + "], data = [" + paramIntent + "]");
    if (paramInt1 == this.sZO)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        this.sZL.a(b.class, paramIntent, new d.a()
        {
          public final void f(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(64977);
            paramAnonymousIntent = new Intent().putExtra("sendId", d.this.sZM.DSY);
            if (paramAnonymousInt == -1) {
              paramAnonymousIntent.putExtra("result_share_msg", true);
            }
            for (;;)
            {
              d locald = d.this;
              locald.sZN = false;
              if (locald.sZL != null) {
                locald.sZL.e(-1, paramAnonymousIntent);
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
      ad.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
      as(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
    }
    AppMethodBeat.o(64984);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64980);
    ad.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.sZL == null)
    {
      AppMethodBeat.o(64980);
      return;
    }
    ckt localckt = new ckt();
    localckt.dlB = this.appId;
    localckt.sYs = 1;
    localckt.Csl = paramInt2;
    localckt.DTe = paramInt1;
    localckt.sYt = paramString;
    localckt.EfZ = paramInt3;
    a(localckt);
    AppMethodBeat.o(64980);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64981);
    ad.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.sZL == null)
    {
      AppMethodBeat.o(64981);
      return;
    }
    ckt localckt = new ckt();
    localckt.dlB = this.appId;
    localckt.sYs = 0;
    localckt.Csl = paramInt2;
    localckt.EfY = paramInt1;
    localckt.sYt = paramString;
    localckt.EfZ = paramInt3;
    a(localckt);
    AppMethodBeat.o(64981);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64979);
    ad.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
    this.sZL = null;
    AppMethodBeat.o(64979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d
 * JD-Core Version:    0.7.0.1
 */