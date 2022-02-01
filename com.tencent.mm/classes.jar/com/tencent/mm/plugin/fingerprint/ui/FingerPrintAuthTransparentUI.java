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
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(7)
public class FingerPrintAuthTransparentUI
  extends WalletBaseUI
  implements com.tencent.mm.plugin.fingerprint.d.b
{
  Dialog mProgressDialog;
  private c tgC;
  private int thA;
  private com.tencent.mm.ui.base.i thN;
  private d thO;
  private int thP;
  private Animation thQ;
  private boolean thR;
  private int thS;
  private boolean thT;
  View view;
  
  public FingerPrintAuthTransparentUI()
  {
    AppMethodBeat.i(64497);
    this.view = null;
    this.thN = null;
    this.thO = null;
    this.thP = -1;
    this.thA = 0;
    this.thR = false;
    this.thS = 0;
    this.thT = false;
    this.tgC = new c()
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
          com.tencent.mm.plugin.soter.d.a.RT(2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
        }
      }
    };
    AppMethodBeat.o(64497);
  }
  
  private void bh(int paramInt, String paramString)
  {
    AppMethodBeat.i(64508);
    if (TextUtils.isEmpty(paramString)) {
      paramString = getString(paramInt);
    }
    for (;;)
    {
      h.a(this, paramString, "", getString(2131765291), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64486);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
          paramAnonymousDialogInterface.dismiss();
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(64486);
        }
      });
      AppMethodBeat.o(64508);
      return;
    }
  }
  
  private void cQd()
  {
    AppMethodBeat.i(64502);
    this.thO.a(getContext(), new com.tencent.mm.plugin.fingerprint.d.b()
    {
      public final void bc(int paramAnonymousInt, String paramAnonymousString)
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
  
  private static void cQe()
  {
    AppMethodBeat.i(64503);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64503);
  }
  
  private void cQf()
  {
    AppMethodBeat.i(64504);
    d locald = this.thO;
    new StringBuilder().append(this.thP);
    locald.a(this, 2);
    AppMethodBeat.o(64504);
  }
  
  private void cQg()
  {
    AppMethodBeat.i(64506);
    com.tencent.mm.plugin.soter.d.a.ic(3, this.thS);
    Intent localIntent = getIntent();
    String str = "";
    if (localIntent != null) {
      str = localIntent.getStringExtra("key_pwd1");
    }
    this.thO.a(this, new com.tencent.mm.plugin.fingerprint.d.b()
    {
      public final void bc(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(64496);
        FingerPrintAuthTransparentUI.this.jt(false);
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
    jt(true);
    if ((this.thN != null) && (this.thN.isShowing())) {
      this.thN.dismiss();
    }
    AppMethodBeat.o(64506);
  }
  
  public final void bc(int paramInt, String paramString)
  {
    AppMethodBeat.i(64511);
    jt(false);
    if (paramInt == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 19), false);
      h.a(this, getString(2131759412), getString(2131759408), getString(2131765649), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64485);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(64485);
        }
      });
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
      h.a(this, paramString, "", getString(2131759417), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64487);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
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
      bh(-1, paramString);
      AppMethodBeat.o(64511);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(64507);
    if (this.thO != null) {
      this.thO.clear();
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
  
  protected final void jt(boolean paramBoolean)
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
    if (!paramBundle.cPQ())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (u.aAB())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (paramBundle.cPN())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (!paramBundle.cPR())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    Object localObject = t.eFy();
    this.thO = paramBundle.cPV();
    this.thT = com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.Ise, false);
    if ((((an)localObject).eGa()) && (!paramBundle.cPN()))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
      f.fVe().fVf();
      com.tencent.mm.plugin.report.service.g.yhR.f(12924, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.soter.d.a.RQ(0);
      if (getIntent().getBooleanExtra("key_show_guide", true))
      {
        if (com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.Isb, true))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Isb, Boolean.FALSE);
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ise, Boolean.FALSE);
          if (this.thT) {}
          for (paramBundle = getString(2131760136);; paramBundle = getString(2131760135))
          {
            h.a(this, paramBundle, "", getString(2131756748), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Isd, Integer.valueOf(1));
            this.thS = 1;
            com.tencent.mm.plugin.soter.d.a.ic(1, this.thS);
            AppMethodBeat.o(64498);
            return;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
        paramBundle = LayoutInflater.from(this).inflate(2131494137, null);
        localObject = (CheckBox)paramBundle.findViewById(2131300097);
        this.thS = (((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Isd, null)).intValue() + 1);
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Isd, Integer.valueOf(this.thS));
        com.tencent.mm.plugin.soter.d.a.ic(1, this.thS);
        h.a(this, false, null, paramBundle, getString(2131756748), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, this.tht.isChecked());
            AppMethodBeat.o(64494);
          }
        });
        AppMethodBeat.o(64498);
        return;
      }
      if (getIntent().getBooleanExtra("isFromKinda", false))
      {
        com.tencent.mm.plugin.soter.d.a.ic(3, this.thS);
        paramBundle = getIntent().getStringExtra("kindaPayPwd");
        if (paramBundle != null)
        {
          this.thO.a(this, new com.tencent.mm.plugin.fingerprint.d.b()
          {
            public final void bc(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(64495);
              FingerPrintAuthTransparentUI.this.jt(false);
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
          jt(true);
        }
        this.mController.setStatusBarColor(getResources().getColor(2131101179));
        AppMethodBeat.o(64498);
        return;
      }
      cQg();
      AppMethodBeat.o(64498);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + ((an)localObject).eGa() + ";isOpenTouch:" + paramBundle.cPN());
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
    finish();
    AppMethodBeat.o(64498);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64510);
    if ((this.thN != null) && (this.thN.isShowing()))
    {
      this.thN.dismiss();
      this.thN = null;
    }
    if (this.thQ != null) {
      this.thQ.cancel();
    }
    jt(false);
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
    cQe();
    if (localWakeLock != null) {
      localWakeLock.release();
    }
    AppMethodBeat.o(64500);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64499);
    super.onResume();
    if (this.thR) {
      cQd();
    }
    AppMethodBeat.o(64499);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64505);
    boolean bool = this.thO.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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