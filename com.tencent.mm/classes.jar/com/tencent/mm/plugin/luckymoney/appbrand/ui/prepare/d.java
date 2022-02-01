package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;

public final class d
  implements a, MMActivity.a
{
  private String appId;
  c yRd;
  dot yRe;
  boolean yRf;
  final int yRg;
  
  public d()
  {
    AppMethodBeat.i(64978);
    this.appId = null;
    this.yRg = (hashCode() & 0xFFFF);
    AppMethodBeat.o(64978);
  }
  
  private void a(dos paramdos)
  {
    AppMethodBeat.i(64982);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
    if (this.yRf)
    {
      Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
      AppMethodBeat.o(64982);
      return;
    }
    this.yRf = true;
    new e(paramdos).b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(64982);
  }
  
  final void aG(Intent paramIntent)
  {
    AppMethodBeat.i(64983);
    this.yRf = false;
    if (this.yRd == null)
    {
      AppMethodBeat.o(64983);
      return;
    }
    this.yRd.f(0, paramIntent);
    AppMethodBeat.o(64983);
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64984);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + paramInt1 + "], resultCode = [" + paramInt2 + "], data = [" + paramIntent + "]");
    if (paramInt1 == this.yRg)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        this.yRd.a(b.class, paramIntent, new d.a()
        {
          public final void g(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(64977);
            paramAnonymousIntent = new Intent().putExtra("sendId", d.this.yRe.MBB);
            if (paramAnonymousInt == -1) {
              paramAnonymousIntent.putExtra("result_share_msg", true);
            }
            for (;;)
            {
              d locald = d.this;
              locald.yRf = false;
              if (locald.yRd != null) {
                locald.yRd.f(-1, paramAnonymousIntent);
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
      Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
      aG(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
    }
    AppMethodBeat.o(64984);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64980);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.yRd == null)
    {
      AppMethodBeat.o(64980);
      return;
    }
    dos localdos = new dos();
    localdos.dNI = this.appId;
    localdos.yPJ = 1;
    localdos.KBv = paramInt2;
    localdos.MBH = paramInt1;
    localdos.yPK = paramString;
    localdos.MRW = paramInt3;
    a(localdos);
    AppMethodBeat.o(64980);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(64981);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.yRd == null)
    {
      AppMethodBeat.o(64981);
      return;
    }
    dos localdos = new dos();
    localdos.dNI = this.appId;
    localdos.yPJ = 0;
    localdos.KBv = paramInt2;
    localdos.MRV = paramInt1;
    localdos.yPK = paramString;
    localdos.MRW = paramInt3;
    a(localdos);
    AppMethodBeat.o(64981);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(64979);
    Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
    this.yRd = null;
    AppMethodBeat.o(64979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d
 * JD-Core Version:    0.7.0.1
 */