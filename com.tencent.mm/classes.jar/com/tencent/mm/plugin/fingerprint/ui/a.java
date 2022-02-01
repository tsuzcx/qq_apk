package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e;

public class a
  extends e
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(64481);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(64476);
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[0];
          a.a(a.this).putString("pwd", paramAnonymousVarArgs);
          Log.i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
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
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(64477);
    Log.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(64477);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(64478);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      Log.i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
      if (this.hPH.getInt("key_open_biometric_type") == 1)
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
    Intent localIntent = new Intent();
    Log.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
    if (paramBundle.getInt("open_scene", 0) == 1)
    {
      a(paramActivity, "wallet", ".pwd.ui.WalletBiometricPaySettingsUI", 0, localIntent, true);
      AppMethodBeat.o(64480);
      return;
    }
    co(paramActivity);
    AppMethodBeat.o(64480);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "FingerprintAuth";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(64479);
    b(paramActivity, new Bundle());
    AppMethodBeat.o(64479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.a
 * JD-Core Version:    0.7.0.1
 */