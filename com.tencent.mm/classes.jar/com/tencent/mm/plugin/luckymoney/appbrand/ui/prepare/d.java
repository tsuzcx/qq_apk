package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

public final class d
  implements a, MMActivity.a
{
  private String appId;
  c ojY;
  bvc ojZ;
  boolean oka;
  final int okb;
  
  public d()
  {
    AppMethodBeat.i(42091);
    this.appId = null;
    this.okb = (hashCode() & 0xFFFF);
    AppMethodBeat.o(42091);
  }
  
  private void a(bvb parambvb)
  {
    AppMethodBeat.i(42095);
    ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
    if (this.oka)
    {
      ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
      AppMethodBeat.o(42095);
      return;
    }
    this.oka = true;
    new e(parambvb).b(new d.1(this));
    AppMethodBeat.o(42095);
  }
  
  final void ae(Intent paramIntent)
  {
    AppMethodBeat.i(42096);
    this.oka = false;
    if (this.ojY == null)
    {
      AppMethodBeat.o(42096);
      return;
    }
    this.ojY.e(0, paramIntent);
    AppMethodBeat.o(42096);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(42097);
    ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + paramInt1 + "], resultCode = [" + paramInt2 + "], data = [" + paramIntent + "]");
    if (paramInt1 == this.okb)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        this.ojY.a(b.class, paramIntent, new d.2(this));
        AppMethodBeat.o(42097);
        return;
      }
      ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
      ae(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
    }
    AppMethodBeat.o(42097);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(42093);
    ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.ojY == null)
    {
      AppMethodBeat.o(42093);
      return;
    }
    bvb localbvb = new bvb();
    localbvb.cwc = this.appId;
    localbvb.oiF = 1;
    localbvb.wjZ = paramInt2;
    localbvb.xxH = paramInt1;
    localbvb.oiG = paramString;
    localbvb.xIK = paramInt3;
    a(localbvb);
    AppMethodBeat.o(42093);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(42094);
    ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.ojY == null)
    {
      AppMethodBeat.o(42094);
      return;
    }
    bvb localbvb = new bvb();
    localbvb.cwc = this.appId;
    localbvb.oiF = 0;
    localbvb.wjZ = paramInt2;
    localbvb.xIJ = paramInt1;
    localbvb.oiG = paramString;
    localbvb.xIK = paramInt3;
    a(localbvb);
    AppMethodBeat.o(42094);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(42092);
    ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
    this.ojY = null;
    AppMethodBeat.o(42092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d
 * JD-Core Version:    0.7.0.1
 */