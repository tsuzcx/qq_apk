package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.a;

public final class WalletFaceIdAuthUI$b
  extends WalletFaceIdAuthUI.c
{
  public WalletFaceIdAuthUI$b(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
  {
    super(paramWalletFaceIdAuthUI);
  }
  
  private void aSr()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
    a.b(this.kkD, new Bundle(), 0);
  }
  
  protected final boolean aSk()
  {
    return false;
  }
  
  protected final void aSm()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
    this.kkD.aEg();
    this.kkC.a(this.kkD, new WalletFaceIdAuthUI.b.1(this), this.frT);
  }
  
  public final void aSn()
  {
    aSr();
  }
  
  public final void aSo()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
    aSs();
  }
  
  protected final int aSp()
  {
    return 0;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (this.kkC.c(paramInt1, paramInt2, paramString, paramm)) {
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
    {
      this.kkD.bka();
      aSr();
      Toast.makeText(this.kkD, a.i.fingerprint_open_success, 0).show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.b
 * JD-Core Version:    0.7.0.1
 */