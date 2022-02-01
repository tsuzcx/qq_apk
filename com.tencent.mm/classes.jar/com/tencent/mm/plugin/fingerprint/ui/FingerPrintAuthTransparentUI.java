package com.tencent.mm.plugin.fingerprint.ui;

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
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fingerprint.c.b;
import com.tencent.mm.plugin.fingerprint.c.c;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.l;

@com.tencent.mm.ui.base.a(7)
public class FingerPrintAuthTransparentUI
  extends WalletBaseUI
  implements b
{
  private com.tencent.mm.ui.widget.a.i GYB;
  private c HfC;
  private int HgB;
  private d HgO;
  private int HgP;
  private Animation HgQ;
  private boolean HgR;
  private int HgS;
  private boolean HgT;
  Dialog mProgressDialog;
  View view;
  
  public FingerPrintAuthTransparentUI()
  {
    AppMethodBeat.i(64497);
    this.view = null;
    this.GYB = null;
    this.HgO = null;
    this.HgP = -1;
    this.HgB = 0;
    this.HgR = false;
    this.HgS = 0;
    this.HgT = false;
    this.HfC = new c()
    {
      public final void iP(int paramAnonymousInt1, int paramAnonymousInt2)
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
          com.tencent.mm.plugin.soter.model.a.e(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
          AppMethodBeat.o(64482);
          return;
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
          if (paramAnonymousInt1 == 10308)
          {
            str = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial);
            com.tencent.mm.plugin.soter.model.a.e(6, -1000223, -1, "too many trial");
          }
          for (;;)
          {
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
            AppMethodBeat.o(64482);
            return;
            com.tencent.mm.plugin.soter.model.a.e(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          }
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
          com.tencent.mm.plugin.soter.model.a.e(1000, -1000223, paramAnonymousInt1, "fingerprint error");
          com.tencent.mm.plugin.soter.model.a.amR(2);
          FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
        }
      }
    };
    AppMethodBeat.o(64497);
  }
  
  private void bQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(64508);
    if (TextUtils.isEmpty(paramString)) {
      paramString = getString(paramInt);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.k.a(this, paramString, "", getString(a.i.wallet_i_know_it), false, new DialogInterface.OnClickListener()
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
  
  private void fue()
  {
    AppMethodBeat.i(64502);
    this.HgO.a(getContext(), new b()
    {
      public final void bL(int paramAnonymousInt, String paramAnonymousString)
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
  
  private static void fuf()
  {
    AppMethodBeat.i(64503);
    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
    ((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class)).userCancel();
    AppMethodBeat.o(64503);
  }
  
  private void fug()
  {
    AppMethodBeat.i(64504);
    d locald = this.HgO;
    new StringBuilder().append(this.HgP);
    locald.a(this, 2);
    AppMethodBeat.o(64504);
  }
  
  private void fuh()
  {
    AppMethodBeat.i(64506);
    com.tencent.mm.plugin.soter.model.a.lW(3, this.HgS);
    Intent localIntent = getIntent();
    String str = "";
    if (localIntent != null) {
      str = localIntent.getStringExtra("key_pwd1");
    }
    this.HgO.a(this, new b()
    {
      public final void bL(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(64496);
        FingerPrintAuthTransparentUI.this.na(false);
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
    na(true);
    if ((this.GYB != null) && (this.GYB.isShowing())) {
      this.GYB.dismiss();
    }
    AppMethodBeat.o(64506);
  }
  
  public final void bL(int paramInt, String paramString)
  {
    AppMethodBeat.i(64511);
    na(false);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
      doSceneProgress(new ae(null, 19), false);
      com.tencent.mm.ui.base.k.a(this, getString(a.i.fingerprint_open_success_msg_text), getString(a.i.fingerprint_has_open_success), getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_known_btn), false, new DialogInterface.OnClickListener()
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
      com.tencent.mm.ui.base.k.a(this, paramString, "", getString(a.i.fingerprint_try_again), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(275239);
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
          FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
          FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(275239);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(275238);
          FingerPrintAuthTransparentUI.this.finish();
          AppMethodBeat.o(275238);
        }
      });
      AppMethodBeat.o(64511);
      return;
      bQ(-1, paramString);
      AppMethodBeat.o(64511);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(64507);
    if (this.HgO != null) {
      this.HgO.clear();
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
  
  protected final void na(boolean paramBoolean)
  {
    AppMethodBeat.i(64509);
    if (paramBoolean)
    {
      this.mProgressDialog = l.a(this, false, null);
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
    paramBundle = (com.tencent.mm.plugin.fingerprint.mgr.a.i)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.mgr.a.i.class);
    if (!paramBundle.ftR())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (z.bBi())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (paramBundle.ftP())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    if (!paramBundle.ftS())
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
      finish();
      AppMethodBeat.o(64498);
      return;
    }
    Object localObject = u.iiC();
    this.HgO = paramBundle.ftW();
    this.HgT = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acJW, false);
    if ((((am)localObject).ijf()) && (!paramBundle.ftP()))
    {
      Log.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
      com.tencent.soter.a.g.f.jYD().jYE();
      com.tencent.mm.plugin.report.service.h.OAn.b(12924, new Object[] { Integer.valueOf(1) });
      com.tencent.mm.plugin.soter.model.a.amO(0);
      if (getIntent().getBooleanExtra("key_show_guide", true))
      {
        if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acJT, true))
        {
          Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acJT, Boolean.FALSE);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acJW, Boolean.FALSE);
          if (this.HgT) {}
          for (paramBundle = getString(a.i.guide_open_text_for_transparent_recover);; paramBundle = getString(a.i.guide_open_text_for_transparent))
          {
            com.tencent.mm.ui.base.k.a(this, paramBundle, "", getString(a.i.btn_guide_open_fingerprint), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acJV, Integer.valueOf(1));
            this.HgS = 1;
            com.tencent.mm.plugin.soter.model.a.lW(1, this.HgS);
            AppMethodBeat.o(64498);
            return;
          }
        }
        Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
        paramBundle = LayoutInflater.from(this).inflate(a.g.fingerprint_guide_dialog, null);
        localObject = (CheckBox)paramBundle.findViewById(a.f.fingerprint_not_show_any_more_cb);
        this.HgS = (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJV, null)).intValue() + 1);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acJV, Integer.valueOf(this.HgS));
        com.tencent.mm.plugin.soter.model.a.lW(1, this.HgS);
        com.tencent.mm.ui.base.k.a(this, false, null, paramBundle, getString(a.i.btn_guide_open_fingerprint), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, this.Hgr.isChecked());
            AppMethodBeat.o(64494);
          }
        });
        AppMethodBeat.o(64498);
        return;
      }
      if (getIntent().getBooleanExtra("isFromKinda", false))
      {
        com.tencent.mm.plugin.soter.model.a.lW(3, this.HgS);
        paramBundle = getIntent().getStringExtra("kindaPayPwd");
        if (paramBundle != null)
        {
          this.HgO.a(this, new b()
          {
            public final void bL(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(64495);
              FingerPrintAuthTransparentUI.this.na(false);
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
          na(true);
        }
        this.mController.setStatusBarColor(getResources().getColor(a.c.white));
        AppMethodBeat.o(64498);
        return;
      }
      fuh();
      AppMethodBeat.o(64498);
      return;
    }
    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + ((am)localObject).ijf() + ";isOpenTouch:" + paramBundle.ftP());
    Log.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
    finish();
    AppMethodBeat.o(64498);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64510);
    if ((this.GYB != null) && (this.GYB.isShowing()))
    {
      this.GYB.dismiss();
      this.GYB = null;
    }
    if (this.HgQ != null) {
      this.HgQ.cancel();
    }
    na(false);
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
    fuf();
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
    if (this.HgR) {
      fue();
    }
    AppMethodBeat.o(64499);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(64505);
    boolean bool = this.HgO.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI
 * JD-Core Version:    0.7.0.1
 */