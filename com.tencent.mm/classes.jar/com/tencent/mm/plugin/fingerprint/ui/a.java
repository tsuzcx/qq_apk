package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    y.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess start,forward to WalletCheckPwdUI");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    if ((paramMMActivity instanceof WalletCheckPwdUI)) {
      return new a.1(this, paramMMActivity, parami);
    }
    return super.a(paramMMActivity, parami);
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      y.i("MicroMsg.FingerPrintAuthProcess", "forward to FingerPrintAuthUI");
      if (this.kke.getInt("key_open_bio_auth_type") == 0) {
        b(paramActivity, FingerPrintAuthUI.class, paramBundle);
      }
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_scene", 0);
      a(paramActivity, WalletFaceIdAuthUI.class, paramBundle, localBundle);
      return;
      if ((paramActivity instanceof FingerPrintAuthUI))
      {
        b(paramActivity, paramBundle);
        return;
      }
    } while (!(paramActivity instanceof WalletFaceIdAuthUI));
    b(paramActivity, paramBundle);
  }
  
  public final String aTh()
  {
    return "FingerprintAuth";
  }
  
  public final void b(Activity paramActivity, int paramInt)
  {
    b(paramActivity, new Bundle());
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    paramBundle = new Intent();
    y.i("MicroMsg.FingerPrintAuthProcess", "FingerPrintAuthProcess end");
    a(paramActivity, "wallet", ".pwd.ui.WalletPasswordSettingUI", 0, paramBundle, true);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.a
 * JD-Core Version:    0.7.0.1
 */