package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(7)
public class FingerPrintAuthTransparentUI
  extends WalletBaseUI
  implements com.tencent.mm.pluginsdk.wallet.a
{
  private d mFN;
  private i mGI;
  private k mGJ;
  private int mGK;
  private Animation mGL;
  private int mGM;
  private boolean mGN;
  private int mGO;
  private boolean mGP;
  Dialog mProgressDialog;
  View view;
  
  public FingerPrintAuthTransparentUI()
  {
    AppMethodBeat.i(41610);
    this.view = null;
    this.mGI = null;
    this.mGJ = null;
    this.mGK = -1;
    this.mGM = 0;
    this.mGN = false;
    this.mGO = 0;
    this.mGP = false;
    this.mFN = new FingerPrintAuthTransparentUI.1(this);
    AppMethodBeat.o(41610);
  }
  
  private void Ok(String paramString)
  {
    AppMethodBeat.i(41620);
    if (TextUtils.isEmpty(paramString)) {
      paramString = getString(-1);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131305099), false, new FingerPrintAuthTransparentUI.4(this));
      AppMethodBeat.o(41620);
      return;
    }
  }
  
  private static void bzD()
  {
    AppMethodBeat.i(41616);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
    com.tencent.mm.plugin.fingerprint.a.byD();
    if (com.tencent.mm.plugin.fingerprint.a.byE() != null) {
      c.userCancel();
    }
    AppMethodBeat.o(41616);
  }
  
  private void bzE()
  {
    AppMethodBeat.i(41618);
    com.tencent.mm.plugin.soter.d.a.fT(3, this.mGO);
    Intent localIntent = getIntent();
    String str = "";
    if (localIntent != null) {
      str = localIntent.getStringExtra("key_pwd1");
    }
    this.mGJ.a(this, new FingerPrintAuthTransparentUI.13(this), str);
    fV(true);
    if ((this.mGI != null) && (this.mGI.isShowing())) {
      this.mGI.dismiss();
    }
    AppMethodBeat.o(41618);
  }
  
  private void hN(boolean paramBoolean)
  {
    AppMethodBeat.i(41615);
    com.tencent.mm.plugin.fingerprint.a.byD();
    com.tencent.mm.plugin.fingerprint.a.byE();
    c.abort();
    c.release();
    if (!c.byY())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
      AppMethodBeat.o(41615);
      return;
    }
    if (c.a(this.mFN, paramBoolean) != 0) {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "startFingerprintAuth failed!");
    }
    AppMethodBeat.o(41615);
  }
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(41623);
    fV(false);
    if (paramInt == 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 19), false);
      com.tencent.mm.ui.base.h.a(this, getString(2131299971), getString(2131299967), getString(2131305435), false, new FingerPrintAuthTransparentUI.3(this));
      AppMethodBeat.o(41623);
      return;
    }
    if (paramInt == -2)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
      if (!TextUtils.isEmpty(paramString)) {
        break label167;
      }
      paramString = getString(2131299968);
    }
    label167:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131299976), getString(2131296888), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(41601);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
          FingerPrintAuthTransparentUI.d(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, false);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(41601);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(142016);
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(142016);
        }
      });
      AppMethodBeat.o(41623);
      return;
      Ok(paramString);
      AppMethodBeat.o(41623);
      return;
    }
  }
  
  protected final void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(41621);
    if (paramBoolean)
    {
      this.mProgressDialog = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
      AppMethodBeat.o(41621);
      return;
    }
    if ((this.mProgressDialog != null) && (this.mProgressDialog.isShowing()))
    {
      this.mProgressDialog.dismiss();
      this.mProgressDialog = null;
    }
    AppMethodBeat.o(41621);
  }
  
  public void finish()
  {
    AppMethodBeat.i(41619);
    if (this.mGJ != null) {
      this.mGJ.clear();
    }
    super.finish();
    AppMethodBeat.o(41619);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41611);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
    if (!com.tencent.mm.plugin.fingerprint.b.e.bzf())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
      finish();
      AppMethodBeat.o(41611);
      return;
    }
    if (r.ZB())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
      finish();
      AppMethodBeat.o(41611);
      return;
    }
    if (com.tencent.mm.plugin.fingerprint.b.e.bzt())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
      finish();
      AppMethodBeat.o(41611);
      return;
    }
    com.tencent.mm.plugin.fingerprint.a.byD();
    com.tencent.mm.plugin.fingerprint.a.byE();
    if (!c.byY())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
      finish();
      AppMethodBeat.o(41611);
      return;
    }
    if (ac.ery.eqB != 1)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "hy: device config force to not support");
      finish();
    }
    paramBundle = com.tencent.mm.plugin.wallet_core.model.t.cTN();
    com.tencent.mm.plugin.fingerprint.a.byD();
    com.tencent.mm.plugin.fingerprint.a.byE();
    this.mGJ = c.byZ();
    this.mGP = com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yzC, false);
    if ((paramBundle.cUl()) && (!com.tencent.mm.plugin.fingerprint.b.e.bzt()))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
      f.dVD().dVE();
      com.tencent.mm.plugin.report.service.h.qsU.e(12924, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.soter.d.a.Ft(0);
      if (getIntent().getBooleanExtra("key_show_guide", true))
      {
        if (com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yzz, true))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzz, Boolean.FALSE);
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzC, Boolean.FALSE);
          if (this.mGP) {}
          for (paramBundle = getString(2131300545);; paramBundle = getString(2131300544))
          {
            com.tencent.mm.ui.base.h.a(this, paramBundle, "", getString(2131297822), getString(2131296888), false, new FingerPrintAuthTransparentUI.8(this), new FingerPrintAuthTransparentUI.9(this));
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzB, Integer.valueOf(1));
            this.mGO = 1;
            com.tencent.mm.plugin.soter.d.a.fT(1, this.mGO);
            AppMethodBeat.o(41611);
            return;
          }
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
        paramBundle = LayoutInflater.from(this).inflate(2130969596, null);
        CheckBox localCheckBox = (CheckBox)paramBundle.findViewById(2131824165);
        this.mGO = (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzB, null)).intValue() + 1);
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzB, Integer.valueOf(this.mGO));
        com.tencent.mm.plugin.soter.d.a.fT(1, this.mGO);
        com.tencent.mm.ui.base.h.a(this, false, null, paramBundle, getString(2131297822), getString(2131296888), new FingerPrintAuthTransparentUI.10(this), new FingerPrintAuthTransparentUI.11(this, localCheckBox));
        AppMethodBeat.o(41611);
        return;
      }
      if (getIntent().getBooleanExtra("isFromKinda", false))
      {
        com.tencent.mm.plugin.soter.d.a.fT(3, this.mGO);
        paramBundle = getIntent().getStringExtra("kindaPayPwd");
        if (paramBundle != null)
        {
          this.mGJ.a(this, new com.tencent.mm.pluginsdk.wallet.a()
          {
            public final void aC(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(41607);
              FingerPrintAuthTransparentUI.this.fV(false);
              if (paramAnonymousInt == 0)
              {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                FingerPrintAuthTransparentUI.d(FingerPrintAuthTransparentUI.this);
                FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, false);
                AppMethodBeat.o(41607);
                return;
              }
              FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, paramAnonymousString);
              AppMethodBeat.o(41607);
            }
          }, paramBundle);
          fV(true);
        }
        paramBundle = this.mController;
        int i = getResources().getColor(2131690709);
        paramBundle.n(paramBundle.zaO, i);
        paramBundle.qq(aj.Ow(i));
        AppMethodBeat.o(41611);
        return;
      }
      bzE();
      AppMethodBeat.o(41611);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + paramBundle.cUl() + ";isOpenTouch:" + com.tencent.mm.plugin.fingerprint.b.e.bzt());
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
    finish();
    AppMethodBeat.o(41611);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41622);
    if ((this.mGI != null) && (this.mGI.isShowing()))
    {
      this.mGI.dismiss();
      this.mGI = null;
    }
    if (this.mGL != null) {
      this.mGL.cancel();
    }
    fV(false);
    super.onDestroy();
    AppMethodBeat.o(41622);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(41613);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
    PowerManager.WakeLock localWakeLock = ((PowerManager)getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null) {
      localWakeLock.acquire();
    }
    bzD();
    if (localWakeLock != null) {
      localWakeLock.release();
    }
    AppMethodBeat.o(41613);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(41612);
    super.onResume();
    if (this.mGN) {
      hN(false);
    }
    AppMethodBeat.o(41612);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41617);
    boolean bool = this.mGJ.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    AppMethodBeat.o(41617);
    return bool;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(41614);
    super.onStop();
    finish();
    AppMethodBeat.o(41614);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI
 * JD-Core Version:    0.7.0.1
 */