package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.ui.base.h;

final class WalletFaceIdAuthUI$a
  extends WalletFaceIdAuthUI.c
{
  public WalletFaceIdAuthUI$a(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
  {
    super(paramWalletFaceIdAuthUI);
    AppMethodBeat.i(41370);
    a.Ft(0);
    AppMethodBeat.o(41370);
  }
  
  private void byJ()
  {
    AppMethodBeat.i(41375);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
    this.mFs.finish();
    AppMethodBeat.o(41375);
  }
  
  protected final void byF()
  {
    AppMethodBeat.i(41372);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
    this.mFs.showProgress();
    this.mFr.a(this.mFs, new WalletFaceIdAuthUI.a.1(this), this.gJv);
    AppMethodBeat.o(41372);
  }
  
  protected final void byG()
  {
    AppMethodBeat.i(41374);
    byJ();
    AppMethodBeat.o(41374);
  }
  
  protected final void byH() {}
  
  protected final int byI()
  {
    return 1;
  }
  
  protected final boolean isTransparent()
  {
    return true;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(41371);
    this.mFs.getWindow().setDimAmount(0.0F);
    super.onCreate();
    this.mFs.hideTitleView();
    this.mFs.hideActionbarLine();
    this.mFs.setContentViewVisibility(8);
    AppMethodBeat.o(41371);
  }
  
  protected final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41373);
    if (this.mFr.onSceneEnd(paramInt1, paramInt2, paramString, paramm))
    {
      AppMethodBeat.o(41373);
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
    {
      this.mFs.hideProgress();
      h.a(this.mFs, this.mFs.getString(2131299652), this.mFs.getString(2131299651), this.mFs.getString(2131305435), false, new WalletFaceIdAuthUI.a.2(this));
      AppMethodBeat.o(41373);
      return true;
    }
    AppMethodBeat.o(41373);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.a
 * JD-Core Version:    0.7.0.1
 */