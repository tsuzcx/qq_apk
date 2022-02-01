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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(7)
public class FingerPrintAuthTransparentUI
  extends WalletBaseUI
  implements com.tencent.mm.plugin.fingerprint.d.b
{
  Dialog mProgressDialog;
  View view;
  private int wFZ;
  private c wFc;
  private com.tencent.mm.ui.base.i wGm;
  private d wGn;
  private int wGo;
  private Animation wGp;
  private boolean wGq;
  private int wGr;
  private boolean wGs;
  
  public FingerPrintAuthTransparentUI()
  {
    AppMethodBeat.i(64497);
    this.view = null;
    this.wGm = null;
    this.wGn = null;
    this.wGo = -1;
    this.wFZ = 0;
    this.wGq = false;
    this.wGr = 0;
    this.wGs = false;
    this.wFc = new c()
    {
      public final void gz(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(64482);
        switch (paramAnonymousInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(64482);
          return;
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, paramAnonymousInt2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64482);
          return;
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
          FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.c(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64482);
          return;
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
          AppMethodBeat.o(64482);
          return;
          String str = MMApplicationContext.getContext().getString(2131766339);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
          AppMethodBeat.o(64482);
          return;
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = MMApplicationContext.getContext().getString(2131766337);
          if (paramAnonymousInt1 == 10308)
          {
            str = MMApplicationContext.getContext().getString(2131766338);
            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
          }
          for (;;)
          {
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
            AppMethodBeat.o(64482);
            return;
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          }
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = MMApplicationContext.getContext().getString(2131766337);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          com.tencent.mm.plugin.soter.d.a.aaw(2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
        }
      }
    };
    AppMethodBeat.o(64497);
  }
  
  private void bl(int paramInt, String paramString)
  {
    AppMethodBeat.i(64508);
    if (TextUtils.isEmpty(paramString)) {
      paramString = getString(paramInt);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131767734), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64486);
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
          paramAnonymousDialogInterface.dismiss();
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(64486);
        }
      });
      AppMethodBeat.o(64508);
      return;
    }
  }
  
  private void dKD()
  {
    AppMethodBeat.i(64502);
    this.wGn.a(getContext(), new com.tencent.mm.plugin.fingerprint.d.b()
    {
      public final void bg(int paramAnonymousInt, String paramAnonymousString)
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
        FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, 2131760697, paramAnonymousString);
        AppMethodBeat.o(64489);
      }
    });
    AppMethodBeat.o(64502);
  }
  
  private static void dKE()
  {
    AppMethodBeat.i(64503);
    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64503);
  }
  
  private void dKF()
  {
    AppMethodBeat.i(64504);
    d locald = this.wGn;
    new StringBuilder().append(this.wGo);
    locald.a(this, 2);
    AppMethodBeat.o(64504);
  }
  
  private void dKG()
  {
    AppMethodBeat.i(64506);
    com.tencent.mm.plugin.soter.d.a.ja(3, this.wGr);
    Intent localIntent = getIntent();
    String str = "";
    if (localIntent != null) {
      str = localIntent.getStringExtra("key_pwd1");
    }
    this.wGn.a(this, new com.tencent.mm.plugin.fingerprint.d.b()
    {
      public final void bg(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(64496);
        FingerPrintAuthTransparentUI.this.ku(false);
        if (paramAnonymousInt == 0)
        {
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
          FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
          AppMethodBeat.o(64496);
          return;
        }
        FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, paramAnonymousString);
        AppMethodBeat.o(64496);
      }
    }, str);
    ku(true);
    if ((this.wGm != null) && (this.wGm.isShowing())) {
      this.wGm.dismiss();
    }
    AppMethodBeat.o(64506);
  }
  
  public final void bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(64511);
    ku(false);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
      doSceneProgress(new ad(null, 19), false);
      com.tencent.mm.ui.base.h.a(this, getString(2131760700), getString(2131760696), getString(2131768102), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64485);
          paramAnonymousDialogInterface.dismiss();
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(64485);
        }
      });
      AppMethodBeat.o(64511);
      return;
    }
    if (paramInt == -2)
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
      if (!TextUtils.isEmpty(paramString)) {
        break label168;
      }
      paramString = getString(2131760697);
    }
    label168:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131760705), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(64487);
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
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
      bl(-1, paramString);
      AppMethodBeat.o(64511);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(64507);
    if (this.wGn != null) {
      this.wGn.clear();
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
  
  protected final void ku(boolean paramBoolean)
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
    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
    paramBundle = (com.tencent.mm.plugin.fingerprint.b.a.i)g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    if (!paramBundle.dKq())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (z.aUo())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (paramBundle.dKn())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (!paramBundle.dKr())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    Object localObject = com.tencent.mm.plugin.wallet_core.model.t.fQI();
    this.wGn = paramBundle.dKv();
    this.wGs = g.aAh().azQ().getBoolean(ar.a.NUC, false);
    if ((((an)localObject).fRk()) && (!paramBundle.dKn()))
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
      f.hlO().hlP();
      com.tencent.mm.plugin.report.service.h.CyF.a(12924, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.soter.d.a.aat(0);
      if (getIntent().getBooleanExtra("key_show_guide", true))
      {
        if (g.aAh().azQ().getBoolean(ar.a.NUz, true))
        {
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
          g.aAh().azQ().set(ar.a.NUz, Boolean.FALSE);
          g.aAh().azQ().set(ar.a.NUC, Boolean.FALSE);
          if (this.wGs) {}
          for (paramBundle = getString(2131761517);; paramBundle = getString(2131761516))
          {
            com.tencent.mm.ui.base.h.a(this, paramBundle, "", getString(2131756910), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            g.aAh().azQ().set(ar.a.NUB, Integer.valueOf(1));
            this.wGr = 1;
            com.tencent.mm.plugin.soter.d.a.ja(1, this.wGr);
            AppMethodBeat.o(64498);
            return;
          }
        }
        Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
        paramBundle = LayoutInflater.from(this).inflate(2131494691, null);
        localObject = (CheckBox)paramBundle.findViewById(2131301532);
        this.wGr = (((Integer)g.aAh().azQ().get(ar.a.NUB, null)).intValue() + 1);
        g.aAh().azQ().set(ar.a.NUB, Integer.valueOf(this.wGr));
        com.tencent.mm.plugin.soter.d.a.ja(1, this.wGr);
        com.tencent.mm.ui.base.h.a(this, false, null, paramBundle, getString(2131756910), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, this.wFS.isChecked());
            AppMethodBeat.o(64494);
          }
        });
        AppMethodBeat.o(64498);
        return;
      }
      if (getIntent().getBooleanExtra("isFromKinda", false))
      {
        com.tencent.mm.plugin.soter.d.a.ja(3, this.wGr);
        paramBundle = getIntent().getStringExtra("kindaPayPwd");
        if (paramBundle != null)
        {
          this.wGn.a(this, new com.tencent.mm.plugin.fingerprint.d.b()
          {
            public final void bg(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(64495);
              FingerPrintAuthTransparentUI.this.ku(false);
              if (paramAnonymousInt == 0)
              {
                Log.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
                FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
                AppMethodBeat.o(64495);
                return;
              }
              FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, paramAnonymousString);
              AppMethodBeat.o(64495);
            }
          }, paramBundle);
          ku(true);
        }
        this.mController.setStatusBarColor(getResources().getColor(2131101424));
        AppMethodBeat.o(64498);
        return;
      }
      dKG();
      AppMethodBeat.o(64498);
      return;
    }
    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + ((an)localObject).fRk() + ";isOpenTouch:" + paramBundle.dKn());
    Log.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
    finish();
    AppMethodBeat.o(64498);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64510);
    if ((this.wGm != null) && (this.wGm.isShowing()))
    {
      this.wGm.dismiss();
      this.wGm = null;
    }
    if (this.wGp != null) {
      this.wGp.cancel();
    }
    ku(false);
    super.onDestroy();
    AppMethodBeat.o(64510);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64500);
    super.onPause();
    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
    PowerManager.WakeLock localWakeLock = ((PowerManager)getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null) {
      localWakeLock.acquire();
    }
    dKE();
    if (localWakeLock != null) {
      localWakeLock.release();
    }
    AppMethodBeat.o(64500);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64499);
    super.onResume();
    if (this.wGq) {
      dKD();
    }
    AppMethodBeat.o(64499);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64505);
    boolean bool = this.wGn.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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