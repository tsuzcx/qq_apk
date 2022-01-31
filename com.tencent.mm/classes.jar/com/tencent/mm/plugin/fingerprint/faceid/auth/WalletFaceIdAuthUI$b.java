package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WalletFaceIdAuthUI$b
  extends WalletFaceIdAuthUI.c
{
  public WalletFaceIdAuthUI$b(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
  {
    super(paramWalletFaceIdAuthUI);
    AppMethodBeat.i(41378);
    com.tencent.mm.plugin.soter.d.a.Ft(1);
    AppMethodBeat.o(41378);
  }
  
  private void byK()
  {
    AppMethodBeat.i(41383);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
    com.tencent.mm.wallet_core.a.b(this.mFs, new Bundle(), 0);
    AppMethodBeat.o(41383);
  }
  
  protected final void byF()
  {
    AppMethodBeat.i(41379);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
    this.mFs.showProgress();
    this.mFr.a(this.mFs, new WalletFaceIdAuthUI.b.1(this), this.gJv);
    AppMethodBeat.o(41379);
  }
  
  public final void byG()
  {
    AppMethodBeat.i(41382);
    byK();
    AppMethodBeat.o(41382);
  }
  
  public final void byH()
  {
    AppMethodBeat.i(41381);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
    byL();
    AppMethodBeat.o(41381);
  }
  
  protected final int byI()
  {
    return 0;
  }
  
  protected final boolean isTransparent()
  {
    return false;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41380);
    if (this.mFr.onSceneEnd(paramInt1, paramInt2, paramString, paramm))
    {
      AppMethodBeat.o(41380);
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
    {
      this.mFs.hideProgress();
      byK();
      Toast.makeText(this.mFs, 2131299969, 0).show();
      AppMethodBeat.o(41380);
      return true;
    }
    AppMethodBeat.o(41380);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.b
 * JD-Core Version:    0.7.0.1
 */