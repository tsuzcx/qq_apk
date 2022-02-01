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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.base.a(7)
public class FingerPrintAuthTransparentUI
  extends WalletBaseUI
  implements com.tencent.mm.plugin.fingerprint.d.b
{
  private com.tencent.mm.ui.base.i Bso;
  private c BxZ;
  private int ByW;
  private d Bzj;
  private int Bzk;
  private Animation Bzl;
  private boolean Bzm;
  private int Bzn;
  private boolean Bzo;
  Dialog mProgressDialog;
  View view;
  
  public FingerPrintAuthTransparentUI()
  {
    AppMethodBeat.i(64497);
    this.view = null;
    this.Bso = null;
    this.Bzj = null;
    this.Bzk = -1;
    this.ByW = 0;
    this.Bzm = false;
    this.Bzn = 0;
    this.Bzo = false;
    this.BxZ = new c()
    {
      public final void hu(int paramAnonymousInt1, int paramAnonymousInt2)
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
          String str = MMApplicationContext.getContext().getString(a.i.soter_on_sensor_error);
          com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
          AppMethodBeat.o(64482);
          return;
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
          if (paramAnonymousInt1 == 10308)
          {
            str = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial);
            com.tencent.mm.plugin.soter.d.a.c(6, -1000223, -1, "too many trial");
          }
          for (;;)
          {
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
            AppMethodBeat.o(64482);
            return;
            com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          }
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
          com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          com.tencent.mm.plugin.soter.d.a.ahQ(2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
        }
      }
    };
    AppMethodBeat.o(64497);
  }
  
  private void bm(int paramInt, String paramString)
  {
    AppMethodBeat.i(64508);
    if (TextUtils.isEmpty(paramString)) {
      paramString = getString(paramInt);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(a.i.wallet_i_know_it), false, new DialogInterface.OnClickListener()
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
  
  private void epc()
  {
    AppMethodBeat.i(64502);
    this.Bzj.a(getContext(), new com.tencent.mm.plugin.fingerprint.d.b()
    {
      public final void bh(int paramAnonymousInt, String paramAnonymousString)
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
        if (paramAnonymousInt == -3)
        {
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, paramAnonymousString);
          AppMethodBeat.o(64489);
          return;
        }
        FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, a.i.fingerprint_open_fail, paramAnonymousString);
        AppMethodBeat.o(64489);
      }
    });
    AppMethodBeat.o(64502);
  }
  
  private static void epd()
  {
    AppMethodBeat.i(64503);
    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
    AppMethodBeat.o(64503);
  }
  
  private void epe()
  {
    AppMethodBeat.i(64504);
    d locald = this.Bzj;
    new StringBuilder().append(this.Bzk);
    locald.a(this, 2);
    AppMethodBeat.o(64504);
  }
  
  private void epf()
  {
    AppMethodBeat.i(64506);
    com.tencent.mm.plugin.soter.d.a.kk(3, this.Bzn);
    Intent localIntent = getIntent();
    String str = "";
    if (localIntent != null) {
      str = localIntent.getStringExtra("key_pwd1");
    }
    this.Bzj.a(this, new com.tencent.mm.plugin.fingerprint.d.b()
    {
      public final void bh(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(64496);
        FingerPrintAuthTransparentUI.this.lG(false);
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
    lG(true);
    if ((this.Bso != null) && (this.Bso.isShowing())) {
      this.Bso.dismiss();
    }
    AppMethodBeat.o(64506);
  }
  
  public final void bh(int paramInt, String paramString)
  {
    AppMethodBeat.i(64511);
    lG(false);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
      doSceneProgress(new ae(null, 19), false);
      com.tencent.mm.ui.base.h.a(this, getString(a.i.fingerprint_open_success_msg_text), getString(a.i.fingerprint_has_open_success), getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_known_btn), false, new DialogInterface.OnClickListener()
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
      paramInt = a.i.fingerprint_open_fail;
      if (!TextUtils.isEmpty(paramString)) {
        break label170;
      }
      paramString = getString(paramInt);
    }
    label170:
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this, paramString, "", getString(a.i.fingerprint_try_again), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(276469);
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
          FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(276469);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(232522);
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(232522);
        }
      });
      AppMethodBeat.o(64511);
      return;
      bm(-1, paramString);
      AppMethodBeat.o(64511);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(64507);
    if (this.Bzj != null) {
      this.Bzj.clear();
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
  
  protected final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(64509);
    if (paramBoolean)
    {
      this.mProgressDialog = com.tencent.mm.wallet_core.ui.i.a(this, false, null);
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
    paramBundle = (com.tencent.mm.plugin.fingerprint.b.a.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.a.i.class);
    if (!paramBundle.eoP())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (z.bdq())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (paramBundle.eoM())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (!paramBundle.eoQ())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    Object localObject = u.gJo();
    this.Bzj = paramBundle.eoU();
    this.Bzo = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.ViC, false);
    if ((((com.tencent.mm.plugin.wallet_core.model.ao)localObject).gJQ()) && (!paramBundle.eoM()))
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
      com.tencent.soter.a.g.f.ipn().ipo();
      com.tencent.mm.plugin.report.service.h.IzE.a(12924, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.soter.d.a.ahN(0);
      if (getIntent().getBooleanExtra("key_show_guide", true))
      {
        if (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Viz, true))
        {
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Viz, Boolean.FALSE);
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViC, Boolean.FALSE);
          if (this.Bzo) {}
          for (paramBundle = getString(a.i.guide_open_text_for_transparent_recover);; paramBundle = getString(a.i.guide_open_text_for_transparent))
          {
            com.tencent.mm.ui.base.h.a(this, paramBundle, "", getString(a.i.btn_guide_open_fingerprint), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViB, Integer.valueOf(1));
            this.Bzn = 1;
            com.tencent.mm.plugin.soter.d.a.kk(1, this.Bzn);
            AppMethodBeat.o(64498);
            return;
          }
        }
        Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
        paramBundle = LayoutInflater.from(this).inflate(a.g.fingerprint_guide_dialog, null);
        localObject = (CheckBox)paramBundle.findViewById(a.f.fingerprint_not_show_any_more_cb);
        this.Bzn = (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViB, null)).intValue() + 1);
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.ViB, Integer.valueOf(this.Bzn));
        com.tencent.mm.plugin.soter.d.a.kk(1, this.Bzn);
        com.tencent.mm.ui.base.h.a(this, false, null, paramBundle, getString(a.i.btn_guide_open_fingerprint), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, this.ByP.isChecked());
            AppMethodBeat.o(64494);
          }
        });
        AppMethodBeat.o(64498);
        return;
      }
      if (getIntent().getBooleanExtra("isFromKinda", false))
      {
        com.tencent.mm.plugin.soter.d.a.kk(3, this.Bzn);
        paramBundle = getIntent().getStringExtra("kindaPayPwd");
        if (paramBundle != null)
        {
          this.Bzj.a(this, new com.tencent.mm.plugin.fingerprint.d.b()
          {
            public final void bh(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(64495);
              FingerPrintAuthTransparentUI.this.lG(false);
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
          lG(true);
        }
        this.mController.setStatusBarColor(getResources().getColor(a.c.white));
        AppMethodBeat.o(64498);
        return;
      }
      epf();
      AppMethodBeat.o(64498);
      return;
    }
    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + ((com.tencent.mm.plugin.wallet_core.model.ao)localObject).gJQ() + ";isOpenTouch:" + paramBundle.eoM());
    Log.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
    finish();
    AppMethodBeat.o(64498);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64510);
    if ((this.Bso != null) && (this.Bso.isShowing()))
    {
      this.Bso.dismiss();
      this.Bso = null;
    }
    if (this.Bzl != null) {
      this.Bzl.cancel();
    }
    lG(false);
    super.onDestroy();
    AppMethodBeat.o(64510);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64500);
    super.onPause();
    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
    PowerManager.WakeLock localWakeLock = ((PowerManager)getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
    if (localWakeLock != null)
    {
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthTransparentUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      localWakeLock.acquire();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthTransparentUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    }
    epd();
    if (localWakeLock != null)
    {
      com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthTransparentUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
      localWakeLock.release();
      com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthTransparentUI", "onPause", "()V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
    }
    AppMethodBeat.o(64500);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64499);
    super.onResume();
    if (this.Bzm) {
      epc();
    }
    AppMethodBeat.o(64499);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64505);
    boolean bool = this.Bzj.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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