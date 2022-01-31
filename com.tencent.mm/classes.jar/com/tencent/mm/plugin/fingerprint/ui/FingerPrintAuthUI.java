package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

public class FingerPrintAuthUI
  extends WalletBaseUI
  implements com.tencent.mm.pluginsdk.wallet.a
{
  private boolean isPaused = false;
  private k mGJ = null;
  private Animation mGL;
  private int mGM = 0;
  private TextView mGR;
  private c mGS;
  private FingerPrintAuthUI.a mGT;
  private boolean mGU = false;
  private final int mGV = 1;
  private Dialog mProgressDialog = null;
  
  private void ck(String paramString, int paramInt)
  {
    AppMethodBeat.i(41648);
    this.mGU = false;
    al.d(new FingerPrintAuthUI.4(this, paramString, paramInt));
    AppMethodBeat.o(41648);
  }
  
  private void hN(boolean paramBoolean)
  {
    AppMethodBeat.i(41644);
    com.tencent.mm.plugin.fingerprint.a.byD();
    com.tencent.mm.plugin.fingerprint.a.byE();
    c.abort();
    c.release();
    if (!c.byY())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
      AppMethodBeat.o(41644);
      return;
    }
    if (this.mGT == null) {
      this.mGT = new FingerPrintAuthUI.a(this, this);
    }
    if (c.a(this.mGT, paramBoolean) != 0) {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthUI", "startFingerprintAuth failed!");
    }
    AppMethodBeat.o(41644);
  }
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(41649);
    if (paramInt == 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 19), false);
      AppMethodBeat.o(41649);
      return;
    }
    fV(false);
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
    h.a(this, getString(2131299968), "", new FingerPrintAuthUI.5(this));
    AppMethodBeat.o(41649);
  }
  
  protected final void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(41642);
    al.d(new FingerPrintAuthUI.2(this, paramBoolean));
    AppMethodBeat.o(41642);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969594;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41641);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131302017));
    this.mGR = ((TextView)findViewById(2131824159));
    com.tencent.mm.plugin.fingerprint.a.byD();
    this.mGS = com.tencent.mm.plugin.fingerprint.a.byE();
    this.mGJ = c.byZ();
    paramBundle = com.tencent.mm.wallet_core.a.aL(this);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("pwd");
      if (TextUtils.isEmpty(paramBundle))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
        ck(getString(2131299968), -1);
        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "get user pwd error");
        AppMethodBeat.o(41641);
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
      ck(getString(2131299968), -1);
      com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
      AppMethodBeat.o(41641);
      return;
    }
    if (e.bzf())
    {
      fV(true);
      f.dVD().dVE();
      this.mGJ.a(this, new FingerPrintAuthUI.1(this), paramBundle);
      AppMethodBeat.o(41641);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
    AppMethodBeat.o(41641);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41646);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
    if (this.mGL != null) {
      this.mGL.cancel();
    }
    this.mGT = null;
    super.onDestroy();
    AppMethodBeat.o(41646);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41645);
    super.onPause();
    this.isPaused = true;
    PowerManager.WakeLock localWakeLock = ((PowerManager)getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null) {
      localWakeLock.acquire();
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
    com.tencent.mm.plugin.fingerprint.a.byD();
    if (com.tencent.mm.plugin.fingerprint.a.byE() != null) {
      c.userCancel();
    }
    if (localWakeLock != null) {
      localWakeLock.release();
    }
    AppMethodBeat.o(41645);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41643);
    super.onResume();
    this.isPaused = false;
    if (this.mGU) {
      hN(false);
    }
    AppMethodBeat.o(41643);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41647);
    if (this.mGJ.onSceneEnd(paramInt1, paramInt2, paramString, paramm))
    {
      AppMethodBeat.o(41647);
      return true;
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
    {
      fV(false);
      com.tencent.mm.wallet_core.a.b(this, new Bundle(), 0);
      Toast.makeText(this, 2131299969, 0).show();
      AppMethodBeat.o(41647);
      return true;
    }
    AppMethodBeat.o(41647);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI
 * JD-Core Version:    0.7.0.1
 */