package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.dyp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;

public final class d
  implements a, MMActivity.a
{
  private c Evb;
  private dyp Evc;
  private boolean Evd;
  private final int Eve;
  private String appId;
  
  public d()
  {
    AppMethodBeat.i(64978);
    this.appId = null;
    this.Eve = (hashCode() & 0xFFFF);
    AppMethodBeat.o(64978);
  }
  
  private void a(dyo paramdyo)
  {
    AppMethodBeat.i(64982);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
    if (this.Evd)
    {
      Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
      AppMethodBeat.o(64982);
      return;
    }
    this.Evd = true;
    new e(paramdyo).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(64982);
  }
  
  private void aE(Intent paramIntent)
  {
    AppMethodBeat.i(64983);
    this.Evd = false;
    if (this.Evb == null)
    {
      AppMethodBeat.o(64983);
      return;
    }
    this.Evb.f(0, paramIntent);
    AppMethodBeat.o(64983);
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64984);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + paramInt1 + "], resultCode = [" + paramInt2 + "], data = [" + paramIntent + "]");
    if (paramInt1 == this.Eve)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        this.Evb.a(b.class, paramIntent, new d.a()
        {
          public final void g(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(64977);
            paramAnonymousIntent = new Intent().putExtra("sendId", d.a(d.this).TNi);
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
      aE(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
    }
    AppMethodBeat.o(64984);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64980);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.Evb == null)
    {
      AppMethodBeat.o(64980);
      return;
    }
    dyo localdyo = new dyo();
    localdyo.appid = this.appId;
    localdyo.EtI = 1;
    localdyo.RDl = paramInt2;
    localdyo.InT = paramInt1;
    localdyo.EtJ = paramString;
    localdyo.Ued = paramInt3;
    a(localdyo);
    AppMethodBeat.o(64980);
  }
  
  public final void f(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64981);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.Evb == null)
    {
      AppMethodBeat.o(64981);
      return;
    }
    dyo localdyo = new dyo();
    localdyo.appid = this.appId;
    localdyo.EtI = 0;
    localdyo.RDl = paramInt2;
    localdyo.Uec = paramInt1;
    localdyo.EtJ = paramString;
    localdyo.Ued = paramInt3;
    a(localdyo);
    AppMethodBeat.o(64981);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64979);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
    this.Evb = null;
    AppMethodBeat.o(64979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d
 * JD-Core Version:    0.7.0.1
 */