package com.tencent.mm.plugin.fingerprint.mgr;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.i;

public final class k
  implements e
{
  public final void a(MMActivity paramMMActivity, com.tencent.mm.plugin.fingerprint.faceid.auth.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(64398);
    parama = new WalletFaceIdDialog(paramMMActivity, parama, paramBundle);
    parama.setCancelable(false);
    paramMMActivity.getLifecycle().addObserver(parama);
    parama.show();
    AppMethodBeat.o(64398);
  }
  
  public final boolean l(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(64399);
    if (((Boolean)h.baE().ban().get(at.a.acJU, Boolean.FALSE)).booleanValue())
    {
      Log.i("MicroMsg.WalletSoterService", "has show the finger print auth guide!");
      AppMethodBeat.o(64399);
      return false;
    }
    Object localObject3 = com.tencent.mm.wallet_core.a.cm(paramMMActivity);
    Object localObject1 = new Bundle();
    if (localObject3 != null) {
      localObject1 = ((com.tencent.mm.wallet_core.e)localObject3).hPH;
    }
    for (;;)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      Object localObject2;
      if (paramMMActivity != null)
      {
        bool1 = bool2;
        if (paramMMActivity.getIntent() != null)
        {
          bool2 = paramMMActivity.getIntent().getBooleanExtra("isFromKinda", false);
          bool1 = bool2;
          if (bool2)
          {
            localObject2 = paramMMActivity.getIntent().getStringExtra("kindaPayPwd");
            if (localObject2 != null) {
              ((Bundle)localObject1).putString("key_pwd1", (String)localObject2);
            }
            bool1 = bool2;
          }
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(((Bundle)localObject1).getString("key_pwd1")))
        {
          Log.i("MicroMsg.WalletSoterService", "pwd is empty, not show the finger print auth guide!");
          AppMethodBeat.o(64399);
          return false;
        }
        Object localObject4 = (com.tencent.mm.plugin.fingerprint.c.a)h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
        Log.i("MicroMsg.WalletSoterService", "fingerprint: %s has fingerprint: %s, faceid: %s has faceid: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.ihi()), Boolean.valueOf(((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftw()), Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.ihj()), Boolean.valueOf(((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftE()) });
        int i;
        if ((!((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftq()) && (!((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftt()))
        {
          if ((!com.tencent.mm.plugin.wallet.b.a.ihi()) || (!((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftw()) || (!com.tencent.mm.plugin.wallet.b.a.ihj()) || (!((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftE())) {
            break label758;
          }
          if (!bool1) {
            break label592;
          }
          boolean bool4 = false;
          int j = 0;
          localObject2 = null;
          localObject1 = localObject2;
          i = j;
          boolean bool3 = bool4;
          bool2 = bool1;
          if (paramMMActivity != null)
          {
            localObject1 = localObject2;
            i = j;
            bool3 = bool4;
            bool2 = bool1;
            if (paramMMActivity.getIntent() != null)
            {
              bool3 = paramMMActivity.getIntent().getBooleanExtra("isFromKinda", false);
              bool2 = paramMMActivity.getIntent().getBooleanExtra("bSupportFaceAndTouch", false);
              i = paramMMActivity.getIntent().getIntExtra("selectBioType", 0);
              localObject1 = paramMMActivity.getIntent().getStringExtra("kindaPayPwd");
            }
          }
          if ((bool3) && (bool2) && (localObject1 != null)) {
            break label406;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(64399);
          return true;
          label406:
          localObject2 = new Bundle();
          if (i == 1)
          {
            Log.i("MicroMsg.WalletSoterService", "click fingerprint btn");
            ((Bundle)localObject2).putBoolean("key_show_guide", false);
            ((Bundle)localObject2).putBoolean("isFromKinda", true);
            ((Bundle)localObject2).putString("kindaPayPwd", (String)localObject1);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            c.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", (Intent)localObject1);
          }
          else if (i == 2)
          {
            Log.i("MicroMsg.WalletSoterService", "click faceid btn");
            localObject2 = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
            ((Intent)localObject2).putExtra("pwd", (String)localObject1);
            ((Intent)localObject2).putExtra("key_scene", 1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "kindaHandleOpenBiometricPay", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramMMActivity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "kindaHandleOpenBiometricPay", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            continue;
            label592:
            localObject2 = new i(paramMMActivity, a.j.mmalertdialog);
            ((i)localObject2).setContentView(a.g.biometric_pay_guide_dialog);
            localObject4 = (CheckBox)((i)localObject2).findViewById(a.f.bpgd_cb);
            TextView localTextView1 = (TextView)((i)localObject2).findViewById(a.f.bpgd_faceid_btn);
            TextView localTextView2 = (TextView)((i)localObject2).findViewById(a.f.bpgd_fingerprint_btn);
            TextView localTextView3 = (TextView)((i)localObject2).findViewById(a.f.bpgd_cancel_btn);
            localObject1 = new Bundle();
            if (localObject3 != null) {
              localObject1 = ((com.tencent.mm.wallet_core.e)localObject3).hPH;
            }
            localTextView1.setOnClickListener(new k.3(this, paramMMActivity, (Bundle)localObject1, (i)localObject2));
            localTextView2.setOnClickListener(new k.4(this, (com.tencent.mm.wallet_core.e)localObject3, (Bundle)localObject1, paramMMActivity, (i)localObject2));
            localTextView3.setOnClickListener(new k.5(this, (CheckBox)localObject4, (i)localObject2));
            ((i)localObject2).show();
            ((MMActivity)paramMMActivity).addDialog((Dialog)localObject2);
            continue;
            label758:
            if ((com.tencent.mm.plugin.wallet.b.a.ihi()) && (((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftw()) && (!((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftq()))
            {
              localObject3 = new Intent();
              ((Intent)localObject3).putExtras((Bundle)localObject1);
              if (bool1)
              {
                ((Intent)localObject3).putExtra("isFromKinda", bool1);
                ((Intent)localObject3).putExtra("kindaPayPwd", (String)localObject2);
                ((Intent)localObject3).putExtra("key_show_guide", false);
              }
              c.b(paramMMActivity, "fingerprint", ".ui.FingerPrintAuthTransparentUI", (Intent)localObject3);
            }
            else if ((com.tencent.mm.plugin.wallet.b.a.ihj()) && (((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftE()) && (!((com.tencent.mm.plugin.fingerprint.c.a)localObject4).ftt()))
            {
              if (bool1)
              {
                localObject2 = new Intent(paramMMActivity, WalletFaceIdAuthUI.class);
                ((Intent)localObject2).putExtra("pwd", ((Bundle)localObject1).getString("key_pwd1"));
                ((Intent)localObject2).putExtra("key_scene", 1);
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(paramMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "showOpenGuideAfterPaySucc", "(Lcom/tencent/mm/ui/MMActivity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramMMActivity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "showOpenGuideAfterPaySucc", "(Lcom/tencent/mm/ui/MMActivity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(64399);
                return true;
              }
              localObject2 = LayoutInflater.from(paramMMActivity).inflate(a.g.fingerprint_guide_dialog, null);
              localObject3 = (TextView)((View)localObject2).findViewById(a.f.fgd_desc_tv);
              localObject4 = (CheckBox)((View)localObject2).findViewById(a.f.fingerprint_not_show_any_more_cb);
              ((TextView)localObject3).setText(paramMMActivity.getString(a.i.faceid_guide_open_text));
              com.tencent.mm.ui.base.k.a(paramMMActivity, false, null, (View)localObject2, paramMMActivity.getString(a.i.btn_guide_open_faceid), paramMMActivity.getString(a.i.app_cancel), new k.1(this, paramMMActivity, (Bundle)localObject1), new k.2(this, (CheckBox)localObject4));
            }
          }
        }
        localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.k
 * JD-Core Version:    0.7.0.1
 */