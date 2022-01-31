package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.view.Window;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class WalletFaceIdAuthUI$a
  extends WalletFaceIdAuthUI.c
{
  public WalletFaceIdAuthUI$a(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
  {
    super(paramWalletFaceIdAuthUI);
  }
  
  private void aSq()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
    this.kkD.finish();
  }
  
  protected final boolean aSk()
  {
    return true;
  }
  
  protected final void aSm()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
    this.kkD.aEg();
    this.kkC.a(this.kkD, new WalletFaceIdAuthUI.a.1(this), this.frT);
  }
  
  protected final void aSn()
  {
    aSq();
  }
  
  protected final void aSo() {}
  
  protected final int aSp()
  {
    return 1;
  }
  
  protected final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    boolean bool = false;
    if (this.kkC.c(paramInt1, paramInt2, paramString, paramm)) {
      bool = true;
    }
    while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.y)) {
      return bool;
    }
    this.kkD.bka();
    h.a(this.kkD, this.kkD.getString(a.i.faceid_open_success_msg_text), this.kkD.getString(a.i.faceid_open_success), this.kkD.getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_known_btn), false, new WalletFaceIdAuthUI.a.2(this));
    return true;
  }
  
  public final void onCreate()
  {
    this.kkD.getWindow().setDimAmount(0.0F);
    super.onCreate();
    this.kkD.mController.hideTitleView();
    this.kkD.czo();
    this.kkD.vN(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.a
 * JD-Core Version:    0.7.0.1
 */