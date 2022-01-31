package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(41592);
    ab.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(41592);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(41596);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new a.1(this, paramMMActivity, parami);
      AppMethodBeat.o(41596);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(41596);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(41593);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      ab.i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
      if (this.mEJ.getInt("key_open_biometric_type") == 1)
      {
        b(paramActivity, FingerPrintAuthUI.class, paramBundle);
        AppMethodBeat.o(41593);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_scene", 0);
      a(paramActivity, WalletFaceIdAuthUI.class, paramBundle, localBundle);
      AppMethodBeat.o(41593);
      return;
    }
    if ((paramActivity instanceof FingerPrintAuthUI))
    {
      b(paramActivity, paramBundle);
      AppMethodBeat.o(41593);
      return;
    }
    if ((paramActivity instanceof WalletFaceIdAuthUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(41593);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(41595);
    paramBundle = new Intent();
    ab.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
    a(paramActivity, "wallet", ".pwd.ui.WalletBiometricPaySettingsUI", 0, paramBundle, true);
    AppMethodBeat.o(41595);
  }
  
  public final String bzC()
  {
    return "FingerprintAuth";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(41594);
    b(paramActivity, new Bundle());
    AppMethodBeat.o(41594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.a
 * JD-Core Version:    0.7.0.1
 */