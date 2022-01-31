package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.protocal.c.blq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;

public final class d
  implements a, MMActivity.a
{
  private String appId = null;
  c lMF;
  blq lMG;
  boolean lMH;
  final int lMI = hashCode() & 0xFFFF;
  
  private void a(blp paramblp)
  {
    y.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
    if (this.lMH)
    {
      y.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
      return;
    }
    this.lMH = true;
    new e(paramblp).b(new d.1(this));
  }
  
  final void L(Intent paramIntent)
  {
    this.lMH = false;
    if (this.lMF == null) {
      return;
    }
    this.lMF.b(0, paramIntent);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + paramInt1 + "], resultCode = [" + paramInt2 + "], data = [" + paramIntent + "]");
    if (paramInt1 == this.lMI)
    {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        this.lMF.a(b.class, paramIntent, new d.2(this));
      }
    }
    else {
      return;
    }
    y.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
    L(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    y.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.lMF == null) {
      return;
    }
    blp localblp = new blp();
    localblp.bOL = this.appId;
    localblp.lLl = 1;
    localblp.srt = paramInt2;
    localblp.txB = paramInt1;
    localblp.lLm = paramString;
    localblp.tFe = paramInt3;
    a(localblp);
  }
  
  public final void d(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    y.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + paramInt1 + "], packageAmount = [" + paramInt2 + "], wishing = [" + paramString + "], scope = [" + paramInt3 + "]");
    if (this.lMF == null) {
      return;
    }
    blp localblp = new blp();
    localblp.bOL = this.appId;
    localblp.lLl = 0;
    localblp.srt = paramInt2;
    localblp.tFd = paramInt1;
    localblp.lLm = paramString;
    localblp.tFe = paramInt3;
    a(localblp);
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
    this.lMF = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d
 * JD-Core Version:    0.7.0.1
 */