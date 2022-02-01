package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends d
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(64481);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(64476);
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[0];
          a.a(a.this).putString("pwd", paramAnonymousVarArgs);
          ae.i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
          AppMethodBeat.o(64476);
          return false;
        }
      };
      AppMethodBeat.o(64481);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(64481);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(64477);
    ae.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(64477);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(64478);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      ae.i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
      if (this.dyY.getInt("key_open_biometric_type") == 1)
      {
        b(paramActivity, FingerPrintAuthUI.class, paramBundle);
        AppMethodBeat.o(64478);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_scene", 0);
      a(paramActivity, WalletFaceIdAuthUI.class, paramBundle, localBundle);
      AppMethodBeat.o(64478);
      return;
    }
    if ((paramActivity instanceof FingerPrintAuthUI))
    {
      b(paramActivity, paramBundle);
      AppMethodBeat.o(64478);
      return;
    }
    if ((paramActivity instanceof WalletFaceIdAuthUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(64478);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(64480);
    paramBundle = new Intent();
    ae.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
    a(paramActivity, "wallet", ".pwd.ui.WalletBiometricPaySettingsUI", 0, paramBundle, true);
    AppMethodBeat.o(64480);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String cSH()
  {
    return "FingerprintAuth";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(64479);
    b(paramActivity, new Bundle());
    AppMethodBeat.o(64479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.a
 * JD-Core Version:    0.7.0.1
 */