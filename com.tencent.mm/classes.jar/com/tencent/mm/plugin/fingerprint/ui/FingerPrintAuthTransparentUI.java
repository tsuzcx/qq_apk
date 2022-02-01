package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(7)
public class FingerPrintAuthTransparentUI
  extends WalletBaseUI
  implements b
{
  Dialog mProgressDialog;
  private c rbG;
  private int rcE;
  private com.tencent.mm.ui.base.i rcR;
  private d rcS;
  private int rcT;
  private Animation rcU;
  private boolean rcV;
  private int rcW;
  private boolean rcX;
  View view;
  
  public FingerPrintAuthTransparentUI()
  {
    AppMethodBeat.i(64497);
    this.view = null;
    this.rcR = null;
    this.rcS = null;
    this.rcT = -1;
    this.rcE = 0;
    this.rcV = false;
    this.rcW = 0;
    this.rcX = false;
    this.rbG = new c()
    {
      public final void fE(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(64482);
        switch (paramAnonymousInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(64482);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, paramAnonymousInt2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64482);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
          FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.c(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64482);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
          AppMethodBeat.o(64482);
          return;
          String str = aj.getContext().getString(2131764097);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
          AppMethodBeat.o(64482);
          return;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = aj.getContext().getString(2131764095);
          if (paramAnonymousInt1 == 10308)
          {
            str = aj.getContext().getString(2131764096);
            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
          }
          for (;;)
          {
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
            AppMethodBeat.o(64482);
            return;
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = aj.getContext().getString(2131764095);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          com.tencent.mm.plugin.soter.d.a.Og(2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
        }
      }
    };
    AppMethodBeat.o(64497);
  }
  
  private void aZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(64508);
    if (TextUtils.isEmpty(paramString)) {
      paramString = getString(paramInt);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131765291), false, new FingerPrintAuthTransparentUI.5(this));
      AppMethodBeat.o(64508);
      return;
    }
  }
  
  private void cuC()
  {
    AppMethodBeat.i(64502);
    this.rcS.a(getContext(), new b()
    {
      public final void aU(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(64489);
        if (paramAnonymousInt == 0)
        {
          FingerPrintAuthTransparentUI.d(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64489);
          return;
        }
        if (paramAnonymousInt == -1)
        {
          FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64489);
          return;
        }
        FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, 2131759409, paramAnonymousString);
        AppMethodBeat.o(64489);
      }
    });
    AppMethodBeat.o(64502);
  }
  
  private static void cuD()
  {
    AppMethodBeat.i(64503);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64503);
  }
  
  private void cuE()
  {
    AppMethodBeat.i(64504);
    d locald = this.rcS;
    new StringBuilder().append(this.rcT);
    locald.a(this, 2);
    AppMethodBeat.o(64504);
  }
  
  private void cuF()
  {
    AppMethodBeat.i(64506);
    com.tencent.mm.plugin.soter.d.a.hC(3, this.rcW);
    Intent localIntent = getIntent();
    String str = "";
    if (localIntent != null) {
      str = localIntent.getStringExtra("key_pwd1");
    }
    this.rcS.a(this, new b()
    {
      public final void aU(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(64496);
        FingerPrintAuthTransparentUI.this.iF(false);
        if (paramAnonymousInt == 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
          FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64496);
          return;
        }
        FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, paramAnonymousString);
        AppMethodBeat.o(64496);
      }
    }, str);
    iF(true);
    if ((this.rcR != null) && (this.rcR.isShowing())) {
      this.rcR.dismiss();
    }
    AppMethodBeat.o(64506);
  }
  
  public final void aU(int paramInt, String paramString)
  {
    AppMethodBeat.i(64511);
    iF(false);
    if (paramInt == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 19), false);
      com.tencent.mm.ui.base.h.a(this, getString(2131759412), getString(2131759408), getString(2131765649), false, new FingerPrintAuthTransparentUI.4(this));
      AppMethodBeat.o(64511);
      return;
    }
    if (paramInt == -2)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
      if (!TextUtils.isEmpty(paramString)) {
        break label168;
      }
      paramString = getString(2131759409);
    }
    label168:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131759417), getString(2131755691), false, new FingerPrintAuthTransparentUI.6(this), new FingerPrintAuthTransparentUI.7(this));
      AppMethodBeat.o(64511);
      return;
      aZ(-1, paramString);
      AppMethodBeat.o(64511);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(64507);
    if (this.rcS != null) {
      this.rcS.clear();
    }
    super.finish();
    AppMethodBeat.o(64507);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  protected final void iF(boolean paramBoolean)
  {
    AppMethodBeat.i(64509);
    if (paramBoolean)
    {
      this.mProgressDialog = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
      AppMethodBeat.o(64509);
      return;
    }
    if ((this.mProgressDialog != null) && (this.mProgressDialog.isShowing()))
    {
      this.mProgressDialog.dismiss();
      this.mProgressDialog = null;
    }
    AppMethodBeat.o(64509);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64498);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
    paramBundle = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    if (!paramBundle.cup())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (u.aqV())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (paramBundle.cum())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (!paramBundle.cuq())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    Object localObject = s.ecc();
    this.rcS = paramBundle.cuu();
    this.rcX = com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FhX, false);
    if ((((am)localObject).ecF()) && (!paramBundle.cum()))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
      f.fnw().fnx();
      com.tencent.mm.plugin.report.service.h.vKh.f(12924, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.soter.d.a.Od(0);
      if (getIntent().getBooleanExtra("key_show_guide", true))
      {
        if (com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FhU, true))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FhU, Boolean.FALSE);
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FhX, Boolean.FALSE);
          if (this.rcX) {}
          for (paramBundle = getString(2131760136);; paramBundle = getString(2131760135))
          {
            com.tencent.mm.ui.base.h.a(this, paramBundle, "", getString(2131756748), getString(2131755691), false, new FingerPrintAuthTransparentUI.10(this), new FingerPrintAuthTransparentUI.11(this));
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FhW, Integer.valueOf(1));
            this.rcW = 1;
            com.tencent.mm.plugin.soter.d.a.hC(1, this.rcW);
            AppMethodBeat.o(64498);
            return;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
        paramBundle = LayoutInflater.from(this).inflate(2131494137, null);
        localObject = (CheckBox)paramBundle.findViewById(2131300097);
        this.rcW = (((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FhW, null)).intValue() + 1);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FhW, Integer.valueOf(this.rcW));
        com.tencent.mm.plugin.soter.d.a.hC(1, this.rcW);
        com.tencent.mm.ui.base.h.a(this, false, null, paramBundle, getString(2131756748), getString(2131755691), new FingerPrintAuthTransparentUI.12(this), new FingerPrintAuthTransparentUI.13(this, (CheckBox)localObject));
        AppMethodBeat.o(64498);
        return;
      }
      if (getIntent().getBooleanExtra("isFromKinda", false))
      {
        com.tencent.mm.plugin.soter.d.a.hC(3, this.rcW);
        paramBundle = getIntent().getStringExtra("kindaPayPwd");
        if (paramBundle != null)
        {
          this.rcS.a(this, new b()
          {
            public final void aU(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(64495);
              FingerPrintAuthTransparentUI.this.iF(false);
              if (paramAnonymousInt == 0)
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
                FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
                AppMethodBeat.o(64495);
                return;
              }
              FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, paramAnonymousString);
              AppMethodBeat.o(64495);
            }
          }, paramBundle);
          iF(true);
        }
        this.mController.setStatusBarColor(getResources().getColor(2131101179));
        AppMethodBeat.o(64498);
        return;
      }
      cuF();
      AppMethodBeat.o(64498);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + ((am)localObject).ecF() + ";isOpenTouch:" + paramBundle.cum());
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
    finish();
    AppMethodBeat.o(64498);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64510);
    if ((this.rcR != null) && (this.rcR.isShowing()))
    {
      this.rcR.dismiss();
      this.rcR = null;
    }
    if (this.rcU != null) {
      this.rcU.cancel();
    }
    iF(false);
    super.onDestroy();
    AppMethodBeat.o(64510);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64500);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
    PowerManager.WakeLock localWakeLock = ((PowerManager)getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null) {
      localWakeLock.acquire();
    }
    cuD();
    if (localWakeLock != null) {
      localWakeLock.release();
    }
    AppMethodBeat.o(64500);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64499);
    super.onResume();
    if (this.rcV) {
      cuC();
    }
    AppMethodBeat.o(64499);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64505);
    boolean bool = this.rcS.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    AppMethodBeat.o(64505);
    return bool;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(64501);
    super.onStop();
    finish();
    AppMethodBeat.o(64501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI
 * JD-Core Version:    0.7.0.1
 */