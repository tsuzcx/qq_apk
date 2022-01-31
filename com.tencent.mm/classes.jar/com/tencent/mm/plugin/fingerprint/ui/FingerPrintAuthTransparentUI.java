package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.CheckBox;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(7)
public class FingerPrintAuthTransparentUI
  extends WalletBaseUI
  implements com.tencent.mm.pluginsdk.wallet.a
{
  private i klR = null;
  Dialog klS;
  private j klT = null;
  private int klU = -1;
  private Animation klV;
  private int klW = 0;
  private boolean klX = false;
  private int klY = 0;
  private boolean klZ = false;
  private com.tencent.mm.pluginsdk.wallet.c kla = new FingerPrintAuthTransparentUI.1(this);
  View view = null;
  
  private void Dh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = getString(-1);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(a.i.wallet_i_know_it), false, new FingerPrintAuthTransparentUI.3(this));
      return;
    }
  }
  
  private static void aTi()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
    com.tencent.mm.plugin.fingerprint.a.aSf();
    if (com.tencent.mm.plugin.fingerprint.a.aSg() != null) {
      com.tencent.mm.plugin.fingerprint.b.c.aSC();
    }
  }
  
  private void gl(boolean paramBoolean)
  {
    com.tencent.mm.plugin.fingerprint.a.aSf();
    com.tencent.mm.plugin.fingerprint.a.aSg();
    com.tencent.mm.plugin.fingerprint.b.c.abort();
    com.tencent.mm.plugin.fingerprint.b.c.release();
    if (!com.tencent.mm.plugin.fingerprint.b.c.aSD()) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
    }
    while (com.tencent.mm.plugin.fingerprint.b.c.a(this.kla, paramBoolean) == 0) {
      return;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "startFingerprintAuth failed!");
  }
  
  public final void ai(int paramInt, String paramString)
  {
    ew(false);
    if (paramInt == 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 19), false, false);
      paramString = LayoutInflater.from(this).inflate(a.g.finger_print_auth_success_dialog_layout, null);
      com.tencent.mm.ui.base.h.a(this.mController.uMN, false, null, paramString, getString(a.i.wallet_i_know_it), "", new FingerPrintAuthTransparentUI.2(this), null);
      return;
    }
    if (paramInt == -2)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
      paramInt = a.i.fingerprint_open_fail;
      if (!TextUtils.isEmpty(paramString)) {
        break label155;
      }
      paramString = getString(paramInt);
    }
    label155:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(a.i.fingerprint_try_again), getString(a.i.app_cancel), false, new FingerPrintAuthTransparentUI.4(this), new FingerPrintAuthTransparentUI.5(this));
      return;
      Dh(paramString);
      return;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return this.klT.c(paramInt1, paramInt2, paramString, paramm);
  }
  
  protected final void ew(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.klS = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
    }
    while ((this.klS == null) || (!this.klS.isShowing())) {
      return;
    }
    this.klS.dismiss();
    this.klS = null;
  }
  
  public void finish()
  {
    if (this.klT != null) {
      this.klT.clear();
    }
    super.finish();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
    if (!com.tencent.mm.plugin.fingerprint.b.e.aSK())
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
      finish();
      return;
    }
    if (com.tencent.mm.model.q.Gw())
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
      finish();
      return;
    }
    if (com.tencent.mm.plugin.fingerprint.b.e.aSY())
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
      finish();
      return;
    }
    com.tencent.mm.plugin.fingerprint.a.aSf();
    com.tencent.mm.plugin.fingerprint.a.aSg();
    if (!com.tencent.mm.plugin.fingerprint.b.c.aSD())
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
      finish();
      return;
    }
    if (com.tencent.mm.compatible.e.q.dyh.dyq != 1)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "hy: device config force to not support");
      finish();
    }
    paramBundle = o.bVs();
    com.tencent.mm.plugin.fingerprint.a.aSf();
    com.tencent.mm.plugin.fingerprint.a.aSg();
    this.klT = com.tencent.mm.plugin.fingerprint.b.c.aSE();
    this.klZ = com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.upG, false);
    if ((paramBundle.bVN()) && (!com.tencent.mm.plugin.fingerprint.b.e.aSY()))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
      f.cPH().cPI();
      com.tencent.mm.plugin.report.service.h.nFQ.f(12924, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.soter.d.a.zi(0);
      if (com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.upD, true))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upD, Boolean.valueOf(false));
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upG, Boolean.valueOf(false));
        if (this.klZ) {}
        for (paramBundle = getString(a.i.guide_open_text_for_transparent_recover);; paramBundle = getString(a.i.guide_open_text_for_transparent))
        {
          com.tencent.mm.ui.base.h.a(this, paramBundle, "", getString(a.i.btn_guide_open_fingerprint), getString(a.i.app_cancel), false, new FingerPrintAuthTransparentUI.7(this), new FingerPrintAuthTransparentUI.8(this));
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upF, Integer.valueOf(1));
          this.klY = 1;
          com.tencent.mm.plugin.soter.d.a.ef(1, this.klY);
          return;
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
      paramBundle = LayoutInflater.from(this).inflate(a.g.fingerprint_guide_dialog, null);
      CheckBox localCheckBox = (CheckBox)paramBundle.findViewById(a.f.fingerprint_not_show_any_more_cb);
      this.klY = (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upF, null)).intValue() + 1);
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upF, Integer.valueOf(this.klY));
      com.tencent.mm.plugin.soter.d.a.ef(1, this.klY);
      com.tencent.mm.ui.base.h.a(this, false, null, paramBundle, getString(a.i.btn_guide_open_fingerprint), getString(a.i.app_cancel), new FingerPrintAuthTransparentUI.9(this), new FingerPrintAuthTransparentUI.10(this, localCheckBox));
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + paramBundle.bVN() + ";isOpenTouch:" + com.tencent.mm.plugin.fingerprint.b.e.aSY());
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
    finish();
  }
  
  public void onDestroy()
  {
    if ((this.klR != null) && (this.klR.isShowing()))
    {
      this.klR.dismiss();
      this.klR = null;
    }
    if (this.klV != null) {
      this.klV.cancel();
    }
    ew(false);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
    PowerManager.WakeLock localWakeLock = ((PowerManager)this.mController.uMN.getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null) {
      localWakeLock.acquire();
    }
    aTi();
    if (localWakeLock != null) {
      localWakeLock.release();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.klX) {
      gl(false);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI
 * JD-Core Version:    0.7.0.1
 */