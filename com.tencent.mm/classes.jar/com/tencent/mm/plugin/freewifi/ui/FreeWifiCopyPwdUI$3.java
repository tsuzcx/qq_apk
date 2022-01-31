package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiCopyPwdUI$3
  implements m.a
{
  FreeWifiCopyPwdUI$3(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI) {}
  
  public final void i(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof a)) {
        return;
      }
      paramString = ((a)paramm).aUw();
      if (paramString != null)
      {
        y.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramString.svu, paramString.hRf, paramString.hPY, Integer.valueOf(paramString.syP), paramString.syQ, paramString.ffk, paramString.syR });
        FreeWifiCopyPwdUI.a(this.krr, new FreeWifiCopyPwdUI.b(this.krr, FreeWifiCopyPwdUI.b(this.krr), paramString));
        return;
      }
      y.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
      paramString = this.krr;
      paramm = this.krr;
      paramInt1 = FreeWifiCopyPwdUI.c(this.krr);
      localObject = new FreeWifiCopyPwdUI.a();
      ((FreeWifiCopyPwdUI.a)localObject).kru = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(this.krr), k.b.knf, 21);
      FreeWifiCopyPwdUI.a(paramString, new FreeWifiCopyPwdUI.b(paramm, paramInt1, localObject));
      return;
    }
    if ((com.tencent.mm.plugin.freewifi.m.cS(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString)))
    {
      paramm = this.krr;
      localObject = this.krr;
      paramInt1 = FreeWifiCopyPwdUI.c(this.krr);
      FreeWifiCopyPwdUI.a locala = new FreeWifiCopyPwdUI.a();
      locala.text = paramString;
      locala.kru = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(this.krr), k.b.knf, paramInt2);
      FreeWifiCopyPwdUI.a(paramm, new FreeWifiCopyPwdUI.b((FreeWifiCopyPwdUI)localObject, paramInt1, locala));
      return;
    }
    paramString = this.krr;
    paramm = this.krr;
    paramInt1 = FreeWifiCopyPwdUI.c(this.krr);
    Object localObject = new FreeWifiCopyPwdUI.a();
    ((FreeWifiCopyPwdUI.a)localObject).kru = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(this.krr), k.b.knf, paramInt2);
    FreeWifiCopyPwdUI.a(paramString, new FreeWifiCopyPwdUI.b(paramm, paramInt1, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.3
 * JD-Core Version:    0.7.0.1
 */