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
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(7)
public class FingerPrintAuthTransparentUI
  extends WalletBaseUI
  implements b
{
  Dialog mProgressDialog;
  private int skY;
  private c ska;
  private com.tencent.mm.ui.base.i sll;
  private d slm;
  private int sln;
  private Animation slo;
  private boolean slp;
  private int slq;
  private boolean slr;
  View view;
  
  public FingerPrintAuthTransparentUI()
  {
    AppMethodBeat.i(64497);
    this.view = null;
    this.sll = null;
    this.slm = null;
    this.sln = -1;
    this.skY = 0;
    this.slp = false;
    this.slq = 0;
    this.slr = false;
    this.ska = new c()
    {
      public final void fL(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(64482);
        switch (paramAnonymousInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(64482);
          return;
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, paramAnonymousInt2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64482);
          return;
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
          FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.c(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64482);
          return;
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
          AppMethodBeat.o(64482);
          return;
          String str = ai.getContext().getString(2131764097);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
          AppMethodBeat.o(64482);
          return;
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = ai.getContext().getString(2131764095);
          if (paramAnonymousInt1 == 10308)
          {
            str = ai.getContext().getString(2131764096);
            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
          }
          for (;;)
          {
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
            AppMethodBeat.o(64482);
            return;
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          }
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = ai.getContext().getString(2131764095);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          com.tencent.mm.plugin.soter.d.a.Ql(2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
        }
      }
    };
    AppMethodBeat.o(64497);
  }
  
  private void be(int paramInt, String paramString)
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
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
          paramAnonymousDialogInterface.dismiss();
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(64486);
        }
      });
      AppMethodBeat.o(64508);
      return;
    }
  }
  
  private void cHO()
  {
    AppMethodBeat.i(64502);
    this.slm.a(getContext(), new b()
    {
      public final void aZ(int paramAnonymousInt, String paramAnonymousString)
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
  
  private static void cHP()
  {
    AppMethodBeat.i(64503);
    ac.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64503);
  }
  
  private void cHQ()
  {
    AppMethodBeat.i(64504);
    d locald = this.slm;
    new StringBuilder().append(this.sln);
    locald.a(this, 2);
    AppMethodBeat.o(64504);
  }
  
  private void cHR()
  {
    AppMethodBeat.i(64506);
    com.tencent.mm.plugin.soter.d.a.hL(3, this.slq);
    Intent localIntent = getIntent();
    String str = "";
    if (localIntent != null) {
      str = localIntent.getStringExtra("key_pwd1");
    }
    this.slm.a(this, new b()
    {
      public final void aZ(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(64496);
        FingerPrintAuthTransparentUI.this.ji(false);
        if (paramAnonymousInt == 0)
        {
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
          FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64496);
          return;
        }
        FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, paramAnonymousString);
        AppMethodBeat.o(64496);
      }
    }, str);
    ji(true);
    if ((this.sll != null) && (this.sll.isShowing())) {
      this.sll.dismiss();
    }
    AppMethodBeat.o(64506);
  }
  
  public final void aZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(64511);
    ji(false);
    if (paramInt == 0)
    {
      ac.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
      doSceneProgress(new ad(null, 19), false);
      com.tencent.mm.ui.base.h.a(this, getString(2131759412), getString(2131759408), getString(2131765649), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64485);
          paramAnonymousDialogInterface.dismiss();
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(64485);
        }
      });
      AppMethodBeat.o(64511);
      return;
    }
    if (paramInt == -2)
    {
      ac.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
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
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
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
      be(-1, paramString);
      AppMethodBeat.o(64511);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(64507);
    if (this.slm != null) {
      this.slm.clear();
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
  
  protected final void ji(boolean paramBoolean)
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
    ac.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
    paramBundle = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    if (!paramBundle.cHB())
    {
      ac.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (u.axL())
    {
      ac.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (paramBundle.cHy())
    {
      ac.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (!paramBundle.cHC())
    {
      ac.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    Object localObject = com.tencent.mm.plugin.wallet_core.model.s.ery();
    this.slm = paramBundle.cHG();
    this.slr = com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GFM, false);
    if ((((am)localObject).esa()) && (!paramBundle.cHy()))
    {
      ac.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
      f.fDM().fDN();
      com.tencent.mm.plugin.report.service.h.wUl.f(12924, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.soter.d.a.Qi(0);
      if (getIntent().getBooleanExtra("key_show_guide", true))
      {
        if (com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GFJ, true))
        {
          ac.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFJ, Boolean.FALSE);
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFM, Boolean.FALSE);
          if (this.slr) {}
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
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFL, Integer.valueOf(1));
            this.slq = 1;
            com.tencent.mm.plugin.soter.d.a.hL(1, this.slq);
            AppMethodBeat.o(64498);
            return;
          }
        }
        ac.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
        paramBundle = LayoutInflater.from(this).inflate(2131494137, null);
        localObject = (CheckBox)paramBundle.findViewById(2131300097);
        this.slq = (((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFL, null)).intValue() + 1);
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFL, Integer.valueOf(this.slq));
        com.tencent.mm.plugin.soter.d.a.hL(1, this.slq);
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
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, this.skR.isChecked());
            AppMethodBeat.o(64494);
          }
        });
        AppMethodBeat.o(64498);
        return;
      }
      if (getIntent().getBooleanExtra("isFromKinda", false))
      {
        com.tencent.mm.plugin.soter.d.a.hL(3, this.slq);
        paramBundle = getIntent().getStringExtra("kindaPayPwd");
        if (paramBundle != null)
        {
          this.slm.a(this, new b()
          {
            public final void aZ(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(64495);
              FingerPrintAuthTransparentUI.this.ji(false);
              if (paramAnonymousInt == 0)
              {
                ac.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
                FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
                AppMethodBeat.o(64495);
                return;
              }
              FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, paramAnonymousString);
              AppMethodBeat.o(64495);
            }
          }, paramBundle);
          ji(true);
        }
        this.mController.setStatusBarColor(getResources().getColor(2131101179));
        AppMethodBeat.o(64498);
        return;
      }
      cHR();
      AppMethodBeat.o(64498);
      return;
    }
    ac.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + ((am)localObject).esa() + ";isOpenTouch:" + paramBundle.cHy());
    ac.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
    finish();
    AppMethodBeat.o(64498);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64510);
    if ((this.sll != null) && (this.sll.isShowing()))
    {
      this.sll.dismiss();
      this.sll = null;
    }
    if (this.slo != null) {
      this.slo.cancel();
    }
    ji(false);
    super.onDestroy();
    AppMethodBeat.o(64510);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64500);
    super.onPause();
    ac.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
    PowerManager.WakeLock localWakeLock = ((PowerManager)getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null) {
      localWakeLock.acquire();
    }
    cHP();
    if (localWakeLock != null) {
      localWakeLock.release();
    }
    AppMethodBeat.o(64500);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64499);
    super.onResume();
    if (this.slp) {
      cHO();
    }
    AppMethodBeat.o(64499);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64505);
    boolean bool = this.slm.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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