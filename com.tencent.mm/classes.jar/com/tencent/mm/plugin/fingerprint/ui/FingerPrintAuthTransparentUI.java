package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(7)
public class FingerPrintAuthTransparentUI
  extends WalletBaseUI
  implements com.tencent.mm.plugin.fingerprint.d.b
{
  Dialog mProgressDialog;
  private c trv;
  private com.tencent.mm.ui.base.i tsG;
  private d tsH;
  private int tsI;
  private Animation tsJ;
  private boolean tsK;
  private int tsL;
  private boolean tsM;
  private int tst;
  View view;
  
  public FingerPrintAuthTransparentUI()
  {
    AppMethodBeat.i(64497);
    this.view = null;
    this.tsG = null;
    this.tsH = null;
    this.tsI = -1;
    this.tst = 0;
    this.tsK = false;
    this.tsL = 0;
    this.tsM = false;
    this.trv = new c()
    {
      public final void gb(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(64482);
        switch (paramAnonymousInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(64482);
          return;
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, paramAnonymousInt2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64482);
          return;
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
          FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.c(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64482);
          return;
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
          AppMethodBeat.o(64482);
          return;
          String str = ak.getContext().getString(2131764097);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
          AppMethodBeat.o(64482);
          return;
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = ak.getContext().getString(2131764095);
          if (paramAnonymousInt1 == 10308)
          {
            str = ak.getContext().getString(2131764096);
            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
          }
          for (;;)
          {
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
            AppMethodBeat.o(64482);
            return;
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          }
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = ak.getContext().getString(2131764095);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          com.tencent.mm.plugin.soter.d.a.SA(2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
        }
      }
    };
    AppMethodBeat.o(64497);
  }
  
  private void bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(64508);
    if (TextUtils.isEmpty(paramString)) {
      paramString = getString(paramInt);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131765291), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64486);
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
          paramAnonymousDialogInterface.dismiss();
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(64486);
        }
      });
      AppMethodBeat.o(64508);
      return;
    }
  }
  
  private void cSI()
  {
    AppMethodBeat.i(64502);
    this.tsH.a(getContext(), new com.tencent.mm.plugin.fingerprint.d.b()
    {
      public final void bb(int paramAnonymousInt, String paramAnonymousString)
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
  
  private static void cSJ()
  {
    AppMethodBeat.i(64503);
    ae.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64503);
  }
  
  private void cSK()
  {
    AppMethodBeat.i(64504);
    d locald = this.tsH;
    new StringBuilder().append(this.tsI);
    locald.a(this, 2);
    AppMethodBeat.o(64504);
  }
  
  private void cSL()
  {
    AppMethodBeat.i(64506);
    com.tencent.mm.plugin.soter.d.a.jdMethod_if(3, this.tsL);
    Intent localIntent = getIntent();
    String str = "";
    if (localIntent != null) {
      str = localIntent.getStringExtra("key_pwd1");
    }
    this.tsH.a(this, new com.tencent.mm.plugin.fingerprint.d.b()
    {
      public final void bb(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(64496);
        FingerPrintAuthTransparentUI.this.js(false);
        if (paramAnonymousInt == 0)
        {
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
          FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64496);
          return;
        }
        FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, paramAnonymousString);
        AppMethodBeat.o(64496);
      }
    }, str);
    js(true);
    if ((this.tsG != null) && (this.tsG.isShowing())) {
      this.tsG.dismiss();
    }
    AppMethodBeat.o(64506);
  }
  
  public final void bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(64511);
    js(false);
    if (paramInt == 0)
    {
      ae.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
      doSceneProgress(new ad(null, 19), false);
      com.tencent.mm.ui.base.h.a(this, getString(2131759412), getString(2131759408), getString(2131765649), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64485);
          paramAnonymousDialogInterface.dismiss();
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(64485);
        }
      });
      AppMethodBeat.o(64511);
      return;
    }
    if (paramInt == -2)
    {
      ae.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
      if (!TextUtils.isEmpty(paramString)) {
        break label168;
      }
      paramString = getString(2131759409);
    }
    label168:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131759417), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64487);
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
          FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(64487);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64488);
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(64488);
        }
      });
      AppMethodBeat.o(64511);
      return;
      bg(-1, paramString);
      AppMethodBeat.o(64511);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(64507);
    if (this.tsH != null) {
      this.tsH.clear();
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
  
  protected final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(64509);
    if (paramBoolean)
    {
      this.mProgressDialog = com.tencent.mm.wallet_core.ui.h.a(this, false, null);
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
    ae.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
    paramBundle = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    if (!paramBundle.cSv())
    {
      ae.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (v.aAR())
    {
      ae.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (paramBundle.cSs())
    {
      ae.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (!paramBundle.cSw())
    {
      ae.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    Object localObject = t.eJf();
    this.tsH = paramBundle.cSA();
    this.tsM = com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IMA, false);
    if ((((an)localObject).eJH()) && (!paramBundle.cSs()))
    {
      ae.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
      f.fZD().fZE();
      com.tencent.mm.plugin.report.service.g.yxI.f(12924, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.soter.d.a.Sx(0);
      if (getIntent().getBooleanExtra("key_show_guide", true))
      {
        if (com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IMx, true))
        {
          ae.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMx, Boolean.FALSE);
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMA, Boolean.FALSE);
          if (this.tsM) {}
          for (paramBundle = getString(2131760136);; paramBundle = getString(2131760135))
          {
            com.tencent.mm.ui.base.h.a(this, paramBundle, "", getString(2131756748), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(64491);
                FingerPrintAuthTransparentUI.e(FingerPrintAuthTransparentUI.this);
                AppMethodBeat.o(64491);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(64492);
                FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, false);
                AppMethodBeat.o(64492);
              }
            });
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMz, Integer.valueOf(1));
            this.tsL = 1;
            com.tencent.mm.plugin.soter.d.a.jdMethod_if(1, this.tsL);
            AppMethodBeat.o(64498);
            return;
          }
        }
        ae.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
        paramBundle = LayoutInflater.from(this).inflate(2131494137, null);
        localObject = (CheckBox)paramBundle.findViewById(2131300097);
        this.tsL = (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMz, null)).intValue() + 1);
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMz, Integer.valueOf(this.tsL));
        com.tencent.mm.plugin.soter.d.a.jdMethod_if(1, this.tsL);
        com.tencent.mm.ui.base.h.a(this, false, null, paramBundle, getString(2131756748), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(64493);
            FingerPrintAuthTransparentUI.e(FingerPrintAuthTransparentUI.this);
            AppMethodBeat.o(64493);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(64494);
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, this.tsm.isChecked());
            AppMethodBeat.o(64494);
          }
        });
        AppMethodBeat.o(64498);
        return;
      }
      if (getIntent().getBooleanExtra("isFromKinda", false))
      {
        com.tencent.mm.plugin.soter.d.a.jdMethod_if(3, this.tsL);
        paramBundle = getIntent().getStringExtra("kindaPayPwd");
        if (paramBundle != null)
        {
          this.tsH.a(this, new com.tencent.mm.plugin.fingerprint.d.b()
          {
            public final void bb(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(64495);
              FingerPrintAuthTransparentUI.this.js(false);
              if (paramAnonymousInt == 0)
              {
                ae.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
                FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
                AppMethodBeat.o(64495);
                return;
              }
              FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, paramAnonymousString);
              AppMethodBeat.o(64495);
            }
          }, paramBundle);
          js(true);
        }
        this.mController.setStatusBarColor(getResources().getColor(2131101179));
        AppMethodBeat.o(64498);
        return;
      }
      cSL();
      AppMethodBeat.o(64498);
      return;
    }
    ae.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + ((an)localObject).eJH() + ";isOpenTouch:" + paramBundle.cSs());
    ae.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
    finish();
    AppMethodBeat.o(64498);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64510);
    if ((this.tsG != null) && (this.tsG.isShowing()))
    {
      this.tsG.dismiss();
      this.tsG = null;
    }
    if (this.tsJ != null) {
      this.tsJ.cancel();
    }
    js(false);
    super.onDestroy();
    AppMethodBeat.o(64510);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64500);
    super.onPause();
    ae.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
    PowerManager.WakeLock localWakeLock = ((PowerManager)getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null) {
      localWakeLock.acquire();
    }
    cSJ();
    if (localWakeLock != null) {
      localWakeLock.release();
    }
    AppMethodBeat.o(64500);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64499);
    super.onResume();
    if (this.tsK) {
      cSI();
    }
    AppMethodBeat.o(64499);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64505);
    boolean bool = this.tsH.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI
 * JD-Core Version:    0.7.0.1
 */