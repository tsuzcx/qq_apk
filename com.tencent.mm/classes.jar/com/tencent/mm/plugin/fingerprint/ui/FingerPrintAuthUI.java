package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

public class FingerPrintAuthUI
  extends WalletBaseUI
  implements com.tencent.mm.pluginsdk.wallet.a
{
  private boolean isPaused = false;
  private Dialog klS = null;
  private j klT = null;
  private Animation klV;
  private int klW = 0;
  private TextView kmb;
  private c kmc;
  private FingerPrintAuthUI.a kmd;
  private boolean kme = false;
  private final int kmf = 1;
  
  private void bC(String paramString, int paramInt)
  {
    ai.d(new FingerPrintAuthUI.4(this, paramString, paramInt));
  }
  
  private void gl(boolean paramBoolean)
  {
    com.tencent.mm.plugin.fingerprint.a.aSf();
    com.tencent.mm.plugin.fingerprint.a.aSg();
    c.abort();
    c.release();
    if (!c.aSD()) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
    }
    do
    {
      return;
      if (this.kmd == null) {
        this.kmd = new FingerPrintAuthUI.a(this, this);
      }
    } while (c.a(this.kmd, paramBoolean) == 0);
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthUI", "startFingerprintAuth failed!");
  }
  
  public final void ai(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 19), false, false);
      return;
    }
    ew(false);
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
    h.a(this, getString(a.i.fingerprint_open_fail), "", new FingerPrintAuthUI.5(this));
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.klT.c(paramInt1, paramInt2, paramString, paramm)) {
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
    {
      ew(false);
      com.tencent.mm.wallet_core.a.b(this, new Bundle(), 0);
      Toast.makeText(this, a.i.fingerprint_open_success, 0).show();
      return true;
    }
    return false;
  }
  
  protected final void ew(boolean paramBoolean)
  {
    ai.d(new FingerPrintAuthUI.2(this, paramBoolean));
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.fingerprint_authorize_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(getString(a.i.open_fingerprint_auth_title));
    this.kmb = ((TextView)findViewById(a.f.input_tips));
    com.tencent.mm.plugin.fingerprint.a.aSf();
    this.kmc = com.tencent.mm.plugin.fingerprint.a.aSg();
    this.klT = c.aSE();
    paramBundle = com.tencent.mm.wallet_core.a.ai(this);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("pwd");
      if (TextUtils.isEmpty(paramBundle))
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
        bC(getString(a.i.fingerprint_open_fail), -1);
        com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, -1, "get user pwd error");
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
      bC(getString(a.i.fingerprint_open_fail), -1);
      com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
      return;
    }
    if (e.aSK())
    {
      ew(true);
      f.cPH().cPI();
      this.klT.a(this, new FingerPrintAuthUI.1(this), paramBundle);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
    if (this.klV != null) {
      this.klV.cancel();
    }
    this.kmd = null;
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.isPaused = true;
    PowerManager.WakeLock localWakeLock = ((PowerManager)this.mController.uMN.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null) {
      localWakeLock.acquire();
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
    com.tencent.mm.plugin.fingerprint.a.aSf();
    if (com.tencent.mm.plugin.fingerprint.a.aSg() != null) {
      c.aSC();
    }
    if (localWakeLock != null) {
      localWakeLock.release();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.isPaused = false;
    if (this.kme) {
      gl(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI
 * JD-Core Version:    0.7.0.1
 */