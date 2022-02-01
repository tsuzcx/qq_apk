package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity.a;

public final class d
  implements a, MMActivity.a
{
  private String appId;
  c uhZ;
  cqb uia;
  boolean uib;
  final int uic;
  
  public d()
  {
    AppMethodBeat.i(64978);
    this.appId = null;
    this.uic = (hashCode() & 0xFFFF);
    AppMethodBeat.o(64978);
  }
  
  private void a(cqa paramcqa)
  {
    AppMethodBeat.i(64982);
    ac.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
    if (this.uib)
    {
      ac.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
      AppMethodBeat.o(64982);
      return;
    }
    this.uib = true;
    new e(paramcqa).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(64982);
  }
  
  final void at(Intent paramIntent)
  {
    AppMethodBeat.i(64983);
    this.uib = false;
    if (this.uhZ == null)
    {
      AppMethodBeat.o(64983);
      return;
    }
    this.uhZ.f(0, paramIntent);
    AppMethodBeat.o(64983);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64984);
    ac.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + paramInt1 + "], resultCode = [" + paramInt2 + "], data = [" + paramIntent + "]");
    if (paramInt1 == this.uic)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        this.uhZ.a(b.class, paramIntent, new d.a()
        {
          public final void g(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(64977);
            paramAnonymousIntent = new Intent().putExtra("sendId", d.this.uia.Fpu);
            if (paramAnonymousInt == -1) {
              paramAnonymousIntent.putExtra("result_share_msg", true);
            }
            for (;;)
            {
              d locald = d.this;
              locald.uib = false;
              if (locald.uhZ != null) {
                locald.uhZ.f(-1, paramAnonymousIntent);
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
      ac.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
      at(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
    }
    AppMethodBeat.o(64984);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64980);
    ac.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.uhZ == null)
    {
      AppMethodBeat.o(64980);
      return;
    }
    cqa localcqa = new cqa();
    localcqa.djj = this.appId;
    localcqa.ugG = 1;
    localcqa.DKD = paramInt2;
    localcqa.FpA = paramInt1;
    localcqa.ugH = paramString;
    localcqa.FCZ = paramInt3;
    a(localcqa);
    AppMethodBeat.o(64980);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64981);
    ac.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.uhZ == null)
    {
      AppMethodBeat.o(64981);
      return;
    }
    cqa localcqa = new cqa();
    localcqa.djj = this.appId;
    localcqa.ugG = 0;
    localcqa.DKD = paramInt2;
    localcqa.FCY = paramInt1;
    localcqa.ugH = paramString;
    localcqa.FCZ = paramInt3;
    a(localcqa);
    AppMethodBeat.o(64981);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64979);
    ac.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
    this.uhZ = null;
    AppMethodBeat.o(64979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d
 * JD-Core Version:    0.7.0.1
 */